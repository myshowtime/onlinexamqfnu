package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.po.Test;
import com.hp.onlinexamqfnu.service.teacher.ITestService;
import com.hp.onlinexamqfnu.service.teacher.TestService;

/**
 * Servlet implementation class testCreateServlet
 */
@WebServlet("/testCreateServlet")
public class TestCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITestService ts = new TestService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher  teacher= (Teacher)request.getSession().getAttribute("user");
		Test test = (Test)request.getSession().getAttribute("test");
		test.setTeacherId(teacher.getId());
		ts.createTest(test);
		response.sendRedirect(getServletContext().getContextPath()+"/testQueryServlet");
	}

}
