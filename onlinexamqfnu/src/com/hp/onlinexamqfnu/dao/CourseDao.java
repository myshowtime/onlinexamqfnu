package com.hp.onlinexamqfnu.dao;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexamqfnu.po.Course;
import com.hp.onlinexamqfnu.po.TeacherCourse;
import com.hp.onlinexamqfnu.util.DBUtil;
import com.hp.onlinexamqfnu.vo.TeacherCourseView;

public class CourseDao implements ICourseDao{
	DBUtil db = new DBUtil();
	@Override
	public List<TeacherCourseView> findAllTeaCourInfo() {
		return null;
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCourse(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAllCourses() {
		List courseList = null;
		String sql = "Select * From course";
		try {
			courseList = db.getQueryList(Course.class, sql,new Object[] {});
		}catch(Exception e) {
			courseList = new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTourse(int tcId) {
		// TODO Auto-generated method stub
		
	}

}
