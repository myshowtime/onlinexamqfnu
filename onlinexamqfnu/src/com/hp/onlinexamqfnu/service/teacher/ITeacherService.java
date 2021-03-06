package com.hp.onlinexamqfnu.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.Teacher;

public interface ITeacherService {		

	public List<Teacher> findAll();
	public List<Teacher> findAllByName(String name);
	public void addTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher,int oldid);
	public Teacher findTeacherInfo(int id) ;
	
	public List<Teacher> findClassesByTeacherId(int teacherId);
}
