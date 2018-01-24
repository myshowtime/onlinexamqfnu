package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.dao.admin.IStuClassDao;
import com.hp.onlinexamqfnu.dao.admin.StuClassDao;
import com.hp.onlinexamqfnu.po.StuClass;

public class StuClassService implements IStuClassService{
	
	private IStuClassDao scd = new StuClassDao();
	@Override
	public List<StuClass> findAll() {
		List stuClassList =  scd.findAllStuClassInfo();
		return stuClassList;
	}
	 @Override
	public void addStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.addStuClassById(sc);
	}

	@Override
	public void updateStuClass(StuClass sc) {
		scd.updateStuClassById(sc);
	}

	@Override
	public StuClass findStuClassById(int id) {
		return scd.findStuClassById(id);
	}

	@Override
	public String findClassNamesByIds(String ids) {
		List<Map<String ,Object>> nameList = scd.findClassNamesByIds(ids);
		StringBuffer sb = new StringBuffer();
		//如果字符串多次拼接要使用stringbuffer
		if(nameList == null || nameList.size()<1)
			return "";
		else
			for (Map<String,Object> name : nameList) {
				sb.append(name.get("name")).append(" ");
			}
		return sb.toString();
	}
	@Override
	public List<StuClass> findAllStuClassByTeacherId(long id) {
		// TODO Auto-generated method stub
		return scd.findAllStuClassByTeacherId(id);
	}
	
}
