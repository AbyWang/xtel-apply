package com.cdxt.ds.web.lesson.service;

import java.util.Map;

import com.cdxt.ds.core.model.PagePojo;
import com.cdxt.ds.web.lesson.pojo.CourseInfo;
import com.cdxt.ds.web.lesson.pojo.CourseInfoBean;

public interface LessonCenterService {

	PagePojo listMyLessonPage(int userID,Integer pageNo, Integer pageSize);
	
	PagePojo listRegisteredLessonPage(int userID,Integer pageNo, Integer pageSize);

	PagePojo listCourseArrangeInfoPage(int userID, Integer pageNo, Integer pageSize);

	PagePojo listAllLesson(int userID, Integer pageNo, Integer pageSize);

	Map<String, Object> getCourseInfoByid(int cpurseID);
	
	void insertSignup(Map<String, Object> map);

	void deleteClassInfo(int cpurseID);
	
	void insertCourseInfo(CourseInfoBean courseInfoBean);
	
	CourseInfo getCourseInfobyCpurseID(int cpurseID);
		
	void insertCourseArrangement(Map<String, Object> map);
		
	Map<String, Object>  getArrangeByid(int id);
	
	void updateCourseArrangeTime(Map<String, Object> map);
	
	void insertExpapersInfo(Map<String, Object> map);
}
