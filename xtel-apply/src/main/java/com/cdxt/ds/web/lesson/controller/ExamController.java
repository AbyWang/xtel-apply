package com.cdxt.ds.web.lesson.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.ds.core.model.PagePojo;
import com.cdxt.ds.web.lesson.service.ExamService;
import com.cdxt.ds.web.sys.pojo.UserInfo;

@Controller
@RequestMapping("/examController")
public class ExamController {

	@Autowired
	private  ExamService  examService;

	
	/**
	 * 
	 * @Title: listExcemPaper
	 * @author wangxiaolong
	 * @Description:试题管理
	 * @param
	 * @return
	 */
	@RequestMapping("/listExerciseList")
	@ResponseBody
	public PagePojo listExerciseList(HttpServletRequest request,@RequestParam(value="pageNo",defaultValue="0")Integer pageNo,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize) throws Exception{

		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		int userID = userinfo.getUserID();
		return examService.listExerciseList(userID,pageNo,pageSize);
	
	}
	 
	
	
	
	/**
	 * 
	 * @Title: listExcemPaper
	 * @author wangxiaolong
	 * @Description:考试试卷列表
	 * @param
	 * @return
	 */
	@RequestMapping("/listExcemPaper")
	@ResponseBody
	public PagePojo listExcemPaper(HttpServletRequest request,@RequestParam(value="pageNo",defaultValue="0")Integer pageNo,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize) throws Exception{
		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		int userID = userinfo.getUserID();
		return examService.getExaminationPage(userID,pageNo,pageSize);

	}



	/**
	 * 
	 * @Title: listExamPlan
	 * @author wangxiaolong
	 * @Description:考试安排
	 * @param
	 * @return
	 */
	@RequestMapping("/listExamPlan")
	@ResponseBody
	public PagePojo listExamPlan( HttpServletRequest request,@RequestParam(value="pageNo",defaultValue="0")Integer pageNo,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize) throws Exception{
		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		int userID = userinfo.getUserID();
		return examService.getExaminationArrangementPage(userID,pageNo,pageSize);

	}


	/**
	 * 
	 * @Title: listOwnGrade
	 * @author wangxiaolong
	 * @Description:查询自己的成绩
	 * @param
	 * @return
	 */
	@RequestMapping("/listOwnGrade")
	@ResponseBody
	public PagePojo listOwnGrade( HttpServletRequest request,@Param(value="pageNo")Integer pageNo,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize) throws Exception{
		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		int userID = userinfo.getUserID();
		return examService.getUserPerformancePage(userID,pageNo,pageSize);


	}

	
}
