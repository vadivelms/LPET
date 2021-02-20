package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doCommon(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doCommon(request, response);
	}

	protected void doCommon(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");

		request.setAttribute("uname", uname);

		if (request.getParameter("authorquestion") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/author_questions.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("addusers") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/add_users.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("createtest") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/createtest.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("result") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/adminresult.jsp");
			rd.forward(request, response);
		}else if (request.getParameter("feedback") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/viewfeedback.jsp");
			rd.forward(request, response);
		}
		
	}

}
