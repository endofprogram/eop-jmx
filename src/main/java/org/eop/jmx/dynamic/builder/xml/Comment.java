package org.eop.jmx.dynamic.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class Comment extends XNode {

	private Object text;
	
	public Comment(IXNode parent, Object text) {
		super(parent, null);
		this.text = text;
	}
	
	Object getText() {
		return text;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		sb.append("<!--");
		sb.append(text);
		sb.append("-->");
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		xmlIndent(sb, indent);
		sb.append("<!--");
		sb.append(text);
		sb.append("-->");
		xmlCRLF(sb);
	}

	@Override
	public Comment deepClone(IXNode parent) {
		return new Comment(parent, text);
	}

}
