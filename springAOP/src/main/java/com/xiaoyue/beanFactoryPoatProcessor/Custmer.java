package com.xiaoyue.beanFactoryPoatProcessor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xiaoyue.Dao.PersonDao;

public class Custmer implements InitializingBean {
	


	private String remark;

	public Custmer(String remark) {
		super();
		this.remark = remark;
	}

	public Custmer() {
		System.out.println("第二步调用无参构造器。");
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		System.out.println("第三部调用set方法。");
		this.remark = remark;
	}
	@PostConstruct
	public void init() {
		System.out.println("初始化");
		 this.remark = "修改之后的描述信息";
	}
	public void afterPropertiesSet() throws Exception {
		 System.out.println("第六步：调用afterPropertiesSet方法");
		
	}
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[描述：").append(remark);
        return builder.toString();
    }

	 
}
