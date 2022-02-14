package co.in.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testsql {
	

	public static void main(String[] args) throws Exception {
		
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet","root","root");
	
	Statement stmt =  conn.createStatement();
	
	ResultSet rs = stmt.executeQuery("select * from student");
	
	System.out.println("id"+"\t"+"roll_no"+"\t"+"fname"+"\t"+"lname");
	
	while(rs.next()) {
	System.out.print(rs.getString(1));
	System.out.print("\t"+rs.getString(2));
	System.out.print("\t"+rs.getString(3));
	System.out.println("\t"+rs.getString(4));
	
	
	

	}
  stmt.close();
	conn.close();

}

}
