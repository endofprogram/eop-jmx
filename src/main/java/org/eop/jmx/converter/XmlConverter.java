package org.eop.jmx.converter;

import java.util.Map;

import org.eop.jmx.converter.setting.ConvertSetting;

/**
 * lixinjie
 */
public class XmlConverter {

	public static Map<String, Object> toMap(org.dom4j.Element element, ConvertSetting convertSetting) {
		return null;
	}
	
	public static Map<String, Object> toMap(org.w3c.dom.Element element, ConvertSetting convertSetting) {
		return null;
	}
	
	public static String toJson(org.dom4j.Element element, ConvertSetting convertSetting) {
		return toJson(element, convertSetting, false);
	}
	
	public static String toJson(org.dom4j.Element element, ConvertSetting convertSetting, boolean format) {
		return null;
	}
	
	public static String toJson(org.w3c.dom.Element element, ConvertSetting convertSetting) {
		return toJson(element, convertSetting, false);
	}
	
	public static String toJson(org.w3c.dom.Element element, ConvertSetting convertSetting, boolean format) {
		return null;
	}
}
