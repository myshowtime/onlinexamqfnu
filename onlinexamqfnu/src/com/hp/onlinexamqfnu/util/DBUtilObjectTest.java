package com.hp.onlinexamqfnu.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexamqfnu.po.Question;
import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.po.StuClass;

public class DBUtilObjectTest {
	private static Map<String,Object> teacherMap;
	private static Iterator<Entry<String,Object>> it;
	private static Map<String,Object> teacherMap2 ;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		String sql ="SELECT * FROM `teacher` WHERE id = 1";
		teacherMap = db.getObject(sql);
		System.out.println(teacherMap);
		it = teacherMap.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String,Object> entry = it.next();
			System.out.println(entry.getKey()+"@@@"+entry.getValue());
		}
		String sql2 = "SELECT * FROM teacher WHERE id = ?";
		teacherMap2 = db.getObject(sql2,new Object[] {1});
		/**
		 * getObject三个参数方法用法
		 * 1.用于一条记录的查询
		 * 2.用于封装成对象
		 * 3.第一个参数一般是自己写的PO或VO
		 * 4.以PO举例，PO里的成员变量要有对应的get,set方法
		 * 5.PO里的成员变量要和数据库对应表的字段完全一样
		 */
		Teacher t2 = (Teacher)db.getObject(Teacher.class,sql2,new Object[] {1});
		String sqlOfQuestion  ="Select * From questions Where id = ?";
		Question qustion = (Question)db.getObject(Question.class,sqlOfQuestion,new Object[] {1});
		
		String sqlOfStuClass = "Select * From stuclass Where id= ?";
		StuClass stuclass = (StuClass)db.getObject(StuClass.class,sqlOfStuClass,new Object[] {1});
	
	}
}
