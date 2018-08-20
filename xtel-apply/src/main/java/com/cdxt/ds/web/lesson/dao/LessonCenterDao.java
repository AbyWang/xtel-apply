package com.cdxt.ds.web.lesson.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cdxt.ds.web.lesson.pojo.CourseInfo;
import com.cdxt.ds.web.lesson.pojo.CoursePlan;

public interface LessonCenterDao {


	//List<Integer>getSignupListbyuserId(Integer userID);
	
	
	List<Map<String, Object>> listAllLesson(int userId);

	Map<String, Object> getCourseInfoByid(int cpurseID);
	
	int insertSignup(@Param("userId")Integer userId,@Param("courseId")Integer courseId,@Param("time")Long time);
	
	void updateSignupSold(Map<String, Object> map);

	void deleteClassInfo(int cpurseID);
	
	int insertCourseInfo(CourseInfo courseInfo);
	
	List<Map<String, Object>>  listMyLessonPage(int userID);
	
	CourseInfo getCourseInfobyCpurseID(int cpurseID);
	
	List<Map<String, Object>>  listRegisteredLessonPage(int userID);
	
	void batchInsertCoursePlan(List<CoursePlan>list);
	
	List<Map<String, Object>>  listCourseArrangeInfoPage(int userID);
	
	Map<String, Object>  getArrangeByid(int id);
	
	void updateCourseArrangeTime(Map<String, Object> map);
	
	void insertExpapersInfo(Map<String, Object> map);
}
