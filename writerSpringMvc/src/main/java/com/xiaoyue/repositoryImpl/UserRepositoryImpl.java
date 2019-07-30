package com.xiaoyue.repositoryImpl;

import com.xiaoyue.anotation.OwnRepository;
import com.xiaoyue.repository.Repository;
/**
 * @author 小岳
 * 			持久层dao实现类组件
 *
 */
@OwnRepository
public class UserRepositoryImpl implements Repository{

	/**
	 *	添加操作
	 */
	public String add(String name) {
		return "dao组件返回：ok"+name;
	}
	
}
