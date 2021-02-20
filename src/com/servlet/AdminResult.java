package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.jfxmediaimpl.MediaDisposer.ResourceDisposer;

@WebServlet("/AdminResult")
public class AdminResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		if (request.getParameter("individual") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/individualresult.jsp");
			rd.forward(request, response);

		} else if (request.getParameter("batch") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/batchresult.jsp");
			rd.forward(request, response);
		}
	}

}
