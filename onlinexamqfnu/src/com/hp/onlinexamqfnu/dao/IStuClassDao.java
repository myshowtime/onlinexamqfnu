package com.hp.onlinexamqfnu.dao;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.StuClass;

public interface IStuClassDao {

	public List<StuClass> findAllStuClassInfo();

	public Map<String, Object> findStuClassById(int classId) ;

	public void addStuClassById(StuClass sc) ;

	public void updateStuClassById(StuClass sc) ;
	
	public String findClassNamesByIds(String ids);
}
