package org.eop.jmx.exception;

/**
 * @author lixinjie
 * @since 2017-05-12
 */
public class JmxException extends RuntimeException {

	private static final long serialVersionUID = 957001216810657236L;

	public JmxException(String message) {
		super(message);
	}
	
	public JmxException(String message, Throwable cause) {
	    super(message, cause);
	}
}
