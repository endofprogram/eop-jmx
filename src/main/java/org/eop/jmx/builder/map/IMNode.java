package org.eop.jmx.builder.map;

/**
 * lixinjie 2016-12-26
 */
public interface IMNode {

	public ICNode getParent();
	
	public void setParent(ICNode parent);
	
	public void toMap(Context context);
}
