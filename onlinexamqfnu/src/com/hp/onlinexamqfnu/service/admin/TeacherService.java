package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.dao.admin.TeacherDao;
import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.service.teacher.ITeacherService;

public class TeacherService implements ITeacherService{
	
	TeacherDao td = new TeacherDao();
	@Override
	public List<Teacher> findAll() {
		List teaList = td.findAllTeacherInfo();
		return teaList;
	}
	@Override
	public List<Teacher> findAllByName(String name) {
		List teaList = td.findAllTeacherInfoByName(name);
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
	public Teacher findTeacherInfo(int id) {
		return td.findTeacherInfo(id);
	}

	@Override
	public List<Teacher> findClassesByTeacherId(int teacherId) {
		return null;
	}

}
