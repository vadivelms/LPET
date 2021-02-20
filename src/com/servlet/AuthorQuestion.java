package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.QuestionBean;
import com.dao.DAO;

/**
 * Servlet implementation class AuthorQuestion
 */
@WebServlet("/AuthorQuestion")
public class AuthorQuestion extends HttpServlet {

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
		QuestionBean qbobj = new QuestionBean();
		DAO obj = new DAO();
		String title = request.getParameter("title");
		String domine = request.getParameter("domine");
		String description = request.getParameter("description");
		String constraints = request.getParameter("constraints");
		String input_format = request.getParameter("input_format");
		String output_format = request.getParameter("output_format");
		String sample_input = request.getParameter("sample_input");
		String sample_output = request.getParameter("sample_output");
		int tc1p = Integer.parseInt(request.getParameter("ip1p"));
		String input1 = request.getParameter("inp1");
		String output1 = request.getParameter("op1");
		int tc2p = Integer.parseInt(request.getParameter("ip2p"));
		String input2 = request.getParameter("inp2");
		String output2 = request.getParameter("op2");
		int tc3p = Integer.parseInt(request.getParameter("ip3p"));
		String input3 = request.getParameter("inp3");
		String output3 = request.getParameter("op3");
		int tc4p = Integer.parseInt(request.getParameter("ip4p"));
		String input4 = request.getParameter("inp4");
		String output4 = request.getParameter("op4");
		String imports = request.getParameter("imports");
		String main = request.getParameter("main");
		String method = request.getParameter("method");

		qbobj.setTitle(title);
		qbobj.setDomine(domine);
		qbobj.setDescription(description);
		qbobj.setConstraints(constraints);
		qbobj.setInput_format(input_format);
		qbobj.setOutput_format(output_format);
		qbobj.setSample_input(sample_input);
		qbobj.setSample_output(sample_output);
		qbobj.setTc1p(tc1p);
		qbobj.setInput1(input1);
		qbobj.setOutput1(output1);
		qbobj.setTc2p(tc2p);
		qbobj.setInput2(input2);
		qbobj.setOutput2(output2);
		qbobj.setTc3p(tc3p);
		qbobj.setInput3(input3);
		qbobj.setOutput3(output3);
		qbobj.setTc4p(tc4p);
		qbobj.setInput4(input4);
		qbobj.setOutput4(output4);
		qbobj.setImports(imports);
		qbobj.setMain(main);
		qbobj.setMethod(method);		
		if (obj.addquestions(qbobj)) {
			request.setAttribute("message", "Your Question Has been Added Successfully....");
			request.setAttribute("title", "Add Question Success");
			RequestDispatcher rd = request.getRequestDispatcher("/response.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("message", " Add Question  Failed....");
			request.setAttribute("title", "Add Question Failed");
			RequestDispatcher rd = request.getRequestDispatcher("/response.jsp");
		}

	}
}
