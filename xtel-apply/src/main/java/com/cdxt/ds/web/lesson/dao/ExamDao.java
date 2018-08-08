package com.cdxt.ds.web.lesson.dao;

import java.util.List;
import java.util.Map;

public interface ExamDao {


	List<Map<String, Object>>getExaminationPage(Integer userID);
	
	
	List<Map<String, Object>> getExaminationArrangementPage(Integer userID);

	
	List<Map<String, Object>> getUserPerformancePage(Integer userID);
}
