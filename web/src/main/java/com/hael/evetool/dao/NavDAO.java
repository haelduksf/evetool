package com.hael.evetool.dao;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.hael.evetool.domain.ActivityLog;
import com.hael.evetool.domain.MapSolarSystem;
import com.hael.evetool.domain.MapSolarSystemJumpLog;
import com.hael.evetool.domain.MapSolarSystemNpcKillLog;
import com.hael.evetool.domain.MapSolarSystemPcKillLog;
import com.hael.evetool.domain.SolarSystem;
import com.hael.evetool.exception.NotARealSolarSystemException;

/**
 * The DAO for the evetool project.
 * @author alecross
 *
 */
public interface NavDAO {
	/**
	 * Checks whether given system exists.
	 * 
	 * @param solarSystem
	 *            the solar system to be checked
	 * @return true for real, false otherwise
	 * @throws IOException if db access fails
	 */
	boolean isRealSystem(String solarSystem) throws IOException;
	/**
	 * Find solar systems that begin with the given string.
	 * @param string prefix to search for
	 * @return list of solar systems whose names begin with string
	 * @throws IOException if db access fails
	 */
	List<String> systemNameLookup(String string) throws IOException;
	/**
	 * Retrieves the specified system from solarSystems.
	 * 
	 * @param name
	 *            the name of the desired system
	 * @return the SolarSystem object representing that system
	 * @throws IOException if db access fails
	 * @throws NotARealSolarSystemException
	 *             if it doesn't exist
	 */
	SolarSystem getSystem(String name) throws IOException, NotARealSolarSystemException;
	/**
	 * Get a list of solar systems adjacent to another.
	 * @param from the SSID of the solar system we want to find neighbours of
	 * @return a list of SSIDs of adjoining systems
	 * @throws IOException if db access fails
	 */
	List<Integer> getNeighbours(int from) throws IOException;
	/**
	 * Fetches the raw data from the MapSolarSystems table.
	 * @return the MapSolarSystem for every system, in a List. 
	 */
	List<MapSolarSystem> getSystemDump();
	/**
	 * Persist an ApiLog to the DB.
	 * @param log the log entity to be persisted.
	 */
	void saveLog(ActivityLog log);
	/**
	 * Creates and returns a new SolarSystem.
	 * @param id the SSID of the SolarSystem
	 * @return the singleton object representing that solar system. 
	 * @throws NotARealSolarSystemException 
	 */
	SolarSystem newSystem(int id) throws NotARealSolarSystemException;
	/**
	 * Creates and returns a new SolarSystem.
	 * @param name the name of the SolarSystem
	 * @return the singleton object representing that solar system.
	 * @throws NotARealSolarSystemException 
	 */
	SolarSystem newSystem(String name) throws NotARealSolarSystemException;
	/**
	 * returns the jump records for the time period and system specified.
	 * 
	 * @param solarSystemID
	 *            the specified solar system
	 * @param from
	 *            the start time
	 * @param to
	 *            the end time
	 * @throws NotARealSolarSystemException 
	 */
	List<MapSolarSystemJumpLog> getJumpsFor(SolarSystem solarSystem, Date from, Date to);
	/**
	 * returns the NPC kill records for the time period and system specified.
	 * 
	 * @param solarSystemID
	 *            the specified solar system
	 * @param from
	 *            the start time
	 * @param to
	 *            the end time
	 * @throws NotARealSolarSystemException 
	 */
	List<MapSolarSystemNpcKillLog> getNpcKillsFor(SolarSystem solarSystem, Date from,
			Date to);
	/**
	 * returns the PC kill records for the time period and system specified.
	 * 
	 * @param solarSystemID
	 *            the specified solar system
	 * @param from
	 *            the start time
	 * @param to
	 *            the end time
	 * @throws NotARealSolarSystemException 
	 */
	List<MapSolarSystemPcKillLog> getPcKillsFor(SolarSystem solarSystem,
			Date from, Date to);

}
