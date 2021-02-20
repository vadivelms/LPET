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

import com.bean.UserBean;
import com.dao.DAO;

/**
 * Servlet implementation class Adduser
 */
@WebServlet("/Adduser")
public class Adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doCommon(request, response);
		} catch (SQLException e) {

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
		PrintWriter out = response.getWriter();
		UserBean beanobj = new UserBean();
		DAO dobj = new DAO();
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String aemail = request.getParameter("aemail");
		String pass = request.getParameter("password");

		if (request.getParameter("addbtn") == null) {
			if (dobj.checkUser(email)) {
				out.println("This Mail Id Already Registred");

			} 
		} else {
			beanobj.setFname(fname);
			beanobj.setLname(lname);
			beanobj.setDob(dob);
			beanobj.setEmail(email);
			beanobj.setAemail(aemail);
			beanobj.setPassword(pass);
			if (dobj.addUser(beanobj)) {
				String message = "\n" + "\nUsername :" + fname + "\nPassword :" + pass + "\nE-Mail :" + email;
				request.setAttribute("message", "New User Has Been Added ..\n" + message);
				request.setAttribute("title", "Add User Success");
				request.setAttribute("url", "admin.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("/response.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "New User Failed ....\n");
				request.setAttribute("title", "Add User Failed");
				
				RequestDispatcher rd = request.getRequestDispatcher("/response.jsp");
				rd.forward(request, response);
			}	
		}
	}
}
