package org.eop.jmx.builder.map;

import java.util.Map;
/**
 * lixinjie 2016-12-26
 */
public abstract class MNode implements IMNode {

	String key;
	ICNode parent;
	
	protected MNode(String key) {
		this(null, key);
	}
	
	protected MNode(ICNode parent, String key) {
		this.parent = parent;
		this.key = key;
	}
	
	@Override
	public ICNode getParent() {
		return parent;
	}
	
	@Override
	public void setParent(ICNode parent) {
		this.parent = parent;
	}
	
	@Override
	public abstract void toMap(Map<String, Object> map);
}
