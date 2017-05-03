package org.eop.jmx.builder.json;
/**
 * lixinjie 2016-12-26
 */
public class Stick extends JNode {
	
	private Object[] values;
	
	public Stick(IJNode parent, String name, Object... values) {
		super(parent, name);
		this.values = values;
	}
	
	Object[] getValues() {
		return values;
	}

	@Override
	public void toJson(StringBuilder sb) {
		jsonName(sb);
		sb.append('[');
		int len = sb.length();
		for (Object value : values) {
			jsonValue(value, sb);
			sb.append(',');
		}
		if (sb.length() > len) {
			sb.setLength(sb.length() - 1);
		}
		sb.append(']');
	}

	@Override
	public void toJson(StringBuilder sb, int indent) {
		jsonIndent(sb, indent);
		jsonName(sb);
		sb.append('[');
		int len = sb.length();
		for (Object value : values) {
			jsonValue(value, sb);
			sb.append(',');
		}
		if (sb.length() > len) {
			sb.setLength(sb.length() - 1);
		}
		sb.append(']');
	}

	@Override
	public IJNode deepClone(IJNode parent) {
		return new Stick(parent, getName(), values);
	}
}
