package org.eop.jmx.builder

import org.eop.chassis.test.AbstractCommonTest
import org.eop.jmx.builder.JsonBuilder
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * @author lixinjie
 */
class JsonBuilderTest extends AbstractCommonTest {
	
	@Test
	void testToJson1() {
		JsonBuilder jb = new JsonBuilder()
		jb.leaf('a', 'a')
		  .leaf('b', 1)
		  .leaf('c', true)
		Assert.assertEquals('{"a":"a","b":1,"c":true}', jb.toJson())
	}
	
	@Test
	void testToJson2() {
		
		
	}
	
	@Test
	void testToJson3() {
		
	}
	
	@Test
	void testToJson4() {
		
	}
	
	@Test
	void testToJson5() {
		
	}
	
	@Test
	void testToJson6() {
		
	}
	
	@Test
	void testToJson7() {
		
	}
	
	@Test
	void testToJson8() {
		
	}
	
	@Test
	void testToJson9() {
		
	}
}
