package org.eop.jmx.converter.test

import org.eop.chassis.test.AbstractCommonTest
import org.eop.jmx.converter.MapConverter
import org.eop.jmx.converter.XmlConverter
import org.eop.jmx.converter.setting.ConvertSetting
import org.eop.jmx.converter.setting.EmptyElementConvertStategy
import org.junit.Assert
import org.junit.Test

/**
 * @author lixinjie
 * @since 2017-06-02
 */
class MapConverterTest01 extends AbstractCommonTest {

	@Test
	void test01() {
		String xml = '''\
<a>
<c>c</c>
<b>b</b>
<c>c</c>
</a>'''
		ConvertSetting cs = new ConvertSetting()
		Assert.assertEquals('{"c":["c","c"],"b":"b"}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test02() {
		String xml = '''\
<a>
<c>c</c>
<c>c</c>
<c>c</c>
</a>'''
		ConvertSetting cs = new ConvertSetting()
		Assert.assertEquals('{"a":["c","c","c"]}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test03() {
		String xml = '''\
<a>
<c>
<d>d</d>
<d>d</d>
<d>d</d>
</c>
<c>
<e>e</e>
<e>e</e>
<e>e</e>
</c>
<c>
<f>f</f>
<f>f</f>
<f>f</f>
</c>
</a>'''
		ConvertSetting cs = new ConvertSetting()
		Assert.assertEquals('{"a":[["d","d","d"],["e","e","e"],["f","f","f"]]}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test04() {
		String xml = '''\
<a>
<c>
<d>
<g>g</g>
<g>g</g>
<g>g</g>
</d>
<d>
<h>h</h>
<h>h</h>
<h>h</h>
</d>
<d>
<g>g</g>
<g>g</g>
<g>g</g>
</d>
</c>
<c>
<e>
<h>h</h>
<h>h</h>
<h>h</h>
</e>
<e>
<g>g</g>
<g>g</g>
<g>g</g>
</e>
<e>
<h>h</h>
<h>h</h>
<h>h</h>
</e>
</c>
<c>
<f>
<g>g</g>
<g>g</g>
<g>g</g>
</f>
<f>
<h>h</h>
<h>h</h>
<h>h</h>
</f>
<f>
<g>g</g>
<g>g</g>
<g>g</g>
</f>
</c>
</a>'''
		ConvertSetting cs = new ConvertSetting()
		Assert.assertEquals('{"a":[[["g","g","g"],["h","h","h"],["g","g","g"]],[["h","h","h"],["g","g","g"],["h","h","h"]],[["g","g","g"],["h","h","h"],["g","g","g"]]]}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test05() {
		String xml = '''\
<a></a>'''
		ConvertSetting cs = new ConvertSetting()
		Assert.assertEquals('{"a":""}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test06() {
		String xml = '''\
<a></a>'''
		ConvertSetting cs = new ConvertSetting()
		cs.setEmptyElementConvertStategy(EmptyElementConvertStategy.EmptyList)
		Assert.assertEquals('{"a":[]}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test07() {
		String xml = '''\
<a>
<b></b>
<c></c>
<c></c>
</a>'''
		ConvertSetting cs = new ConvertSetting()
		Assert.assertEquals('{"b":"","c":["",""]}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test08() {
		String xml = '''\
<a>
<b></b>
<c></c>
<c></c>
</a>'''
		ConvertSetting cs = new ConvertSetting()
		cs.setEmptyElementConvertStategy(EmptyElementConvertStategy.EmptyList)
		Assert.assertEquals('{"b":[],"c":[[],[]]}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test09() {
		String xml = '''\
<a>
<b>b</b>
<c>c</c>
<c>c</c>
</a>'''
		ConvertSetting cs = new ConvertSetting(['a':'A', 'a.b':'B', 'a.c':'C'])
		Assert.assertEquals('{"B":"b","C":["c","c"]}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test10() {
		String xml = '''\
<a>
<b>
<d>
<d>d</d>
<e>e</e>
</d>
<e>
<d>d</d>
<e>e</e>
</e>
</b>
<c>
<d>
<d>d</d>
<e>e</e>
</d>
<e>
<d>d</d>
<e>e</e>
</e>
</c>
</a>'''
		ConvertSetting cs = new ConvertSetting(['a':'A', 'a.b':'B', 'a.b.d':'D1', 'a.b.d.d':'D1D', 'a.b.d.e':'D1E', 'a.b.e':'E1', 'a.b.e.d':'E1D', 'a.b.e.e':'E1E', 'a.c':'C'])
		Assert.assertEquals('{"B":{"D1":{"D1D":"d","D1E":"e"},"E1":{"E1D":"d","E1E":"e"}},"C":{"d":{"d":"d","e":"e"},"e":{"d":"d","e":"e"}}}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test11() {
		String xml = '''\
<a>
<b>b</b>
<b>b</b>
</a>'''
		ConvertSetting cs = new ConvertSetting(['a':'A', 'a.b':'B', 'a.c':'C'])
		Assert.assertEquals('{"A":["b","b"]}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test12() {
		String xml = '''\
<a>
<b>b</b>
<c>c</c>
<d>
<e>
<f>f</f>
<g>g</g>
</e>
<e>
<f>f</f>
<g>g</g>
</e>
</d>
</a>'''
		ConvertSetting cs = new ConvertSetting()
		Assert.assertEquals('{"b":"b","c":"c","d":[{"f":"f","g":"g"},{"f":"f","g":"g"}]}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test13() {
		String xml = '''\
<a>
<b>b</b>
<c>c</c>
<d>
<b>b</b>
<c>c</c>
<e>
<f>f</f>
<g>g</g>
</e>
<e>
<f>f</f>
<g>g</g>
</e>
</d>
<h>
<b>b</b>
<c>c</c>
<e>
<f>f</f>
<g>g</g>
</e>
<e>
<f>f</f>
<g>g</g>
</e>
</h>
</a>'''
		ConvertSetting cs = new ConvertSetting()
		Assert.assertEquals('{"b":"b","c":"c","d":{"b":"b","c":"c","e":[{"f":"f","g":"g"},{"f":"f","g":"g"}]},"h":{"b":"b","c":"c","e":[{"f":"f","g":"g"},{"f":"f","g":"g"}]}}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
	
	@Test
	void test14() {
		String xml = '''\
<a>
<b>b</b>
<c>c</c>
<x>x</x>
<x>x</x>
<d>
<b>b</b>
<c>c</c>
<xs>
<x>x</x>
<x>x</x>
</xs>
<es>
<e>
<f>f</f>
<g>g</g>
</e>
<e>
<f>f</f>
<g>g</g>
</e>
</es>
</d>
<h>
<b>b</b>
<c>c</c>
<x>x</x>
<x>x</x>
<es>
<e>
<f>f</f>
<g>g</g>
</e>
<e>
<f>f</f>
<g>g</g>
</e>
</es>
</h>
</a>'''
		ConvertSetting cs = new ConvertSetting()
		Assert.assertEquals('{"b":"b","c":"c","x":["x","x"],"d":{"b":"b","c":"c","xs":["x","x"],"es":[{"f":"f","g":"g"},{"f":"f","g":"g"}]},"h":{"b":"b","c":"c","x":["x","x"],"es":[{"f":"f","g":"g"},{"f":"f","g":"g"}]}}', MapConverter.toJson(XmlConverter.toMap(org.eop.jmx.parser.XmlParser.parseW3cXml(xml), cs), cs))
	}
}
