package org.eop.jmx.builder.xml;

import java.util.List;

import org.eop.chassis.util.ListUtil;
import org.eop.chassis.util.TypeUtil;
/**
 * lixinjie 2016-12-26
 */
public class DElements extends DElement {

	public DElements(IXNode parent, String name, boolean selfClose, String path, String namespace) {
		super(parent, name, selfClose, path, namespace);
	}

	@Override
	public void toXml(StringBuilder sb) {
		prepare();
		processClone();
		getElement().toXml(sb);
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		prepare();
		processClone();
		getElement().toXml(sb, indent);
	}
	
	void processClone() {
		int size = TypeUtil.asListType(getSelfClaw().getUnderlyingData()).size();
		if (size < 1) {
			getChildren().clear();
		} else if (size > 1) {
			List<IXNode> children = getChildren();
			IXNode child = ListUtil.getFirst(children);
			for (int i = 1; i < size; i++) {
				IDXNode clonedChild = (IDXNode)child.deepClone(this);
				clonedChild.setPath(i + "()");
				children.add(clonedChild);
			}
		}
	}
}
