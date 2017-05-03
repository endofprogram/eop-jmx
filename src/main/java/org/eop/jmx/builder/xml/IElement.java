package org.eop.jmx.builder.xml;

import java.util.List;
/**
 * lixinjie 2016-12-26
 */
public interface IElement extends ICNode {

	void addNamespace(Namespace namespace);
	
	List<Namespace> getNamespaces();
	
	void addAttribute(Attribute attribute);
	
	List<Attribute> getAttributes();
	
}
