package org.eop.jmx.builder.map;
/**
 * lixinjie 2016-12-26
 */
public class KeyList extends CNode {

	public KeyList(ICNode parent, String key) {
		super(parent, key);
	}
	
	@Override
	public void toMap(Context context) {
		Context ncontext = new Context(context.getListType(), context.getMapType());
		for (IMNode child : children) {
			child.toMap(ncontext);
		}
		context.add(key, ncontext.getList());
	}
}
