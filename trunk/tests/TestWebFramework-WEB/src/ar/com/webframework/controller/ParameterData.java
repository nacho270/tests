package ar.com.webframework.controller;

@Deprecated
public class ParameterData<T> {
	
	private String name;
	private T value;
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public ParameterData(String name, T value) {
		this.name = name;
		this.value = value;
		clazz = (Class<T>)value.getClass();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
}
