package com.cdxt.ds.web.sys.service;

import java.util.List;
import java.util.Map;

import com.cdxt.ds.core.model.ResJson;
import com.cdxt.ds.web.sys.pojo.MenuFunction;
import com.cdxt.ds.web.sys.pojo.UserInfo;

public interface UserService {
	
	UserInfo getuUserInfoByLoginName(String loginName) ;
	
	void updateUserinfo(UserInfo user) ;

	void insertUserInfo(Map<String, Object> map);
	
	List<MenuFunction> getUserMenuList(Integer parentId);
	
	ResJson  addUser(String name,String password,Integer groupId);
	
	/**
	 * 
	 * @Title: getAllGroup
	 * @author wangxiaolong
	 * @Description:查询所有群组
	 * @param
	 * @return
	 */
	List<Map<String, Object>> getAllGroup();
}
