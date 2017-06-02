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

	protected ConvertSetting(KeyMapper keyMapper) {
		this.settings = new HashMap<>();
		this.keyMapper = keyMapper;
		this.actionWhenNoMapping = ActionWhenNoMapping.UseSrcKey;
		this.actionWhenNullValue = ActionWhenNullValue.UseNullString;
		this.valueListToXmlStrategy = ValueListToXmlStrategy.MultipleChildrenWithSameName;
		this.emptyElementConvertStategy = EmptyElementConvertStategy.EmptyString;
		initDefaultSetting();
		initKeyMapper();
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
		addSetting("json.null.string", "null");
		addSetting("json.list.item.src.key", "__item");
		addSetting("xml.null.string", "null");
		addSetting("xml.list.item.delimiter", ",");
		addSetting("xml.list.src.key", "__list");
		addSetting("xml.list.item.src.key", "__item");
		addSetting("xml.root.src.key", "__root");
		addSetting("key.mapping.src.key.delimiter", ".");
	}
	
	protected void initKeyMapper() {
		keyMapper.setActionWhenNoMapping(actionWhenNoMapping);
		keyMapper.setSrcKeyDelimiter(getSetting("key.mapping.src.key.delimiter"));
	}
}
