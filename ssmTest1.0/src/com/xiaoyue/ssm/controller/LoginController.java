package com.xiaoyue.ssm.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoyue.ssm.pojo.User;
import com.xiaoyue.ssm.service.UserService;

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
	 User reuser = userService.selectUser(map);
	if(reuser != null) {
	    return "loginPage";
	}
	session.setAttribute("user", reuser);
	return "redirect:/listStudent";
    }
}
