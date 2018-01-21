package com.hp.onlinexamqfnu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.util.DBUtil;

public class TeacherDao implements ITeacherDao{
	DBUtil db = new DBUtil();
	@Override
	public List<Teacher> findAllTeacherInfo() {
		String sql = "Select * From teacher";
		List teaList = null;
		try {
			teaList = db.getQueryList(Teacher.class,sql,new Object[] {});
		}catch(Exception e) {
			teaList = new ArrayList();
			e.printStackTrace();
		}
		return teaList;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldId) {
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
