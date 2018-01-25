package com.hp.onlinexamqfnu.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Paper;
import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.service.teacher.IPaperService;
import com.hp.onlinexamqfnu.service.teacher.IQuestionService;
import com.hp.onlinexamqfnu.service.teacher.ITestService;
import com.hp.onlinexamqfnu.service.teacher.PaperService;
import com.hp.onlinexamqfnu.service.teacher.QuestionService;
import com.hp.onlinexamqfnu.service.teacher.TestService;

/**
 * Servlet implementation class StudentTest
 */
@WebServlet("/studentTest")
public class StudentTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITestService ts = new TestService();
    private IQuestionService qs = new QuestionService();
    private IPaperService ps = new PaperService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s= (Student)request.getSession().getAttribute("user");
		Map<String ,Object> testMap = new HashMap();
		List<Map<String ,Object>> questionList = new ArrayList();
		/**
		 * 获取试题 的 id
		 */
		int testId = Integer.valueOf(request.getParameter("testId"));
		/**
		 * 获取试题
		 */
		testMap = ts.findStudentTestsById(s.getId(), testId);
		questionList= qs.findQuestionByIds((String)testMap.get("questions"));
		double scoreperques = Integer.valueOf((String)testMap.get("scores"))*1.0/questionList.size();
		request.setAttribute("scoreperques", scoreperques);
		request.setAttribute("test", testMap);
		request.setAttribute("quesList", questionList);
		request.getRequestDispatcher("student/exam.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s = (Student)request.getSession().getAttribute("user");
		int testId = Integer.valueOf(request.getParameter("testId"));
		String testTime = request.getParameter("hidden1");
		StringBuffer sbOfWrongId = new StringBuffer();
		StringBuffer sbOfWrongAns = new StringBuffer();
		Map<String ,Object> testMap = new HashMap();
		List<Map<String,Object>> quesList = new ArrayList();
		testMap = ts.findStudentTestsById(s.getId(), testId);
		quesList = qs.findQuestionByIds((String)testMap.get("questions"));
		float score = Integer.valueOf((String)testMap.get("scores"));
		float numOfQues = (float)quesList.size();
		float rightAns=(float) 0.0;
		String tempId;
		String InputAns;
		for (Map<String, Object> queMap : quesList) {
			tempId = String.valueOf(queMap.get("id"));
			InputAns = request.getParameter("ques_"+tempId);
			if(InputAns.equals((String)queMap.get("ans"))) {
				rightAns+=1;
			}else {
				sbOfWrongId.append(tempId).append(",");
				sbOfWrongAns.append(InputAns).append(",");
			}
		}
		score = score*(rightAns/numOfQues);
		/**
		 * 去除末尾的逗号
		 */
		if(sbOfWrongId.length()>0) {
			sbOfWrongId.deleteCharAt(sbOfWrongId.length()-1);
			sbOfWrongAns.deleteCharAt(sbOfWrongAns.length()-1);
		}
		Paper p = new Paper();
		p.setCourseId((int)testMap.get("courseId"));
		p.setScore(score);
		p.setStudentId(s.getId());
		p.setTestId(testId);
		p.setTime(testTime);
	
		p.setWrongAns(sbOfWrongAns.toString());
		p.setWrongQueId(sbOfWrongId.toString());
		ps.save(p);
		response.sendRedirect(getServletContext().getContextPath()+"/pastTestServlet");
	}

}
