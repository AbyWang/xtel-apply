package com.cdxt.ds.web.lesson.pojo;


/**
 * @类描述：课程信息表
 * @项目名称：teachingSystem
 * @包名： com.cdxt.ms.model
 * @类名称：CourseInfo
 * @创建人：张兴成
 * @创建时间：2018年4月26日上午9:45:21
 * @修改人：张兴成
 * @修改时间：2018年4月26日上午9:45:21
 * @修改备注：
 * @version v1.0
 * @see 
 * @bug 
 * @Copyright 
 * @mail *@qq.com
 */
public class CourseInfo {
	//课程ID
	private int courseID;
	//课程所属的用户ID
	private int lecturerID;
	//课程名称
	private String name;
	//课程状态
	//0 – 未提交，未审核
	//1 – 已提交，审核中
	//2 – 审核通过，等待开课
	//3 – 课程进行中
	//4 – 课程已结束
	private int status;
	//总课时
	private int totalClass;
	//价格
	private int price;
	//课程类型
	//0 – 传统直播授课
	//1 – 智能授课
	private int courseType;
	//已售出数量
	private int sold;
	//已通过该门课程的人数
	private int pass;
	//最近一次开课时间，以s为单位的时间戳
	private int lastClassTime;
	//审核人ID
	private int reviewerID;
	//课程简介
	private String brief;

	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getLecturerID() {
		return lecturerID;
	}
	public void setLecturerID(int lecturerID) {
		this.lecturerID = lecturerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTotalClass() {
		return totalClass;
	}
	public void setTotalClass(int totalClass) {
		this.totalClass = totalClass;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCourseType() {
		return courseType;
	}
	public void setCourseType(int courseType) {
		this.courseType = courseType;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getLastClassTime() {
		return lastClassTime;
	}
	public void setLastClassTime(int lastClassTime) {
		this.lastClassTime = lastClassTime;
	}
	public int getReviewerID() {
		return reviewerID;
	}
	public void setReviewerID(int reviewerID) {
		this.reviewerID = reviewerID;
	}
	
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	@Override
	public String toString() {
		return "CourseInfo [courseID=" + courseID + ", lecturerID=" + lecturerID + ", name=" + name + ", status="
				+ status + ", totalClass=" + totalClass + ", price=" + price + ", courseType=" + courseType + ", sold="
				+ sold + ", pass=" + pass + ", lastClassTime=" + lastClassTime + ", reviewerID=" + reviewerID
				+ ", brief=" + brief + "]";
	}
	

}
