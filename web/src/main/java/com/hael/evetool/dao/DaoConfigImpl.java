package com.hael.evetool.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.map.jumps.JumpsParser;
import com.beimin.eveapi.map.jumps.JumpsResponse;
import com.beimin.eveapi.map.kills.KillsParser;
import com.beimin.eveapi.map.kills.KillsResponse;
import com.hael.evetool.domain.MapSolarSystem;
import com.hael.evetool.domain.MapSolarSystemJumpLog;
import com.hael.evetool.domain.MapSolarSystemNpcKillLog;
import com.hael.evetool.domain.MapSolarSystemPcKillLog;
import com.hael.evetool.domain.SolarSystem;
import com.hael.evetool.exception.NotARealSolarSystemException;

/**
 * A utility class containing the business logic needed to setup a NavDAO.
 * 
 * @author alecross
 * 
 */
@Component
public class DaoConfigImpl implements DaoConfig {

	private static final int API_RETRY_TIME = 1 * 60 * 1000; // one minute
	private final Logger log = LoggerFactory.getLogger(DaoConfigImpl.class);
	@Autowired
	private NavDAO navDAO;
	private List<SolarSystem> solarSystems = new ArrayList<SolarSystem>();
	private Timer updateTimer = new Timer(true);

	/* (non-Javadoc)
	 * @see com.hael.evetool.dao.DaoConfig#setupDao()
	 */
	@Override
	public List<SolarSystem> setupDao() throws IOException {
		log.debug("setup started");
		importDataFromDB();
		updateTimer.schedule(new JumpTask(), 1L);
		updateTimer.schedule(new KillTask(), 1L);
		return solarSystems;
	}

	private void importDataFromDB() throws IOException {

		List<MapSolarSystem> systems = navDAO.getSystemDump();
		List<Integer> neighbours;

		for (MapSolarSystem s : systems) {
			SolarSystem newSS = new SolarSystem(s);
			solarSystems.add(newSS);
		}

		for (SolarSystem ssr : solarSystems) {
			neighbours = navDAO.getNeighbours(ssr.getSolarSystemID());
			for (Integer sysid : neighbours) {
				SolarSystem search = null;
				try {
					search = navDAO.newSystem(sysid);
				} catch (NotARealSolarSystemException e) {
					log.error("DB error, rebuild solar systems");
				}
				int index = Collections.binarySearch(solarSystems, search);
				SolarSystem neighbour = solarSystems.get(index);
				ssr.addNeighbour(neighbour);
			}
		}
	}

	private Date importJumpData() {
		log.info("Importing Jump Data");
		JumpsParser jumpsParser = JumpsParser.getInstance();
		JumpsResponse jumpsResponse = null;

		try {
			jumpsResponse = jumpsParser.getResponse();

		} catch (ApiException e) {
			Date retryTime = new Date(System.currentTimeMillis() + API_RETRY_TIME);
			log.error("jump import failed. Next attempt scheduled at " + retryTime);
			log.error("nested error:" + e.getMessage());
			return retryTime;
		}
		Map<Integer, Integer> jumpMap = jumpsResponse.getSystemJumps();
		Date timeRetrieved = jumpsResponse.getCurrentTime();
		Date cachedUntil = jumpsResponse.getCachedUntil();
		
		for (SolarSystem s : solarSystems) {
			int ssid = s.getSolarSystemID();
			Integer jumpCount = jumpMap.get(ssid);

			if (jumpCount == null) {
				jumpCount = 0;
			}

			MapSolarSystemJumpLog jumpLog = new MapSolarSystemJumpLog(ssid,
					timeRetrieved, jumpCount);
			navDAO.saveLog(jumpLog);
		}
		log.info("Jump import complete. Next jump fetch scheduled for "
				+ cachedUntil);
		return cachedUntil;
	}

	private Date importKillData() {
		log.info("Importing Kill Data");
		KillsParser killsParser = KillsParser.getInstance();
		KillsResponse killsResponse = null;

		try {
			killsResponse = killsParser.getResponse();
		} catch (ApiException e) {
			Date retryTime = new Date(System.currentTimeMillis() + API_RETRY_TIME);
			log.error("kill import failed. Next attempt scheduled at" + retryTime);
			log.error("nested error:" + e.getMessage());
			return retryTime;
		}

		Map<Integer, Integer> factionKills = killsResponse.getFactionKills();
		Map<Integer, Integer> podKills = killsResponse.getPodKills();
		Map<Integer, Integer> shipKills = killsResponse.getShipKills();
		Date timeRetrieved = killsResponse.getCurrentTime();
		Date cachedUntil = killsResponse.getCachedUntil();

		for (SolarSystem s : solarSystems) {
			int ssid = s.getSolarSystemID();
			Integer factionKillCount = factionKills.get(ssid);
			Integer shipKillCount = shipKills.get(ssid);
			Integer podKillCount = podKills.get(ssid);

			if (factionKillCount == null) {
				factionKillCount = 0;
			}
			if (shipKillCount == null) {
				shipKillCount = 0;
			}
			if (podKillCount == null) {
				podKillCount = 0;
			}

			MapSolarSystemNpcKillLog npcKillLog = new MapSolarSystemNpcKillLog(
					ssid, timeRetrieved, factionKillCount);
			MapSolarSystemPcKillLog pcKillLog = new MapSolarSystemPcKillLog(
					ssid, timeRetrieved, shipKillCount + podKillCount);
			navDAO.saveLog(npcKillLog);
			navDAO.saveLog(pcKillLog);
		}

		
		log.info("Kill import complete. Next kill fetch scheduled for "
				+ cachedUntil);
		return cachedUntil;
	}

	/**
	 * Fetches jump info from the Eve API when it's updated.
	 * @author alecross
	 *
	 */
	private class JumpTask extends TimerTask {

		@Override
		public void run() {
			Date cachedUntil = importJumpData();
			updateTimer.schedule(new JumpTask(), cachedUntil);
		}

	}
	
	/**
	 * Fetches kill info from the Eve API when it's updated.
	 * @author alecross
	 *
	 */
	private class KillTask extends TimerTask {

		@Override
		public void run() {
			Date cachedUntil = importKillData();
			updateTimer.schedule(new KillTask(), cachedUntil);
		}

	}
}
