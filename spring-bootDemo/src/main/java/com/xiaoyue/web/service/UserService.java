package com.xiaoyue.web.service;

import java.util.HashMap;


import com.xiaoyue.web.model.User;



public interface UserService {
    User findUser(User user);
    void registerUser(User user);
    Integer selectUser(HashMap<String , Object> map);
    String helloTest();
}
