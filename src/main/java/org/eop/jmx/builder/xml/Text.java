package org.eop.jmx.builder.xml;
/**
 * lixinjie 2016-12-26
 */
public class Text extends XNode {

	private Object text;
	
	public Text(IXNode parent, Object text) {
		super(parent, null);
		this.text = text;
	}
	
	Object getText() {
		return text;
	}
	
	@Override
	public void toXml(StringBuilder sb) {
		sb.append(text);
	}

	@Override
	public void toXml(StringBuilder sb, int indent) {
		sb.append(text);
	}

	@Override
	public Text deepClone(IXNode parent) {
		return new Text(parent, text);
	}

}
