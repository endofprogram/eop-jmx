package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class DCDatas extends DXNode {

	private String namespace;
	private CDatas cdatas;
	
	public DCDatas(IXNode parent, String name, String path) {
		this(parent, name, path, null);
	}
	
	public DCDatas(IXNode parent, String name, String path, String namespace) {
		super(parent, name, path);
		this.namespace = namespace;
	}
	
	String getNamespace() {
		return namespace;
	}
	
	CDatas getCDatas() {
		return cdatas;
	}

	@Override
	void prepare() {
		fetchParentClaw();
		cdatas = new CDatas(this, getName(), getParentClaw().getList(getPath()).toArray(), namespace);
	}

	@Override
	public void toXml(StringBuilder sb) {
		prepare();
		cdatas.toXml(sb);
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		prepare();
		cdatas.toXml(sb, indent);
	}

	@Override
	public DCDatas deepClone(IXNode parent) {
		return new DCDatas(parent, getName(), getPath(), namespace);
	}

}
