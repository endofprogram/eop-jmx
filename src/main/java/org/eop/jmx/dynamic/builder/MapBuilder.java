package org.eop.jmx.dynamic.builder;

import java.util.HashMap;
import java.util.Map;

import org.eop.jmx.builder.map.ICNode;
import org.eop.jmx.builder.map.ItemMap;
import org.eop.jmx.builder.map.KeyMap;
import org.eop.jmx.builder.map.KeyMaps;
import org.eop.jmx.builder.map.KeyVal;
import org.eop.jmx.builder.map.KeyVals;
import org.eop.jmx.builder.map.RootMap;
/**
 * lixinjie 2016-12-26
 */
public class MapBuilder {

	private ICNode root;
	private ICNode currentNode;
	
	public MapBuilder() {
		
	}
	
	public MapBuilder root() {
		root = new RootMap();
		currentNode = root;
		return this;
	}
	
	public MapBuilder keyval(String key, Object val) {
		currentNode.addChild(new KeyVal(currentNode, key, val));
		return this;
	}
	
	public MapBuilder keyvals(String key, Object... vals) {
		currentNode.addChild(new KeyVals(currentNode, key, vals));
		return this;
	}
	
	public MapBuilder keymap(String key) {
		KeyMap keymap = new KeyMap(currentNode, key);
		currentNode.addChild(keymap);
		currentNode = keymap;
		return this;
	}
	
	public MapBuilder keymaps(String key) {
		KeyMaps keymaps = new KeyMaps(currentNode, key);
		currentNode.addChild(keymaps);
		currentNode = keymaps;
		return this;
	}
	
	public MapBuilder itemmap() {
		ItemMap itemmap = new ItemMap(currentNode);
		currentNode.addChild(itemmap);
		currentNode = itemmap;
		return this;
	}
	
	public MapBuilder end() {
		currentNode = currentNode.getParent();
		return this;
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		root.toMap(map);
		return map;
	}
	
}
