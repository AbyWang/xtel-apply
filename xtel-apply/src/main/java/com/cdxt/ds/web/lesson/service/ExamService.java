package com.cdxt.ds.web.lesson.service;

import com.cdxt.ds.core.model.PagePojo;
import com.cdxt.ds.core.model.ResJson;
import com.cdxt.ds.web.lesson.pojo.ChoiceQuestion;
import com.cdxt.ds.web.lesson.pojo.EssayQuestion;
import com.cdxt.ds.web.lesson.pojo.Exercises;

public interface ExamService {

	PagePojo getExaminationPage(int userID,Integer pageNo, Integer pageSize);

	PagePojo getExaminationArrangementPage(int userID, Integer pageNo, Integer pageSize);

	PagePojo getUserPerformancePage(int userID, Integer pageNo, Integer pageSize);
	/**
	 * 
	 * @Title: listExerciseList
	 * @author wangxiaolong
	 * @Description:试题列表
	 * @param
	 * @return
	 */
	PagePojo  listExercise(int userID,Integer pageNo, Integer pageSize);
	
	/**
	 * 
	 * @Title: addExercise
	 * @author wangxiaolong
	 * @Description:添加试题
	 * @param
	 * @return
	 */
	ResJson addExercise(Exercises exercises,ChoiceQuestion choiceQuestion,EssayQuestion essayQuestion);
}
