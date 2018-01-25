package com.hp.onlinexamqfnu.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.Test;
import com.hp.onlinexamqfnu.util.DBUtil;
import com.hp.onlinexamqfnu.util.ToolUtil;

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
		String sql = "SELECT t.*,c.name courseName ,GROUP_CONCAT(sc.name) classNames from test t, course c, stuclass sc where t.courseId = c.id and FIND_IN_SET(sc.id,t.classIds) and t.teacherId = ? and t.endDate > ? GROUP BY t.id";
		List<Map<String,Object>> testList = new ArrayList();
		try {
			testList = db.getQueryList(sql, new Object[] {teaId,ToolUtil.getCurrentTime()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testList;
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		String sql = "select * from test where id = ? and teacherId = ? ";
		Map<String ,Object> testMap = null;
		try {
			testMap = db.getObject(sql,new Object[] {id,teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		String sql  = "select t.name testName,c.id courseId,t.testTime,t.scores,t.id,t.classIds,t.endDate ,c.name courseName,t.questions,sc.name className from test as t ,course as c ,stuclass as sc where t.id = ? and c.id = t.courseId and sc.id = (Select classId from student where id = ?)";
		Map<String,Object> testMap = new HashMap();
		try {
			testMap = db.getObject(sql, new Object[] {testid,studentid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		String sql = "select DISTINCT t.id,t.name testName,t.courseId,c.name courseName ,t.endDate,t.classIds from test t,course c,student s where t.courseId =c.id and FIND_IN_SET(s.classId,t.classIds)and t.id not in (select testId from papers where studentId = ?)and s.id = ? and endDate > ?";
		List stuRecentTests = new ArrayList();
		try {
			stuRecentTests = db.getQueryList(sql,new Object[] {id,id,currData});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuRecentTests;
	}
	

}
