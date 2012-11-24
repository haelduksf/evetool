package com.hael.evetool.dao;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hael.evetool.domain.ActivityLog;
import com.hael.evetool.domain.MapSolarSystem;
import com.hael.evetool.domain.MapSolarSystemJumpLog;
import com.hael.evetool.domain.MapSolarSystemNpcKillLog;
import com.hael.evetool.domain.MapSolarSystemPcKillLog;
import com.hael.evetool.domain.SolarSystem;
import com.hael.evetool.exception.NotARealSolarSystemException;

/**
 * Implementation of the DAO for the evetool project.
 * 
 * @author alecross
 * 
 */
@Repository
public class NavDAOImpl implements NavDAO {

	private static final Logger log = LoggerFactory.getLogger(NavDAOImpl.class);
	@PersistenceContext
	private EntityManager entityManager;
	private List<SolarSystem> solarSystems;

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getNeighbours(int from) throws IOException {

		Query query = entityManager.createNamedQuery(
				"SolarSystem.getNeighboursID").setParameter("from", from);
		return query.getResultList();
	}

	@Override
	public boolean isRealSystem(String solarSystem) throws IOException {

		try {
			newSystem(solarSystem);
		} catch (NotARealSolarSystemException e) {
			return false;
		}
		return true;
	}

	@Override
	public SolarSystem getSystem(String name) throws IOException,
			NotARealSolarSystemException {

		SolarSystem target = newSystem(name);
		int index = getSolarSystems().indexOf(target);
		if (index != -1) {
			return getSolarSystems().get(index);
		} else {
			throw new NotARealSolarSystemException(name + " is not a real solar system");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> systemNameLookup(String string) throws IOException {

		Query nameLookup = entityManager.createNamedQuery(
				"SolarSystem.nameLookup").setParameter("name", string + "%");
		return nameLookup.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapSolarSystem> getSystemDump() {
		Query dump = entityManager.createNamedQuery("getSolarSystems");
		return (List<MapSolarSystem>) dump.getResultList();
	}

	@Override
	public SolarSystem newSystem(String name)
			throws NotARealSolarSystemException {
		Query getSolarSystemFromName = entityManager.createNamedQuery(
				"SolarSystem.getSolarSystemFromName")
				.setParameter("name", name);
		try {
			return new SolarSystem(
					(MapSolarSystem) getSolarSystemFromName.getSingleResult());
		} catch (NoResultException e) {
			throw new NotARealSolarSystemException(name + " is not a real solar system");
		}
	}

	@Override
	public SolarSystem newSystem(int id) throws NotARealSolarSystemException {
		Query getSolarSystemFromId = entityManager.createNamedQuery(
				"SolarSystem.getSolarSystemFromId").setParameter("id", id);
		try {
			return new SolarSystem(
					(MapSolarSystem) getSolarSystemFromId.getSingleResult());
		} catch (EmptyResultDataAccessException e) {
			throw new NotARealSolarSystemException(id + " is not a real solar system");
		}
	}

	@Override
	@Transactional
	public void saveLogs(Set<ActivityLog> logs) {
		for (ActivityLog log : logs) {
			entityManager.persist(log);
		}
	}

	private void setupDao() throws IOException {
		// can't @Autowire this object at bean creation without introducing a
		// circular reference, so setup is done here instead
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"springConfig.xml");
		DaoConfig daoConfig = context
				.getBean(com.hael.evetool.dao.DaoConfig.class);
		solarSystems = daoConfig.setupDao();
	}

	private List<SolarSystem> getSolarSystems() throws IOException {

		if (this.solarSystems == null) {
			log.info("brb, creating the universe");
			setupDao();
		}
		return this.solarSystems;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapSolarSystemJumpLog> getJumpsFor(SolarSystem solarSystem, Date from, Date to) {
		Query getJumpsFor = entityManager
				.createNamedQuery("MapSolarSystemJumpLog.getJumpsFor")
				.setParameter("solarSystemID", solarSystem.getSolarSystemID())
				.setParameter("from", from).setParameter("to", to);
		return getJumpsFor.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapSolarSystemNpcKillLog> getNpcKillsFor(SolarSystem solarSystem, Date from, Date to) {
		Query getNpcKillsFor = entityManager
				.createNamedQuery("MapSolarSystemNpcKillLog.getKillsFor")
				.setParameter("solarSystemID", solarSystem.getSolarSystemID())
				.setParameter("from", from).setParameter("to", to);
		return getNpcKillsFor.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapSolarSystemPcKillLog> getPcKillsFor(SolarSystem solarSystem,
			Date from, Date to) {
		Query getPcKillsFor = entityManager
				.createNamedQuery("MapSolarSystemPcKillLog.getKillsFor")
				.setParameter("solarSystemID", solarSystem.getSolarSystemID())
				.setParameter("solarSystemID", solarSystem.getSolarSystemID())
				.setParameter("from", from).setParameter("to", to);
		return getPcKillsFor.getResultList();
	}
}
