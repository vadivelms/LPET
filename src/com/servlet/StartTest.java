package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAO;

/**
 * Servlet implementation class StartTest
 */
@WebServlet("/StartTest")
public class StartTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StartTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doCommon(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doCommon(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doCommon(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		DAO ob = new DAO();
		String id = null;
		String testname = null;
		ResultSet rs = null;
		String title = null;
		String desc = null;
		String constraints = null;
		String i_f = null;
		String o_f = null;
		String s_i = null;
		String s_o = null;
		String initialCode = "";
		String username = request.getParameter("uname");
		request.setAttribute("username", username);
		Enumeration paramNames = request.getParameterNames();
		String testId = null;
		while (paramNames.hasMoreElements()) {
			testId = (String) paramNames.nextElement();
		}
		try {
			testname = ob.getTestName(testId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			rs = ob.getQuestion(testId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if (ob.checkTestAttempt(testId, username)) {
			request.setAttribute("message", "You have alread taken this this Test");
			request.setAttribute("title", "More attempts");
			RequestDispatcher rd = request.getRequestDispatcher("/response.jsp");
			rd.forward(request, response);
		}*/
		try {
			while (rs.next()) {

				if (rs.getString("title") != null) {
					id = rs.getString("id");
					title = rs.getString("title");
					desc = rs.getString("description");
					constraints = rs.getString("constraints");
					i_f = rs.getString("input_format");
					o_f = rs.getString("output_format");
					s_i = rs.getString("sample_input");
					s_o = rs.getString("sample_output");
					initialCode += rs.getString("IMPORTS") + "\n";
					initialCode += "class " + username.substring(0, username.indexOf('@')) + id + "{" + "\n";
					initialCode += rs.getString("MAIN") + "\n";
					initialCode += rs.getString("METHOD") + "\n{\n}\n}";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName = username.substring(0, username.indexOf('@')) + id + ".java";

		request.setAttribute("filename", fileName);
		request.setAttribute("coding", initialCode);
		request.setAttribute("title", title);
		request.setAttribute("desc", desc);
		request.setAttribute("constraints", constraints);
		request.setAttribute("i_f", i_f);
		request.setAttribute("o_f", o_f);
		request.setAttribute("s_i", s_i);
		request.setAttribute("s_o", s_o);
		request.setAttribute("testName", testname);
		request.setAttribute("testId", testId);
		request.setAttribute("questionId", id);		
		if (ob.saveUserDetails(testId, username, id)) {
			RequestDispatcher rd = request.getRequestDispatcher("/test.jsp");
			rd.forward(request, response);
		}

	}

}
