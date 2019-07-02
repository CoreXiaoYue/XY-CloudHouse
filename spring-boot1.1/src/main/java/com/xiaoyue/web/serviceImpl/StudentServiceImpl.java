package com.xiaoyue.web.serviceImpl;

import com.xiaoyue.web.mapper.StudentMapper;
import com.xiaoyue.web.model.Student;
import com.xiaoyue.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    
    public StudentServiceImpl() {
	System.out.println("Service组建准备就绪。");
    }
    
    //查询全部学生。
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
    @Override
    public List<Student> selectAll() {
	return studentMapper.selectAll();
    }
    
    //根据id查询
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
    @Override
    public Student selectById(Integer id) {
	Student student = studentMapper.selectById(id);
	return student;
    }
    //添加学生
    @Override
    public void insertStudent(Student student) {
	studentMapper.insertStudent(student);	
    }

    @Override
    public void deleteStudentById(Integer id) {
	studentMapper.deleteStudentById(id);
    }
    @Transactional
    @Override
    public void updateStudentById(Integer id, Student student) {
	System.out.println("进入updateStudentById");
	student.setId(id);
	studentMapper.updateStudentById(student);
	System.out.println("结束updateStudentById");
    }
    //接收要更新的数据更新对象。使用map集合封装pojo对象
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    @Override
    public void updateStudentByIdMap(Integer id,Student student) {
	HashMap<String, Object> map=new HashMap<String, Object>();
	student.setId(id);
	map.put("student", student);
	studentMapper.updateStudentByIdMap(map);
	
    }
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public List<Student> selectByquery(HashMap<String, Object> map) {
		return studentMapper.selectByquery(map);
	}

  

}
