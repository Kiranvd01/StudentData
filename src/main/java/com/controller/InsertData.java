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
import com.modal.Student;

@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	StudentDAO dao;
	ServletContext config;

	public void init(ServletConfig config) throws ServletException {
		dao = new StudentDAO();
		this.config=config.getServletContext();
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int roll = Integer.parseInt(request.getParameter("roll"));

		String name = request.getParameter("uname");
		int marks = Integer.parseInt(request.getParameter("marks"));

		Student student = new Student(roll, name, marks);
		
		String url=config.getInitParameter("url");
		String username=config.getInitParameter("username");
		String password=config.getInitParameter("password");

		int i = dao.insertStudent(student,url,username,password);

		if (i == 1) {
			out.print("SUCESS !!! ");
			//request.getRequestDispatcher("StudentDisply").forward(request, response);
			response.sendRedirect("jsp/Disply.jsp");
		} else
			out.print("NOT INSERT  STUDENt");

	}

}
