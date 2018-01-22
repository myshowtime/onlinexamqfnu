package com.hp.onlinexamqfnu.service.admin;

import java.util.List;

import com.hp.onlinexamqfnu.dao.CourseDao;
import com.hp.onlinexamqfnu.dao.ICourseDao;
import com.hp.onlinexamqfnu.po.Course;
import com.hp.onlinexamqfnu.po.TeacherCourse;
import com.hp.onlinexamqfnu.vo.TeacherCourseView;

public class CourseService implements ICourseService{
	private ICourseDao cd = new CourseDao(); 
	@Override
	public List<TeacherCourseView> findAll() {
		return null;
	}

	@Override
	public TeacherCourseView findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findCourseById(int id) {
		return cd.findCourseById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		List courseList = cd.findAllCourses();
		return courseList;
	}

	@Override
	public List<Course> findAllCourses(String name) {
		return null;
	}

	@Override
	public void modifyTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTeacherCourse(int tcId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourse(String courseName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCourse(Course course) {
		cd.updateCourse(course);
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		// TODO Auto-generated method stub
		
	}

}
