package org.eop.jmx.dynamic.builder;

import org.eop.claw.Claw;
import org.eop.jmx.builder.xml.Attribute;
import org.eop.jmx.builder.xml.CData;
import org.eop.jmx.builder.xml.CDatas;
import org.eop.jmx.builder.xml.Comment;
import org.eop.jmx.builder.xml.DCData;
import org.eop.jmx.builder.xml.DCDatas;
import org.eop.jmx.builder.xml.DComment;
import org.eop.jmx.builder.xml.DDocument;
import org.eop.jmx.builder.xml.DElement;
import org.eop.jmx.builder.xml.DElements;
import org.eop.jmx.builder.xml.DText;
import org.eop.jmx.builder.xml.DTexts;
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
	}
	
	public XmlBuilder document() {
		document = new Document();
		return this;
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
		return rootElement(name, null);
	}
	
	public XmlBuilder rootElement(String name, String namespace) {
		return rootElement(name, false, namespace);
	}
	
	public XmlBuilder rootElement(String name, boolean selfClose, String namespace) {
		Element root = new Element(document, name, selfClose, namespace);
		document.setRoot(root);
		currentElement = root;
		return this;
	}
	
	public XmlBuilder element(String name) {
		return element(name, null);
	}
	
	public XmlBuilder element(String name, String namespace) {
		return element(name, false, namespace);
	}
	
	public XmlBuilder element(String name, boolean selfClose, String namespace) {
		Element element = new Element(currentElement, name, selfClose, namespace);
		currentElement.addChild(element);
		currentElement = element;
		return this;
	}
	
	public XmlBuilder namespace(String prefix, String uri) {
		((IElement)currentElement).addNamespace(new Namespace(currentElement, prefix, uri, attrQuote));
		return this;
	}
	
	public XmlBuilder attribute(String name, String value) {
		return attribute(name, value, null);
	}
	
	public XmlBuilder attribute(String name, String value, String namespace) {
		((IElement)currentElement).addAttribute(new Attribute(currentElement, name, value, namespace, attrQuote));
		return this;
	}
	
	public XmlBuilder text(Object text) {
		currentElement.addChild(new Text(currentElement, text));
		return this;
	}
	
	public XmlBuilder text(String name, Object text) {
		return text(name, text, null);
	}
	
	public XmlBuilder text(String name, Object text, String namespace) {
		Element element = new Element(currentElement, name, false, namespace);
		element.addChild(new Text(element, text));
		currentElement.addChild(element);
		return this;
	}
	
	public XmlBuilder texts(String name, Object[] texts) {
		return texts(name, texts, null);
	}
	
	public XmlBuilder texts(String name, Object[] texts, String namespace) {
		currentElement.addChild(new Texts(currentElement, name, texts, namespace));
		return this;
	}
	
	public XmlBuilder cdata(Object text) {
		currentElement.addChild(new CData(currentElement, text));
		return this;
	}
	
	public XmlBuilder cdata(String name, Object text) {
		return cdata(name, text, null);
	}
	
	public XmlBuilder cdata(String name, Object text, String namespace) {
		Element element = new Element(currentElement, name, false, namespace);
		element.addChild(new CData(element, text));
		currentElement.addChild(element);
		return this;
	}
	
	public XmlBuilder cdatas(String name, Object[] texts) {
		return cdatas(name, texts, null);
	}
	
	public XmlBuilder cdatas(String name, Object[] texts, String namespace) {
		currentElement.addChild(new CDatas(currentElement, name, texts, namespace));
		return this;
	}
	
	public XmlBuilder comment(Object text) {
		currentElement.addChild(new Comment(currentElement, text));
		return this;
	}
	
	public XmlBuilder end() {
		currentElement = (ICNode)currentElement.getParent();
		return this;
	}
	
	public XmlBuilder ddocument(Claw claw) {
		document = new DDocument(claw);
		return this;
	}
	
	public XmlBuilder drootElement(String name, String path) {
		return drootElement(name, path, null);
	}
	
	public XmlBuilder drootElement(String name, String path, String namespace) {
		return drootElement(name, false, path, namespace);
	}
	
	public XmlBuilder drootElement(String name, boolean selfClose, String path, String namespace) {
		DElement droot = new DElement(document, name, selfClose, path, namespace);
		document.setRoot(droot);
		currentElement = droot;
		return this;
	}
	
	public XmlBuilder delement(String name, String path) {
		return delement(name, path, null);
	}
	
	public XmlBuilder delement(String name, String path, String namespace) {
		return delement(name, false, path, namespace);
	}
	
	public XmlBuilder delement(String name, boolean selfClose, String path, String namespace) {
		DElement delement = new DElement(currentElement, name, selfClose, path, namespace);
		currentElement.addChild(delement);
		currentElement = delement;
		return this;
	}
	
	public XmlBuilder delements(String name, String path) {
		return delements(name, path, null);
	}
	
	public XmlBuilder delements(String name, String path, String namespace) {
		return delements(name, false, path, namespace);
	}
	
	public XmlBuilder delements(String name, boolean selfClose, String path, String namespace) {
		DElements delements = new DElements(currentElement, name, selfClose, path, namespace);
		currentElement.addChild(delements);
		currentElement = delements;
		return this;
	}
	
	public XmlBuilder dtext(String path) {
		currentElement.addChild(new DText(currentElement, path));
		return this;
	}
	
	public XmlBuilder dtext(String name, String path) {
		return dtext(name, path, null);
	}
	
	public XmlBuilder dtext(String name, String path, String namespace) {
		Element element = new Element(currentElement, name, false, namespace);
		element.addChild(new DText(element, path));
		currentElement.addChild(element);
		return this;
	}
	
	public XmlBuilder dtexts(String name, String path) {
		return dtexts(name, path, null);
	}
	
	public XmlBuilder dtexts(String name, String path, String namespace) {
		currentElement.addChild(new DTexts(currentElement, name, path, namespace));
		return this;
	}
	
	public XmlBuilder dcdata(String path) {
		currentElement.addChild(new DCData(currentElement, path));
		return this;
	}
	
	public XmlBuilder dcdata(String name, String path) {
		return dcdata(name, path, null);
	}
	
	public XmlBuilder dcdata(String name, String path, String namespace) {
		Element element = new Element(currentElement, name, false, namespace);
		element.addChild(new DCData(element, path));
		currentElement.addChild(element);
		return this;
	}
	
	public XmlBuilder dcdatas(String name, String path) {
		return dcdatas(name, path, null);
	}
	
	public XmlBuilder dcdatas(String name, String path, String namespace) {
		currentElement.addChild(new DCDatas(currentElement, name, path, namespace));
		return this;
	}
	
	public XmlBuilder dcomment(String path) {
		currentElement.addChild(new DComment(currentElement, path));
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
