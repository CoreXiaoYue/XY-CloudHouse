package com.xiaoyue.importSelectBean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyInportSelect implements ImportSelector{

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] {"com.xiaoyue.bean.Person"};
	}

}
