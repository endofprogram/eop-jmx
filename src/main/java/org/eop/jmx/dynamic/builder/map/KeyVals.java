package org.eop.jmx.dynamic.builder.map;

import java.util.Arrays;
import java.util.Map;
/**
 * lixinjie 2016-12-26
 */
public class KeyVals extends MNode {

	Object[] vals;
	
	public KeyVals(CNode parent, String key, Object... vals) {
		super(parent, key);
		this.vals = vals;
	}

	@Override
	public void toMap(Map<String, Object> map) {
		map.put(key, Arrays.asList(vals));
	}
}
