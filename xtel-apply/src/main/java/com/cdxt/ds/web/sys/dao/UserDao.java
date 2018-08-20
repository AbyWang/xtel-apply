package com.cdxt.ds.web.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cdxt.ds.web.sys.pojo.MenuFunction;
import com.cdxt.ds.web.sys.pojo.UserInfo;

public interface UserDao {


	/**
	 * 
	 * @Title: getuUserInfoByLoginName
	 * @author wangxiaolong
	 * @Description:通过名字查询用户
	 * @param
	 * @return
	 */
	UserInfo getuUserInfoByLoginName(String loginName);

	/**
	 * 
	 * @Title: updateUserinfo
	 * @author wangxiaolong
	 * @Description:更新用户信息
	 * @param
	 * @return
	 */
	void updateUserinfo(UserInfo userInfo);

	/**
	 * 
	 * @Title: insertUserInfo
	 * @author wangxiaolong
	 * @Description:插入用户信息
	 * @param
	 * @return
	 */
	void insertUserInfo(@Param("map")Map<String, Object> map);


	/**
	 * 
	 * @Title: getUserMenuList
	 * @author wangxiaolong
	 * @Description:查询菜单
	 * @param
	 * @return
	 */
	List<MenuFunction> getUserMenuList(Integer parentId);
	
	/**
	 * 
	 * @Title: addUser
	 * @author wangxiaolong
	 * @Description:添加用户
	 * @param
	 * @return
	 */
	Map<String, Object> addUser(Map<String, Object> paramMap);
	
	/**
	 * 
	 * @Title: getAllGroup
	 * @author wangxiaolong
	 * @Description:查询所有群组
	 * @param
	 * @return
	 */
	List<Map<String, Object>>getAllGroup();
}
