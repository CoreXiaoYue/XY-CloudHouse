package com.xiaoyue.Annotation;

public class AnnotationPojo {
	private String value;
	private String method;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public AnnotationPojo(String value, String method) {
		super();
		this.value = value;
		this.method = method;
	}
	public AnnotationPojo() {
		super();
	}
	@Override
	public String toString() {
		return "AnnotationPojo [value=" + value + ", method=" + method + "]";
	}
	
}
