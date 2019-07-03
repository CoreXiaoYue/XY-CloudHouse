package com.xiaoyue.web.mapper;

import org.apache.ibatis.annotations.*;

import com.xiaoyue.web.model.Student;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student")
    List<Student> selectAll();//查询全部
    
    @Select("select*from student where id=#{id}")
    Student selectById(@Param("id") Integer id) ;//根据id查询
    
    @Insert("insert into student(name,gender,department,admission,professional) values(#{name},#{gender},#{department},#{admission},#{professional})")
    void insertStudent(Student student);//添加学生
    
    @Delete("delete from student where id=#{id}")
    void deleteStudentById(@Param("id") Integer id);//根据Id删除
    
    @Update("update student set name=#{name},gender=#{gender},department=#{department},admission=#{admission},professional=#{professional} where id=#{id}")
    void updateStudentById(Student student);//更新学生
    
    @Update("update student set name=#{student.name},gender=#{student.gender},department=#{student.department},admission=#{student.admission},professional=#{student.professional} where id=#{student.id}")
    void updateStudentByIdMap(HashMap<String, Object> map);//更新学生
    
    @Select("SELECT id,name,gender,department,admission,professional FROM student where  name LIKE #{student.name} or department like #{student.department} or professional like #{student.professional} ")
    List<Student> selectByquery(HashMap<String, Object> map);
}
