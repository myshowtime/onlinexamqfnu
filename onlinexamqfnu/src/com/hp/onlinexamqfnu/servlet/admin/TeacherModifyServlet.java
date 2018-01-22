package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.service.admin.ITeacherService;
import com.hp.onlinexamqfnu.service.admin.TeacherService;
import com.hp.onlinexamqfnu.util.Department;

/**
 * Servlet implementation class TeacherModifyServlet
 */
@WebServlet("/teacherModifyServlet")
public class TeacherModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITeacherService ts = new TeacherService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Teacher t = ts.findTeacherInfo(Integer.valueOf(id));
		request.setAttribute("teacherInfo", t);
		request.setAttribute("deptList", Department.values());
		request.getRequestDispatcher("manager/teachermodify.jsp").forward(request,response);
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
		t.setDeptName(deptName);
		t.setId(Integer.valueOf(teaId));
		t.setName(teaName);
		t.setpwd(teaPwd);
		ts.updateTeacher(t,Integer.valueOf(teaId));
		request.getRequestDispatcher("/teacherQueryServlet").forward(request, response);
	}

}
