package com.xiaoyue.web.service;

import com.xiaoyue.web.model.Student;

import java.util.HashMap;
import java.util.List;


public interface StudentService {
    List<Student> selectAll();
    Student selectById(Integer id) ;
    void insertStudent(Student student);
    void deleteStudentById(Integer id);
    void updateStudentById(Integer id, Student student);
    void updateStudentByIdMap(Integer id, Student student);//更新学生
    List<Student> selectByquery(HashMap<String, Object> map);
}
