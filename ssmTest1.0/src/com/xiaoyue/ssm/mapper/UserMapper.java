package com.xiaoyue.ssm.mapper;

import java.util.HashMap;

import com.xiaoyue.ssm.pojo.User;


public interface UserMapper {
	User selectUser(HashMap<String , Object> map) ; 
    User checkUserName(Object name);
}
