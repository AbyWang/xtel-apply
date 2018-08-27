package com.cdxt.ds.web.lesson.dao;

import java.util.List;
import java.util.Map;

import com.cdxt.ds.web.lesson.pojo.ChoiceQuestion;
import com.cdxt.ds.web.lesson.pojo.EssayQuestion;
import com.cdxt.ds.web.lesson.pojo.Exercises;

public interface ExamDao {

	List<Map<String, Object>>listExercise(Integer userID);
	
	
	List<Map<String, Object>>listExaminationPage(Integer userID);
	
	
	List<Map<String, Object>> getExaminationArrangementPage(Integer userID);

	
	List<Map<String, Object>> getUserPerformancePage(Integer userID);
	
	/**
	 * 
	 * @Title: insertChoiceQuestion
	 * @author wangxiaolong
	 * @Description:插入选择题
	 * @param
	 * @return
	 */
	int insertChoiceQuestion(ChoiceQuestion choiceQuestion);
	
	/**
	 * 
	 * @Title: isertEssayQuestion
	 * @author wangxiaolong
	 * @Description:插入问答题
	 * @param
	 * @return
	 */
	int isertEssayQuestion(EssayQuestion essayQuestion);
	
	
	int InsertExercises(Exercises exercises);
}
