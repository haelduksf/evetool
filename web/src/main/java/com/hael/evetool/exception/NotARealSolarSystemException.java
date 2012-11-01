package com.hael.evetool.exception;

import javax.xml.ws.WebFault;

/**
 * Indicates that a solar system was requested that doesn't exist. 
 * @author alecross
 *
 */
@WebFault(name = "NotARealSolarSystem")
public class NotARealSolarSystemException extends Exception {

	private static final long serialVersionUID = 1L;
	/**
	 * Default constructor w/ message.
	 * @param string message.
	 */
	public NotARealSolarSystemException(String string) {
		super(string);
	}
	/**
	 * Default constructor.
	 */
	public NotARealSolarSystemException() {
		super();
	}
}
