package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.service.teacher.IPaperService;
import com.hp.onlinexamqfnu.service.teacher.PaperService;

/**
 * Servlet implementation class PaperCompareServlet
 */
@WebServlet("/papersCompareServlet")
public class PapersCompareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IPaperService ps = new PaperService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PapersCompareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher t = (Teacher)request.getSession().getAttribute("user");
		List<Map<String,Object>> pList = (List<Map<String, Object>>) ps.getPaperCompare(t.getId());
		request.setAttribute("paperList", pList);
		request.getRequestDispatcher("teacher/classpapers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
