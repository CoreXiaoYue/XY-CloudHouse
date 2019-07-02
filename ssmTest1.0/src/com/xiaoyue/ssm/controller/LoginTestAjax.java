package com.xiaoyue.ssm.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaoyue.ssm.pojo.User;
import com.xiaoyue.ssm.service.UserService;

@Controller
public class LoginTestAjax {
    @Autowired
    UserService userService;
    
//    @PostMapping(value="checknameTest")
//    public Object LoginTest() {
//    	
//		return null;
//    	
//    }
    
    
    @PostMapping(value="checknameTest")
    @ResponseBody
    public Object checknameTest(@RequestBody User user,HttpServletResponse response) throws Exception {
    	System.out.println(user.getName());
    	System.out.println(user);
    	
    	User users = new User();
    	users.setId(user.getId());
    	users.setName(user.getName());
    	users.setPassword(user.getPassword());
    	return user;
//    	ObjectMapper mapper=new ObjectMapper();
//    	response.setContentType("text/html;charset=utf-8");
//		response.getWriter().print(mapper.writeValueAsString(user));
    }
    
    @RequestMapping(value="/checkpost2", method = RequestMethod.POST)
    @ResponseBody
    public String checkpost2(String name,String id) {
    	System.out.println(name);
    	System.out.println(id);
		return "success";
    }
    
    
    @RequestMapping(value="/checkpost4", method = RequestMethod.POST)
    @ResponseBody
    public String checkpost4(@RequestBody JSONObject jsonObject) {
    	List<String> list = jsonObject.getObject("list",List.class);
    	for (String string : list) {
			System.out.println(string);
		}
    	
    	Map map = jsonObject.getObject("map", Map.class);
    	Set entrySet = map.entrySet();
    	Iterator iterator = entrySet.iterator();
    	while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
    	
    	String string = jsonObject.getString("strings");
    	System.out.println(string);
    	String usernsme = jsonObject.getString("username");
    	System.out.println(usernsme);
    	if(usernsme.equals("小岳")) {
    		return "1";
    	}
		return "0";
    }
    
    @RequestMapping("/ajaxResopnseTest1")
    @ResponseBody
    public Object ajaxResopnseTest1(HttpServletResponse response) throws Exception {

    	User user=new User();
    	user.setName("兴虎");
    	user.setPassword("88888");
    	User user1=new User();
    	user1.setName("充军");
    	user1.setPassword("99999");
    	List<User> list=new ArrayList<User>();
    	list.add(user);
    	list.add(user1);
    	Map<String, User> map=new HashMap<String, User>();
    	map.put("user", user);
    	ObjectMapper mapper=new ObjectMapper();
    	response.setContentType("text/html;charset=utf-8");
//    	response.getWriter().print(JSONObject.toJSONString(user));
//    	response.getWriter().print(mapper.writeValueAsString(map));
		return list;
    	
    }
    
    
    @RequestMapping(value="/checkpost1")
    public void checkpost1(@RequestBody User user,HttpServletResponse response) throws Exception  {
    	System.out.println(user);
    	ObjectMapper mapper=new ObjectMapper();
    	System.out.println(mapper.writeValueAsString(user));
    	user.setId(20);
    	user.setPassword("1254");
    	response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(mapper.writeValueAsString(user));
    }
}
