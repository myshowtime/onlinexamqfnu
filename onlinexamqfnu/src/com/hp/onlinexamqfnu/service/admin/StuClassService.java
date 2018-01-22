package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.dao.IStuClassDao;
import com.hp.onlinexamqfnu.dao.StuClassDao;
import com.hp.onlinexamqfnu.po.StuClass;

public class StuClassService implements IStuClassService{
	
	private IStuClassDao scd = new StuClassDao();
	@Override
	public List<StuClass> findAll() {
		List stuClassList =  scd.findAllStuClassInfo();
		return stuClassList;
	}
	 @Override
	public void addStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.addStuClassById(sc);
	}

	@Override
	public void updateStuClass(StuClass sc) {
		scd.updateStuClassById(sc);
	}

	@Override
	public StuClass findStuClassById(int id) {
		return scd.findStuClassById(id);
	}

	@Override
	public String findClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
