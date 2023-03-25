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

@WebServlet("/updateStudent")
public class UpdateData extends HttpServlet {
	StudentDAO dao;
	ServletContext config;
	public void init(ServletConfig config) throws ServletException{
		dao=new StudentDAO();
		this.config=config.getServletContext();
	}
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int roll = Integer.parseInt(request.getParameter("roll"));
		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");

		Student student=dao.getStudentById(roll,url,username,password);
		request.setAttribute("stud", student);
		
		request.getRequestDispatcher("jsp/Update.jsp").forward(request, response);
		

		
		int i=dao.updateStudent(student,url,username,password);
		
	}

}
