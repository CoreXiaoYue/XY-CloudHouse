package com.xiaoyue.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoyue.web.model.Student;
import com.xiaoyue.web.service.StudentService;

@Controller
public class StudentController {
    @Resource
    private StudentService studentService;


//    @ExceptionHandler(value=Exception.class)
//    public ModelAndView getExcepion(Exception ex)  {
//        ModelAndView mView =new ModelAndView();
//        mView.addObject("ex", ex);
//        mView.setViewName("error");
//        return mView;
//    }

    public StudentController()  {
        System.out.println("Controller前端控制器已就绪。");
    }

    //查询全部学生。
    @RequestMapping("/listStudent")
    public ModelAndView listStudent()  throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Student> listStudnet = studentService.selectAll();
        System.out.println(listStudnet.size());
        mv.addObject("list", listStudnet);
        mv.setViewName("list");
        return mv;
    }

    //添加学生预页面。
    @RequestMapping("/addpage")
    public String addpage() {
        return "addpage";
    }

    //添加学生。
    @RequestMapping("/insertStudent")
    public String insertStudent(Student student)  throws Exception{
        studentService.insertStudent(student);
        return "redirect:/listStudent";
    }

    //接收Id,删除学生。
    @RequestMapping("/deleteStudentById")
    public String deleteStudentById(@RequestParam("id") Integer id)  throws Exception{
        studentService.deleteStudentById(id);
        return "redirect:/listStudent";
    }

    //根据传入的id先查出要修改的学生数据在修改页面显示。
    @RequestMapping("/updatePage")
    public String updatePage(@RequestParam("id") Integer id, Model model)  throws Exception{
        Student student = studentService.selectById(id);
        model.addAttribute("student", student);
        return "updatePage";
    }


    //接收要更新的数据更新对象。使用普通pojo对象封装数据
    @RequestMapping("/updateStudentById")
    public String updateStudentById(@RequestParam("id") Integer id, Student student)  throws Exception{
        studentService.updateStudentById(id, student);
        return "redirect:/listStudent";
    }


    //接收要更新的数据更新对象。使用map集合封装pojo对象
    @RequestMapping("/updateStudentByIdMap")
    public String updateStudentByIdMap(@RequestParam("id") Integer id,Student student)  throws Exception{
        studentService.updateStudentByIdMap(id,student);
        return "redirect:/listStudent";
    }

    //根据条件查询。
    @RequestMapping("selectByquery")
    public String selectByquery(Student student,Model model)  throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("student", student);
        List<Student> list = studentService.selectByquery(map);
        model.addAttribute("list", list);
        return "list";
    }
    
    
}