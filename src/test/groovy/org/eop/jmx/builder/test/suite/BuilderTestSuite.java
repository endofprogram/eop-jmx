package org.eop.jmx.builder.test.suite;

import org.eop.jmx.builder.test.JsonBuilderTest;
import org.eop.jmx.builder.test.MapBuilderTest;
import org.eop.jmx.builder.test.XmlBuilderTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author lixinjie
 * @since 2017-06-03
 */
@RunWith(Suite.class)
@SuiteClasses({JsonBuilderTest.class, MapBuilderTest.class, XmlBuilderTest.class})
public class BuilderTestSuite {
	
}
