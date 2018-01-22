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
import com.hp.onlinexamqfnu.vo.TeacherCourseView;

/**
 * Servlet implementation class ScheduleQueryServlet
 */
@WebServlet("/scheduleQueryServlet")
public class ScheduleQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ICourseService cs = new CourseService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TeacherCourseView> tcvList = cs.findAll();
		request.setAttribute("tcList", tcvList);
		request.getRequestDispatcher("manager/schedulemanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
