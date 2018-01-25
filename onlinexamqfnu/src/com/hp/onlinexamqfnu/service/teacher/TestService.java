package com.hp.onlinexamqfnu.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.dao.admin.CourseDao;
import com.hp.onlinexamqfnu.dao.admin.ICourseDao;
import com.hp.onlinexamqfnu.dao.admin.IStuClassDao;
import com.hp.onlinexamqfnu.dao.admin.StuClassDao;
import com.hp.onlinexamqfnu.dao.teacher.IQuestionDao;
import com.hp.onlinexamqfnu.dao.teacher.ITestDao;
import com.hp.onlinexamqfnu.dao.teacher.QuestionDao;
import com.hp.onlinexamqfnu.dao.teacher.TestDao;
import com.hp.onlinexamqfnu.po.Test;

public class TestService implements ITestService {
	private ITestDao td = new TestDao();
	@Override
	public void createTest(Test t) {
		// TODO Auto-generated method stub
		td.createTest(t);
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		// TODO Auto-generated method stub
		return td.findTestsByTeaId(teaId);
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		Map<String ,Object> testMap = td.findTestById(id, teaId);
		return testMap;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
