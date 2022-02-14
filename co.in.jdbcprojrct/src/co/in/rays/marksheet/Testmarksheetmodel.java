package co.in.rays.marksheet;

import java.sql.SQLException;

public class Testmarksheetmodel {

	public static void main(String[] args) throws Exception, SQLException {
	
		
		//testsearchmarksheet();
		//	testgetmeritlist();
	//	testgetrollno();
//testdelete();
 // testupdate();
	//	testadd();

		
	}

	private static void testsearchmarksheet() throws ClassNotFoundException, SQLException {
	
		Marksheet mm = new Marksheet();
		
		Marksheetmodel ms= new Marksheetmodel();
		
		ms.search(mm);
		
	}
	
	

	private static void testgetmeritlist() throws ClassNotFoundException, SQLException {
		Marksheet mm = new Marksheet();
		
		
		Marksheetmodel ms= new Marksheetmodel();
		
		ms.getmeritlist(mm);
		
		
	}

	private static void testgetrollno() throws ClassNotFoundException, SQLException {
		
		Marksheet ms = new Marksheet();
		
		ms.setRoll_no(115);
		
		Marksheetmodel mm = new Marksheetmodel();
		
		mm.get(ms);
	}

	private static void testdelete() throws Exception {
		Marksheet bean = new Marksheet();
		
		bean.setId(1);
		
		Marksheetmodel mm = new Marksheetmodel();
		
		mm.delete(bean);
		
	}

	private static void testupdate() throws ClassNotFoundException, SQLException {
		
		Marksheet ms = new Marksheet();
		
		ms.setId(14);
		ms.setRoll_no(114);
		ms.setFname("ritik");
		ms.setLname("panchal");
		ms.setPhy(60);
		ms.setChem(80);
		ms.setMat(67);
	
		
		Marksheetmodel mm = new Marksheetmodel();
		
		mm.update(ms);
		
	}

	private static void testadd() throws ClassNotFoundException, SQLException {
	
		Marksheet bean = new Marksheet();
		
		bean.setId(15);
		bean.setRoll_no(115);
		bean.setFname("jay");
		bean.setLname("kalal");
		bean.setPhy(78);
		bean.setChem(80);
		bean.setMat(66);
		
		
		Marksheetmodel model = new Marksheetmodel();
		
		model.add(bean);
		
	}
	
	
	
	

}
