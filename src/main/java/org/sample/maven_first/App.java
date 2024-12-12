package org.sample.maven_first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws SQLException  {
       String dburl = "jdbc:mysql://localhost:3306/classicmodels";
       String user = "root";
       String password = "Dragon29";
       System.out.println("----MySQL JDBC Connection----");
    	
    	try { 
//    		creates a connection to MySQL on local machine with db credentials
    		Connection connection = DriverManager.getConnection(dburl, user, password);
    		String SelectSQL = "Select * FROM employees";
    		Statement stmt = connection.createStatement();
    		ResultSet result = stmt.executeQuery(SelectSQL);
    		while(result.next()) {
    			String EmployeeID = result.getString("employeeNumber");
    			String fname = result.getString("firstName");
    			String lname = result.getString("lastName");
    			System.out.println(EmployeeID + " | " + fname + " | " + lname);
    		}
    		connection.close();
    	} catch (SQLException e) {
    		
    		e.printStackTrace();  	}
    	
    		
    	
    }
}
