package com.web.testDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDb() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//set variables for connection
		String user="mp";
		String pass="mp";
		
		String driver="com.mysql.jdbc.Driver";
		
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		
		
		
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(jdbcUrl, user, pass);
			PrintWriter out=response.getWriter();
			out.println("Connection Successful");
			conn.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
