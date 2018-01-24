package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Course;
import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.po.Test;
import com.hp.onlinexamqfnu.service.admin.CourseService;
import com.hp.onlinexamqfnu.service.admin.ICourseService;
import com.hp.onlinexamqfnu.service.admin.IStuClassService;
import com.hp.onlinexamqfnu.service.admin.StuClassService;
import com.hp.onlinexamqfnu.service.teacher.IQuestionService;
import com.hp.onlinexamqfnu.service.teacher.ITestService;
import com.hp.onlinexamqfnu.service.teacher.QuestionService;
import com.hp.onlinexamqfnu.service.teacher.TestService;
import com.hp.onlinexamqfnu.util.ToolUtil;

/**
 * Servlet implementation class Test
 */
@WebServlet("/testAddServlet")
public class TestAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITestService ts = new TestService();
    private ICourseService cs= new CourseService();
    private IStuClassService scs = new StuClassService();
    private IQuestionService qs = new QuestionService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher t = (Teacher)request.getSession().getAttribute("user");
		List cList = cs.findAllCoursesByTeacherId(t.getId());
		List scList  = scs.findAllStuClassByTeacherId(t.getId());
		request.setAttribute("courseList", cList);
		request.setAttribute("classesList", scList);
		request.getRequestDispatcher("teacher/testadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date endDate = null;
		try {
			endDate = (Date) sdf.parse(request.getParameter("enddate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int testTime= Integer.valueOf(request.getParameter("testtime"));
		String sinScores = request.getParameter("sinscores");
		int sinNum = Integer.valueOf(request.getParameter("sinnum"));
		int courseId = Integer.valueOf(request.getParameter("courseid"));
		String []classIds = request.getParameterValues("classCheck");
		String testName = request.getParameter("testname");
		int teacherId = ((Teacher)request.getSession().getAttribute("user")).getId();
		/**
		 * 查找相应课程
		 */
		Course c = cs.findCourseById(courseId);
		/**
		 * 查找相应班级
		 */
		String classIdsToStr = ToolUtil.arraytoString(classIds);//将Id数组转换为字符串
		String classNames = scs.findClassNamesByIds(classIdsToStr);
		/**
		 *业务方面：查找相应题目
		 */
		List<Map<String ,Object>> questionList = qs.collectQuestions(courseId, sinNum);
		/**
		 * 向页面传递信息
		 */
		/**
		 * 封转Test对象	
		 */
		Test t = new Test();
		String quesIds = qs.testQuestionIds(questionList);
		t.setClassIds(quesIds);
		t.setCourseId(courseId);
		t.setClassIds(classIdsToStr);
		t.setEndDate(endDate);
		t.setScores(sinScores);
		t.setName(testName);
		t.setTeacherId(teacherId);
		
		request.setAttribute("c",c);
		request.setAttribute("classNames", classNames);
		request.setAttribute("quesList", questionList);
		request.getRequestDispatcher("teacher/test.jsp").forward(request, response);
		
	}

}
