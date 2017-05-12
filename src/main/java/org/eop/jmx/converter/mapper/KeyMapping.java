package org.eop.jmx.converter.mapper;

/**
 * @author lixinjie
 * @since 2017-05-11
 */
public class KeyMapping {

	private String srcKey;
	private String mapKey;
	
	public KeyMapping(String srcKey, String mapKey) {
		this.srcKey = srcKey;
		this.mapKey = mapKey;
	}
	
	public String getSrcKey() {
		return srcKey;
	}
	
	public String getMapKey() {
		return mapKey;
	}
}
