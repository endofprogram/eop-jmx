package org.eop.jmx.builder.test

import org.eop.chassis.test.AbstractCommonTest
import org.eop.jmx.builder.JsonBuilder
import org.junit.Assert
import org.junit.Test

/**
 * @author lixinjie
 * @since 2017-06-01
 */
class JsonBuilderTest extends AbstractCommonTest {

	@Test
	void test01() {
		def jb = new JsonBuilder()
		jb.leaf('a', 'a')
		  .leaf('b', 10)
		  .leaf('c', true)
		Assert.assertEquals('{"a":"a","b":10,"c":true}', jb.toJson())
	}
	
	@Test
	void test02() {
		def jb = new JsonBuilder()
		jb.stick('a', 'a', 'a', 'a')
		  .stick('b', 10, 11, 12)
		  .stick('c', true, false, true)
		Assert.assertEquals('{"a":["a","a","a"],"b":[10,11,12],"c":[true,false,true]}', jb.toJson())
	}
	
	@Test
	void test03() {
		def jb = new JsonBuilder()
		jb.fork('a').leaf('c', 'c')
		           .stick('d', 10, 11, 12)
				   .end()
		  .fork('b').leaf('e', true)
		           .stick('f', 'f', 10, true)
				   .end()
		Assert.assertEquals('{"a":{"c":"c","d":[10,11,12]},"b":{"e":true,"f":["f",10,true]}}', jb.toJson())
	}
	
	@Test
	void test04() {
		def jb = new JsonBuilder()
		jb.bole('a').bud('a')
					.bud(10)
					.bud(true)
					.end()
		Assert.assertEquals('{"a":["a",10,true]}', jb.toJson())
	}
	
	@Test
	void test05() {
		def jb = new JsonBuilder()
		jb.bole('a').twig('a', 'a', 'a')
					.twig(10, 11, 12)
					.twig(false, true, false)
					.end()
		Assert.assertEquals('{"a":[["a","a","a"],[10,11,12],[false,true,false]]}', jb.toJson())
	}
	
	@Test
	void test06() {
		def jb = new JsonBuilder()
		jb.bole('a').bough().leaf('c', 'c')
		                    .stick('d', 10, 11, 12)
							.end()
					.bough().leaf('e', 'e')
					        .stick('f', true, true, true)
							.end()
		Assert.assertEquals('{"a":[{"c":"c","d":[10,11,12]},{"e":"e","f":[true,true,true]}]}', jb.toJson())
	}
	
	@Test
	void test07() {
		def jb = new JsonBuilder()
		jb.bole('a').trunk().bud(10)
							.twig(10, 11, 12)
							.end()
					.trunk().bough().leaf('b', false)
									.stick('c', 10, 11, 12)
									.end()
							.bough().leaf('d', false)
									.stick('e', 10, 11, 12)
									.end()
							.end()
		Assert.assertEquals('{"a":[[10,[10,11,12]],[{"b":false,"c":[10,11,12]},{"d":false,"e":[10,11,12]}]]}', jb.toJson())
	}
}
