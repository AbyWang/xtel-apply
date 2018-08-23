package com.cdxt.ds.web.lesson.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdxt.ds.core.constant.SysConstants;
import com.cdxt.ds.core.model.PagePojo;
import com.cdxt.ds.core.model.ResJson;
import com.cdxt.ds.core.util.DateUtils;
import com.cdxt.ds.core.util.PageUtil;
import com.cdxt.ds.web.lesson.dao.LessonCenterDao;
import com.cdxt.ds.web.lesson.pojo.CourseInfo;
import com.cdxt.ds.web.lesson.pojo.CoursePlan;
import com.cdxt.ds.web.lesson.service.LessonCenterService;
import com.github.pagehelper.PageHelper;


@Transactional
@Service("lessonCenterService")
public class LessonCenterServiceImpl implements LessonCenterService {

	@Autowired
	private LessonCenterDao lessonCenterDao;

	@Override
	public PagePojo listAllLesson(int userId, Integer pageNo,Integer pageSize)  {
		//List<Integer>  list=new ArrayList<Integer>();

		//list=lessonCenterDao.getSignupListbyuserId(userId);
		//分页
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> mapList=lessonCenterDao.listAllLesson(userId);
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
	public ResJson insertSignup(Integer courseId,Integer userId) {
		int result=0;
		//Map<String, Object> map=new HashMap<String, Object>();
	
		result= lessonCenterDao.insertSignup(userId,courseId,new Date().getTime());
		if(result==1){
			return new ResJson(SysConstants.STRING_ONE,"保存成功");
		}
		return new ResJson(SysConstants.STRING_ZERO,"保存成功");
		//	lessonCenterDao.updateSignupSold(map);

	}

	@Override
	public void deleteClassInfo(int cpurseID) {
		lessonCenterDao.deleteClassInfo(cpurseID);

	}

	@Override
	public void insertCourseInfo(CourseInfo courseInfo,String divArrayStr){

		courseInfo.setStatus(SysConstants.INTEGER_ONE);
		courseInfo.setSold(SysConstants.INTEGER_ZERO);
		courseInfo.setPass(SysConstants.INTEGER_ZERO);

		lessonCenterDao.insertCourseInfo(courseInfo);
		if(StringUtils.isNoneBlank(divArrayStr)){
			List<CoursePlan>list=new ArrayList<CoursePlan>();
			divArrayStr= divArrayStr.replace("[", "").trim();
			divArrayStr= divArrayStr.replace("]", "").trim();
			String[]  divArrays= divArrayStr.split(",");
			int classNumber=1;
			for(String planArr:divArrays){
				CoursePlan coursePlan=new CoursePlan();
				//排课
				planArr = planArr.replace("\"", "").trim();
				coursePlan.setCourseID(courseInfo.getCourseID());
				coursePlan.setTime(DateUtils.str2Long(planArr));
				coursePlan.setClassNumber(classNumber);
				classNumber++;
				list.add(coursePlan);
			}
			lessonCenterDao.batchInsertCoursePlan(list);
		}
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


//	
//	public 	void batchMergeCoursePlan（List<CoursePlan>list){
//		
//	}

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
