package org.eop.jmx.builder.xml;

import java.util.List;
/**
 * lixinjie 2016-12-26
 */
public class DElement extends DCNode implements IDElement {

	private Element element;
	
	public DElement(IXNode parent, String name, boolean selfClose, String path, String namespace) {
		super(parent, name, path);
		this.element = new Element(parent, name, selfClose, namespace);
	}

	@Override
	public void addNamespace(Namespace namespace) {
		element.addNamespace(namespace);
	}
	
	@Override
	public List<Namespace> getNamespaces() {
		return element.getNamespaces();
	}

	@Override
	public void addAttribute(Attribute attribute) {
		element.addAttribute(attribute);
	}
	
	@Override
	public List<Attribute> getAttributes() {
		return element.getAttributes();
	}
	
	Element getElement() {
		return element;
	}

	@Override
	ICNode getSelf() {
		return element;
	}

	@Override
	void prepare() {
		fetchParentClaw();
		setSelfClaw();
	}

	@Override
	public void toXml(StringBuilder sb) {
		prepare();
		element.toXml(sb);
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		prepare();
		element.toXml(sb, indent);
	}

	@Override
	IDCNode cloneDSelf(IXNode parent) {
		return new DElement(parent, getName(), element.getSelfClose(), getPath(), element.getQName().getPrefix());
	}

}
