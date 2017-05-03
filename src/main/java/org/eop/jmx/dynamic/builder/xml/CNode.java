package org.eop.jmx.dynamic.builder.xml;

import java.util.ArrayList;
import java.util.List;
/**
 * lixinjie 2016-12-26
 */
public abstract class CNode extends XNode implements ICNode {

	protected List<IXNode> children = new ArrayList<>();
	
	protected CNode(IXNode parent, String name) {
		super(parent, name);
	}

	@Override
	public void addChild(IXNode child) {
		children.add(child);
	}

	@Override
	public List<IXNode> getChildren() {
		return children;
	}

}
