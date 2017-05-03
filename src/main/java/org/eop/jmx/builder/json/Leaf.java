package org.eop.jmx.builder.json;
/**
 * lixinjie 2016-12-26
 */
public class Leaf extends JNode {
	
	private Object value;
	
	public Leaf(IJNode parent, String name, Object value) {
		super(parent, name);
		this.value = value;
	}
	
	Object getValue() {
		return value;
	}

	@Override
	public void toJson(StringBuilder sb) {
		jsonName(sb);
		jsonValue(value, sb);
	}

	@Override
	public void toJson(StringBuilder sb, int indent) {
		jsonIndent(sb, indent);
		jsonName(sb);
		jsonValue(value, sb);
	}

	@Override
	public IJNode deepClone(IJNode parent) {
		return new Leaf(parent, getName(), value);
	}
}
