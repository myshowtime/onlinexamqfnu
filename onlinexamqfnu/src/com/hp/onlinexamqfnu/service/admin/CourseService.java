package com.hp.onlinexamqfnu.service.admin;

import java.util.List;

import com.hp.onlinexamqfnu.dao.admin.CourseDao;
import com.hp.onlinexamqfnu.dao.admin.ICourseDao;
import com.hp.onlinexamqfnu.po.Course;
import com.hp.onlinexamqfnu.po.TeacherCourse;
import com.hp.onlinexamqfnu.vo.TeacherCourseView;

public class CourseService implements ICourseService{
	private ICourseDao cd = new CourseDao(); 
	@Override
	public List<TeacherCourseView> findAll() {
		return cd.findAllTeaCourInfo();
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		return cd.findTeacherCourseById(id);
	}

	@Override
	public Course findCourseById(int id) {
		return cd.findCourseById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return cd.findAllCourses();
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		return cd.findAllCoursesByName(name);
	}

	@Override
	public void modifyTeacherCourse(TeacherCourse tc) {
		cd.updateTeacherCourse(tc);
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
		cd.addCourse(courseName);
	}

	@Override
	public void updateCourse(Course course) {
		cd.updateCourse(course);
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		cd.addTeacherCourse(tc);
	}

	@Override
	public List<Course> findAllCoursesByTeacherId(long id) {
		// TODO Auto-generated method stub
		return cd.findCoursesByTeacherId(id);
	}
}
