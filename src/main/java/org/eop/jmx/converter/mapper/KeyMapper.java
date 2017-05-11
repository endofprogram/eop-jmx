package org.eop.jmx.converter.mapper;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lixinjie
 * @since 2017-05-11
 */
public class KeyMapper {

	private Map<String, Mapping> mapper;
	
	public KeyMapper() {
		this.mapper = new LinkedHashMap<>();
	}
	
	public void addMapping(String srcKey, String mapKey) {
		mapper.put(srcKey, new Mapping(srcKey, mapKey));
	}
	
	public String getMapKey(String srcKey) {
		return mapper.get(srcKey).getMapKey();
	}
	
	public Mapping[] getMappings() {
		Mapping[] mps = new Mapping[mapper.values().size()];
		return mapper.values().toArray(mps);
	}
}
