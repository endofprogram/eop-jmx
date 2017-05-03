package org.eop.jmx.builder.map;

/**
 * lixinjie 2016-12-26
 */
public class KeyVal extends MNode {

	Object val;
	
	public KeyVal(ICNode parent, String key, Object val) {
		super(parent, key);
		this.val = val;
	}

	@Override
	public void toMap(Context context) {
		context.add(key, val);
	}
}
