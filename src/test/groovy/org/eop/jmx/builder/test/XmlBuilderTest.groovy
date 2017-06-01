package org.eop.jmx.builder.test

import org.eop.chassis.test.AbstractCommonTest
import org.eop.jmx.builder.XmlBuilder
import org.junit.Assert
import org.junit.Test

/**
 * @author lixinjie
 * @since 2017-06-01
 */
class XmlBuilderTest extends AbstractCommonTest {
	
	@Test
	void test01() {
		def xb = new XmlBuilder();
		xb.declaration()
		Assert.assertEquals('<?xml version="1.0" encoding="UTF-8"?>', xb.toXml())
	}
	
	@Test
	void test02() {
		def xb = new XmlBuilder();
		xb.docType('mapper', '-//mybatis.org//DTD Mapper 3.0//EN', null, 'http://mybatis.org/dtd/mybatis-3-mapper.dtd')
		Assert.assertEquals('<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">', xb.toXml())
	}
	
	@Test
	void test03() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').namespace(null, 'http://www.w3.org/1999/xhtml')
								.namespace('math', 'http://www.w3.org/1999/Math/MathMl')
		Assert.assertEquals('<mapper xmlns="http://www.w3.org/1999/xhtml" xmlns:math="http://www.w3.org/1999/Math/MathMl"></mapper>', xb.toXml())
	}
	
	@Test
	void test04() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').attribute('namespace', 'http://mybatis.org')
								.attribute('ns', 'class', 'http://mybatis.org')
		Assert.assertEquals('<mapper namespace="http://mybatis.org" ns:class="http://mybatis.org"></mapper>', xb.toXml())
	}
	
	@Test
	void test05() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').text('mapper')
		Assert.assertEquals('<mapper>mapper</mapper>', xb.toXml())
	}
	
	@Test
	void test06() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').text('select', 'select * from table')
		Assert.assertEquals('<mapper><select>select * from table</select></mapper>', xb.toXml())
	}
	
	@Test
	void test07() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').text('ns', 'select', 'select * from table')
		Assert.assertEquals('<mapper><ns:select>select * from table</ns:select></mapper>', xb.toXml())
	}
	
	@Test
	void test08() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').texts('select', ['select * from table1', 'select * from table2'] as Object[])
		Assert.assertEquals('<mapper><select>select * from table1</select><select>select * from table2</select></mapper>', xb.toXml())
	}
	
	@Test
	void test09() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').texts('ns', 'select', ['select * from table1', 'select * from table2'] as Object[])
		Assert.assertEquals('<mapper><ns:select>select * from table1</ns:select><ns:select>select * from table2</ns:select></mapper>', xb.toXml())
	}
	
	@Test
	void test10() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').cdata('select * from table where id > 10')
		Assert.assertEquals('<mapper><![CDATA[select * from table where id > 10]]></mapper>', xb.toXml())
	}
	
	@Test
	void test11() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').cdata('select', 'select * from table where id > 10')
		Assert.assertEquals('<mapper><select><![CDATA[select * from table where id > 10]]></select></mapper>', xb.toXml())
	}
	
	@Test
	void test12() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').cdata('ns', 'select', 'select * from table where id > 10')
		Assert.assertEquals('<mapper><ns:select><![CDATA[select * from table where id > 10]]></ns:select></mapper>', xb.toXml())
	}
	
	@Test
	void test13() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').cdatas('select', ['select * from table where id > 10', 'select * from table where id < 10'] as Object[])
		Assert.assertEquals('<mapper><select><![CDATA[select * from table where id > 10]]></select><select><![CDATA[select * from table where id < 10]]></select></mapper>', xb.toXml())
	}
	
	@Test
	void test14() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').cdatas('ns', 'select', ['select * from table where id > 10', 'select * from table where id < 10'] as Object[])
		Assert.assertEquals('<mapper><ns:select><![CDATA[select * from table where id > 10]]></ns:select><ns:select><![CDATA[select * from table where id < 10]]></ns:select></mapper>', xb.toXml())
	}
	
	@Test
	void test15() {
		def xb = new XmlBuilder();
		xb.rootElement('mapper').comment('this is a comment')
		Assert.assertEquals('<mapper><!--this is a comment--></mapper>', xb.toXml())
	}
}
