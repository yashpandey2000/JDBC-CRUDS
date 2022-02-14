package co.in.rays.marksheet;

import java.util.Locale;
import java.util.ResourceBundle;

public class testrb {
	
	public static void main(String[] args) {
		
	//	ResourceBundle rs = ResourceBundle.getBundle("co.in.rays.rb.app"); // resource bundle
		
	ResourceBundle rs = ResourceBundle.getBundle("co.in.rays.rb.app",new Locale("hi")); // for differennt language
	
	
	System.out.println(rs.getString("greeting"));
	}
}
