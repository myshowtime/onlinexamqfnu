package com.hp.onlinexamqfnu.dao;

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
	public Map<String, Object> findStuClassById(int classId) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String findClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
