package com.hp.onlinexamqfnu.dao.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.Test;
import com.hp.onlinexamqfnu.util.DBUtil;

public class TestDao implements ITestDao{
	DBUtil db = new DBUtil();
	@Override
	public void createTest(Test t) {
		String sql = "insert into test(name,courseId,endDate,questions,teacherId,classIds,testTime,scores) "
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql,new Object[] {t.getName(),t.getCourseId(),t.getEndDate(),t.getQuetions(),t.getTeacherId(),t.getClassIds(),t.getTestTime(),t.getScores()});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		// TODO Auto-generated method stub
		return null;
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
