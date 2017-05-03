package org.eop.jmx.dynamic.builder.map;

import java.util.HashMap;
import java.util.Map;
/**
 * lixinjie 2016-12-26
 */
public class KeyMap extends CNode {

	public KeyMap(CNode parent, String key) {
		super(parent, key);
	}

	@Override
	public void toMap(Map<String, Object> map) {
		Map<String, Object> nmap = new HashMap<>();
		for (MNode child : children) {
			child.toMap(nmap);
		}
		map.put(key, nmap);
	}
}
