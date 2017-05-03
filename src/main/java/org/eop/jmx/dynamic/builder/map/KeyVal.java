package org.eop.jmx.dynamic.builder.map;

import java.util.Map;
/**
 * lixinjie 2016-12-26
 */
public class KeyVal extends MNode {

	Object val;
	
	public KeyVal(CNode parent, String key, Object val) {
		super(parent, key);
		this.val = val;
	}

	@Override
	public void toMap(Map<String, Object> map) {
		map.put(key, val);
	}
}
