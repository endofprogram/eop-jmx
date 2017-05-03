package org.eop.jmx.builder.json;
/**
 * lixinjie 2016-12-26
 */
public interface IJNode {
	
	String getName();
	
	void toJson(StringBuilder sb);

	void toJson(StringBuilder sb, int indent);
	
	IJNode getParent();
	
	void setParent(IJNode parent);
	
	IJNode deepClone(IJNode parent);
}
