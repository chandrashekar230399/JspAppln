package com.chandu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet{
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("uname");
		String email = request.getParameter("email");
		String password = request.getParameter("pswd");
		String Gender = request.getParameter("gender");
		String City = request.getParameter("city");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","marolix@2023");
			
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
			
			//PreparedStatement ps = con.prepareStatement("delete from register where name=?");
			
			//PreparedStatement ps = con.prepareStatement("update register set city=? where username=?");
			ps.setString(1,username);
			ps.setString(2,email);
			ps.setString(3, password);
			ps.setString(4,Gender);
			ps.setString(5, City);
			
			int count=ps.executeUpdate();
			
//			ps.setString(1, username);
//			
//			int count=ps.executeUpdate();
//			out.print(count+"delete sucessfully");
			
			
			
//			ps.setString(1, City);
//			ps.setString(2, username);
//			int count=ps.executeUpdate();
//			out.print(count+"Updated data sucessfully");
			
			if(count>0) {
				response.setContentType("text/html");
				out.print("<h3 style='color:green' >User register sucessfully</h3>");
				
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
			}
			else {
				response.setContentType("text/html");
				out.print("<h3 style='color:red'>registration failed</h3>");
				
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
			}
			
			con.close();
		}
		catch (Exception e) {
			
			out.print(e);
			
			response.setContentType("text/html");
			out.print("<h3 style='color:red'>Exception Occured:"+e.getMessage()+"</h3>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			rd.include(request, response);
			
			
		}
	}
	

}
