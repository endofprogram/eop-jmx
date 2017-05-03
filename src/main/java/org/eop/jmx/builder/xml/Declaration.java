package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class Declaration extends XNode {

	private String version;
	private String encoding;
	
	public Declaration(IXNode parent, String version, String encoding, char quote) {
		super(parent, "xml", quote);
		this.version = version;
		this.encoding = encoding;
	}
	
	String getVersion() {
		return version;
	}
	
	String getEncoding() {
		return encoding;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		sb.append("<?");
		sb.append(getName());
		sb.append(" version=").append(getQuote()).append(version).append(getQuote());
		sb.append(" encoding=").append(getQuote()).append(encoding).append(getQuote());
		sb.append("?>");
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		sb.append("<?");
		sb.append(getName());
		sb.append(" version=").append(getQuote()).append(version).append(getQuote());
		sb.append(" encoding=").append(getQuote()).append(encoding).append(getQuote());
		sb.append("?>");
		xmlCRLF(sb);
	}

	@Override
	public Declaration deepClone(IXNode parent) {
		return new Declaration(parent, version, encoding, getQuote());
	}
}
