package com.cdxt.ds.web.res.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdxt.ds.core.model.PagePojo;
import com.cdxt.ds.core.util.PageUtil;
import com.cdxt.ds.web.res.dao.ResourcesDao;
import com.cdxt.ds.web.res.service.ResourcesService;
import com.github.pagehelper.PageHelper;
@Service
public class ResourcesServiceImpl implements ResourcesService {
	@Autowired
	private  ResourcesDao resourcesDao;

	@Override
	public PagePojo listLibraryPage(Map<String, Object> map,Integer pageNo, Integer pageSize)  {
		PageHelper.offsetPage(pageNo, pageSize);
		
		List<Map<String, Object>>mapList= resourcesDao.listLibraryPage(map);
		return PageUtil.Map2PageInfo(mapList);
	}

	@Override
	public void insertLibraryInfo(Map<String, Object> map)  {

		resourcesDao.insertLibraryInfo(map);
	}

	@Override
	public Map<String, Object> getLibraryInfo(int id)  {

		return resourcesDao.getLibraryInfo(id);
	}

	@Override
	public PagePojo listDataPage(String strname,Integer pageNo, Integer pageSize)  {
		PageHelper.offsetPage(pageNo, pageSize);
		
		List<Map<String, Object>>mapList=  resourcesDao.listDataPage(strname);
		return PageUtil.Map2PageInfo(mapList);
	}

	@Override
	public void updateLearningData(Map<String, Object> map)  {

		resourcesDao.updateLearningData(map);
	}

	@Override
	public void insertLearningData(Map<String, Object> map)  {

		resourcesDao.insertLearningData(map);
	}

	@Override
	public Map<String, Object> getLearningDataByid(int id)  {

		return resourcesDao.getLearningDataByid(id);
	}

	@Override
	public void deletedataInfo(int id)  {
		
		resourcesDao.deletedataInfo(id);
	}

	@Override
	public PagePojo listMyLibraryPage(Map<String, Object> map, Integer pageNo, Integer pageSize)  {
		PageHelper.offsetPage(pageNo, pageSize);
		
		
		List<Map<String, Object>>mapList= resourcesDao.listMyLibraryPage(map);
		return PageUtil.Map2PageInfo(mapList);
	
	}

	@Override
	public PagePojo listMydataPage(Map<String, Object> map, Integer pageNo, Integer pageSize){
		PageHelper.offsetPage(pageNo, pageSize);
		List<Map<String, Object>>mapList=resourcesDao.listMydataPage(map);

		return PageUtil.Map2PageInfo(mapList);
	}
	
	
}
