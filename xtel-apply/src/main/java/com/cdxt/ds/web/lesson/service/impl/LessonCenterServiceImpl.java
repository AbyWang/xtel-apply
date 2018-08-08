package com.cdxt.ds.web.lesson.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.ds.core.model.PagePojo;
import com.cdxt.ds.core.util.PageUtil;
import com.cdxt.ds.web.lesson.dao.LessonCenterDao;
import com.cdxt.ds.web.lesson.pojo.CourseInfo;
import com.cdxt.ds.web.lesson.pojo.CourseInfoBean;
import com.cdxt.ds.web.lesson.service.LessonCenterService;
import com.github.pagehelper.PageHelper;

@Service
public class LessonCenterServiceImpl implements LessonCenterService {
	
	@Autowired
	private LessonCenterDao lessonCenterDao;

	@Override
	public PagePojo listAllLesson(int userID, Integer pageNo,Integer pageSize)  {
		List<Integer>  list=new ArrayList<Integer>();

		list=lessonCenterDao.getSignupListbyuserId(userID);
		//分页
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> mapList=lessonCenterDao.listAllLesson(list);
		return PageUtil.Map2PageInfo(mapList);
	}

	@Override
	public PagePojo listMyLessonPage(int userID, Integer pageNo, Integer pageSize){

		//分页
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list=lessonCenterDao.listMyLessonPage(userID);
		return PageUtil.Map2PageInfo(list);
	}

	/**
	 * @Title: listRegisteredLessonPage
	 * @Description:
	 * @param
	 * @return
	 */
	@Override
	public PagePojo listRegisteredLessonPage(int userID, Integer pageNo, Integer pageSize) {
		//分页
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list= lessonCenterDao.listRegisteredLessonPage(userID);
		return PageUtil.Map2PageInfo(list);
	}

	
	@Override
	public PagePojo listCourseArrangeInfoPage(int userID,Integer pageNo, Integer pageSize) {
		//分页
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list= lessonCenterDao.listCourseArrangeInfoPage(userID);
		return PageUtil.Map2PageInfo(list);
	}
	
	@Override
	public Map<String, Object> getCourseInfoByid(int cpurseID){
		Map<String, Object> map=lessonCenterDao.getCourseInfoByid(cpurseID);
		return map;
	}

	@Override
	public void insertSignup(Map<String, Object> map) {
		lessonCenterDao.insertSignup(map);
		lessonCenterDao.updateSignupSold(map);

	}

	@Override
	public void deleteClassInfo(int cpurseID) {
		lessonCenterDao.deleteClassInfo(cpurseID);

	}

	@Override
	public void insertCourseInfo(CourseInfoBean courseInfoBean){
		courseInfoBean.Sold=0;
		courseInfoBean.Pass=0;
		courseInfoBean.LastClassTime=new Date().getTime();
		courseInfoBean.ReviewerID=0;
		courseInfoBean.satus=1;
		lessonCenterDao.insertCourseInfo(courseInfoBean);


	}

	
	/**
	 * 
	 * @Title: getCourseInfobyCpurseID
	 * @author wangxiaolong
	 * @Description:查询课程信息单一记录
	 * @param
	 * @return
	 */
	@Override
	public CourseInfo getCourseInfobyCpurseID(int cpurseID)  {

		return lessonCenterDao.getCourseInfobyCpurseID(cpurseID);

	}

	@Override
	public void insertCourseArrangement(Map<String, Object> map){
		lessonCenterDao.insertCourseArrangement(map);

	}

	@Override
	public Map<String, Object> getArrangeByid(int id){
		return lessonCenterDao.getArrangeByid(id);
	}

	@Override
	public void updateCourseArrangeTime(Map<String, Object> map) {
		lessonCenterDao.updateCourseArrangeTime(map);
	}

	@Override
	public void insertExpapersInfo(Map<String, Object> map){
		map.put("uplodaTime", new Date().getTime());
		map.put("TOTALSCORE", 0);
		map.put("PASSSCORE", 0);
		map.put("NUMBEROFPARTICIPANTS", 0);
		map.put("NUMBEROFPASS", 0);
		lessonCenterDao.insertExpapersInfo(map);
	}




}
