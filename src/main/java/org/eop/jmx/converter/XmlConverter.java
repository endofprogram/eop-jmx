package org.eop.jmx.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eop.jmx.converter.exception.ConvertException;
import org.eop.jmx.converter.setting.ConvertSetting;
import org.eop.jmx.converter.setting.EmptyElementConvertStategy;
import org.w3c.dom.NodeList;

/**
 * lixinjie
 */
public class XmlConverter {

	public static Map<String, Object> toMap(org.dom4j.Element element, ConvertSetting convertSetting) {
		try {
			return convertMap(element, "", convertSetting);
		} catch (Exception e) {
			throw new ConvertException("convert xml to map error", e);
		}
	}
	
	public static Map<String, Object> toMap(org.w3c.dom.Element element, ConvertSetting convertSetting) {
		try {
			return convertMap(element, "", convertSetting);
		} catch (Exception e) {
			throw new ConvertException("convert xml to map error", e);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected static Map<String, Object> convertMap(org.dom4j.Element element, String prefix, ConvertSetting convertSetting) {
		Map<String, Object> map = new LinkedHashMap<>();
		if (!element.hasContent()) {
			map.put(getMapKey(element.getName(), prefix, convertSetting), getValueForEmptyElement(convertSetting));
			return map;
		}
		List<org.dom4j.Element> children = (List<org.dom4j.Element>)element.elements();
		if (children == null || children.isEmpty()) {
			map.put(getMapKey(element.getName(), prefix, convertSetting), element.node(0).getText());
			return map;
		}
		for (org.dom4j.Element child : children) {
			Map<String, Object> cmap = convertMap(child, nextLevelPrefix(prefix, element.getName(), convertSetting.getSetting("key.mapping.src.key.delimiter")), convertSetting);
			addToParent(map, nextLevelPrefix(prefix, element.getName(), convertSetting.getSetting("key.mapping.src.key.delimiter")), child.getName(), cmap, convertSetting);
		}
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().endsWith("__status")) {
				iterator.remove();
			}
		}
		if (map.size() < 2) {
			String onlyKey = getOnlyKey(map.keySet());
			map.put(getMapKey(element.getName(), prefix, convertSetting), map.get(onlyKey));
			map.remove(onlyKey);
		}
		return map;
	}
	
	protected static Map<String, Object> convertMap(org.w3c.dom.Element element, String prefix, ConvertSetting convertSetting) {
		Map<String, Object> map = new LinkedHashMap<>();
		if (!element.hasChildNodes()) {
			map.put(getMapKey(element.getNodeName(), prefix, convertSetting), getValueForEmptyElement(convertSetting));
			return map;
		}
		List<org.w3c.dom.Element> children = getChildElements(element);
		if (children == null || children.isEmpty()) {
			map.put(getMapKey(element.getNodeName(), prefix, convertSetting), element.getFirstChild().getTextContent());
			return map;
		}
		for (org.w3c.dom.Element child : children) {
			Map<String, Object> cmap = convertMap(child, nextLevelPrefix(prefix, element.getNodeName(), convertSetting.getSetting("key.mapping.src.key.delimiter")), convertSetting);
			addToParent(map, nextLevelPrefix(prefix, element.getNodeName(), convertSetting.getSetting("key.mapping.src.key.delimiter")), child.getNodeName(), cmap, convertSetting);
		}
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().endsWith("__status")) {
				iterator.remove();
			}
		}
		if (map.size() < 2) {
			String onlyKey = getOnlyKey(map.keySet());
			map.put(getMapKey(element.getNodeName(), prefix, convertSetting), map.get(onlyKey));
			map.remove(onlyKey);
		}
		return map;
	}
	
	protected static List<org.w3c.dom.Element> getChildElements(org.w3c.dom.Element element) {
		List<org.w3c.dom.Element> children = new ArrayList<>();
		NodeList nl = element.getChildNodes();
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0, len = nl.getLength(); i < len; i++) {
				if (nl.item(i) instanceof org.w3c.dom.Element) {
					children.add((org.w3c.dom.Element)nl.item(i));
				}
			}
		}
		return children;
	}
	
	protected static void addToParent(Map<String, Object> map, String prefix, String key, Map<String, Object> cmap, ConvertSetting convertSetting) {
		if (cmap.size() < 2) {
			addToMap(map, getOnlyKey(cmap.keySet()), cmap.get(getOnlyKey(cmap.keySet())));
		} else {
			addToMap(map, getMapKey(key, prefix, convertSetting), cmap);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected static void addToMap(Map<String, Object> map, String key, Object value) {
		if (!map.containsKey(key)) {
			map.put(key, value);
			map.put(key + "__status", "single");
		} else {
			String valueStatus = (String)map.get(key + "__status");
			Object oval = map.get(key);
			if ("list".equals(valueStatus)) {
				((List<Object>)oval).add(value);
			} else if ("single".equals(valueStatus)) {
				List<Object> list = new ArrayList<>();
				list.add(oval);
				list.add(value);
				map.put(key, list);
				map.put(key + "__status", "list");
			}
		}
	}
	
	protected static String getOnlyKey(Set<String> keys) {
		return keys.iterator().next();
	}
	
	protected static String getMapKey(String key, String prefix, ConvertSetting convertSetting) {
		return convertSetting.getKeyMapper().getMapKey(prefix + key);
	}
	
	protected static String nextLevelPrefix(String prefix, String key, String delimiter) {
		return prefix + key + delimiter;
	}
	
	protected static Object getValueForEmptyElement(ConvertSetting convertSetting) {
		if (convertSetting.getEmptyElementConvertStategy() == EmptyElementConvertStategy.EmptyString) {
			return "";
		}
		if (convertSetting.getEmptyElementConvertStategy() == EmptyElementConvertStategy.EmptyList) {
			return new ArrayList<>();
		}
		return "";
	}

}
