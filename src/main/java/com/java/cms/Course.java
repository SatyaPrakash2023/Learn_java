package com.java.cms;

public class Course {
	private int courseId;
	private String courseName;
	private String DeptName;
	private int credits;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int courseId, String courseName, String deptName, int credits) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		DeptName = deptName;
		this.credits = credits;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", DeptName=" + DeptName + ", credits="
				+ credits + "]";
	}
	
	

}
