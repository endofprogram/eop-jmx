package org.eop.jmx.converter.exception;

/**
 * @author lixinjie
 * @since 2017-06-02
 */
public class KeyMappingNotFoundException extends ConvertException {

	private static final long serialVersionUID = -1080008104727477435L;

	public KeyMappingNotFoundException(String message) {
		super(message);
	}

	public KeyMappingNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
