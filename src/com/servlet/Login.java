package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doCommon(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		username = username.trim();

		request.setAttribute("username", username);
		if (username == null && password == null) {

			request.setAttribute("message", "Username and password can not be empty");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		} else if (username.equalsIgnoreCase("admin@wipro.com") && password.equals("wiproadmin")) {

			RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		} else {
			DAO dob1 = new DAO();
			boolean flag = dob1.verifyUser(username, password);
			if (flag) {
				RequestDispatcher rd = request.getRequestDispatcher("/avilabletests.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("username", username);
				request.setAttribute("message", "Invalied User name or password");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}

	}

}
