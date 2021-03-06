package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.StuClass;

public interface IStuClassService {	

	public List<StuClass> findAll() ;
	
	public void addStuClass(StuClass sc);
	public void updateStuClass(StuClass sc);
	public StuClass findStuClassById(int id);
	
	public String findClassNamesByIds(String ids);
	public List<StuClass> findAllStuClassByTeacherId(long id);
}
