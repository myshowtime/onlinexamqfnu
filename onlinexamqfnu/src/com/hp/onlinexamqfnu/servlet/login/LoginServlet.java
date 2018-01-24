package com.hp.onlinexamqfnu.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.service.login.ILoginService;
import com.hp.onlinexamqfnu.service.login.LoginService;

/**
 * Servlet implementation class LoginServlet
 * 
 */

/**
 * 使用哪个方法 
 * 查询一般用get方式
 * 增删改一般用post方式 登陆一般用post
 * 
 * @author Administrator
 *
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 *1.接受请求参数
	 *2.向业务层获取结果
	 *3.把结果封装到request对象传递到页面
	 *4.页面跳转
	 */
	private static final long serialVersionUID = 1L;
    private ILoginService ls = new LoginService();
    private Teacher t = null;
	private Student s = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("password");
		String userRole = request.getParameter("role");
		
		if("admin".equals(userRole)) {
			if("admin".equals(userName) && "123".equals(userPwd)){
				response.sendRedirect("manager/mindex.jsp");
			}
		}
		else if("teacher".equals(userRole)) {
			t=new Teacher();
			t.setName(userName);
			t.setpwd(userPwd);
			t = ls.canLogin(t);
			if(t!=null) {
				request.getSession().setAttribute("user", t);
				response.sendRedirect("teacher/tindex.jsp");
			}
		}
		
	}

}
