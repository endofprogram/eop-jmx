package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class Attribute extends XNode {

	private QName qname;
	private String value;
	
	public Attribute(IXNode parent, String name, String value, String prefix, char quote) {
		super(parent, name, quote);
		this.value = value;
		this.qname = new QName(this, name, prefix);
	}
	
	QName getQName() {
		return qname;
	}
	
	String getValue() {
		return value;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		qname.toXml(sb);
		sb.append('=');
		sb.append(getQuote()).append(value).append(getQuote());
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		qname.toXml(sb, indent);
		sb.append('=');
		sb.append(getQuote()).append(value).append(getQuote());
	}

	@Override
	public Attribute deepClone(IXNode parent) {
		return new Attribute(parent, getName(), value, qname.getPrefix(), getQuote());
	}

}
