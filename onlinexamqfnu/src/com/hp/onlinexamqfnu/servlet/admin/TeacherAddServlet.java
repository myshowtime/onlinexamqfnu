package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.service.admin.TeacherService;
import com.hp.onlinexamqfnu.service.teacher.ITeacherService;
import com.hp.onlinexamqfnu.util.Department;

/**
 * Servlet implementation class TeacherAddServlet
 */
@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITeacherService ts = new TeacherService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("deptList", Department.values());
		request.getRequestDispatcher("manager/teacheradd.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teaId = request.getParameter("num");
		String teaName = request.getParameter("username");
		String teaPwd =request.getParameter("password");
		String deptName = request.getParameter("dep");
		Teacher t = new Teacher();
		t.setId(Integer.valueOf(teaId));
		t.setDeptName(deptName);
		t.setName(teaName);
		t.setpwd(teaPwd);
		ts.addTeacher(t);
		response.sendRedirect(getServletContext().getContextPath()+"/teacherQueryServlet");
	}

}
