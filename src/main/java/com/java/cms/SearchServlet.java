package com.java.cms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int course_id=Integer.parseInt(request.getParameter("courseId"));
		CourseDAO dao = new CourseDaoImpl();
		PrintWriter out = response.getWriter();
		try {
			Course obj = dao.searchCourse(course_id);
			if(obj!=null) {
				out.println("Course Id is "+obj.getCourseId());
				out.println("Course Name is "+obj.getCourseName());
				out.println("DepartMent Name is"+obj.getDeptName());
				out.println("Credits "+obj.getCredits());
				
			}else {
				out.println("Record Not Found");
			}
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
