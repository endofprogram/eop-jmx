package org.eop.jmx.dynamic.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class DocType extends XNode {

	private String publicID;
	private String systemID;
	private String[] externalDTDs;
	
	public DocType(IXNode parent, String name, char quote, String publicID, String systemID, String... externalDTDs) {
		super(parent, name, quote);
		this.publicID = publicID;
		this.systemID = systemID;
		this.externalDTDs = externalDTDs;
	}
	
	String getPublicID() {
		return publicID;
	}
	
	String getSystemID() {
		return systemID;
	}
	
	String[] getExternalDTDs() {
		return externalDTDs;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		sb.append("<!DOCTYPE ");
		sb.append(getName());
		if (publicID !=null && !publicID.isEmpty()) {
			 sb.append(" PUBLIC ");
	         sb.append(getQuote()).append(publicID).append(getQuote());
		} else if (systemID != null && !systemID.isEmpty()) {
			sb.append(" SYSTEM ");
			sb.append(getQuote()).append(systemID).append(getQuote());
		}
		if (externalDTDs != null && externalDTDs.length > 0) {
			for (String dtd : externalDTDs) {
				sb.append(' ').append(getQuote());
				sb.append(dtd);
				sb.append(getQuote());
			}
		}
		sb.append('>');
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		sb.append("<!DOCTYPE ");
		sb.append(getName());
		if (publicID !=null && !publicID.isEmpty()) {
			 sb.append(" PUBLIC ");
	         sb.append(getQuote()).append(publicID).append(getQuote());
		} else if (systemID != null && !systemID.isEmpty()) {
			sb.append(" SYSTEM ");
			sb.append(getQuote()).append(systemID).append(getQuote());
		}
		if (externalDTDs != null && externalDTDs.length > 0) {
			for (String dtd : externalDTDs) {
				xmlCRLF(sb);
				sb.append(' ').append(getQuote());
				sb.append(dtd);
				sb.append(getQuote());
			}
		}
		sb.append('>');
		xmlCRLF(sb);
	}

	@Override
	public DocType deepClone(IXNode parent) {
		return new DocType(parent, getName(), getQuote(), publicID, systemID, externalDTDs);
	}

}
