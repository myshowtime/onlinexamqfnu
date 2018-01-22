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
		String sql = "Insert into teacher values(?,?,?,?)";
		try {
			db.execute(sql,new Object[] {teacher.getId(),teacher.getName(),teacher.getpwd(),teacher.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldId) {
		String sql = "update teacher set id=?,name=?,pwd=?,deptName =? where id =?";
		try {
			db.execute(sql,new Object[] {teacher.getId(),teacher.getName(),teacher.getpwd(),teacher.getDeptName(),teacher.getId()});
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
	}

	@Override
	public Teacher findTeacherInfo(int id) {
		String sql = "Select * from teacher where id = ?";
		try {
			return (Teacher)db.getObject(Teacher.class,sql,new Object[] {id});
		} catch (Exception e) {
			e.printStackTrace();
			return new Teacher();
		}
	}

	@Override
	public List<Teacher> findClassesByTeacherId(int teacherId) {
		return null;
	}

}
