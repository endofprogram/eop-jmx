package org.eop.jmx.builder.json;
/**
 * lixinjie 2016-12-26
 */
public class Bud extends JNode {
	
	private Object value;
	
	public Bud(IJNode parent, Object value) {
		super(parent, "");
		this.value = value;
	}
	
	Object getValue() {
		return value;
	}

	@Override
	public void toJson(StringBuilder sb) {
		jsonValue(value, sb);
	}

	@Override
	public void toJson(StringBuilder sb, int indent) {
		jsonIndent(sb, indent);
		jsonValue(value, sb);
	}

	@Override
	public IJNode deepClone(IJNode parent) {
		return new Bud(parent, value);
	}
}
