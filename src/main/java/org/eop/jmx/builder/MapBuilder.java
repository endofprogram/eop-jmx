package org.eop.jmx.builder;

import java.util.Map;

import org.eop.jmx.builder.map.Context;
import org.eop.jmx.builder.map.Context.ListType;
import org.eop.jmx.builder.map.Context.MapType;
import org.eop.jmx.builder.map.ICNode;
import org.eop.jmx.builder.map.ItemList;
import org.eop.jmx.builder.map.ItemMap;
import org.eop.jmx.builder.map.ItemVal;
import org.eop.jmx.builder.map.ItemVals;
import org.eop.jmx.builder.map.KeyList;
import org.eop.jmx.builder.map.KeyMap;
import org.eop.jmx.builder.map.KeyVal;
import org.eop.jmx.builder.map.KeyVals;
import org.eop.jmx.builder.map.RootMap;
/**
 * lixinjie 2016-12-26
 */
public class MapBuilder {

	private ICNode root;
	private ICNode currentNode;
	private boolean useLinkedHashMap;
	private boolean useLinkedList;
	
	public MapBuilder() {
		this(false, false);
	}
	
	public MapBuilder(boolean useLinkedHashMap, boolean useLinkedList) {
		this.useLinkedHashMap = useLinkedHashMap;
		this.useLinkedList = useLinkedList;
		root = new RootMap(null);
		currentNode = root;
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
	
	public MapBuilder keylist(String key) {
		KeyList keylist = new KeyList(currentNode, key);
		currentNode.addChild(keylist);
		currentNode = keylist;
		return this;
	}
	
	public MapBuilder itemval(Object val) {
		currentNode.addChild(new ItemVal(currentNode, val));
		return this;
	}
	
	public MapBuilder itemvals(Object... vals) {
		currentNode.addChild(new ItemVals(currentNode, vals));
		return this;
	}
	
	public MapBuilder itemmap() {
		ItemMap itemmap = new ItemMap(currentNode);
		currentNode.addChild(itemmap);
		currentNode = itemmap;
		return this;
	}
	
	public MapBuilder itemlist() {
		ItemList itemlist = new ItemList(currentNode);
		currentNode.addChild(itemlist);
		currentNode = itemlist;
		return this;
	}
	
	public MapBuilder end() {
		currentNode = currentNode.getParent();
		return this;
	}
	
	public Map<String, Object> toMap() {
		Context context = new Context(useLinkedHashMap ? MapType.LinkedHashMap : MapType.HashMap, useLinkedList ? ListType.LinkedList : ListType.ArrayList);
		root.toMap(context);
		return context.getMap();
	}
	
}
