package com.hp.onlinexamqfnu.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.service.teacher.IPaperService;
import com.hp.onlinexamqfnu.service.teacher.PaperService;

/**
 * Servlet implementation class PastTestServlet
 */
@WebServlet("/pastTestServlet")
public class PastTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPaperService ps = new PaperService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PastTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s = (Student)request.getSession().getAttribute("user");
		List paperList  = ps.getPaperByStudentId(s.getId());
		request.setAttribute("paperList", paperList);
		request.setAttribute("user", s);
		request.getRequestDispatcher("student/history.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
