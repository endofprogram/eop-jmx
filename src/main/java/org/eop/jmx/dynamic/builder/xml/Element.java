package org.eop.jmx.dynamic.builder.xml;

import java.util.ArrayList;
import java.util.List;

import org.eop.chassis.util.EmptyUtil;
/**
 * lixinjie 2016-12-26
 */
public class Element extends CNode implements IElement {
	
	private boolean selfClose;
	private QName qname;
	private List<Namespace> namespaces;
	private List<Attribute> attributes;
	
	public Element(IXNode parent, String name, boolean selfClose, String namespace) {
		super(parent, name);
		this.selfClose = selfClose;
		this.qname = new QName(this, name, namespace);
	}
	
	@Override
	public void addNamespace(Namespace namespace) {
		if (namespaces == null) {
			namespaces = new ArrayList<>();
		}
		namespaces.add(namespace);
	}
	
	@Override
	public List<Namespace> getNamespaces() {
		return namespaces;
	}
	
	@Override
	public void addAttribute(Attribute attribute) {
		if (attributes == null) {
			attributes = new ArrayList<>();
		}
		attributes.add(attribute);
	}
	
	@Override
	public List<Attribute> getAttributes() {
		return attributes;
	}
	
	QName getQName() {
		return qname;
	}
	
	boolean getSelfClose() {
		return selfClose;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		sb.append('<');
		qname.toXml(sb);
		
		if (namespaces != null && !namespaces.isEmpty()) {
			for (Namespace namespace : namespaces) {
				sb.append(' ');
				namespace.toXml(sb);
			}
		}
		
		if (attributes != null && !attributes.isEmpty()) {
			for (Attribute attribute : attributes) {
				sb.append(' ');
				attribute.toXml(sb);
			}
		}
		
		boolean hasChild = (getChildren() != null) && (!getChildren().isEmpty());
		if (hasChild || !selfClose) {
			sb.append('>');
		} else {
			sb.append("/>");
		}
		
		if (hasChild) {
			for (IXNode child : getChildren()) {
				child.toXml(sb);
			}
		}
		
		if (hasChild || !selfClose) {
			sb.append("</");
			qname.toXml(sb);
			sb.append('>');
		}
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		xmlIndent(sb, indent);
		sb.append('<');
		qname.toXml(sb, indent);
		
		if (namespaces != null && !namespaces.isEmpty()) {
			for (Namespace namespace : namespaces) {
				sb.append(' ');
				namespace.toXml(sb, indent);
			}
		}
		
		if (attributes != null && !attributes.isEmpty()) {
			for (Attribute attribute : attributes) {
				sb.append(' ');
				attribute.toXml(sb, indent);
			}
		}
		
		boolean hasChild = (getChildren() != null) && (!getChildren().isEmpty());
		if (hasChild || !selfClose) {
			sb.append('>');
		} else {
			sb.append("/>");
		}
		
		if (!hasChild && selfClose) {
			xmlCRLF(sb);
		} else if (hasChild && !(getChildren().get(0) instanceof Text)) {
			xmlCRLF(sb);
		}
		
		if (hasChild) {
			for (IXNode child : getChildren()) {
				child.toXml(sb, indent + 1);
			}
		}
		
		if (hasChild && !(getChildren().get(0) instanceof Text)) {
			xmlIndent(sb, indent);
		}
		
		if (hasChild || !selfClose) {
			sb.append("</");
			qname.toXml(sb);
			sb.append('>');
			xmlCRLF(sb);
		}
	}

	@Override
	public Element deepClone(IXNode parent) {
		Element element = new Element(parent, getName(), selfClose, qname.getPrefix());
		if (EmptyUtil.notEmpty(namespaces)) {
			for (Namespace namespace : namespaces) {
				element.addNamespace(namespace.deepClone(element));
			}
		}
		if (EmptyUtil.notEmpty(attributes)) {
			for (Attribute attribute : attributes) {
				element.addAttribute(attribute.deepClone(element));
			}
		}
		for (IXNode child : getChildren()) {
			element.addChild(child.deepClone(element));
		}
		return element;
	}

}
