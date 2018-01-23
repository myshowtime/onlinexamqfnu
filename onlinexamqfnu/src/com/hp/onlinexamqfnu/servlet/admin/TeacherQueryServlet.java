package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.service.admin.ITeacherService;
import com.hp.onlinexamqfnu.service.admin.TeacherService;

/**
 * Servlet implementation class TeacherQueryServlet
 */
@WebServlet("/teacherQueryServlet")
public class TeacherQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITeacherService ts = new TeacherService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List teaList = ts.findAll();
		request.setAttribute("teacherList", teaList);
		request.getRequestDispatcher("manager/teachermanage.jsp").forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		List teaList = ts.findAllByName(name);
		request.setAttribute("teacherList", teaList);
		request.getRequestDispatcher("manager/teachermanage.jsp").forward(request,response);
	}

}
