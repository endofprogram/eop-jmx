package org.eop.jmx.dynamic.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class Namespace extends XNode {

	private String prefix;
	private String uri;
	
	public Namespace(IXNode parent, String prefix, String uri, char quote) {
		super(parent, null, quote);
		this.prefix = prefix;
		this.uri = uri;
	}
	
	String getPrefix() {
		return prefix;
	}
	
	String getUri() {
		return uri;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		sb.append("xmlns");
		if (prefix != null && !prefix.isEmpty()) {
			sb.append(':').append(prefix);
		}
		sb.append('=').append(getQuote()).append(uri).append(getQuote());
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		sb.append("xmlns");
		if (prefix != null && !prefix.isEmpty()) {
			sb.append(':').append(prefix);
		}
		sb.append('=').append(getQuote()).append(uri).append(getQuote());
	}

	@Override
	public Namespace deepClone(IXNode parent) {
		return new Namespace(parent, prefix, uri, getQuote());
	}

}
