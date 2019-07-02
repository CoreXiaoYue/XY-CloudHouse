package com.xiaoyue.ssm.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    	User user = new User();
    	System.out.println("loginPage");
    	model.addAttribute("user", user);
	return "loginPage";
    }
    
  
	/*
	 * @RequestMapping("/checkName/{name}")
	 * 
	 * @ResponseBody public String checkName(@PathVariable Object name) {
	 * System.out.println(name); boolean flog=false; User user =
	 * userService.checkUserName(name); if(user!=null) { return "1"; } return "0"; }
	 */
    
    
    @RequestMapping("/checkName")
    public void checkName(@RequestBody User user ,HttpServletResponse response) throws Exception {
    	boolean flog=false;
    	System.out.println(user.getName());
    	User user1 = userService.checkUserName(user.getName());
    	if(user1!=null) { 
    		response.setContentType("text/html;charset=utf-8");
    		response.getWriter().print(1);
    	}else {
    		response.setContentType("text/html;charset=utf-8");
    		response.getWriter().print(0);
		}
    }
    
    @RequestMapping("/login")
    public String login(HttpSession session,@Valid @ModelAttribute User user,Errors errors,Model model) {
    	if(errors.hasErrors()) {
    		return "loginPage";
    	}
	System.out.println(user.toString());
	HashMap< String , Object> map=new HashMap<String, Object>();
	map.put("user", user);
	 User users= userService.selectUser(map);
	if(users==null) {
		model.addAttribute("msg", "密码错误");
	    return "loginPage";
	}
	session.setAttribute("user", user);
	return "redirect:/listStudent";
    }
}
