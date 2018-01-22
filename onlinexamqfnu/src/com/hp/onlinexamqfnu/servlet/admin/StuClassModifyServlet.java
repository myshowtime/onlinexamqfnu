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
 * Servlet implementation class StuClassModifyServlet
 */
@WebServlet("/stuClassModifyServlet")
public class StuClassModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStuClassService scs = new StuClassService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuClassModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("info");
		StuClass sc = scs.findStuClassById(Integer.valueOf(id));
		request.setAttribute("stuClassMap", sc);
		request.setAttribute("depList",Department.values());
		request.getRequestDispatcher("manager/stuclassmodify.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classId = request.getParameter("clanum");
		String className = request.getParameter("claname");
		String deptName =request.getParameter("depInfo");
		StuClass sc =  new StuClass();
		sc.setId(Integer.valueOf(classId));
		sc.setDeptName(deptName);
		sc.setName(className);
		scs.updateStuClass(sc);
		request.getRequestDispatcher("/stuClassQueryServlet").forward(request, response);
	}

}
