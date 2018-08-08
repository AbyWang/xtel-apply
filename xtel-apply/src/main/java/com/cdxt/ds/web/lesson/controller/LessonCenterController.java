package com.cdxt.ds.web.lesson.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.ds.core.model.PagePojo;
import com.cdxt.ds.web.lesson.pojo.CourseInfoBean;
import com.cdxt.ds.web.lesson.service.LessonCenterService;
import com.cdxt.ds.web.sys.pojo.UserInfo;


@Controller
@RequestMapping("/lessonCenterController")
public class LessonCenterController {

	@Autowired
	private LessonCenterService lessonCenterService;


	/**
	 * 
	 * @Title: listAllLesson
	 * @author wangxiaolong
	 * @Description:查询已通过课程的信息，带分页
	 * @param
	 * @return
	 */
	@RequestMapping("/listAllLesson")
	@ResponseBody
	public PagePojo listAllLesson(HttpServletRequest request, @Param(value="pageNo")Integer pageNo,
			@Param(value="pageSize")Integer pageSize) {

		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		int userID = userinfo.getUserID();
		return lessonCenterService.listAllLesson(userID,pageNo,pageSize);
	}

	/**
	 * 
	 * @Title: getmycuriculumPage
	 * @author wangxiaolong
	 * @Description:获取自己的已申请课程分页信息
	 * @param
	 * @return
	 */
	@RequestMapping("/listMyLessonPage")
	@ResponseBody
	public PagePojo listMyLessonPage(HttpServletRequest request, 
			@RequestParam(value="pageNo",defaultValue="0")Integer pageNo,
			@RequestParam(value="pageSize",defaultValue="10")Integer pageSize) {
		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		int userID = userinfo.getUserID();
		return lessonCenterService.listMyLessonPage(userID,pageNo,pageSize);
	}

	/**
	 * 
	 * @Title: listRegisteredLessonPage
	 * @author wangxiaolong
	 * @Description:获取已报名信息
	 * @param
	 * @return
	 */
	@RequestMapping("/listRegisteredLessonPage")
	@ResponseBody
	public PagePojo listRegisteredLessonPage(HttpServletRequest request,
			@RequestParam(value="pageNo",defaultValue="0")Integer pageNo,
			@RequestParam(value="pageSize",defaultValue="10")Integer pageSize) {
		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		int userID = userinfo.getUserID();
		return lessonCenterService.listRegisteredLessonPage(userID,pageNo,pageSize);

	}	

	/**
	 * 
	 * @Title: listCourseArrangeInfoPage
	 * @author wangxiaolong
	 * @Description:查询我的课程安排信息
	 * @param
	 * @return
	 */
	@RequestMapping("/listLsssonArrangePage")
	@ResponseBody
	public PagePojo listLsssonArrangePage(HttpServletRequest request, 
			@RequestParam(value="pageNo")Integer pageNo,
			@RequestParam(value="pageSize",defaultValue="10")Integer pageSize){
		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		int userID = userinfo.getUserID();
		return lessonCenterService.listCourseArrangeInfoPage(userID,pageNo,pageSize);
	}	

	/**
	 * @描述:添加报名培训信息
	 * @方法名: updateTeachingStatus
	 * @param teachingID
	 * @return
	 * @
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年4月26日下午3:38:54
	 * @修改人 张兴成
	 * @修改时间 2018年4月26日下午3:38:54
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/insertSignup")
	@ResponseBody
	public Map<String,Object> insertSignup(@RequestParam("CpurseID")int CpurseID,@RequestParam("userid")int userid){
		Map<String, Object> result =new HashMap<String, Object>();
		Map<String, Object> map =new HashMap<String, Object>();
		try {
			map.put("CpurseID", CpurseID);
			map.put("userid", userid);
			map.put("time", new Date().getTime());
			lessonCenterService.insertSignup(map);
			result.put("flag", true);
			result.put("massge", "报名成功");
			return result;
		} catch (Exception e) {
			result.put("flag", false);
			result.put("massgefalse", "报名失败");
			return result;
		}

	}


	/**
	 * @描述:删除课程信息
	 * @方法名: deleteClassInfo
	 * @param CpurseID
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年5月7日下午2:04:18
	 * @修改人 张兴成
	 * @修改时间 2018年5月7日下午2:04:18
	 * @修改备注
	 * @since
	 * @throws
	 */
	//	@RequestMapping("/deleteClassInfo/{CpurseID}")
	//	@ResponseBody
	//	public Map<String,Object> deleteClassInfo(@PathVariable(value="CpurseID")int CpurseID){
	//		Map<String, Object> result =new HashMap<String, Object>();
	//		try {
	//			//查询这个课程信息表的状态
	//			CourseInfo courseInfo=lessonCenterService.selectcourseInfobyCpurseID(CpurseID);
	//			if(courseInfo!=null){
	//				if(courseInfo.getStatus()==2){
	//					result.put("flag", 1);
	//					result.put("massge","该课程已通过审核，如需删除请联系管理员");
	//					return result;
	//				}
	//
	//			}
	//			lessonCenterService.deleteClassInfo(CpurseID);
	//			result.put("flag", true);
	//			result.put("massge", "撤销成功");
	//			return result;
	//
	//		} catch (Exception e) {
	//			result.put("flag", false);
	//			result.put("massge", "撤销失败");
	//			return result;
	//		}
	//	}


	/**
	 * @描述:跳转加载课程信息页面
	 * @方法名: toClassInfo
	 * @return
	 * @返回类型 String
	 * @创建人 张兴成
	 * @创建时间 2018年5月7日下午2:05:03
	 * @修改人 张兴成
	 * @修改时间 2018年5月7日下午2:05:03
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/toClassInfopage")
	public String toClassInfopage(){

		return "classInfoJsp/classPage";
	}	
	@RequestMapping("/toInitarrangeClassPage")
	public String toInitarrangeClassPage(){

		return "classInfoJsp/arrangeClass";
	}
	@RequestMapping("/toInitUpdateArrangeClassPage")
	public String toInitUpdateArrangeClassPage(){

		return "classInfoJsp/updateArrangeClass";
	}
	@RequestMapping("/toInitAddClasstestPaperPage")
	public String toInitAddClasstestPaperPage(){

		return "examPapers/examPapersPage";
	}


	/**
	 * @描述:新增试卷信息
	 * @方法名: insertExpapersInfo
	 * @param id
	 * @param expapersNmae
	 * @param expapersurl
	 * @param request
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年5月22日上午11:07:45
	 * @修改人 张兴成
	 * @修改时间 2018年5月22日上午11:07:45
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/insertExpapersInfo")
	@ResponseBody
	public Map<String,Object> insertExpapersInfo(HttpServletRequest  request,@RequestParam("id")int id,@RequestParam("expapersNmae")String expapersNmae,@RequestParam("expapersurl")String expapersurl){
		Map<String, Object> result =new HashMap<String, Object>();
		Map<String, Object> map =new HashMap<String, Object>();
		try {
			UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
			int userID = userinfo.getUserID();
			map.put("id", id);
			map.put("expapersNmae", expapersNmae);
			map.put("expapersUrl", expapersurl);
			map.put("userID", userID);
			lessonCenterService.insertExpapersInfo(map);

			result.put("flag", true);
			result.put("massge", "添加成功");
			return result;
		} catch (Exception e) {
			result.put("flag", false);
			result.put("massgefalse", "添加失败");
			return result;
		}

	}

	/**
	 * @描述:新增课程信息
	 * @方法名: insertCourseInfo
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年5月7日下午3:03:39
	 * @修改人 张兴成
	 * @修改时间 2018年5月7日下午3:03:39
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/insertCourseInfo")
	@ResponseBody
	public Map<String,Object> insertCourseInfo(@RequestBody CourseInfoBean courseInfoBean,HttpServletRequest  request ){
		Map<String, Object> result =new HashMap<String, Object>();
		try {
			UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
			courseInfoBean.LecturerID=userinfo.getUserID();
			lessonCenterService.insertCourseInfo(courseInfoBean);
			result.put("flag", true);
			result.put("massge", "发布成功");
			return result;
		} catch (Exception e) {
			result.put("flag", false);
			result.put("massgefalse", "发布失败");
			return result;
		}
	}



	/**
	 * @描述:新增我的排课记录
	 * @方法名: insertCourseArrangement
	 * @param CpurseID
	 * @param dateTime
	 * @param request
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年5月10日下午1:44:15
	 * @修改人 张兴成
	 * @修改时间 2018年5月10日下午1:44:15
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/insertCourseArrangement")
	@ResponseBody
	public Map<String,Object> insertCourseArrangement(@RequestParam("CpurseID")int CpurseID,
			@RequestParam("dateTime")long dateTime,HttpServletRequest request){
		Map<String, Object> result =new HashMap<String, Object>();
		Map<String, Object> map =new HashMap<String, Object>();
		try {
			UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
			int userID = userinfo.getUserID();
			map.put("userID", userID);
			map.put("CpurseID",CpurseID);
			map.put("dateTime",dateTime);
			lessonCenterService.insertCourseArrangement(map);
			result.put("flag", true);
			result.put("massge", "发布成功");
			return result;
		} catch (Exception e) {
			result.put("flag", false);
			result.put("massgefalse", "发布失败");
			return result;
		}

	}


	/**
	 * @描述:查看我的课程安排详情
	 * @方法名: selectArrangeByid
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年5月14日下午3:37:56
	 * @修改人 张兴成
	 * @修改时间 2018年5月14日下午3:37:56
	 * @修改备注
	 * @since
	 * @throws
	 */
	//	@RequestMapping("/selectArrangeByid/{id}")
	//	@ResponseBody
	//	public Map<String,Object> selectArrangeByid(@PathVariable("id") int id){
	//		Map<String,Object> map=null;
	//		try {
	//			map=lessonCenterService.selectArrangeByid(id);
	//			return map;
	//		} catch (Exception e) {
	//			map.put("flag", false);
	//			map.put("massgefalse", "查询失败");
	//			return map;
	//		}
	//
	//	}
	//	@RequestMapping("/updateCourseArrangementTime")
	//	@ResponseBody
	//	public Map<String,Object> updateCourseArrangementTime(@RequestParam("id")int id,@RequestParam("dateTime")long time){
	//		Map<String, Object> result =new HashMap<String, Object>();
	//		Map<String, Object> map =new HashMap<String, Object>();
	//		try {
	//			map.put("id",id);
	//			map.put("dateTime",time);
	//			lessonCenterService.updateCourseArrangementTime(map);
	//			result.put("flag", true);
	//			result.put("massge", "修改成功");
	//			return result;
	//		} catch (Exception e) {
	//			result.put("flag", false);
	//			result.put("massgefalse", "修改失败");
	//			return result;
	//		}
	//
	//
	//	}

}
