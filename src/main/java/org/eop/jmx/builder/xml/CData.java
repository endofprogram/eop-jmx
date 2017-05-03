package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class CData extends XNode {

	private Object cdata;
	
	public CData(IXNode parent, Object cdata) {
		super(parent, null);
		this.cdata = cdata;
	}
	
	Object getCData() {
		return cdata;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		sb.append("<![CDATA[");
		sb.append(cdata);
		sb.append("]]>");
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		xmlIndent(sb, indent);
		sb.append("<![CDATA[");
		sb.append(cdata);
		sb.append("]]>");
		xmlCRLF(sb);
	}

	@Override
	public CData deepClone(IXNode parent) {
		return new CData(parent, cdata);
	}

}
