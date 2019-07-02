package com.xiaoyue.ssm.mapper;

import java.util.HashMap;

import com.xiaoyue.ssm.pojo.User;


public interface UserMapper {
    Integer selectUser(HashMap<String , Object> map) ; 
}
