package com.servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.compiler.CompileCode;
import com.compiler.FileCreator;
import com.dao.DAO;

/**
 * Servlet implementation class Compiler
 */
@WebServlet("/Compiler")
public class Compiler extends HttpServlet {	
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
		System.out.println("Compiler caller");
		PrintWriter out = response.getWriter();
		DAO obj = new DAO();
		CompileCode ccob = new CompileCode();
		FileCreator ob = new FileCreator();
		float marks = 0;
		int total_score = 0;
		int actual_score = 0;
		float score;
		String op = null;
		String inputFile = "D:\\workspace\\LPET\\javacompilerfiles\\input.txt";
		FileWriter fw = new FileWriter(inputFile);
		String button_name = request.getParameter("btn");
		String username = request.getParameter("username");
		String testId = request.getParameter("testId");
		String questionId = request.getParameter("questionId");
		String ip = request.getParameter("userip");
		String filename = request.getParameter("filename");
		String code = request.getParameter("sourcecode");
		String filePath = ob.createMyFile(filename, code);
		String output = ccob.compileCode(filePath);
		System.out.println("*********source***********");
		System.out.println(code);
		if (request.getParameter("finish") != null) {
			marks = obj.getStudentMarks(testId, username);
			String status = null;
			if (marks >= 50)
				status = "PASS";
			else
				status = "FAIL";
			request.setAttribute("marks", marks);
			request.setAttribute("status", status);
			RequestDispatcher rd = request.getRequestDispatcher("/studentresult.jsp");
			rd.include(request, response);
		} else {
			if (ip.equals("null"))
				ip = obj.getSampleInput(questionId);
			op = obj.getSampleOutput(questionId);			
			if (button_name.equals("submitbutton")) {
				if (output.equals("")) {					
					int count = 0;
					String expectedop = null;
					String actualop = null;
					String input;
					ArrayList inputs = obj.getInputs(questionId);
					ArrayList outputs = obj.getOutputs(questionId);				
					ArrayList<Integer> points = obj.getPoints(questionId);
					for (Integer i : points)
						total_score += i;

					for (int i = 0; i < 4; i++) {
						fw = new FileWriter(inputFile);
						input = (String) inputs.get(i);
						expectedop = (String) outputs.get(i);						
						fw.write(input);
						fw.close();
						actualop = ccob.runCode(filename, input);
						if (actualop.trim().equals(expectedop)) {
							actual_score += points.get(i);
							count++;
						}
					}
					score = ((float) actual_score / total_score) * 100;
					

					if (obj.saveScore(testId, username, questionId, score)) {
						out.println(count + " Test Cases Passed out of 4 Test Cases");
					}
				} else
					out.println(output);

			}
		}
		if (button_name.equals("compile_run")) {

			if (output.equals("")) {
				fw.write(ip);
				fw.close();
				output = ccob.runCode(filename, ip);
			}
			output = output.replace("D:\\workspace\\LPET\\javacompilerfiles\\", "");
			out.println(output);
		}

	}

}
