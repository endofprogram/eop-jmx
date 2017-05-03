package org.eop.jmx.builder.map;

import java.util.Map;
/**
 * lixinjie 2016-12-26
 */
public class ItemMap extends CNode {

	public ItemMap(ICNode parent) {
		super(parent, "");
	}

	@Override
	public void toMap(Map<String, Object> map) {
		for (IMNode child : children) {
			child.toMap(map);
		}
	}
}
