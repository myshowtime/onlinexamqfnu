package com.hp.onlinexamqfnu.dao;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexamqfnu.po.StuClass;
import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.util.DBUtil;

public class StuClassDao implements IStuClassDao{
	private DBUtil db = new DBUtil();

	@Override
	public List<StuClass> findAllStuClassInfo() {
		String sql = "Select * From stuclass";
		List stuClassList = new ArrayList();
		try {
			stuClassList = db.getQueryList(StuClass.class,sql,new Object[] {});
		}catch(Exception e) {
			stuClassList = new ArrayList();
			e.printStackTrace();
		}
		return stuClassList;
	}

	@Override
	public StuClass findStuClassById(int classId) {
		String sql = "select * from stuclass where id = ?";
		try {
			return (StuClass)db.getObject(StuClass.class,sql,new Object[] {classId});
		} catch (Exception e) {
			e.printStackTrace();
			return new StuClass();
		}
	}

	@Override
	public void addStuClassById(StuClass sc) {
		String sql = "insert into stuclass values(?,?,?)";
		try {
			db.execute(sql, new Object[]{sc.getId(),sc.getName(),sc.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStuClassById(StuClass sc) {
		String sql = "update stuclass set id = ?, name = ?, deptName = ? where id = ?";
		try {
			db.execute(sql,new Object[] {sc.getId(),sc.getName(),sc.getDeptName(),sc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String findClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
