package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TestBean;
import com.dao.DAO;

/**
 * Servlet implementation class CreateTest
 */
@WebServlet("/CreateTest")
public class CreateTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doCommon(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

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
		TestBean tbobj = new TestBean();
		DAO ob = new DAO();
		int testDuration = Integer.parseInt(request.getParameter("duration"));
		String testName = request.getParameter("testname");
		String questionsid[] = request.getParameterValues("question");
		String testDate = request.getParameter("date");

		String testquestionsid = "";
		for (int i = 0; i < questionsid.length; i++) {
			testquestionsid += questionsid[i] + " ";
		}
		tbobj.setTestName(testName);
		tbobj.setTestDuration(testDuration);
		tbobj.setTestQuestionsId(testquestionsid);
		tbobj.setTestDate(testDate);

		ob.saveTest(tbobj);

		request.setAttribute("message", "Test has been saved with name: " + testName);
		RequestDispatcher rd = request.getRequestDispatcher("/response.jsp");
		rd.forward(request, response);

	}

}
