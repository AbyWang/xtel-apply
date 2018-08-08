package com.cdxt.ds.web.res.service;

import java.util.Map;

import com.cdxt.ds.core.model.PagePojo;

public interface ResourcesService {

	PagePojo listLibraryPage(Map<String, Object> map, Integer pageNo, Integer pageSize) ;

	void insertLibraryInfo(Map<String, Object> map);

	Map<String, Object> getLibraryInfo(int id);

	PagePojo listDataPage(String strname, Integer pageNo, Integer pageSize);

	void updateLearningData(Map<String, Object> map);

	void insertLearningData(Map<String, Object> map);

	Map<String, Object> getLearningDataByid(int id);

	void deletedataInfo(int id);

	PagePojo listMyLibraryPage(Map<String, Object> map, Integer pageNo, Integer pageSize);

	PagePojo listMydataPage(Map<String, Object> map, Integer pageNo, Integer pageSize);

}
