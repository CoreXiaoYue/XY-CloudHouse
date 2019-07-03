package com.xiaoyue.web.serviceImpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyue.web.mapper.UserMapper;
import com.xiaoyue.web.model.User;
import com.xiaoyue.web.service.UserService;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    
    @Override
    public User findUser(User user) {
	return null;
    }

    @Override
    public void registerUser(User user) {
	
    }

    @Override
    public Integer selectUser(HashMap<String , Object> map) {
	Integer count = userMapper.selectUser(map);
	return count;
    }
    
    public String helloTest() {
		return "hello";
    }

}
