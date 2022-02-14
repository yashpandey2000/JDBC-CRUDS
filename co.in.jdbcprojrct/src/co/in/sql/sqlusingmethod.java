package co.in.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlusingmethod {
	public static void main(String[] args) throws Exception {
		
        testSelect();
		//testAdd();
		//testUpdate();
		//testdelete();
		
		
	}

	public static void testdelete() throws Exception {
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
		
		Statement stn = conn.createStatement();	

		int i = stn.executeUpdate("delete from employee where id=5");
		
		System.out.println(i+"deleted");
		
		stn.close();
		conn.close();
		
	}

	public static void testUpdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
		
		Statement stn = conn.createStatement();	

		int i = stn.executeUpdate("update employee set fname='kishore',lname='kumar',salary=15000,dep_id=2 where id =6");
		
		System.out.println(i+"updated");
		
		stn.close();
		conn.close();
		
	}

	public static void testSelect() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
		
		Statement stn = conn.createStatement();
		
		ResultSet rs  = stn.executeQuery("select * from employee");
		
		System.out.println("id"+"\t"+"fname"+"\t"+"lname"+"\t"+"salary"+"\t"+"dep_id");
		while(rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.println("\t"+rs.getString(5));
			
			
		}
		stn.close();
		conn.close();
	}

	public static void testAdd() throws Exception {
		
			
			Class.forName("com.mysql.jdbc.Driver");
		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			
			Statement stn = conn.createStatement();	
			
			int id=1;
			String fname="yash";
			String lname="pandey";  //all this attribute given here for make it dynamic
			int salary=80000;
			int dep_id=1;
			
			
			int i = stn.executeUpdate("insert into employee values("+id+",'"+fname+"','"+lname+"',"+salary+","+dep_id+")"); //to make dynamic we use this syntax
	
			//int i = stn.executeUpdate("insert into employee values(6,'divyansh','kumar',12000,3)");  //to make static this syntax is used
			
			System.out.println(i+"created");
			
			stn.close();
			conn.close();
		
}
	
	
	
	
	

}
