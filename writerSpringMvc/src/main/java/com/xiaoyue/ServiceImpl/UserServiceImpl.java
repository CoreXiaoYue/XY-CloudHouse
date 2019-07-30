package com.xiaoyue.ServiceImpl;

import com.xiaoyue.Service.UserService;
import com.xiaoyue.anotation.OwnAutoAware;
import com.xiaoyue.anotation.OwnService;
import com.xiaoyue.repository.Repository;
/**
 * @author 小岳
 * 		服务层UserService实现类组件
 *
 */
@OwnService
public class UserServiceImpl implements UserService{
	
	@OwnAutoAware
	Repository userRepositoryImpl;
	/**
	 *	添加操作
	 */
	public String add(String name) {
		if(userRepositoryImpl != null) {
			return userRepositoryImpl.add(name);
		}else {
			return "userRepository组件没有注入。";
		}
	}

}
