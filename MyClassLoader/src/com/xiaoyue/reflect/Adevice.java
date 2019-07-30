package com.xiaoyue.reflect;

import java.lang.reflect.Method;

public interface Adevice {
	void before(Method method);
	void after(Method method);
}
