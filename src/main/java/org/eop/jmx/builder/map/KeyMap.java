package org.eop.jmx.builder.map;

/**
 * lixinjie 2016-12-26
 */
public class KeyMap extends CNode {

	public KeyMap(ICNode parent, String key) {
		super(parent, key);
	}

	@Override
	public void toMap(Context context) {
		Context ncontext = new Context(context.getMapType(), context.getListType());
		for (IMNode child : children) {
			child.toMap(ncontext);
		}
		context.add(key, ncontext.getMap());
	}
}
