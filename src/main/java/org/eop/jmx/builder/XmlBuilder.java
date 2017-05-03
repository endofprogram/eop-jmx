package org.eop.jmx.builder;

import org.eop.jmx.builder.xml.Attribute;
import org.eop.jmx.builder.xml.CData;
import org.eop.jmx.builder.xml.CDatas;
import org.eop.jmx.builder.xml.Comment;
import org.eop.jmx.builder.xml.Declaration;
import org.eop.jmx.builder.xml.DocType;
import org.eop.jmx.builder.xml.Document;
import org.eop.jmx.builder.xml.Element;
import org.eop.jmx.builder.xml.ICNode;
import org.eop.jmx.builder.xml.IDocument;
import org.eop.jmx.builder.xml.IElement;
import org.eop.jmx.builder.xml.Namespace;
import org.eop.jmx.builder.xml.Text;
import org.eop.jmx.builder.xml.Texts;
/**
 * lixinjie 2016-12-26
 */
public class XmlBuilder {

	private char declQuote;
	private char doctQuote;
	private char attrQuote;
	private int capacity;
	
	private IDocument document;
	private ICNode currentElement;
	
	public XmlBuilder() {
		this(1024);
	}
	
	public XmlBuilder(int capacity) {
		this('"', '"', '"', capacity);
	}
	
	public XmlBuilder(char declQuote, char doctQuote, char attrQuote) {
		this(declQuote, doctQuote, attrQuote, 1024);
	}
	
	public XmlBuilder(char declQuote, char doctQuote, char attrQuote, int capacity) {
		this.declQuote = declQuote;
		this.doctQuote = doctQuote;
		this.attrQuote = attrQuote;
		this.capacity = capacity;
		document = new Document();
	}
	
	public XmlBuilder declaration() {
		return declaration("1.0", "UTF-8");
	}
	
	public XmlBuilder declaration(String version, String encoding) {
		document.setDeclaration(new Declaration(document, version, encoding, declQuote));
		return this;
	}
	
	public XmlBuilder docType(String name, String publicID, String systemID, String... externalDTDs) {
		document.setDocType(new DocType(document, name, doctQuote, publicID, systemID, externalDTDs));
		return this;
	}
	
	public XmlBuilder rootElement(String name) {
		return rootElement(null, name);
	}
	
	public XmlBuilder rootElement(String namespace, String name) {
		return rootElement(namespace, name, false);
	}
	
	public XmlBuilder rootElement(String namespace, String name, boolean selfClosing) {
		Element root = new Element(document, namespace, name, selfClosing);
		document.setRoot(root);
		currentElement = root;
		return this;
	}
	
	public XmlBuilder element(String name) {
		return element(null, name);
	}
	
	public XmlBuilder element(String namespace, String name) {
		return element(namespace, name, false);
	}
	
	public XmlBuilder element(String namespace, String name, boolean selfClosing) {
		Element element = new Element(currentElement, namespace, name, selfClosing);
		currentElement.addChild(element);
		currentElement = element;
		return this;
	}
	
	public XmlBuilder namespace(String prefix, String uri) {
		((IElement)currentElement).addNamespace(new Namespace(currentElement, prefix, uri, attrQuote));
		return this;
	}
	
	public XmlBuilder attribute(String name, String value) {
		return attribute(null, name, value);
	}
	
	public XmlBuilder attribute(String namespace, String name, String value) {
		((IElement)currentElement).addAttribute(new Attribute(currentElement, namespace, name, value, attrQuote));
		return this;
	}
	
	public XmlBuilder text(Object text) {
		currentElement.addChild(new Text(currentElement, text));
		return this;
	}
	
	public XmlBuilder text(String name, Object text) {
		return text(null, name, text);
	}
	
	public XmlBuilder text(String namespace, String name, Object text) {
		Element element = new Element(currentElement, namespace, name, false);
		element.addChild(new Text(element, text));
		currentElement.addChild(element);
		return this;
	}
	
	public XmlBuilder texts(String name, Object[] texts) {
		return texts(null, name, texts);
	}
	
	public XmlBuilder texts(String namespace, String name, Object[] texts) {
		currentElement.addChild(new Texts(currentElement, namespace, name, texts));
		return this;
	}
	
	public XmlBuilder cdata(Object cdata) {
		currentElement.addChild(new CData(currentElement, cdata));
		return this;
	}
	
	public XmlBuilder cdata(String name, Object cdata) {
		return cdata(null, name, cdata);
	}
	
	public XmlBuilder cdata(String namespace, String name, Object cdata) {
		Element element = new Element(currentElement, namespace, name, false);
		element.addChild(new CData(element, cdata));
		currentElement.addChild(element);
		return this;
	}
	
	public XmlBuilder cdatas(String name, Object[] cdatas) {
		return cdatas(null, name, cdatas);
	}
	
	public XmlBuilder cdatas(String namespace, String name, Object[] cdatas) {
		currentElement.addChild(new CDatas(currentElement, namespace, name, cdatas));
		return this;
	}
	
	public XmlBuilder comment(Object comment) {
		currentElement.addChild(new Comment(currentElement, comment));
		return this;
	}
	
	public XmlBuilder end() {
		currentElement = (ICNode)currentElement.getParent();
		return this;
	}
	
	public String toXml() {
		return toXml(false);
	}
	
	public String toXml(boolean format) {
		StringBuilder sb = new StringBuilder(capacity);
		if (format) {
			document.toXml(sb, 0);
		} else {
			document.toXml(sb);
		}
		return sb.toString();
	}
}
