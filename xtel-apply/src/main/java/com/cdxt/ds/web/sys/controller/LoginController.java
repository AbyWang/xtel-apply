package com.cdxt.ds.web.sys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdxt.ds.core.constant.SysConstants;
import com.cdxt.ds.core.model.AjaxJson;
import com.cdxt.ds.core.model.ResJson;
import com.cdxt.ds.core.util.MD5;
import com.cdxt.ds.web.sys.pojo.MenuFunction;
import com.cdxt.ds.web.sys.pojo.UserInfo;
import com.cdxt.ds.web.sys.service.UserService;

/**
 * 
 * 
 * @ClassName: LoginController.java
 * @Description: 
 * @author wangxiaolong
 * @Copyright: Copyright (c) 2017
 * @Company:成都信通网易医疗科技发展有限公司
 * @date 2018年7月20日
 */
@Controller
public class LoginController {


	@Autowired
	private UserService userService;


	/**
	 * 检查用户名称
	 * 
	 * @param user
	 * @param req
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/checkuser")
	@ResponseBody
	public AjaxJson checkuser(HttpServletRequest req,@RequestParam("loginname")String loginName,
			@RequestParam("password")String password) throws Exception {
		AjaxJson json=new AjaxJson();
		//	HttpSession session = ContextHolderUtils.getSession();
		//通过登录名名查询manager
		UserInfo userInfo=userService.getuUserInfoByLoginName(loginName);
		//登录密码MD5加密
		String pwMd5=MD5.toMD5(password);
		if(userInfo==null || !pwMd5.equals(userInfo.getPassword())){
			json.setSuccess(false);
			json.setMsg("用户名或密码错误");
			return json;
		}
		if(userInfo.getStatus()==0){
			json.setSuccess(false);
			json.setMsg("用户已锁定,请联系管理员");
			return json;
		}
		UserInfo user=new UserInfo();
		user.setUserID(userInfo.getUserID());
		user.setLoginTime(new Date().getTime());
		//更新在线状态和登录时间
		userService.updateUserinfo(user);
		HttpSession session=req.getSession();
		session.setAttribute("userInfo", userInfo);
		return json;
	}



	@RequestMapping("/register")
	@ResponseBody
	public ResJson registerUser(@RequestParam("userName")String userName,@RequestParam("password")String password){
		
		
		return userService.addUser(userName,password);
	}

	/**
	 * 
	 * @Title: getRootMenus
	 * @author wangxiaolong
	 * @Description:c查询所有的菜单
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getMenus")
	@ResponseBody
	public ResJson getRootMenus(HttpServletRequest request,HttpSession session,Integer parentId) {
		UserInfo user = (UserInfo)session.getAttribute("userInfo");
		if(user == null){
			return new ResJson(SysConstants.STRING_ZERO,"请先进行登录操作！");
		}
		List<MenuFunction>resultList=new ArrayList<MenuFunction>();
		List<MenuFunction> menuList=userService.getUserMenuList(parentId);
		//		List<MenuFunction>childList=null;
		//查询所有的一级菜单
		for(MenuFunction menuFunction:menuList){
			if(menuFunction.getParent()==null){
				resultList.add(menuFunction);
			}

		}
		for (MenuFunction menu : resultList) {
			menu.setMenuFunctions(getChild(menu.getId(), menuList));
		}


		return new ResJson(SysConstants.STRING_ONE,"登录成功！",resultList);


	}

	/**
	 * 
	 * @Title: getChild
	 * @author wangxiaolong
	 * @Description:递归查找子菜单
	 * @param id
	 *            当前菜单id
	 * @param menuList
	 *            要查找的列表
	 * @return
	 */
	private List<MenuFunction> getChild(Integer id, List<MenuFunction> menuList) {
		// 子菜单
		List<MenuFunction> childList = new ArrayList<>();
		for (MenuFunction menu : menuList) {
			// 遍历所有节点，将父菜单id与传过来的id比较
			if (menu.getParent()!=null) {
				if (menu.getParent().equals(id)) {
					childList.add(menu);
				}
			}
		}
		// 把子菜单的子菜单再循环一遍
		for (MenuFunction menu : childList) {//type=0,还有子菜单
			if (menu.getType()==0) {
				// 递归
				menu.setMenuFunctions(getChild(menu.getId(), menuList));
			}
		} // 递归退出条件
		if (childList.size() == 0) {
			return null;
		}
		return childList;
	}
	
}
