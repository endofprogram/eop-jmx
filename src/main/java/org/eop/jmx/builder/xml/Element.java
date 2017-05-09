package org.eop.jmx.builder.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * lixinjie 2016-12-26
 */
public class Element extends CNode implements IElement {
	
	private boolean selfClosing;
	private QName qname;
	private List<Namespace> namespaces;
	private List<Attribute> attributes;
	
	public Element(IXNode parent, String namespace, String name, boolean selfClosing) {
		super(parent, name);
		this.selfClosing = selfClosing;
		this.qname = new QName(this, namespace, name);
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
	
	public QName getQName() {
		return qname;
	}
	
	public boolean getSelfClosing() {
		return selfClosing;
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
		if (hasChild || !selfClosing) {
			sb.append('>');
		} else {
			sb.append("/>");
		}
		
		if (hasChild) {
			for (IXNode child : getChildren()) {
				child.toXml(sb);
			}
		}
		
		if (hasChild || !selfClosing) {
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
		if (hasChild || !selfClosing) {
			sb.append('>');
		} else {
			sb.append("/>");
		}
		
		if (!hasChild && selfClosing) {
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
		
		if (hasChild || !selfClosing) {
			sb.append("</");
			qname.toXml(sb);
			sb.append('>');
			xmlCRLF(sb);
		}
	}

	@Override
	public Element deepClone(IXNode parent) {
		Element element = new Element(parent, qname.getPrefix(), getName(), selfClosing);
		if (namespaces != null && !namespaces.isEmpty()) {
			for (Namespace namespace : namespaces) {
				element.addNamespace(namespace.deepClone(element));
			}
		}
		if (attributes != null && !attributes.isEmpty()) {
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
