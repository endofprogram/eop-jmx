package org.eop.jmx.builder.map;

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
		for (IMNode child : children) {
			child.toMap(map);
		}
	}

}
