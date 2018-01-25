package com.hp.onlinexamqfnu.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.service.teacher.ITestService;
import com.hp.onlinexamqfnu.service.teacher.TestService;
import com.hp.onlinexamqfnu.util.ToolUtil;

/**
 * Servlet implementation class RecentTestServlet
 */
@WebServlet("/recentTestServlet")
public class RecentTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITestService ts = new TestService();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecentTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s = (Student)request.getSession().getAttribute("user");
		int id = s.getId();
		List stuRecentTests = new ArrayList();
		stuRecentTests = ts.getTestByStudent(id, ToolUtil.getCurrentTime());
		request.setAttribute("testsList", stuRecentTests);
		request.getRequestDispatcher("student/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
