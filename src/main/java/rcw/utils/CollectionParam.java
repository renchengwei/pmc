package rcw.utils;

import java.util.Collection;

public class CollectionParam {
	private String key;
	private Collection<Object> value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Collection<Object> getValue() {
		return value;
	}
	public void setValue(Collection<Object> value) {
		this.value = value;
	}
}
