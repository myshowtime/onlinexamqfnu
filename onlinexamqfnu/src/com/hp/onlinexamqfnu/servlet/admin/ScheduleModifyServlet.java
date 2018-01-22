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
 * Servlet implementation class ScheduleModifyServlet
 */
@WebServlet("/scheduleModifyServlet")
public class ScheduleModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ICourseService cs = new CourseService();
    private IStuClassService scs = new StuClassService();
    private ITeacherService ts = new TeacherService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("info"));
		List cList = cs.findAllCourses();
		List scList = scs.findAll();
		List tList = ts.findAll();
		TeacherCourse tc= cs.findTeacherCourseById(id);
		request.setAttribute("teaList", tList);
		request.setAttribute("courList", cList);
		request.setAttribute("stuclList", scList);
		request.setAttribute("tc", tc);
		request.setAttribute("teaCourId", id);
		request.getRequestDispatcher("manager/schedulemodify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherCourse tc = new TeacherCourse();
		tc.setId(Integer.valueOf(request.getParameter("teaCourId")));
		tc.setCourseId(Integer.valueOf(request.getParameter("course")));
		tc.setTeaId(Integer.valueOf(request.getParameter("teacher")));
		tc.setClassId(Integer.valueOf(request.getParameter("stuclass")));
		cs.modifyTeacherCourse(tc);
		request.getRequestDispatcher("/scheduleQueryServlet").forward(request, response);
	}

}
