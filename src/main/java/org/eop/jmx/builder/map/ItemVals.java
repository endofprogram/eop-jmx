package org.eop.jmx.builder.map;

import java.util.Arrays;
/**
 * lixinjie 2016-12-26
 */
public class ItemVals extends MNode {

	Object[] vals;
	
	public ItemVals(ICNode parent, Object... vals) {
		super(parent, "");
		this.vals = vals;
	}

	@Override
	public void toMap(Context context) {
		context.add(Arrays.asList(vals));
	}
}
