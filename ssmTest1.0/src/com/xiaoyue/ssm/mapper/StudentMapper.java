package com.xiaoyue.ssm.mapper;

import java.util.HashMap;
import java.util.List;


import com.xiaoyue.ssm.pojo.Student;

public interface StudentMapper {
    
    List<Student> selectAll();//查询全部
    Student selectById(Integer id) ;//根据id查询
    void insertStudent(Student student);//添加学生
    void deleteStudentById(Integer id);//根据Id删除
    void updateStudentById(Student student);//更新学生
    void updateStudentByIdMap(HashMap<String, Object> map);//更新学生
}
