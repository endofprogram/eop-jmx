package org.eop.jmx.dynamic.builder.map;

import java.util.Map;
/**
 * lixinjie 2016-12-26
 */
public class RootMap extends CNode {

	public RootMap() {
		super(null, "");
	}
	
	@Override
	public void toMap(Map<String, Object> map) {
		for (MNode child : children) {
			child.toMap(map);
		}
	}

}
