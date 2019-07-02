package com.xiaoyue.ssm.service;

import java.util.HashMap;

import com.xiaoyue.ssm.pojo.User;

public interface UserService {
    User findUser(User user);
    void registerUser(User user);
    User selectUser(HashMap<String , Object> map);
    User checkUserName(Object name);
}
