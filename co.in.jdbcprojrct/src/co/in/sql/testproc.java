package co.in.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class testproc {

	public static void main(String[] args) throws Exception   {
		// TODO Auto-generated method stub

		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
		
		CallableStatement cs = conn.prepareCall("{Call empcount(?)}");
		
		cs.registerOutParameter(1,Types.INTEGER);
		
		cs.execute();
		
		int i = cs.getInt(1);
		
		
		
		System.out.println("employee count:"+i);
		
	}

}
