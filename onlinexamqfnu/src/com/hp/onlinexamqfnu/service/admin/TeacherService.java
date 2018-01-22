package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.dao.TeacherDao;
import com.hp.onlinexamqfnu.po.Teacher;

public class TeacherService implements ITeacherService{
	
	TeacherDao td = new TeacherDao();
	@Override
	public List<Teacher> findAll() {
		List teaList = td.findAllTeacherInfo();
		return teaList;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		td.addTeacher(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldId) {
		td.updateTeacher(teacher, oldId);
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher findClassesByTeacherId(int teacherId) {
		return td.findClassesByTeacherId(teacherId);
	}

}
