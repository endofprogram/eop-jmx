package org.eop.jmx.builder.map;

import java.util.List;
/**
 * lixinjie 2016-12-26
 */
public interface ICNode extends IMNode {

	public void addChild(IMNode child);
	
	public List<IMNode> getChildren();
}
