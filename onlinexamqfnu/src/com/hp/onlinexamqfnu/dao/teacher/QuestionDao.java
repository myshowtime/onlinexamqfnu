package com.hp.onlinexamqfnu.dao.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.Question;
import com.hp.onlinexamqfnu.util.DBUtil;

public class QuestionDao implements IQuestionDao{
	DBUtil db = new DBUtil();
	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		String sql = null;
		List<Map<String ,Object>> qList=null;
		if(key == null) {
			sql = "SELECT que.id ,c.name, que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c where que.courseId = c.id";
		}else {
			sql = "SELECT que.id ,c.name, que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c where que.courseId = c.id and "
					+ key + " like '%" + value + "%'";
		}
		try {
			qList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return qList;
	}

	@Override
	public void addQuestion(Question q) {
		String sql = "insert into questions(courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans,queExist) "
				+ "values(?,?,?,?,?,?,?,?,1)";
		try {
			db.execute(sql,new Object[] {q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns()});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		Map<String ,Object> q  = null;
		String sql = "select * from questions where id = ?";
		try {
			q= db.getObject(sql,new Object [] {id});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return q;
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateQuestionInfo(Question q) {
		String sql = "update questions set courseId = ?, queType = ?, queTitle = ?, choiceA = ?, choiceB = ?,choiceC = ?, choiceD = ?, ans = ? where id = ?";
		try {
			db.execute(sql,new Object[] {q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),q.getId()});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		String sql = "select * from questions where courseId = ?";
		List questionList = new ArrayList();
		try {
			questionList = db.getQueryList(sql,new Object[] {courseId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionList;
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
