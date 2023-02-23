package com.Rajbir.LearnAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class AssignmnetQuestion2 {
	public static void main(String args[]) throws SQLException {
		
	
	Connection connection;
	ResultSet resultSet;
	
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeerecord","root","password");
	System.out.println("Connection set");
	String queryForSelectMaxandMinSalary="Select  max(salary), min(Salary)from employee" ;
	Statement statement=connection.createStatement();
	resultSet=statement.executeQuery(queryForSelectMaxandMinSalary);

	while(resultSet.next()) {
		String maxSalary=resultSet.getString("max(salary)");
		String minSalary=resultSet.getString("min(Salary)");
		System.out.println(maxSalary);
		System.out.println(minSalary);
	}
	String queryToReturnSecondHighestSalary="SELECT MAX(SALARY) FROM Employee WHERE SALARY < (SELECT MAX(SALARY) FROM Employee)";
	Statement statement2=connection.createStatement();
			resultSet=statement2.executeQuery(queryToReturnSecondHighestSalary);
	while(resultSet.next()) {
		String secondHighestSalary=resultSet.getString("MAX(SALARY)");
		
		System.out.println(secondHighestSalary);
		
	}
	connection.close();
	

}
}