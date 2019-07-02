package com.xiaoyue.proxyJDK;

import java.util.Arrays;

public class GetAdvicer {
	private String[] methodName;

	public String[] getMethodName() {
		return methodName;
	}

	public void setMethodName(String[] methodName) {
		this.methodName = methodName;
	}

	public GetAdvicer(String[] methodName) {
		super();
		this.methodName = methodName;
	}

	public GetAdvicer() {
		super();
	}

	@Override
	public String toString() {
		return "GetAdvicer [methodName=" + Arrays.toString(methodName) + "]";
	}


	
}
