package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public interface IXNode {
	
	String getName();
	
	IXNode getParent();
	
	void toXml(StringBuilder sb);
	
	void toXml(StringBuilder sb, int indent);
	
	IXNode deepClone(IXNode parent);
}
