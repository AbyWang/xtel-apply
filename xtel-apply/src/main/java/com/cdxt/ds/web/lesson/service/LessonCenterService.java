package com.cdxt.ds.web.lesson.service;

import java.util.List;
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
	
	/**
	 * 
	 * @Title: listAllValidCourse
	 * @author wangxiaolong
	 * @Description:获取所有有效的课程
	 * @param
	 * @return
	 */
	List<Map<String, Object>>listAllValidCourseByUserId(int userID);
		
	//void batchInsertCoursePlan(List<CoursePlan>list);
	
	//void batchMergeCoursePlan(String divArrayStr);
	
	/**
	 * 
	 * @Title: updateCourse
	 * @author wangxiaolong
	 * @Description:修改课程信息
	 * @param
	 * @return
	 */
	ResJson updateCourse(CourseInfo courseInfo,String divArrayStr);
		
	Map<String, Object>  getArrangeByid(int id);
	
	void updateCourseArrangeTime(Map<String, Object> map);
	
	void insertExpapersInfo(Map<String, Object> map);
}
