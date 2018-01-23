package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.TeacherCourse;
import com.hp.onlinexamqfnu.service.admin.CourseService;
import com.hp.onlinexamqfnu.service.admin.ICourseService;
import com.hp.onlinexamqfnu.service.admin.IStuClassService;
import com.hp.onlinexamqfnu.service.admin.ITeacherService;
import com.hp.onlinexamqfnu.service.admin.StuClassService;
import com.hp.onlinexamqfnu.service.admin.TeacherService;

/**
 * Servlet implementation class ScheduleAddServlet
 */
@WebServlet("/scheduleAddServlet")
public class ScheduleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ICourseService cs = new CourseService();
    private IStuClassService scs = new StuClassService();
    private ITeacherService ts = new TeacherService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List cList = cs.findAllCourses();
		List scList = scs.findAll();
		List tList = ts.findAll();
		request.setAttribute("teaList", tList);
		request.setAttribute("courseList", cList);
		request.setAttribute("stuclList", scList);
		request.getRequestDispatcher("manager/scheduleadd.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tId = Integer.valueOf(request.getParameter("teacher"));
		int cId = Integer.valueOf(request.getParameter("course"));
		int scId = Integer.valueOf(request.getParameter("stuclass"));
		TeacherCourse tc = new TeacherCourse();
		tc.setClassId(scId);
		tc.setTeaId(tId);
		tc.setCourseId(cId);
		cs.addSchedule(tc);
		response.sendRedirect(getServletContext().getContextPath()+"/scheduleQueryServlet");	
	}

}
