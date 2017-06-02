package org.eop.jmx.converter.mapper;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eop.jmx.converter.exception.KeyMappingNotFoundException;
import org.eop.jmx.converter.setting.ActionWhenNoMapping;

/**
 * @author lixinjie
 * @since 2017-05-11
 */
public class KeyMapper {

	private Map<String, KeyMapping> mapper;
	private ActionWhenNoMapping actionWhenNoMapping;
	private String srcKeyDelimiter;
	
	public KeyMapper() {
		this.mapper = new LinkedHashMap<>();
	}
	
	public KeyMapper(Map<String, String> map) {
		this();
		initMapper(map);
	}
	
	public ActionWhenNoMapping getActionWhenNoMapping() {
		return actionWhenNoMapping;
	}

	public void setActionWhenNoMapping(ActionWhenNoMapping actionWhenNoMapping) {
		this.actionWhenNoMapping = actionWhenNoMapping;
	}

	public String getSrcKeyDelimiter() {
		return srcKeyDelimiter;
	}

	public void setSrcKeyDelimiter(String srcKeyDelimiter) {
		this.srcKeyDelimiter = srcKeyDelimiter;
	}

	public void addKeyMapping(String srcKey, String mapKey) {
		mapper.put(srcKey, new KeyMapping(srcKey, mapKey));
	}
	
	public boolean containsKeyMapping(String srcKey) {
		return mapper.containsKey(srcKey);
	}
	
	public String getMapKey(String srcKey) {
		switch (actionWhenNoMapping) {
			case UseSrcKey : return getMapKeyUseSrcKey(srcKey);
			case Exclusion : return getMapKeyExclusion(srcKey);
			case Exception : return getMapKeyException(srcKey);
			default : return getMapKeyUseSrcKey(srcKey);
		}
	}
	
	protected String getMapKeyUseSrcKey(String srcKey) {
		if (containsKeyMapping(srcKey)) {
			return mapper.get(srcKey).getMapKey();
		}
		int index = srcKey.lastIndexOf(srcKeyDelimiter);
		if (index > -1) {
			return srcKey.substring(index + 1);
		}
		return srcKey;
	}
	
	protected String getMapKeyExclusion(String srcKey) {
		if (containsKeyMapping(srcKey)) {
			return mapper.get(srcKey).getMapKey();
		}
		return null;
	}
	
	protected String getMapKeyException(String srcKey) {
		if (containsKeyMapping(srcKey)) {
			return mapper.get(srcKey).getMapKey();
		}
		throw new KeyMappingNotFoundException("mapkey not found for srckey: " + srcKey);
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
