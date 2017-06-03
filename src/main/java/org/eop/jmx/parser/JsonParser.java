package org.eop.jmx.parser;

import org.eop.jmx.parser.exception.ParseException;

import com.alibaba.fastjson.parser.Feature;

/**
 * @author lixinjie
 * @since 2017-06-02
 */
public class JsonParser {

	public static net.sf.json.JSONObject parseNetsfJson(String json) {
		try {
			return net.sf.json.JSONObject.fromObject(json);
		} catch (Exception e) {
			throw new ParseException("parse json error", e);
		}
	}
	
	public static com.alibaba.fastjson.JSONObject parseFastJson(String json) {
		try {
			return com.alibaba.fastjson.JSON.parseObject(json, Feature.OrderedField);
		} catch (Exception e) {
			throw new ParseException("parse json error", e);
		}
	}
}
