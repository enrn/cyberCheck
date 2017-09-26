package com.java.ControllerServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/Validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Validation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean s=false;
	
		out.println(username+password);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cyberSolve","root","*1Narayan1*");
			PreparedStatement psc =con.prepareStatement("select * from users where username=? and password=?");
			psc.setString(1, username);
			psc.setString(2, password);
			
			ResultSet rs= psc.executeQuery();
			out.println(rs.next());
			s=rs.next();
			if(s=true){
				RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
				rd.forward(request, response);
			}else{
				out.println("Incorrect username or password");
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		doGet(request, response);
	}

}
