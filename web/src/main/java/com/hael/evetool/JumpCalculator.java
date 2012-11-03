package com.hael.evetool;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.hael.evetool.domain.MapSolarSystemJumpLog;
import com.hael.evetool.domain.MapSolarSystemNpcKillLog;
import com.hael.evetool.domain.MapSolarSystemPcKillLog;
import com.hael.evetool.domain.SolarSystem;
import com.hael.evetool.exception.NoPathExistsException;
import com.hael.evetool.exception.NotARealSolarSystemException;
import com.hael.evetool.exception.NotEnoughArgumentsException;

/**
 * The public face of the web service.
 * 
 * @author alecross
 * 
 */
@Component
@WebService
public interface JumpCalculator {

	/**
	 * Returns an ordered list representing the shortest route from
	 * <code>from</code> to <code>to</code> passing only through systems with
	 * security levels between <code>minSecurity</code> and
	 * <code> maxSecurity</code>, inclusive.
	 * 
	 * @throws NotARealSolarSystemException
	 *             when one or both inputs can't be found
	 * @throws NotEnoughArgumentsException
	 *             when one or both inputs are empty
	 * @throws IOException
	 *             when I haven't implemented error handling
	 * @return an ordered list of SolarSystems representing the route from
	 *         "from" to "to".
	 * @param from
	 *            the start system
	 * @param to
	 *            the destination system
	 * @param minSecurity
	 *            the minimum desired security level for systems on the path
	 * @param maxSecurity
	 *            the maximum desired security level for systems on the path
	 * 
	 * @throws NoPathExistsException
	 * 
	 */
	@WebMethod
	List<SolarSystem> shortestRoute(@WebParam(name = "from") String from,
			@WebParam(name = "to") String to,
			@WebParam(name = "minSecurity") float minSecurity,
			@WebParam(name = "maxSecurity") float maxSecurity)
			throws NotARealSolarSystemException, NotEnoughArgumentsException,
			IOException, NoPathExistsException;

	/**
	 * Returns a list of systems that are candidates to autocomplete the given
	 * string.
	 * 
	 * @param string
	 *            The name fragment to be autocompleted.
	 * @return A list of possible solar systems.
	 * @throws IOException
	 *             if exception handling has not been implemented
	 */
	@WebMethod
	List<String> systemNameLookup(@WebParam(name = "string") String string)
			throws IOException;

	/**
	 * Gets the solar system having the given name.
	 * 
	 * @param name
	 *            the name of the desired solar system
	 * @return the solar system object
	 * @throws IOException
	 *             if exception handling is still not done
	 * @throws NotARealSolarSystemException
	 *             if such a system doesn't exist
	 */
	@WebMethod
	SolarSystem getSystem(@WebParam(name = "name") String name)
			throws IOException, NotARealSolarSystemException;

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

	@WebMethod
	List<MapSolarSystemJumpLog> getJumpsFor(
			@WebParam(name = "solarSystem") SolarSystem solarSystem,
			@WebParam(name = "from") Date from, @WebParam(name = "to") Date to)
			throws NotARealSolarSystemException;

	/**
	 * returns the npc kill records for the time period and system specified.
	 * 
	 * @param solarSystemID
	 *            the specified solar system
	 * @param from
	 *            the start time
	 * @param to
	 *            the end time
	 * @throws NotARealSolarSystemException
	 */

	@WebMethod
	List<MapSolarSystemNpcKillLog> getNpcKillsFor(
			@WebParam(name = "solarSystem") SolarSystem solarSystem,
			@WebParam(name = "from") Date from, @WebParam(name = "to") Date to)
			throws NotARealSolarSystemException;

	/**
	 * returns the pc kill records for the time period and system specified.
	 * 
	 * @param solarSystemID
	 *            the specified solar system
	 * @param from
	 *            the start time
	 * @param to
	 *            the end time
	 * @throws NotARealSolarSystemException
	 */

	@WebMethod
	List<MapSolarSystemPcKillLog> getPcKillsFor(
			@WebParam(name = "solarSystem") SolarSystem solarSystem,
			@WebParam(name = "from") Date from, @WebParam(name = "to") Date to)
			throws NotARealSolarSystemException;
}
