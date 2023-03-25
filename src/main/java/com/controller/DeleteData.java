package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;

@WebServlet("/DeleteStudent")
public class DeleteData extends HttpServlet {
	StudentDAO delete;
	ServletContext config;

	public void init(ServletConfig config) {
		delete = new StudentDAO();
		this.config = config.getServletContext();
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int roll = Integer.parseInt(request.getParameter("roll"));
		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");

		int i = delete.deleteStudent(roll, url, username, password);

		if (i == 1) {
			out.print("SUCESS !!! ");
			response.sendRedirect("jsp/Disply.jsp");
		} else
			out.print("NOT Update  STUDENt");

	}

}
