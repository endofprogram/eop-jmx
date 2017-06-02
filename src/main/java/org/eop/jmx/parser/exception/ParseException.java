package org.eop.jmx.parser.exception;

import org.eop.jmx.exception.JmxException;

/**
 * @author lixinjie
 * @since 2017-06-02
 */
public class ParseException extends JmxException {

	private static final long serialVersionUID = -490394203070710582L;

	public ParseException(String message) {
		super(message);
	}
	
	public ParseException(String message, Throwable cause) {
		super(message, cause);
	}
}
