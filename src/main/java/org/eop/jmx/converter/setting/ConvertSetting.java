package org.eop.jmx.converter.setting;

import java.util.HashMap;
import java.util.Map;

import org.eop.jmx.converter.mapper.KeyMapper;

/**
 * @author lixinjie
 * @since 2017-05-11
 */
public class ConvertSetting {

	private Map<String, String> settings;
	private KeyMapper keyMapper;
	private ActionWhenNoMapping actionWhenNoMapping;
	private ActionWhenNullValue actionWhenNullValue;
	private ValueListToXmlStrategy valueListToXmlStrategy;
	private EmptyElementConvertStategy emptyElementConvertStategy;
	
	public ConvertSetting() {
		this(new KeyMapper());
	}
	
	public ConvertSetting(Map<String, String> map) {
		this(new KeyMapper(map));
	}

	public ConvertSetting(KeyMapper keyMapper) {
		this.settings = new HashMap<>();
		this.keyMapper = keyMapper;
		this.actionWhenNoMapping = ActionWhenNoMapping.UseSrcKey;
		this.actionWhenNullValue = ActionWhenNullValue.UseNullString;
		this.valueListToXmlStrategy = ValueListToXmlStrategy.MultipleChildrenWithSameName;
		this.emptyElementConvertStategy = EmptyElementConvertStategy.EmptyString;
		initDefaultSetting();
	}
	
	public void addSetting(String name, String value) {
		settings.put(name, value);
	}
	
	public String getSetting(String name) {
		return settings.get(name);
	}
	
	public KeyMapper getKeyMapper() {
		return keyMapper;
	}

	public void setKeyMapper(KeyMapper keyMapper) {
		this.keyMapper = keyMapper;
	}

	public ActionWhenNoMapping getActionWhenNoMapping() {
		return actionWhenNoMapping;
	}

	public void setActionWhenNoMapping(ActionWhenNoMapping actionWhenNoMapping) {
		this.actionWhenNoMapping = actionWhenNoMapping;
	}

	public ActionWhenNullValue getActionWhenNullValue() {
		return actionWhenNullValue;
	}

	public void setActionWhenNullValue(ActionWhenNullValue actionWhenNullValue) {
		this.actionWhenNullValue = actionWhenNullValue;
	}
	
	public ValueListToXmlStrategy getValueListToXmlStrategy() {
		return valueListToXmlStrategy;
	}

	public void setValueListToXmlStrategy(ValueListToXmlStrategy valueListToXmlStrategy) {
		this.valueListToXmlStrategy = valueListToXmlStrategy;
	}

	public EmptyElementConvertStategy getEmptyElementConvertStategy() {
		return emptyElementConvertStategy;
	}

	public void setEmptyElementConvertStategy(EmptyElementConvertStategy emptyElementConvertStategy) {
		this.emptyElementConvertStategy = emptyElementConvertStategy;
	}

	protected void initDefaultSetting() {
		addSetting("null.string", "null");
		addSetting("xml.list.split.char", ",");
		addSetting("list.item.src.key", "itemName");
		addSetting("map.root.src.key", "rootName");
	}
}
