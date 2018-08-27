package com.cdxt.ds.web.sys.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cdxt.ds.web.lesson.service.LessonCenterService;
import com.cdxt.ds.web.sys.pojo.UserInfo;

/**
 * @ClassName: SystemController.java
 * @Description: 
 * @author wangxiaolong
 * @Copyright: Copyright (c) 2017
 * @Company:成都信通网易医疗科技发展有限公司
 * @date 2018年7月18日
 */
@Controller
public class CommonController {

	@Autowired
	private LessonCenterService lessonCenterService;

	@RequestMapping("/logout")
	public String logout(HttpSession session){
		//清除session
		session.removeAttribute("userInfo");
		session.invalidate();
		return "redirect:/toLogin";
	}


	@RequestMapping("/toLogin")
	public ModelAndView toLogin(){

		return new ModelAndView("main/login");
	}



	@RequestMapping("/login")
	public String systemLogin(HttpServletRequest request){

		return "main/main";
	}

	/**
	 * 
	 * @Title: gotoAllLesson
	 * @author wangxiaolong
	 * @Description:课程列表
	 * @param
	 * @return
	 */
	@RequestMapping("/gotoAllLesson")
	public String gotoAllLesson(){
		return "lesson/allLesson";
	}

	/**
	 * 
	 * @Title: gotoMyLesson
	 * @author wangxiaolong
	 * @Description:我的课程
	 * @param
	 * @return
	 */
	@RequestMapping("/gotoMyLesson")
	public String gotoMyLesson(){
		return "lesson/myLesson";
	}


	/**
	 * 
	 * @Title: gotoLessonPlan
	 * @author wangxiaolong
	 * @Description:课程安排
	 * @param
	 * @return
	 */
	@RequestMapping("/gotoLessonPlan")
	public String gotoLessonArrange(){
		return "lesson/lessonPlan";
	}

	/**
	 * 
	 * @Title: listExercise
	 * @author wangxiaolong
	 * @Description:习题列表
	 * @param
	 * @return
	 */
	@RequestMapping("/gotoExerciseList")
	public String  listExercise(HttpServletRequest request){

		return "exam/exercise_list";
	}

	/**
	 * 
	 * @Title: gotoRegistered
	 * @author wangxiaolong
	 * @Description:已报名课程
	 * @param
	 * @return
	 */
	@RequestMapping("/gotoRegistered")
	public String gotoRegistered(){
		return "lesson/registered";
	}

	/**
	 * 
	 * @Title: gotoAddExercise
	 * @author wangxiaolong
	 * @Description:新增习题
	 * @param
	 * @return
	 */
	@RequestMapping("/gotoAddExercise")
	public String gotoAddExercise(){
		return "exam/addExercise";
	}

	/**
	 * 
	 * @Title: gotoAddExercise
	 * @author wangxiaolong
	 * @Description:组卷
	 * @param
	 * @return
	 */
	@RequestMapping("/gotoAddExam")
	public String gotoAddExam(HttpServletRequest request){
		HttpSession session=request.getSession();
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		List<Map<String, Object>>mapList=lessonCenterService.listAllValidCourseByUserId(userInfo.getUserID());
		request.setAttribute("courseList", mapList);
		return "exam/addExam";
	}


	/**
	 * 
	 * @Title: gotoMyLibraryList
	 * @author wangxiaolong
	 * @Description:我的文库
	 * @param
	 * @return
	 */
	@RequestMapping("/gotoMyLibraryList")
	public String gotoMyLibraryList(){
		return "cloud/myLibrary_list";
	}

	@RequestMapping("/gotoMyDataList")
	public String gotoMyDataList(){
		return "cloud/myData_list";
	}

	@RequestMapping("/gotoLibraryList")
	public String gotoLibraryList(){
		return "res/library_list";
	}
	@RequestMapping("/gotoDataList")
	public String gotoDataList(){
		return "res/data_list";
	}


	@RequestMapping("/gotoExamPaperList")
	public String gotoExamPaperList(){
		return "exam/examPaper_list";
	}

	@RequestMapping("/gotoExamPlanList")
	public String gotoExamPlanList(){
		return "exam/examPlan_list";
	}

	@RequestMapping("/gotoOwnGradeList")
	public String gotoOwnGradeList(){
		return "exam/ownGrade_list";
	}

}
