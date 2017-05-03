package org.eop.jmx.builder.json;

import java.util.ArrayList;
import java.util.List;
/**
 * lixinjie 2016-12-26
 */
public abstract class CNode extends JNode implements ICNode {
	
	protected List<IJNode> children = new ArrayList<>();
	
	protected CNode(IJNode parent, String name) {
		super(parent, name);
	}
	
	@Override
	public void addChild(IJNode child) {
		children.add(child);
	}
	
	@Override
	public List<IJNode> getChildren() {
		return children;
	}
	
	@Override
	public IJNode deepClone(IJNode parent) {
		ICNode self = cloneSelf(parent);
		for (IJNode child : getChildren()) {
			self.addChild(child.deepClone(self));
		}
		return self;
	}
	
	public abstract ICNode cloneSelf(IJNode parent);
}
