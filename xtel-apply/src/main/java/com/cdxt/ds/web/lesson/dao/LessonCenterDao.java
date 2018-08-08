package com.cdxt.ds.web.lesson.dao;

import java.util.List;
import java.util.Map;

import com.cdxt.ds.web.lesson.pojo.CourseInfo;
import com.cdxt.ds.web.lesson.pojo.CourseInfoBean;

public interface LessonCenterDao {


	List<Integer>getSignupListbyuserId(Integer userID);
	
	
	List<Map<String, Object>> listAllLesson(List<Integer>list);

	Map<String, Object> getCourseInfoByid(int cpurseID);
	
	void insertSignup(Map<String, Object> map);
	
	void updateSignupSold(Map<String, Object> map);

	void deleteClassInfo(int cpurseID);
	
	void insertCourseInfo(CourseInfoBean courseInfoBean);
	
	List<Map<String, Object>>  listMyLessonPage(int userID);
	
	CourseInfo getCourseInfobyCpurseID(int cpurseID);
	
	List<Map<String, Object>>  listRegisteredLessonPage(int userID);
	
	void insertCourseArrangement(Map<String, Object> map);
	
	List<Map<String, Object>>  listCourseArrangeInfoPage(int userID);
	
	Map<String, Object>  getArrangeByid(int id);
	
	void updateCourseArrangeTime(Map<String, Object> map);
	
	void insertExpapersInfo(Map<String, Object> map);
}
