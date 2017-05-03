package org.eop.jmx.dynamic.builder.map;

import java.util.Map;
/**
 * lixinjie 2016-12-26
 */
public abstract class MNode {

	String key;
	CNode parent;
	
	protected MNode(String key) {
		this(null, key);
	}
	
	protected MNode(CNode parent, String key) {
		this.parent = parent;
		this.key = key;
	}
	
	public CNode getParent() {
		return parent;
	}
	
	public void setParent(CNode parent) {
		this.parent = parent;
	}
	
	public abstract void toMap(Map<String, Object> map);
}
