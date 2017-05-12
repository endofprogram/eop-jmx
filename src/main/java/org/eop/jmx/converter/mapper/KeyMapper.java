package org.eop.jmx.converter.mapper;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lixinjie
 * @since 2017-05-11
 */
public class KeyMapper {

	private Map<String, KeyMapping> mapper;
	
	public KeyMapper() {
		this.mapper = new LinkedHashMap<>();
	}
	
	public KeyMapper(Map<String, String> map) {
		this();
		initMapper(map);
	}
	
	public void addKeyMapping(String srcKey, String mapKey) {
		mapper.put(srcKey, new KeyMapping(srcKey, mapKey));
	}
	
	public String getMapKey(String srcKey) {
		return mapper.get(srcKey).getMapKey();
	}
	
	public KeyMapping[] getKeyMappings() {
		KeyMapping[] mps = new KeyMapping[mapper.values().size()];
		return mapper.values().toArray(mps);
	}
	
	protected void initMapper(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			addKeyMapping(entry.getKey(), entry.getValue());
		}
	}
}
