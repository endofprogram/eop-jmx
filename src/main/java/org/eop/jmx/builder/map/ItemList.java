package org.eop.jmx.builder.map;
/**
 * lixinjie 2016-12-26
 */
public class ItemList extends CNode {

	public ItemList(ICNode parent) {
		super(parent, "");
	}
	
	@Override
	public void toMap(Context context) {
		Context ncontext = new Context(context.getListType(), context.getMapType());
		for (IMNode child : children) {
			child.toMap(ncontext);
		}
		context.add(ncontext.getList());
	}
}
