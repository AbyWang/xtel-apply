package com.cdxt.ds.web.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdxt.ds.core.constant.SysConstants;
import com.cdxt.ds.core.model.ResJson;
import com.cdxt.ds.core.util.MD5;
import com.cdxt.ds.web.sys.dao.UserDao;
import com.cdxt.ds.web.sys.pojo.MenuFunction;
import com.cdxt.ds.web.sys.pojo.UserInfo;
import com.cdxt.ds.web.sys.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserInfo getuUserInfoByLoginName(String loginName)  {

		return userDao.getuUserInfoByLoginName(loginName);
	}

	@Override
	public void updateUserinfo(UserInfo user)  {

		userDao.updateUserinfo(user);
	}

	@Override
	public void insertUserInfo(Map<String, Object> map)  {


		userDao.insertUserInfo(map);
	}


	/**
	 * 
	 * @Title: getUserMenuList
	 * @Description:获取菜单
	 * @param
	 * @return
	 */
	public 	List<MenuFunction> getUserMenuList(Integer parentId){

		return userDao.getUserMenuList(parentId);
	}

	/**
	 * 
	 * @Title: sigUpUser
	 * @Description:用户注册，调用存储过程
	 * @param
	 * @return
	 */
	public ResJson  addUser(String userName,String password,Integer groupId){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//把密码进行加密处理
		password = MD5.toMD5(password); 
		paramMap.put("uName", userName);
		paramMap.put("pwd", password);
		paramMap.put("groupId", groupId);
		paramMap.put("returnValue", 1);
		userDao.addUser(paramMap);
		if((int)paramMap.get("returnValue")==0){
			return new ResJson(SysConstants.STRING_ZERO,"用户名已存在");
		}
		return new ResJson(SysConstants.STRING_ONE,"注册成功");
	}
	
	public  List<Map<String, Object>> getAllGroup(){
		return userDao.getAllGroup();
	}
}
