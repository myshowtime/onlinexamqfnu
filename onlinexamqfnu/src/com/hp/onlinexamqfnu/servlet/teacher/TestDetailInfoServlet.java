package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Course;
import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.service.admin.CourseService;
import com.hp.onlinexamqfnu.service.admin.ICourseService;
import com.hp.onlinexamqfnu.service.admin.IStuClassService;
import com.hp.onlinexamqfnu.service.admin.StuClassService;
import com.hp.onlinexamqfnu.service.teacher.IQuestionService;
import com.hp.onlinexamqfnu.service.teacher.ITestService;
import com.hp.onlinexamqfnu.service.teacher.QuestionService;
import com.hp.onlinexamqfnu.service.teacher.TestService;

/**
 * Servlet implementation class TestDetailServlet
 */
@WebServlet("/testDetailInfoServlet")
public class TestDetailInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITestService ts = new TestService();
    private ICourseService cs = new CourseService();
    private IQuestionService qs = new QuestionService();
    private IStuClassService scs = new StuClassService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDetailInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		Teacher t = (Teacher) request.getSession().getAttribute("user");
		Map<String, Object> testMap = ts.findTestById(id, t.getId());
		Course course = cs.findCourseById(((int)testMap.get("courseId")));
		List<Map<String ,Object>> queList = qs.findQuestionByIds((String)testMap.get("questions"));
		String className = scs.findClassNamesByIds((String)testMap.get("classIds"));
		Map<String,Object> test = new HashMap();
		test.put("className", className);
		test.put("cName", course.getName());
		test.put("tName", testMap.get("name"));
		test.put("endDate", testMap.get("endDate"));
		test.put("testTime", testMap.get("testTime"));
		request.setAttribute("test", test);
		request.setAttribute("quesList", queList);
		request.getRequestDispatcher("teacher/viewtest.jsp").forward(request, response);		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(getServletContext().getContextPath()+"/testQueryServlet");
	}

}
