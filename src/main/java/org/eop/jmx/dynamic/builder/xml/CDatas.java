package org.eop.jmx.dynamic.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class CDatas extends CNode {

	private Object[] texts;
	private String namespace;
	
	public CDatas(IXNode parent, String name, Object[] texts) {
		this(parent, name, texts, null);
	}
	
	public CDatas(IXNode parent, String name, Object[] texts, String namespace) {
		super(parent, name);
		this.texts = texts;
		this.namespace = namespace;
	}

	Object[] getTexts() {
		return texts;
	}
	
	String getNamespace() {
		return namespace;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		prepare();
		for (IXNode child : getChildren()) {
			child.toXml(sb);
		}
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		prepare();
		for (IXNode child : getChildren()) {
			child.toXml(sb, indent);
		}
	}

	void prepare() {
		for (Object text : texts) {
			Element element = new Element(this, getName(), false, namespace);
			element.addChild(new CData(element, text));
			addChild(element);
		}
	}

	@Override
	public IXNode deepClone(IXNode parent) {
		return new CDatas(parent, getName(), texts, namespace);
	}
}
