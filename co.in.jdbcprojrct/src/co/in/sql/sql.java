package co.in.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class sql {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
		
		Statement stm = conn.createStatement();
		
	 int i = stm.executeUpdate("insert into student values(13,121,'laksh','purohit',12,18,28)");
		
	
		
	System.out.println("created");
	
	stm.close();
	conn.close();

	}


}
