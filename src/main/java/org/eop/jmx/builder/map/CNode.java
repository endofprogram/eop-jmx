package org.eop.jmx.builder.map;

import java.util.ArrayList;
import java.util.List;
/**
 * lixinjie 2016-12-26
 */
public abstract class CNode extends MNode implements ICNode {

	List<IMNode> children = new ArrayList<>();
	
	protected CNode(ICNode parent, String key) {
		super(parent, key);
	}
	
	@Override
	public void addChild(IMNode child) {
		children.add(child);
	}
	
	@Override
	public List<IMNode> getChildren() {
		return children;
	}
}
