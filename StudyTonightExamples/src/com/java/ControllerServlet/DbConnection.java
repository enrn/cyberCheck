package com.java.ControllerServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private String url="jdbc:mysql:/ /localhost:3306/cyberSolve";
	private String username = "root";
	private String password= "*1Narayan1*";
	
	public Connection dbConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			return con;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
