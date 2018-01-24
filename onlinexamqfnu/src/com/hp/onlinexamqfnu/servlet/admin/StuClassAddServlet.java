package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.StuClass;
import com.hp.onlinexamqfnu.service.admin.IStuClassService;
import com.hp.onlinexamqfnu.service.admin.StuClassService;
import com.hp.onlinexamqfnu.util.Department;

/**
 * Servlet implementation class StuClassAddServlet
 */
@WebServlet("/stuClassAddServlet")
public class StuClassAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IStuClassService scs = new StuClassService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuClassAddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("depList", Department.values());
		request.getRequestDispatcher("manager/stuclassadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String claNum = request.getParameter("clanum");
		String claName = request.getParameter("claname");
		String depInfo = request.getParameter("depInfo");
		StuClass sc = new StuClass();
		sc.setId(Integer.valueOf(claNum));
		sc.setName(claName);
		sc.setDeptName(depInfo);
		scs.addStuClass(sc);
		/**
		 * 添加完班级后，需要重新做查询。因为已经做过查询功能，只需跳转查询servlet就可以。
		 */
		response.sendRedirect(getServletContext().getContextPath()+"/stuClassQueryServlet");	
	}

}
