package org.eop.jmx.builder.xml;

import java.util.List;
/**
 * lixinjie 2016-12-26
 */
public interface ICNode extends IXNode {

	void addChild(IXNode child);
	
	List<IXNode> getChildren();
}
