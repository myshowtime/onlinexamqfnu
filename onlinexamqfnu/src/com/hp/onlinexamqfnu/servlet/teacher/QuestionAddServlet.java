package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Question;
import com.hp.onlinexamqfnu.service.admin.CourseService;
import com.hp.onlinexamqfnu.service.admin.ICourseService;
import com.hp.onlinexamqfnu.service.teacher.IQuestionService;
import com.hp.onlinexamqfnu.service.teacher.QuestionService;

/**
 * Servlet implementation class QuestionAddServlet
 */
@WebServlet("/questionAddServlet")
public class QuestionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ICourseService cs = new CourseService();
    private IQuestionService qs = new QuestionService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List cList = cs.findAllCourses();
		request.setAttribute("courseList", cList);
		request.getRequestDispatcher("teacher/quesadd.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Question q =new Question();
		q.setCourseId(Integer.valueOf(request.getParameter("courseId")));
		q.setQueTitle(request.getParameter("queTitle"));
		q.setQueType(Integer.valueOf(request.getParameter("queType")));
		q.setChoiceA(request.getParameter("choiceA"));
		q.setChoiceB(request.getParameter("choiceB"));
		q.setChoiceC(request.getParameter("choiceC"));
		q.setChoiceD(request.getParameter("choiceD"));
		q.setAns(request.getParameter("ans"));
		qs.addQuestion(q);
		response.sendRedirect(getServletContext().getContextPath()+"/questionQueryServlet");
	}

}
