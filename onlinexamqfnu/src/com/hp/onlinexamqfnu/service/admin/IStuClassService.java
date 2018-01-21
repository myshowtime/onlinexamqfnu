package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.StuClass;

public interface IStuClassService {	

	public List<StuClass> findAll() ;
	
	public Map<String,Object> addstuClass(StuClass sc);
	public void updateStuClass(StuClass sc);
	public Map<String,Object> findStuClassById(int id);
	
	public String findClassNamesByIds(String ids);
}
