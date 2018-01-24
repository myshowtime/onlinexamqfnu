package com.hp.onlinexamqfnu.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.StuClass;
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
	public List findClassNamesByIds(String ids) {
		String sql ="Select name from stuclass where find_in_set(id,?)";
		List<Map<String ,Object>> classList = null;
		try {
			classList = db.getQueryList(sql,new Object[] {ids});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return classList;
		
	}

	@Override
	public List<StuClass> findAllStuClassByTeacherId(long id) {
		String sql = "Select DISTINCT sc.id,sc.name from stuclass as sc, teachercourse as tc where sc.id = tc.classId and tc.teaId = ?";
		List scList = null;
		try {
			scList = db.getQueryList(StuClass.class,sql,new Object[] {id});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return scList;
	}
}
