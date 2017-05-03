package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class DTexts extends DXNode {

	private String namespace;
	private Texts texts;
	
	public DTexts(IXNode parent, String name, String path) {
		this(parent, name, path, null);
	}
	
	public DTexts(IXNode parent, String name, String path, String namespace) {
		super(parent, name, path);
		this.namespace = namespace;
	}
	
	String getNamespace() {
		return namespace;
	}
	
	Texts getTexts() {
		return texts;
	}
	
	@Override
	void prepare() {
		fetchParentClaw();
		texts = new Texts(this, getName(), getParentClaw().getList(getPath()).toArray(), namespace);
	}

	@Override
	public void toXml(StringBuilder sb) {
		prepare();
		texts.toXml(sb);
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		prepare();
		texts.toXml(sb, indent);
	}

	@Override
	public DTexts deepClone(IXNode parent) {
		return new DTexts(parent, getName(), getPath(), namespace);
	}

}
