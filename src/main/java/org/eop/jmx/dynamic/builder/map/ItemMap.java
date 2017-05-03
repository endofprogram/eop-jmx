package org.eop.jmx.dynamic.builder.map;

import java.util.Map;
/**
 * lixinjie 2016-12-26
 */
public class ItemMap extends CNode {

	public ItemMap(CNode parent) {
		super(parent, "");
	}

	@Override
	public void toMap(Map<String, Object> map) {
		for (MNode child : children) {
			child.toMap(map);
		}
	}
}
