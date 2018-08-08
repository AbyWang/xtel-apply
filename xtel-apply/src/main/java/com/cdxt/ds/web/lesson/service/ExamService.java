package com.cdxt.ds.web.lesson.service;

import com.cdxt.ds.core.model.PagePojo;

public interface ExamService {

	PagePojo getExaminationPage(int userID,Integer pageNo, Integer pageSize);

	PagePojo getExaminationArrangementPage(int userID, Integer pageNo, Integer pageSize);

	PagePojo getUserPerformancePage(int userID, Integer pageNo, Integer pageSize);

}
