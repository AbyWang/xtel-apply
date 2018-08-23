package com.cdxt.ds.web.lesson.service;

import java.util.Map;

import com.cdxt.ds.core.model.PagePojo;
import com.cdxt.ds.core.model.ResJson;
import com.cdxt.ds.web.lesson.pojo.CourseInfo;

public interface LessonCenterService {

	PagePojo listMyLessonPage(int userID,Integer pageNo, Integer pageSize);
	
	PagePojo listRegisteredLessonPage(int userID,Integer pageNo, Integer pageSize);

	PagePojo listCourseArrangeInfoPage(int userID, Integer pageNo, Integer pageSize);

	PagePojo listAllLesson(int userID, Integer pageNo, Integer pageSize);

	Map<String, Object> getCourseInfoByid(int cpurseID);
	
	ResJson insertSignup(Integer courseId,Integer userId);

	void deleteClassInfo(int cpurseID);
	
	void insertCourseInfo(CourseInfo courseInfo,String divArray);
	
	
	CourseInfo getCourseInfobyCpurseID(int cpurseID);
		
	//void batchInsertCoursePlan(List<CoursePlan>list);
	
	//void batchMergeCoursePlan(String divArrayStr);
		
	Map<String, Object>  getArrangeByid(int id);
	
	void updateCourseArrangeTime(Map<String, Object> map);
	
	void insertExpapersInfo(Map<String, Object> map);
}
