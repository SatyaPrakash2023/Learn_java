package com.java.cms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCourseServlet
 */
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Course course = new Course();
		course.setCourseId(Integer.parseInt(request.getParameter("courseId")));
		course.setCourseName(request.getParameter("courseName"));
		course.setDeptName(request.getParameter("DeptName"));
		course.setCredits(Integer.parseInt(request.getParameter("Credits")));
		PrintWriter out = response.getWriter();
		CourseDAO dao = new CourseDaoImpl();
		
		try {
			dao.AddCourse(course);
			out.println("Your Record  Added to Database...");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
