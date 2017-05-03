package org.eop.jmx.dynamic.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class CData extends XNode {

	private Object text;
	
	public CData(IXNode parent, Object text) {
		super(parent, null);
		this.text = text;
	}
	
	Object getText() {
		return text;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		sb.append("<![CDATA[");
		sb.append(text);
		sb.append("]]>");
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		xmlIndent(sb, indent);
		sb.append("<![CDATA[");
		sb.append(text);
		sb.append("]]>");
		xmlCRLF(sb);
	}

	@Override
	public CData deepClone(IXNode parent) {
		return new CData(parent, text);
	}

}
