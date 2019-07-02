package com.xiaoyue.ssm.service;

import java.util.HashMap;

import com.xiaoyue.ssm.pojo.User;

public interface UserService {
    User findUser(User user);
    void registerUser(User user);
    Integer selectUser(HashMap<String , Object> map);
}
