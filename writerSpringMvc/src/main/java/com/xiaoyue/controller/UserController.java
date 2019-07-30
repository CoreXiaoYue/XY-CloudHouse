package com.xiaoyue.controller;

import com.xiaoyue.Service.UserService;
import com.xiaoyue.anotation.OwnAutoAware;
import com.xiaoyue.anotation.OwnController;
import com.xiaoyue.anotation.OwnRequestMapping;

/**
 * @author 小岳
 * 		控制层组件
 *
 */
@OwnController
@OwnRequestMapping("/user")
public class UserController {
	@OwnAutoAware
	UserService userServiceImpl;


	@OwnRequestMapping("/add")
	public String add(String name) {
		String result = null;
		if(userServiceImpl!=null) {
			 result = userServiceImpl.add(name);
			 return result;
		}else {
			System.out.println("Service组件没有注入");
		}
		return null;
	}
}
