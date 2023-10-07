package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDAO {
	Connection connection;
	PreparedStatement pst;
	CourseDAO dao;

	@Override
	public String AddCourse(Course course) throws ClassNotFoundException, SQLException {
		connection = CourseConnectionHelper.getConnection();
		String cmd = "Insert Into Courses(CourseID,CourseName,Department,Credits) values(?,?,?,?)";
		pst= connection.prepareStatement(cmd);
		pst.setInt(1, course.getCourseId());
		pst.setString(2, course.getCourseName());
		pst.setString(3, course.getDeptName());
		pst.setInt(4, course.getCredits());
		pst.executeUpdate();
		
		return"Course Added in Your Database";
		
	}

	@Override
	public List<Course> showCourse() throws ClassNotFoundException, SQLException {
		connection=CourseConnectionHelper.getConnection();
		String cmd = "Select*from Courses";
		pst=connection.prepareStatement(cmd);
		List<Course> courseList = new ArrayList<Course>();
		Course course=null;
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			course=new Course();
			course.setCourseId(rs.getInt("CourseID"));
			course.setCourseName(rs.getString("CourseName"));
			course.setDeptName(rs.getString("Department"));
			course.setCredits(rs.getInt("Credits"));
			courseList.add(course);
		}
		return courseList;
	}

	@Override
	public Course searchCourse(int courseId) throws ClassNotFoundException, SQLException {
		connection = CourseConnectionHelper.getConnection();
		String cmd = "Select * from Courses where CourseID=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, courseId);
		ResultSet rs = pst.executeQuery();
		Course course=null;
		if(rs.next()) {
			course=new Course();
			course.setCourseId(rs.getInt("CourseID"));
			course.setCourseName(rs.getString("CourseName"));
			course.setDeptName(rs.getString("Department"));
			course.setCredits(rs.getInt("Credits"));
			
			
		}
		return course;
				
	}

	@Override
	public String deleteCourse(int courseId) throws ClassNotFoundException, SQLException {
		dao=new CourseDaoImpl();
		Course course_found = dao.searchCourse(courseId);
		if(course_found!=null) {
			connection = CourseConnectionHelper.getConnection();
			String cmd = "Delete from Courses where courseID=?";
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, course_found.getCourseId());
			pst.executeUpdate();
			return"Record Deleted..";
	}
	return "Your Record Not Exists";
 }

	@Override
	public String UpdateCourse(Course course) throws ClassNotFoundException, SQLException {
		connection=CourseConnectionHelper.getConnection();
//		Course course1 = dao.searchCourse(course.getCourseId());
		String cmd = "Update Courses set CourseName=?,Department=?,Credits=? where courseID=?";
		pst=connection.prepareStatement(cmd);
//		Course course_found = dao.searchCourse(course.getCourseId());
		pst.setString(1,course.getCourseName());
		pst.setString(2, course.getDeptName());
		pst.setInt(3, course.getCredits());
		pst.setInt(4, course.getCourseId());
		pst.executeUpdate();
		
		return"Course Updated...";
	}

}
