package com.hael.evetool.validation;

import java.io.IOException;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.hael.evetool.dao.NavDAO;
import com.hael.evetool.exception.NotARealSolarSystemException;
import com.hael.evetool.exception.NotEnoughArgumentsException;

/**
 * Assorted Spring validators for the evetool project.
 * @author alecross
 *
 */
@Aspect
public class Validator {

	@Autowired
	private NavDAO navDAO;

	/**
	 * ShortestRoute pointcut.
	 * @param to destination system
	 * @param from origin system
	 */
	@Pointcut("execution(* com.hael.evetool.JumpCalculator.shortestRoute(..)) && args(to,from)")
	public void jumpCalculator(String to, String from) {
	}

	/**
	 * Checks both arguments to ensure that they're non-null.
	 * @param to destination system
	 * @param from origin system
	 * @throws NotEnoughArgumentsException if either argument is null
	 */
	@Before("jumpCalculator(to, from)")
	public void enoughArguments(String to, String from) throws NotEnoughArgumentsException {
		if (from == null || to == null) {
			throw new NotEnoughArgumentsException();
		}
	}

	/**
	 * Checks both solarsystems to ensure that they exist.
	 * @param to destination system
	 * @param from origin system
	 * @throws NotARealSolarSystemException if either doesn't represent a real system
	 * @throws IOException if exception handling is not yet implemented
	 */
	@Before("jumpCalculator(to, from)")
	public void validArguments(String to, String from) throws NotARealSolarSystemException, IOException {


		if (!navDAO.isRealSystem(from)) {
			throw new NotARealSolarSystemException("From system " + from + " is not real");
		} else if (!navDAO.isRealSystem(to)) {
			throw new NotARealSolarSystemException("To system " + to + " is not real");
		}

	}
}
