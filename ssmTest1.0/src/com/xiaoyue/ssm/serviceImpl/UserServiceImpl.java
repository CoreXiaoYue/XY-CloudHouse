package com.xiaoyue.ssm.serviceImpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyue.ssm.mapper.UserMapper;
import com.xiaoyue.ssm.pojo.User;
import com.xiaoyue.ssm.service.UserService;
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
    public User selectUser(HashMap<String , Object> map) {
	User user = userMapper.selectUser(map);
	return user;
    }

	@Override
	public User checkUserName(Object name) {
		return userMapper.checkUserName(name);
	}

}
