package org.eop.jmx.dynamic.builder.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * lixinjie 2016-12-26
 */
public class KeyMaps extends CNode {

	public KeyMaps(CNode parent, String key) {
		super(parent, key);
	}

	@Override
	public void toMap(Map<String, Object> map) {
		List<Map<String, Object>> mapList = new ArrayList<>();
		Map<String, Object> nmap;
		for (MNode child : children) {
			nmap = new HashMap<>();
			child.toMap(nmap);
			mapList.add(nmap);
		}
		map.put(key, mapList);
	}
}
