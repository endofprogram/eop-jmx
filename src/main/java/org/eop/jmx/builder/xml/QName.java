package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class QName extends XNode {

	private String prefix;
	
	public QName(IXNode parent, String name, String prefix) {
		super(parent, name);
		this.prefix = prefix;
	}
	
	String getPrefix() {
		return prefix;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		if (prefix != null && !prefix.isEmpty()) {
			sb.append(prefix);
			sb.append(':');
		}
		sb.append(getName());
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		if (prefix != null && !prefix.isEmpty()) {
			sb.append(prefix);
			sb.append(':');
		}
		sb.append(getName());
	}

	@Override
	public QName deepClone(IXNode parent) {
		return new QName(parent, getName(), prefix);
	}

}
