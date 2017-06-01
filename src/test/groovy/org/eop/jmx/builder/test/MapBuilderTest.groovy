package org.eop.jmx.builder.test

import org.eop.chassis.test.AbstractCommonTest
import org.eop.jmx.builder.MapBuilder
import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Test

/**
 * @author lixinjie
 * @since 2017-06-01
 */
class MapBuilderTest extends AbstractCommonTest {

	@Test
	void test01() {
		def mb = new MapBuilder(true, false)
		mb.keyval('a', 'a')
		  .keyval('b', 10)
		  .keyval('c', true)
		Assert.assertEquals('[a:a, b:10, c:true]', mb.toMap().toString())
	}
	
	@Test
	void test02() {
		def mb = new MapBuilder(true, false)
		mb.keyvals('a', 'a', 'a')
		  .keyvals('b', 10, 11)
		  .keyvals('c', true, false)
		Assert.assertEquals('[a:[a, a], b:[10, 11], c:[true, false]]', mb.toMap().toString())
	}
	
	@Test
	void test03() {
		def mb = new MapBuilder(true, false)
		mb.keymap('a').keyval('b', 'b')
					  .keyvals('c', 'c', 'c')
					  .end()
		Assert.assertEquals('[a:[b:b, c:[c, c]]]', mb.toMap().toString())
	}
	
	@Test
	void test04() {
		def mb = new MapBuilder(true, false)
		mb.keylist('a').itemval('a')
					   .itemval(10)
					   .itemval(true)
					   .end()
		Assert.assertEquals('[a:[a, 10, true]]', mb.toMap().toString())
	}
	
	@Test
	void test05() {
		def mb = new MapBuilder(true, false)
		mb.keylist('a').itemvals('a', 'a')
					   .itemvals(10, 11)
					   .itemvals(true, false)
					   .end()
		Assert.assertEquals('[a:[[a, a], [10, 11], [true, false]]]', mb.toMap().toString())
	}
	
	@Test
	void test06() {
		def mb = new MapBuilder(true, false)
		mb.keylist('a').itemmap().keyval('a', 'a')
								 .keyvals('b', 'b', 10, true)
								 .end()
					   .itemmap().keyval('c', 10)
					   			 .keyvals('d', 'd', 11, true)
								 .end()
					   .end()
		Assert.assertEquals('[a:[[a:a, b:[b, 10, true]], [c:10, d:[d, 11, true]]]]', mb.toMap().toString())
	}
	
	@Test
	void test07() {
		def mb = new MapBuilder(true, false)
		mb.keylist('a').itemlist().itemmap().keyval('a', 'a')
								 			.keyvals('b', 'b', 10, true)
											.end()
								  .itemmap().keyval('c', 10)
											.keyvals('d', 'd', 11, true)
											.end()
								  .end()
					   .itemlist().itemval(10)
					   			  .itemval(true)
								  .end()
					   .end()
		Assert.assertEquals('[a:[[[a:a, b:[b, 10, true]], [c:10, d:[d, 11, true]]], [10, true]]]', mb.toMap().toString())
	}
}
