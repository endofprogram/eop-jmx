package org.eop.jmx.builder;

import org.eop.jmx.builder.json.Bole;
import org.eop.jmx.builder.json.Bough;
import org.eop.jmx.builder.json.Fork;
import org.eop.jmx.builder.json.ICNode;
import org.eop.jmx.builder.json.Leaf;
import org.eop.jmx.builder.json.Root;
import org.eop.jmx.builder.json.Stick;
import org.eop.jmx.builder.json.Trunk;
import org.eop.jmx.builder.json.Twig;
/**
 * lixinjie 2016-12-26
 */
public class JsonBuilder {

	private ICNode root;
	private ICNode currentNode;
	private int capacity;
	
	public JsonBuilder() {
		this(512);
	}
	
	public JsonBuilder(int capacity) {
		this.capacity = capacity;
		root = new Root(null, "");
		currentNode = root;
	}
	
	public JsonBuilder leaf(String name, Object value) {
		currentNode.addChild(new Leaf(currentNode, name, value));
		return this;
	}
	
	public JsonBuilder stick(String name, Object... values) {
		currentNode.addChild(new Stick(currentNode, name, values));
		return this;
	}
	
	public JsonBuilder fork(String name) {
		Fork fork = new Fork(currentNode, name);
		currentNode.addChild(fork);
		currentNode = fork;
		return this;
	}
	
	public JsonBuilder bole(String name) {
		Bole bole = new Bole(currentNode, name);
		currentNode.addChild(bole);
		currentNode = bole;
		return this;
	}
	
	public JsonBuilder twig(Object... values) {
		currentNode.addChild(new Twig(currentNode, values));
		return this;
	}
	
	public JsonBuilder trunk() {
		Trunk trunk = new Trunk(currentNode);
		currentNode.addChild(trunk);
		currentNode = trunk;
		return this;
	}
	
	public JsonBuilder bough() {
		Bough bough = new Bough(currentNode);
		currentNode.addChild(bough);
		currentNode = bough;
		return this;
	}
	
	public JsonBuilder end() {
		currentNode = (ICNode)currentNode.getParent();
		return this;
	}
	
	public String toJson() {
		return toJson(false);
	}
	
	public String toJson(boolean format) {
		StringBuilder sb = new StringBuilder(capacity);
		if (format) {
			root.toJson(sb, 0);
		} else {
			root.toJson(sb);
		}
		return sb.toString();
	}

}
