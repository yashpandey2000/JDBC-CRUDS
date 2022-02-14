package co.in.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class preparedstatement {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//testadd();
		//testupdate();
		//testdelete();
		
		testselect();
		
		
		
	}
	private static void testselect() throws ClassNotFoundException, SQLException {

		
Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
						
PreparedStatement ps = conn.prepareStatement("select * from employee");

ResultSet rs = ps.executeQuery();

while(rs.next()) {
	
	System.out.println(rs.getString(1));
	System.out.println(rs.getString(2));
	System.out.println(rs.getString(3));
	System.out.println(rs.getString(4));
	System.out.println(rs.getString(5));
	
}
	conn.close();
	rs.close();
}

		
		
	private static void testdelete() throws SQLException, ClassNotFoundException {
	
		
Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
		
		int id = 12;
		
		PreparedStatement ps = conn.prepareStatement("delete from employee where id = ?");
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
		System.out.println("deleted");
		
		ps.close();
		conn.close();
		
		
	}
	private static void testupdate() throws Exception {

		
Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
		
		int id =12;
		String fn="hitesh";
		String ln="mehta";
		int salary=19000;
		int dep_id=3;
				
PreparedStatement ps = conn.prepareStatement("update employee set fname=? , lname=? , salary=? , dep_id =? where id =?");

ps.setString(1, fn);
ps.setString(2, ln);
ps.setInt(3,salary);
ps.setInt(4, dep_id);
ps.setInt(5, id);

ps.executeUpdate();
System.out.println("updated");
ps.close();
conn.close();
	}
	public static void testadd() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
		
		int id =1;
		String fn="heena";
		String ln="khan";
		int salary=13000;
		int dep_id=2;
				
PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?,?)");

ps.setInt(1, id);
ps.setString(2, fn);
ps.setString(3, ln);
ps.setInt(4, salary);
ps.setInt(5, dep_id);

ps.executeUpdate();

System.out.println("inserted");

ps.close();
conn.close();
		
		
	}
	

}
