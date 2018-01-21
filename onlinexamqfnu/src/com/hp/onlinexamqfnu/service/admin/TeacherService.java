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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

}
