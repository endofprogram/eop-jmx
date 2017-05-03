package org.eop.jmx.builder.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * lixinjie 2016-12-26
 */
public class Context {

	private Map<String, Object> map;
	private List<Object> list;
	private MapType mapType;
	private ListType listType;
	
	public Context(MapType mapType, ListType listType) {
		this.mapType = mapType;
		this.listType = listType;
		this.map = generateMap();
	}
	
	public Context(ListType listType, MapType mapType) {
		this.listType = listType;
		this.mapType = mapType;
		this.list = generateList();
	}
	
	public void add(String key, Object val) {
		map.put(key, val);
	}
	
	public void add(Object val) {
		list.add(val);
	}
	
	public Map<String, Object> getMap() {
		return map;
	}
	
	public List<Object> getList() {
		return list;
	}
	
	public MapType getMapType() {
		return mapType;
	}
	
	public ListType getListType() {
		return listType;
	}
	
	protected Map<String, Object> generateMap() {
		if (mapType == MapType.HashMap) {
			return new HashMap<>();
		}
		if (mapType == MapType.LinkedHashMap) {
			return new LinkedHashMap<>();
		}
		return null;
	}
	
	protected List<Object> generateList() {
		if (listType == ListType.ArrayList) {
			return new ArrayList<>();
		}
		if (listType == ListType.LinkedList) {
			return new LinkedList<>();
		}
		return null;
	}
	
	public enum MapType {
		HashMap,
		LinkedHashMap
	}
	
	public enum ListType {
		ArrayList,
		LinkedList
	}
}
