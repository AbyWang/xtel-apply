package com.cdxt.ds.web.res.dao;

import java.util.List;
import java.util.Map;

public interface ResourcesDao {


	List<Map<String, Object>>listLibraryPage(Map<String, Object> map);
	
	
	void insertLibraryInfo(Map<String, Object> map);

	
	Map<String, Object> getLibraryInfo(int id);
	
	List<Map<String, Object>>listDataPage(String strname);
	
	void updateLearningData(Map<String, Object> map);
	
	void insertLearningData(Map<String, Object> map);
	
	Map<String, Object> getLearningDataByid(int id);
	
	void deletedataInfo(int id);
	
	List<Map<String, Object>> listMyLibraryPage(Map<String, Object> map);
	
	List<Map<String, Object>>listMydataPage(Map<String, Object> map);
}
