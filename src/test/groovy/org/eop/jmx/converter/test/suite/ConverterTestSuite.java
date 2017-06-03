package org.eop.jmx.converter.test.suite;

import org.eop.jmx.converter.test.MapConverterTest01;
import org.eop.jmx.converter.test.MapConverterTest02;
import org.eop.jmx.converter.test.MapConverterTest03;
import org.eop.jmx.converter.test.MapConverterTest04;
import org.eop.jmx.converter.test.XmlConverterTest01;
import org.eop.jmx.converter.test.XmlConverterTest02;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author lixinjie
 * @since 2017-06-03
 */
@RunWith(Suite.class)
@SuiteClasses({MapConverterTest01.class, MapConverterTest02.class, MapConverterTest03.class, MapConverterTest04.class, XmlConverterTest01.class, XmlConverterTest02.class})
public class ConverterTestSuite {
	
}
