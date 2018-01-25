package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.service.teacher.ITestService;
import com.hp.onlinexamqfnu.service.teacher.TestService;

/**
 * Servlet implementation class TestQueryServlet
 */
@WebServlet("/testQueryServlet")
public class TestQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITestService ts =  new TestService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestQueryServlet() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher t = (Teacher)request.getSession().getAttribute("user");
		List<java.util.Map<String, Object>> testList = ts.findTestsByTeaId(t.getId());
		request.setAttribute("testsList", testList);
		request.getRequestDispatcher("teacher/tmain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
