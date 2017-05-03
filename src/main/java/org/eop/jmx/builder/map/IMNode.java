package org.eop.jmx.builder.map;

import java.util.Map;

/**
 * @author lixinjie
 */
public interface IMNode {

	public ICNode getParent();
	
	public void setParent(ICNode parent);
	
	public void toMap(Map<String, Object> map);
}
