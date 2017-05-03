package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public abstract class XNode implements IXNode {
	
	protected IXNode parent;
	protected String name;
	protected char quote;
	
	protected XNode(IXNode parent, String name) {
		this(parent, name, '\0');
	}
	
	protected XNode(IXNode parent, String name, char quote) {
		this.parent = parent;
		this.name = name;
		this.quote = quote;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public IXNode getParent() {
		return parent;
	}
	
	char getQuote() {
		return quote;
	}
	
	void setQuote(char quote) {
		this.quote = quote;
	}
	
	@Override
	public abstract void toXml(StringBuilder sb);
	
	@Override
	public abstract void toXml(StringBuilder sb, int indent);
	
	void xmlIndent(StringBuilder sb, int indent) {
		for (int i = 0; i < indent; i++) {
			sb.append("    ");
		}
	}
	
	void xmlCRLF(StringBuilder sb) {
		sb.append('\r').append('\n');
	}
}
