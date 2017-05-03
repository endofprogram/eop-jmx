package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class CDatas extends CNode {

	private Object[] cdatas;
	private String namespace;
	
	public CDatas(IXNode parent, String name, Object[] cdatas) {
		this(parent, null, name, cdatas);
	}
	
	public CDatas(IXNode parent, String namespace, String name, Object[] cdatas) {
		super(parent, name);
		this.cdatas = cdatas;
		this.namespace = namespace;
	}

	Object[] getCDatas() {
		return cdatas;
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
		for (Object cdata : cdatas) {
			Element element = new Element(this, namespace, getName(), false);
			element.addChild(new CData(element, cdata));
			addChild(element);
		}
	}

	@Override
	public IXNode deepClone(IXNode parent) {
		return new CDatas(parent, namespace, getName(), cdatas);
	}
}
