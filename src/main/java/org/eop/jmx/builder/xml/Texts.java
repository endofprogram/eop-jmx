package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class Texts extends CNode {

	private Object[] texts;
	private String namespace;
	
	public Texts(IXNode parent, String name, Object[] texts) {
		this(parent, name, texts, null);
	}
	
	public Texts(IXNode parent, String name, Object[] texts, String namespace) {
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
			element.addChild(new Text(element, text));
			addChild(element);
		}
	}

	@Override
	public Texts deepClone(IXNode parent) {
		return new Texts(parent, getName(), texts, namespace);
	}
}
