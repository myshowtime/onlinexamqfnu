package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.service.teacher.IQuestionService;
import com.hp.onlinexamqfnu.service.teacher.QuestionService;

/**
 * Servlet implementation class QuestionQueryServlet
 */
@WebServlet("/questionQueryServlet")
public class QuestionQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IQuestionService qs= new QuestionService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectk = request.getParameter("selectk");
		String searchName = request.getParameter("searchName");
		if(searchName != null)
		searchName = new String(searchName.getBytes("ISO-8859-1"), "utf-8");
		List<Map<String ,Object>> qList = qs.findAll(selectk, searchName);
		request.setAttribute("queList", qList);
		request.getRequestDispatcher("teacher/questionmanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
