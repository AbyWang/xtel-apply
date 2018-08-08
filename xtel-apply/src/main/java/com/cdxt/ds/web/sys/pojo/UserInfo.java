package com.cdxt.ds.web.sys.pojo;

public class UserInfo {
	//登录使用的用户名
	private  String userName;
	//用户ID，系统中所有的交互均以用户ID为准
	private int  userID;
	//用户昵称
	private  String nickName;
	//用户所属群组的ID，可从XTEL_GroupInfo表中获取群组信息
	private int groupID;
	//用户注册时间，以s为单位的时间戳
	private long registTime;
	//当前已购买课程数量
	private int purchasedCourse;
	//及格的课程数量
	private int passCourse;
	//得优的课程数量
	private int excellentCourse;
	//正在学习的课程数量
	private int learningCourse;
	//已完成的课程数量
	private int completeCourse;
	//成为讲师的次数，即开设的课程数量
	private int lectures;
	//在线状态	0 – 离线	1 – 在线
	private int isOnline;
	//用户登录平台的时间
	private long loginTime;
	//登录密码，使用base64加密，目的仅仅只是为了让密码不能直观的被看到。
	private String password;
	//用户当前状态	0 – 正常1 – 锁定
	private int status;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public long getRegistTime() {
		return registTime;
	}
	public void setRegistTime(long registTime) {
		this.registTime = registTime;
	}
	public int getPurchasedCourse() {
		return purchasedCourse;
	}
	public void setPurchasedCourse(int purchasedCourse) {
		this.purchasedCourse = purchasedCourse;
	}
	public int getPassCourse() {
		return passCourse;
	}
	public void setPassCourse(int passCourse) {
		this.passCourse = passCourse;
	}
	public int getExcellentCourse() {
		return excellentCourse;
	}
	public void setExcellentCourse(int excellentCourse) {
		this.excellentCourse = excellentCourse;
	}
	public int getLearningCourse() {
		return learningCourse;
	}
	public void setLearningCourse(int learningCourse) {
		this.learningCourse = learningCourse;
	}
	public int getCompleteCourse() {
		return completeCourse;
	}
	public void setCompleteCourse(int completeCourse) {
		this.completeCourse = completeCourse;
	}
	public int getLectures() {
		return lectures;
	}
	public void setLectures(int lectures) {
		this.lectures = lectures;
	}
	public int getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}
	public long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "userInfo [userName=" + userName + ", userID=" + userID + ", nickName=" + nickName + ", groupID="
				+ groupID + ", registTime=" + registTime + ", purchasedCourse=" + purchasedCourse + ", passCourse="
				+ passCourse + ", excellentCourse=" + excellentCourse + ", learningCourse=" + learningCourse
				+ ", completeCourse=" + completeCourse + ", lectures=" + lectures + ", isOnline=" + isOnline
				+ ", loginTime=" + loginTime + ", password=" + password + ", status=" + status + ", getUserName()="
				+ getUserName() + ", getUserID()=" + getUserID() + ", getNickName()=" + getNickName()
				+ ", getGroupID()=" + getGroupID() + ", getRegistTime()=" + getRegistTime() + ", getPurchasedCourse()="
				+ getPurchasedCourse() + ", getPassCourse()=" + getPassCourse() + ", getExcellentCourse()="
				+ getExcellentCourse() + ", getLearningCourse()=" + getLearningCourse() + ", getCompleteCourse()="
				+ getCompleteCourse() + ", getLectures()=" + getLectures() + ", getIsOnline()=" + getIsOnline()
				+ ", getLoginTime()=" + getLoginTime() + ", getPassword()=" + getPassword() + ", getStatus()="
				+ getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
