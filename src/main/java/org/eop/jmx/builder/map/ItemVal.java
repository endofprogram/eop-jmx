package org.eop.jmx.builder.map;
/**
 * lixinjie 2016-12-26
 */
public class ItemVal extends MNode {

	Object val;
	
	public ItemVal(ICNode parent, Object val) {
		super(parent, "");
		this.val = val;
	}

	@Override
	public void toMap(Context context) {
		context.add(val);
	}
}
