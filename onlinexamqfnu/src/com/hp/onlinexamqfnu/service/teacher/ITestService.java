package com.hp.onlinexamqfnu.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.Test;

public interface ITestService { 

	public void createTest(Test t) ;

	/**
	 * 返回试卷信息
	 * 
	 * @param teaId
	 * @return
	 */
	public List<Map<String, Object>> findTestsByTeaId(int teaId) ;

	public List<Map<String, Object>> findTestsById(int id, int teaId);
	public Map<String, Object> findStudentTestsById(int studentid,int testid) ;
	public List<Map<String, Object>> getTestByStudent(int id, String currData);
	
}
