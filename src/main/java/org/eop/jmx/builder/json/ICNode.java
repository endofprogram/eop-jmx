package org.eop.jmx.builder.json;

import java.util.List;
/**
 * lixinjie 2016-12-26
 */
public interface ICNode extends IJNode {

	void addChild(IJNode child);
	
	List<IJNode> getChildren();
}
