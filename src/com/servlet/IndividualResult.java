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
 * Servlet implementation class IndividualResult
 */
@WebServlet("/IndividualResult")
public class IndividualResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doCommon(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		ResultSet rs = ob.getAllTests();
		
		String username=request.getParameter("username");		
		out.println("<table id='tbl'>");
		out.println("<caption>");
		out.println(username);
		out.println("</caption>");
		out.println("	<tr><th>Test Name</th><th>Marks</th></tr>");
		while (rs.next()) {
			out.println("<tr>");
			out.println("<td class='testname'>");
			out.println("<lable class='names'>" + rs.getString("TEST_NAME"));
			out.println("</td>");
			out.println("<td class='testname'>");
			out.println(ob.getStudentMarks( rs.getString("TEST_ID"), username));
			out.println("</td>");			
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<input type='button' class='gbutton' onclick='getExcelFile()' value='Download Report'>");
	}

}
