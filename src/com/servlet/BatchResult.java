package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAO;

/**
 * Servlet implementation class BatchResult
 */
@WebServlet("/BatchResult")
public class BatchResult extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doCommon(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			doCommon(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doCommon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		DAO ob = new DAO();
		PrintWriter out = response.getWriter();
		
		
		String testId=request.getParameter("testName");
		String testName=ob.getTestName(testId);
		ResultSet rs = ob.getTestReport(testId);
		/*ResultSet userDetails=ob.getUserDetails(userName);*/		
		
		out.println("<table id='tbl'>");
		out.println("<caption>"+testName+"</caption>");
		out.println("<thead id='headers'>");
		
		out.println("	<tr><th>Name</th><th>Marks</th></tr>");
		out.println("</thead>");
		while (rs.next()) {
			out.println("<tr>");
			out.println("<td class='name'>");
			out.println(rs.getString("USERNAME"));
			out.println("</td>");
			out.println("<td class='marks'>");
			out.println(rs.getString("MARK1"));
			out.println("</td>");			
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<input type='button' class='gbutton' onclick='getExcelFile()' value='Download Report'>");
	}

}
