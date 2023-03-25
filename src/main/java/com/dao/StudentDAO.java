package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.modal.Student;
import com.util.DBUtility;
public class StudentDAO{
	DBUtility utility;
	public StudentDAO(){
		utility=new DBUtility();
	}
	public int insertStudent(Student student,String url,String username,String password) {

		Connection con = utility.getConnection(url,username,password);
		String sql = "insert into student2 values(?,?,?)";
		int res = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getMarks());

			res = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}if (res > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	public int deleteStudent(int roll,String url,String username,String password) {

		Connection con = utility.getConnection(url,username,password);
		String sql = "delete from student2  where roll=?";
		int res = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, roll);
			

			res = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}if (res > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public List<Student> getAllStudent(String url,String username,String password)
	{
	
			
		Connection con = utility.getConnection(url,username,password);
		String sql="select * from student2 order by roll";
		List<Student>list=new ArrayList<Student>();
		try {
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Student s1=new Student();
			s1.setRoll(rs.getInt(1));
			s1.setName(rs.getString(2));
			s1.setMarks(rs.getInt(3));
			list.add(s1);
		}
		}																														
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	
	public int updateStudent(Student student,String url,String username,String password) {

		Connection con = utility.getConnection(url,username,password);
		String sql = "update student2 set name=?,marks=? where roll=?";
		int res = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(3, student.getRoll());
			ps.setString(1, student.getName());
			ps.setInt(2, student.getMarks());

			res = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}if (res > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	
	public Student getStudentById(int id, String url, String username, String password) {

		Connection con =utility.getConnection(url, username, password);
		String sql = "SELECT * FROM STUDENT2 where roll=?";
		Student s1 = new Student();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s1.setRoll(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setMarks(rs.getInt(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return s1;
	}


}

		
