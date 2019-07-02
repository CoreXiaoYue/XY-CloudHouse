package com.xiaoyue.ssm.mapperImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.xiaoyue.ssm.mapper.StudentMapper;
import com.xiaoyue.ssm.pojo.Student;

public class StudentMapperImpl extends SqlSessionDaoSupport implements StudentMapper{


    @Override
    public List<Student> selectAll() {
	SqlSession sqlSession = this.getSqlSession();
	StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
	List<Student> list = studentMapper.selectAll();
	return list;
    }

    @Override
    public Student selectById(Integer id) {
	SqlSession sqlSession = this.getSqlSession();
	StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
	Student student = studentMapper.selectById(id);
	return student;
    }

    @Override
    public void insertStudent(Student student) {
	SqlSession sqlSession = this.getSqlSession();
	StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
	studentMapper.insertStudent(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
	SqlSession sqlSession = this.getSqlSession();
	StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
	studentMapper.deleteStudentById(id);
    }

    @Override
    public void updateStudentById(Student student) {
	System.out.println("进入updateStudentById");
	SqlSession sqlSession = this.getSqlSession();
	StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
	studentMapper.updateStudentById(student);
    }

    @Override
    public void updateStudentByIdMap(HashMap<String, Object> map) {
	SqlSession sqlSession = this.getSqlSession();
	StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
	studentMapper.updateStudentByIdMap(map);
    }
}
