package com.xiaoyue.web.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoyue.web.model.Student;

@Controller
public class TestController {
	
	
	@RequestMapping("testThymealf")
	public String testThymealf(Model model) throws Exception {
		List<Student> studentlist =new ArrayList<Student>();
	 	 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 	 Date date = dateFormat.parse("2013-11-13");
		studentlist.add(new Student(1,"小月","男","美术系",date,"美术学"));
		studentlist.add(new Student(2,"小月1","男1","美术系1",date,"美术学1"));
		model.addAttribute("users", studentlist);
		return "studentPage";
		
	}
}
