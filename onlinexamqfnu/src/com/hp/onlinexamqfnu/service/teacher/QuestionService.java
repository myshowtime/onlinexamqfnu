package com.hp.onlinexamqfnu.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.dao.teacher.IQuestionDao;
import com.hp.onlinexamqfnu.dao.teacher.QuestionDao;
import com.hp.onlinexamqfnu.po.Question;

public class QuestionService implements IQuestionService{
	private IQuestionDao qd = new QuestionDao();
	@Override
	public List<Map<String, Object>> findAll(String key, String value) {
		// TODO Auto-generated method stub
		return qd.findAllQuestionInfo(key, value);
	}

	@Override
	public void addQuestion(Question q) {
		qd.addQuestion(q);
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateQuestionInfo(Question q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> collectQuestions(int courseId, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String testQuestionIds(List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
