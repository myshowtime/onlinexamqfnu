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
		String sql = "Select tc.id as tcId,t.`name` as teacherName, c.`name` as courseName, sc.`name` as stuclassName from teachercourse as tc,teacher as t,stuclass as sc,course as c where  tc.classId = sc.id and tc.courseId = c.id and tc.teaId = t.id";
		List tcList = null; 
		try {
			tcList = db.getQueryList(sql,new Object[] {});
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return tcList;
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		String sql = "Select * From teachercourse where id = ?";
		TeacherCourse tc = null;
		try {
			tc= (TeacherCourse)db.getObject(TeacherCourse.class,sql,new Object[] {id});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace( );
		}
		return tc;
	}

	@Override
	public void addCourse(String name) {
		String sql = "Insert into course(name) values(?)";
		try {
			db.execute(sql,new Object[] {name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourse(Course course) {
		String sql = "update course set name = ? where id = ?";
		try {
			db.execute(sql,new Object[] {course.getName(),course.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Course findCourseById(int id) {
		String sql = "select * from course where id = ?";
		try {
			return (Course)db.getObject(Course.class,sql,new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		String sql = "Insert into teachercourse(teaId, courseId, classId) values(?, ?, ?)";
		try {
			db.execute(sql,new Object[] {tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		String sql = "Select * From teachercourse where id = ?";
		TeacherCourseView tc = null;
		try {
			tc = (TeacherCourseView)db.getObject(TeacherCourseView.class,sql,new Object[] {id});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tc;
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
		name = "%"+name+"%";
		String sql = "Select * from course where name like ?";
		List courseList = null;
		try {
			courseList = db.getQueryList(Course.class,sql,new Object[] {name});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		String sql = "Update teachercourse set teaId = ?, courseId = ?, classId = ? where id = ?";
		try {
			db.execute(sql,new Object[] {tc.getTeaId(),tc.getCourseId(),tc.getClassId(),tc.getId()});
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteCourse(int tcId) {
		// TODO Auto-generated method stub
		
	}

}
