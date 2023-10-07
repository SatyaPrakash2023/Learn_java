package com.java.cms;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO {
	String AddCourse(Course course) throws ClassNotFoundException, SQLException;
	List<Course> showCourse() throws ClassNotFoundException, SQLException;
	Course searchCourse(int courseId) throws ClassNotFoundException, SQLException;
	String deleteCourse(int courseId) throws ClassNotFoundException, SQLException;
	String UpdateCourse(Course course) throws ClassNotFoundException, SQLException;
	

}
