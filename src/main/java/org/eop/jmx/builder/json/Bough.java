package org.eop.jmx.builder.json;
/**
 * lixinjie 2016-12-26
 */
public class Bough extends CNode {

	public Bough(IJNode parent) {
		super(parent, "");
	}

	@Override
	public void toJson(StringBuilder sb) {
		sb.append('{');
		int len = sb.length();
		for (IJNode child : getChildren()) {
			child.toJson(sb);
			sb.append(',');
		}
		if (sb.length() > len) {
			sb.setLength(sb.length() - 1);
		}
		sb.append('}');
	}

	@Override
	public void toJson(StringBuilder sb, int indent) {
		jsonIndent(sb, indent);
		sb.append('{');
		int len = sb.length();
		for (IJNode child : getChildren()) {
			jsonCRLF(sb);
			child.toJson(sb, indent + 1);
			sb.append(',');
		}
		if (sb.length() > len) {
			sb.setLength(sb.length() - 1);
		}
		jsonCRLF(sb);
		jsonIndent(sb, indent);
		sb.append('}');
	}

	@Override
	public ICNode cloneSelf(IJNode parent) {
		return new Bough(parent);
	}

}
