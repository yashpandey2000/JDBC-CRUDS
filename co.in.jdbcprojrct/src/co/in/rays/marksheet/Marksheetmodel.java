package co.in.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Marksheetmodel {

	public void add(Marksheet bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");

		ps.setInt(1, bean.getId());
		ps.setInt(2, bean.getRoll_no());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhy());
		ps.setInt(6, bean.getChem());
		ps.setInt(7, bean.getMat());

		ps.executeUpdate();

		conn.commit();

		System.out.println("inserted");

		ps.close();
		conn.close();

	}

	public void update(Marksheet bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("update marksheet set roll_no=?,fname=?,lname=?,phy=?,chem=?,mat=? where id = ?");

		ps.setInt(1, bean.getRoll_no());
		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());
		ps.setInt(4, bean.getPhy());
		ps.setInt(5, bean.getChem());
		ps.setInt(6, bean.getMat());
		ps.setInt(7, bean.getId());

		ps.executeUpdate();

		conn.commit();

		System.out.println("updated");
		
		conn.close();
		ps.close();

	}

	public void delete(Marksheet bean) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id =?");

		ps.setInt(1, bean.getId());

		ps.executeUpdate();

		conn.commit();

		System.out.println("deleted");

		ps.close();
		conn.close();

	}

	public void get(Marksheet bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("select * from marksheet where roll_no=?");

		ps.setInt(1, bean.getRoll_no());

		ResultSet rs = ps.executeQuery();

		System.out.println("id" + "\t" + "roll_no" + "\t" + "fname" + "\t" + "lname" + "\t" + "phy" + "\t" + "chem"
				+ "\t" + "mat");

		while (rs.next()) {

			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getString(6));
			System.out.println("\t" + rs.getString(7));

		}

		conn.commit();

		ps.close();
		conn.close();

	}

	public void getmeritlist(Marksheet bean) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement(
				"select *,(phy+chem+mat) as total,((phy+chem+mat)/3)as percentage from marksheet order by percentage desc limit 0,10");

		ResultSet rs = ps.executeQuery();

		System.out.println("id" + "\t" + "roll_no" + "\t" + "fname" + "\t" + "lname" + "\t" + "phy" + "\t" + "chem"
				+ "\t" + "mat" + "\t" + "total" + "\t" + "percentage(%)");
		while (rs.next()) {

			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getString(6));
			System.out.print("\t" + rs.getString(7));
			System.out.print("\t" + rs.getString(8));
			System.out.println("\t" + rs.getString(9) +"%");

		}

		conn.commit();

		conn.close();
		ps.close();
	}

	public void search(Marksheet bean) throws SQLException, ClassNotFoundException {

		ResourceBundle rb = ResourceBundle.getBundle("co.in.rays.rb.app");
		
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("select * from marksheet");

		ResultSet rs = ps.executeQuery();

		System.out.println("id" + "\t" + "roll_no" + "\t" + "fname" + "\t" + "lname" + "\t" + "phy" + "\t" + "chem"
				+ "\t" + "mat");
		while (rs.next()) {

			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getString(6));
			System.out.println("\t" + rs.getString(7));

		}

		conn.commit();

		conn.close();
		ps.close();

	}

}
