package org.eop.jmx.converter;

import org.eop.jmx.converter.exception.ConvertException;
import org.eop.jmx.converter.setting.ConvertSetting;

/**
 * lixinjie
 */
public class JsonConverter {
	
	public static String toXml(com.alibaba.fastjson.JSONObject json, ConvertSetting convertSetting) {
		return toXml(json, convertSetting, false);
	}

	public static String toXml(com.alibaba.fastjson.JSONObject json, ConvertSetting convertSetting, boolean format) {
		try {
			return MapConverter.toXml(json, convertSetting, format);
		} catch (Exception e) {
			throw new ConvertException("convert json to xml error", e);
		}
	}
	
	public static String toXml(net.sf.json.JSONObject json, ConvertSetting convertSetting) {
		return toXml(json, convertSetting, false);
	}
	
	@SuppressWarnings("unchecked")
	public static String toXml(net.sf.json.JSONObject json, ConvertSetting convertSetting, boolean format) {
		try {
			return MapConverter.toXml(json, convertSetting, format);
		} catch (Exception e) {
			throw new ConvertException("convert json to xml error", e);
		}
	}
}
