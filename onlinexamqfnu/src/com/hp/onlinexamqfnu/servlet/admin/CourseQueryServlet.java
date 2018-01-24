package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.service.admin.CourseService;
import com.hp.onlinexamqfnu.service.admin.ICourseService;

/**
 * Servlet implementation class CourseQueryServlet
 */
@WebServlet("/courseQueryServlet")
public class CourseQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ICourseService cs= new CourseService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List courseList = cs.findAllCourses();
		request.setAttribute("tcList", courseList);
		request.getRequestDispatcher("manager/coursemanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("courseSearch");
		List courseList = cs.findAllCoursesByName(name);
		request.setAttribute("tcList", courseList);
		request.getRequestDispatcher("manager/coursemanage.jsp").forward(request, response);	
	}
}
