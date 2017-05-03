package com.eop.jmx.builder.map;

import org.eop.jmx.builder.MapBuilder;

/**
 * @author lixinjie 2017-03-04
 */
public class MapBuilderSample {

	public static void main(String[] args) {
		map1();
		map2();
		map3();
		map4();
	}

	public static void map1() {
		MapBuilder mb = new MapBuilder();
		mb.root().keyval("name", "李新杰")
				 .keyval("age", 32)
				 .keyval("height", 1.81)
				 .keyval("man", true);
		System.out.println(mb.toMap());
	}
	
	public static void map2() {
		MapBuilder mb = new MapBuilder();
		mb.root().keyvals("phones", "13673960000", "13837140000")
				 .keyvals("workday", "Mon", "Tue", "Wen", "Thi", "Fri");
		System.out.println(mb.toMap());
	}
	
	public static void map3() {
		MapBuilder mb = new MapBuilder();
		mb.root().keymap("grade1").keyval("chinese", "good")
								  .keyval("english", "good")
								  .end()
				 .keymap("grade2").keyval("chinese", "more or less")
				 				  .keyval("english", "more or less")
				 				  .end();
		System.out.println(mb.toMap());
	}
	
	public static void map4() {
		MapBuilder mb = new MapBuilder();
		mb.root().keymaps("grade").itemmap().keyval("chi", "98")
											.keyval("eng", "92")
											.end()
								  .itemmap().keyval("math", "100")
								  			.keyval("phy", "96")
								  			.end()
								  .end();
		System.out.println(mb.toMap());
	}
}
