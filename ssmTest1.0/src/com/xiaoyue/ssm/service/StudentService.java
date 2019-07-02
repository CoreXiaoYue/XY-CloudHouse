package com.xiaoyue.ssm.service;

import java.util.List;

import com.xiaoyue.ssm.pojo.Student;

public interface StudentService {
    List<Student> selectAll();
    Student selectById(Integer id) ;
    void insertStudent(Student student);
    void deleteStudentById(Integer id);
    void updateStudentById(Integer id,Student student);
    void updateStudentByIdMap(Integer id, Student student);//更新学生
}
