package com.cdxt.ds.web.lesson.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.ds.core.constant.SysConstants;
import com.cdxt.ds.core.model.PagePojo;
import com.cdxt.ds.core.model.ResJson;
import com.cdxt.ds.core.util.PageUtil;
import com.cdxt.ds.core.util.oConvertUtils;
import com.cdxt.ds.web.lesson.dao.ExamDao;
import com.cdxt.ds.web.lesson.pojo.ChoiceQuestion;
import com.cdxt.ds.web.lesson.pojo.EssayQuestion;
import com.cdxt.ds.web.lesson.pojo.Exercises;
import com.cdxt.ds.web.lesson.service.ExamService;
import com.cdxt.ds.web.sys.pojo.UserInfo;
import com.github.pagehelper.PageHelper;
@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private  ExamDao  examDao;

	@Autowired
	HttpSession session;

	public PagePojo  listExercise (int userID,Integer pageNo, Integer pageSize){

		PageHelper.offsetPage(pageNo, pageSize);
		List<Map<String, Object>> mapList= examDao.listExercise(userID);
		return PageUtil.Map2PageInfo(mapList);

	}
	@Override
	public PagePojo listExaminationPage(Integer pageNo, Integer pageSize){
		UserInfo userinfo=(UserInfo) session.getAttribute("userInfo");
		int userID = userinfo.getUserID();
		PageHelper.offsetPage(pageNo, pageSize);
		List<Map<String, Object>> mapList= examDao.listExaminationPage(userID);
		return PageUtil.Map2PageInfo(mapList);
	}

	@Override
	public PagePojo getExaminationArrangementPage(int userID, Integer pageNo, Integer pageSize) {

		List<Map<String, Object>> mapList=  examDao.getExaminationArrangementPage(userID);
		return PageUtil.Map2PageInfo(mapList);
	}

	@Override
	public PagePojo getUserPerformancePage(int userID, Integer pageNo, Integer pageSize){

		List<Map<String, Object>> mapList=  examDao.getUserPerformancePage(userID);

		return PageUtil.Map2PageInfo(mapList);
	}

	public ResJson addExercise(Exercises exercises,ChoiceQuestion choiceQuestion,EssayQuestion essayQuestion){
		int results=0;
		UserInfo userinfo=(UserInfo) session.getAttribute("userInfo");
		int userID = userinfo.getUserID();

		Integer type=exercises.getType();
		Integer id=0;
		if(oConvertUtils.isNotEmpty(type)){
			switch(type){
			//选择题
			case 0:
				id=examDao.insertChoiceQuestion(choiceQuestion);
				break;
			case 1:	
				id=examDao.isertEssayQuestion(essayQuestion);
			    break;	
		    default :
		        break;
			}
			//判断前面是否成功插入了
			if(id!=0){
				exercises.setRecordId(id);
				exercises.setUploaderId(userID);
				exercises.setUploadTime(new Date().getTime());
				results=examDao.InsertExercises(exercises);
			}
		}
      if(results==1){
    	  return new ResJson(SysConstants.STRING_ONE,"保存成功");
      }
      
      return new ResJson(SysConstants.STRING_ZERO,"保存失败");
	}
}
