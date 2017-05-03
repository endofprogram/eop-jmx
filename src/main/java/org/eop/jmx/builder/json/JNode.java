package org.eop.jmx.builder.json;
/**
 * lixinjie 2016-12-26
 */
public abstract class JNode implements IJNode {
	
	protected String name;
	protected IJNode parent;
	
	protected JNode(IJNode parent, String name) {
		this.parent = parent;
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public IJNode getParent() {
		return parent;
	}
	
	@Override
	public void setParent(IJNode parent) {
		this.parent = parent;
	}
	
	public abstract void toJson(StringBuilder sb);

	public abstract void toJson(StringBuilder sb, int indent);
	
	public abstract IJNode deepClone(IJNode parent);
	
	void jsonIndent(StringBuilder sb, int indent) {
		for (int i = 0; i < indent; i++) {
			sb.append("    ");
		}
	}
	
	void jsonCRLF(StringBuilder sb) {
		sb.append('\r').append('\n');
	}
	
	void jsonName(StringBuilder sb) {
		sb.append('"').append(name).append('"').append(':');
	}
	
	void jsonValue(Object value, StringBuilder sb) {
		if (value instanceof String) {
			sb.append('"').append(value).append('"');
		} else {
			sb.append(value);
		}
	}
}
