package org.eop.jmx.parser;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.DocumentHelper;
import org.eop.jmx.parser.exception.ParseException;
import org.xml.sax.InputSource;

/**
 * @author lixinjie
 * @since 2017-06-02
 */
public class XmlParser {

	public static org.w3c.dom.Element parseW3cXml(String xml) {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xml))).getDocumentElement();
		} catch (Exception e) {
			throw new ParseException("parse xml error", e);
		}
	}
	
	public static org.dom4j.Element parseDom4jXml(String xml) {
		try {
			return DocumentHelper.parseText(xml).getRootElement();
		} catch (Exception e) {
			throw new ParseException("parse xml error", e);
		}
	}
}
