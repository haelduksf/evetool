package com.hael.evetool.dao;

import java.io.IOException;
import java.util.List;

import com.hael.evetool.domain.SolarSystem;

/**
 * A utility class containing the business logic needed to setup our NavDAO.
 * 
 * @author alecross
 * 
 */
public interface DaoConfig {

	/**
	 * Configures the DAO for use.
	 * 
	 * @return the master list of solar systems
	 * @throws IOException
	 *             if exception handling is not yet implemented
	 */
	List<SolarSystem> setupDao() throws IOException;

}