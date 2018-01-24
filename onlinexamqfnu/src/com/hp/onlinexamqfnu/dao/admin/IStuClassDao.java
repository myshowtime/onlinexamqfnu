package com.hp.onlinexamqfnu.dao.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.StuClass;

public interface IStuClassDao {

	public List<StuClass> findAllStuClassInfo();

	public StuClass findStuClassById(int classId) ;

	public void addStuClassById(StuClass sc) ;

	public void updateStuClassById(StuClass sc) ;
	
	public List findClassNamesByIds(String ids);
	
	public List<StuClass> findAllStuClassByTeacherId(long id);
}
