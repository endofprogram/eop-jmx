package org.eop.jmx.builder.json;
/**
 * lixinjie 2016-12-26
 */
public class Twig extends JNode {
	
	private Object[] values;
	
	public Twig(IJNode parent, Object... values) {
		super(parent, "");
		this.values = values;
	}
	
	Object[] getValues() {
		return values;
	}

	@Override
	public void toJson(StringBuilder sb) {
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
		return new Twig(parent, getName(), values);
	}
}
