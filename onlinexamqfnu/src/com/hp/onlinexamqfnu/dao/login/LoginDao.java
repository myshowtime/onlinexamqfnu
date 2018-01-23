package com.hp.onlinexamqfnu.dao.login;

import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.util.DBUtil;

public class LoginDao implements ILoginDao{
	DBUtil db = new DBUtil();
	@Override
	public Teacher canLogin(Teacher t) {
		String sql = "select * from teacher where name = ? and pwd = ?";
		Teacher tReturn = null;
		try {
			tReturn= (Teacher)db.getObject(Teacher.class,sql,new Object[] {t.getName(),t.getpwd()});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tReturn;
	}

	@Override
	public Student canLogin(Student s) {
		String sql = "select * from teacher where name = ? and pwd = ?";
		Student sReturn = null;
		try {
			sReturn= (Student)db.getObject(Student.class,sql,new Object[] {s.getName(),s.getPwd()});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sReturn;
	}

}
