package org.eop.jmx.converter.setting;

import java.util.Map;

/**
 * @author lixinjie
 * @since 2017-05-11
 */
public class ConvertSetting {

	private Map<String, String> map;
	
	public ConvertSetting() {
		
	}
	
	public void addSetting(String name, String value) {
		map.put(name, value);
	}
	
	public String getSetting(String name) {
		return map.get(name);
	}
}
