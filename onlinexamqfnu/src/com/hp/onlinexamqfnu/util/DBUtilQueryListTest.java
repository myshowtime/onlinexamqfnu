package com.hp.onlinexamqfnu.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexamqfnu.po.Student;

public class DBUtilQueryListTest {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		String sql = "Select * From teacher";
		List<Map<String,Object>> teacherList = db.getQueryList(sql); 
		for(int i = 0; i< teacherList.size();i++) {
			Map<String,Object> teaMap = teacherList.get(i);
			Iterator<Entry<String,Object>> it = teaMap.entrySet().iterator();
			while(it.hasNext()) {
				Entry<String,Object> entry = it.next();
				System.out.println(entry.getKey()+"@@@"+entry.getValue());
			}
		}
		/**
		 * 第二种方法
		 */
		String sql2 = "Select * From student where sex  = ?";
		List<Map<String,Object>> teaMaplist = db.getQueryList(sql2, new Object[] {"男"});
		
		/**
		 * 第三种方法
		 */
	
		String sql3 = "Select * From student";
		List stulist = db.getQueryList(Student.class,sql3,new Object[] {});
	}

}
