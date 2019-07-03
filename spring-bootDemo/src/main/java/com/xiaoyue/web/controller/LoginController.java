package com.xiaoyue.web.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoyue.web.model.User;
import com.xiaoyue.web.service.UserService;



@Controller
public class LoginController {
    @Autowired
    UserService userService;
    //添加学生预页面。
    @RequestMapping("/loginPage")
    public String loginPage(Model model) {
	model.addAttribute("user", new User());
	return "loginPage";
    }
    @RequestMapping("/login")
    public String login(Model model,User user,HttpSession session) {
	System.out.println(user.toString());
	HashMap< String , Object> map=new HashMap<String, Object>();
	map.put("user", user);
	 Integer count = userService.selectUser(map);
	if(count<1) {
	    return "loginPage";
	}
	session.setAttribute("user", user);
	return "redirect:/listStudent";
    }
}
