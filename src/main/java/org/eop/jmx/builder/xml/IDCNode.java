package org.eop.jmx.builder.xml;

import org.eop.claw.Claw;
/**
 * lixinjie 2016-12-26
 */
public interface IDCNode extends ICNode, IDXNode {

	void setSelfClaw();
	
	Claw getSelfClaw();
}
