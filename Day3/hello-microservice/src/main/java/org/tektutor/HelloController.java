package org.tektutor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.sql.*;

@RestController
public class HelloController {

	public String readGreetingMsgFromDB() {
		//String url = "jdbc:mysql://localhost:3306/tektutor";
		String url = System.getenv("JDBC_URL");
		String username = System.getenv("USERNAME");
		String password = System.getenv("PASSWORD");

		String query = "select * from greeting";

		String msg = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			Statement statement   = connection.createStatement();
			ResultSet resultSet   = statement.executeQuery(query);
			resultSet.next();

			msg = resultSet.getString("message");

			statement.close();
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return msg; 
	}

	@RequestMapping("/")
	public String sayHello() {
		return readGreetingMsgFromDB();
	}
}
