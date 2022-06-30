package com.training.utils;
import java.sql.*;
import java.util.ResourceBundle;

import com.javatraining.model.BookService;


public class ConnectionFactory {
	


	public static Connection getpostgresConnection() {
		 
		Connection con=null;
		ResourceBundle lables=ResourceBundle.getBundle("application");
		try
		{
			String url=lables.getString("datasourse.postgres.url");
			String username=lables.getString("datasourse.postgres.username");
			String password=lables.getString("datasourse.postgres.password");
			
			String driverClass=lables.getString("datasourse.postgres.driverclass");
			
			Class.forName(driverClass);
			BookService service=new BookService(con);
			
			
			
			
			con=DriverManager.getConnection(url,username,password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
