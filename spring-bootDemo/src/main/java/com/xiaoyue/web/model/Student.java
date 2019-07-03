package com.xiaoyue.web.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String name;
    private String gender;//性别
    private String department;//院系
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date admission;//入学时间
    private String professional;//专业
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public Date getAdmission() {
        return admission;
    }
    public void setAdmission(Date admission) {
        this.admission = admission;
    }
    public String getProfessional() {
        return professional;
    }
    public void setProfessional(String professional) {
        this.professional = professional;
    }
    @Override
    public String toString() {
	return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department
		+ ", admission=" + admission + ", professional=" + professional + "]";
    }
    
}
