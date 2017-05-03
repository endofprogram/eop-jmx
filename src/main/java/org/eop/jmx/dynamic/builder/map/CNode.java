package org.eop.jmx.dynamic.builder.map;

import java.util.ArrayList;
import java.util.List;
/**
 * lixinjie 2016-12-26
 */
public abstract class CNode extends MNode {

	List<MNode> children = new ArrayList<>();
	
	protected CNode(CNode parent, String key) {
		super(parent, key);
	}
	
	public void addChild(MNode child) {
		children.add(child);
	}
	
	public CNode back() {
		return parent;
	}
}
