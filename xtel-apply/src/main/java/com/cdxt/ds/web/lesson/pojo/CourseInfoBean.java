package com.cdxt.ds.web.lesson.pojo;

public class CourseInfoBean {
	public int LecturerID;
	public String className;
	public int classTime;
	public int classPrice;
	public int satus;
	public int classtype;
	public int calssNumber;
	public String classinfo;
	public  int Sold;
	public int Pass;
	public long LastClassTime;
	public int ReviewerID;
	@Override
	public String toString() {
		return "CourseInfoBean [LecturerID=" + LecturerID + ", className=" + className + ", classTime=" + classTime
				+ ", classPrice=" + classPrice + ", satus=" + satus + ", classtype=" + classtype + ", calssNumber="
				+ calssNumber + ", classinfo=" + classinfo + ", Sold=" + Sold + ", Pass=" + Pass + ", LastClassTime="
				+ LastClassTime + ", ReviewerID=" + ReviewerID + "]";
	}
	
	
	
	
	

}
