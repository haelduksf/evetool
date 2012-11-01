package com.hael.evetool.exception;

import javax.xml.ws.WebFault;

/**
 * Indicates that at least one required argument is null.
 * @author alecross
 *
 */
@WebFault(name = "NotEnoughArguments")
public class NotEnoughArgumentsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
