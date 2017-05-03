package org.eop.jmx.builder.map;

import java.util.List;

/**
 * @author lixinjie
 */
public interface ICNode extends IMNode {

	public void addChild(IMNode child);
	
	public List<IMNode> getChildren();
}
