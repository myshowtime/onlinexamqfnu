package com.hp.onlinexamqfnu.dao;

import java.util.List;

import com.hp.onlinexamqfnu.po.Paper;

public interface IPapersDao {
	
	public int save(Paper  paper);
	
	public List getPaperByStudentId(int studentId,int testId);
	
	public List getPaperByStudentId(int studentId);
	
	//所有的班级成绩。
	public List getPaperCompare();
}
