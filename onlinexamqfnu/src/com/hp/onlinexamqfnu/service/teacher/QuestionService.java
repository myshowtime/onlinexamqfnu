package com.hp.onlinexamqfnu.service.teacher;

import java.util.ArrayList;
import java.util.Collections;
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
		return qd.findQuestionById(id);
	}

	@Override
	public void updateQuestionInfo(Question q) {
		// TODO Auto-generated method stub
		qd.updateQuestionInfo(q);
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> collectQuestions(int courseId, int num) {
		/**
		 * 1.根据课程id产讯出符合条件的试题集合
		 * 2.试题随机，把试题顺序打乱
		 * 3.如果试题数量足够，取钱num道题，如果不够，取所有试题
		 */
		List<Map<String,Object>> questionList = qd.findQuestionsByCourseId(courseId);
		if(null==questionList || questionList.size()<1)
			return new ArrayList();
		Collections.shuffle(questionList);
		if(questionList.size()>num)
			return questionList.subList(0, num);
		else return questionList;
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
