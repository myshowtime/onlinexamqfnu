package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.Teacher;

public interface ITeacherService {		

	public List<Teacher> findAll();
	public void addTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher,int oldid);
	public Map<String,Object> findTeacherInfo(int id) ;
	
	public Teacher findClassesByTeacherId(int teacherId);
}
