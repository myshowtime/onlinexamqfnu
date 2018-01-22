package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.dao.IStudentDao;
import com.hp.onlinexamqfnu.dao.StudentDao;
import com.hp.onlinexamqfnu.po.Student;

public class StudentService implements IStudentService{
	private IStudentDao sd = new StudentDao();
	
	@Override
	public void addStudent(Student s) {
		sd.addStudent(s);
	}

	@Override
	public void updateStudent(Student s) {
		sd.updateStudent(s);
	}

	@Override
	public Student findStudentById(int id) {
		return sd.findStudentById(id);
	}

	@Override
	public List<Map<String, Object>> findAll() {	
		return sd.findAll();
	}

}
