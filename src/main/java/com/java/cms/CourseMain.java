package com.java.cms;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;



public class CourseMain {
	public static void main(String[] args) {
		int courseId,credits;
		String courseName,DeptName;
		
		
		int choice;
		
		
		do {
			System.out.println("1.Add Course");
			System.out.println("2. Show Course");
			System.out.println("3.Search Course");
			System.out.println("4.Delete Course");
			System.out.println("5. Update Course.");
			Scanner sc = new Scanner(System.in);
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				AddCourse();
				break;
			case 2:
				ShowCourse();
				break;
			case 3:
				SearchCourse();
				break;
			case 4:
				DeleteCourse();
				break;
			case 5:
				UpdateCourse();
				break;
			}
			
			
		}while(choice!=6);
		
		
		
		
	}

	public static void UpdateCourse() {
		Course course = new Course();
		CourseDAO dao=  new CourseDaoImpl();
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Enter Course Id..");
		course.setCourseId(sc3.nextInt());
		System.out.println("Enter Course Name ");
		course.setCourseName(sc3.next());
		System.out.println("Enter Department Name");
		course.setDeptName(sc3.next());
		System.out.println("Enter Credits..");
		course.setCredits(sc3.nextInt());
		
		try {
			System.out.println(dao.UpdateCourse(course));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void DeleteCourse() {
		int courseId;
		Scanner sc4 =new Scanner(System.in);
		System.out.println("Enter your course Id.");
		courseId = sc4.nextInt();
		
		CourseDAO dao=new CourseDaoImpl();
		try {
			System.out.println(dao.deleteCourse(courseId));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void SearchCourse() {
		int courseId;
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter Your CourseId..");
		courseId=sc2.nextInt();
		CourseDAO dao=  new CourseDaoImpl();
		
		try {
			System.out.println(dao.searchCourse(courseId));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public static void ShowCourse() {
		CourseDAO dao = new CourseDaoImpl();
		try {
			List<Course> courseList = dao.showCourse();
			for (Course course2 : courseList) {
				System.out.println(course2);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void AddCourse() {
		 
		Course course = new Course();
		CourseDAO dao=  new CourseDaoImpl();
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter Course Name ");
		course.setCourseName(sc1.next());
		System.out.println("Enter Department Name");
		course.setDeptName(sc1.next());
		System.out.println("Enter Credits..");
		course.setCredits(sc1.nextInt());
		
		try {
			System.out.println(dao.AddCourse(course));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
