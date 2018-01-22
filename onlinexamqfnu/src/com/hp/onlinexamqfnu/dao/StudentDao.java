package com.hp.onlinexamqfnu.dao;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.util.DBUtil;

public class StudentDao implements IStudentDao{
	DBUtil db = new DBUtil();
	@Override
	public void addStudent(Student s) {
		String sql = "Insert into student values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql,new Object[] {s.getId(),s.getName(),s.getPwd(),s.getSchool(),s.getDeptName(),s.getSex(),s.getBorn(),s.getClassId()});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void updateStudent(Student s) {
		String sql = "Update student set id = ?,name = ?, pwd = ?,school = ?, deptName = ?,sex = ?, born = ?. classId =? where id = ?";
		try {
			db.execute(sql,new Object[] {s.getId(),s.getName(),s.getPwd(),s.getSchool(),s.getDeptName(),s.getSex(),s.getBorn(),s.getClassId(),s.getId()});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student findStudentById(int id) {
		String sql= "Select * From student where id = ?";
		try {
			return (Student)db.getObject(Student.class,sql,new Object[] {id});
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> findAll() {
		String sql = "Select * From student";
		List stuList =  null;
		
		try {
			stuList = db.getQueryList(sql);
		} catch (Exception e) {
			stuList = new ArrayList();
			e.printStackTrace();
		}
		return stuList;
	}

}
