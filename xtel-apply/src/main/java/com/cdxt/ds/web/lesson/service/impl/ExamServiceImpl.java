package com.cdxt.ds.web.lesson.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.ds.core.model.PagePojo;
import com.cdxt.ds.core.util.PageUtil;
import com.cdxt.ds.web.lesson.dao.ExamDao;
import com.cdxt.ds.web.lesson.service.ExamService;
import com.github.pagehelper.PageHelper;
@Service
public class ExamServiceImpl implements ExamService {
	@Autowired
	private  ExamDao  examDao;

	@Override
	public PagePojo getExaminationPage(int userID,Integer pageNo, Integer pageSize){
		
		PageHelper.offsetPage(pageNo, pageSize);
		List<Map<String, Object>> mapList= examDao.getExaminationPage(userID);
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

}
