package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class Comment extends XNode {

	private Object comment;
	
	public Comment(IXNode parent, Object comment) {
		super(parent, "");
		this.comment = comment;
	}
	
	Object getComment() {
		return comment;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		sb.append("<!--");
		sb.append(comment);
		sb.append("-->");
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		xmlIndent(sb, indent);
		sb.append("<!--");
		sb.append(comment);
		sb.append("-->");
		xmlCRLF(sb);
	}

	@Override
	public Comment deepClone(IXNode parent) {
		return new Comment(parent, comment);
	}

}
