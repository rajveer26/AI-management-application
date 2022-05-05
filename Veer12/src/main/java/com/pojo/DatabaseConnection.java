package com.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DatabaseConnection {
	public static void main(String args[]) {  
		
	try{  
	
		final String url="jdbc:mysql://localhost:3306/grey_goose"; 

	 Connection con=DriverManager.getConnection(  

	url,"root","AnuVeer@1803");  
 
	Statement stmt=con.createStatement();  

	ResultSet rs=stmt.executeQuery("SELECT sl_no,\r\n" + 
			"wi.business_code, \r\n" + 
			"business_name, \r\n" + 
			"wi.cust_number, \r\n" + 
			"name_customer,\r\n" + 
			"clear_date, \r\n" + 
			"buisness_year, \r\n" + 
			"doc_id, \r\n" + 
			"posting_date, \r\n" + 
			"document_create_date, \r\n" + 
			"document_create_date1, \r\n" + 
			"due_in_date,\r\n" + 
			"invoice_currency, \r\n" + 
			"document_type, \r\n" + 
			"posting_id, \r\n" + 
			"area_business, \r\n" + 
			"total_open_amount, \r\n" + 
			"baseline_create_date, \r\n" + 
			"cust_payment_terms, \r\n" + 
			"invoice_id,\r\n" + 
			"isOpen, \r\n" + 
			"aging_bucket, \r\n" + 
			"is_deleted, \r\n" + 
			"predicted \r\n" + 
			"FROM winter_internship wi \r\n" + 
			"INNER JOIN business \r\n" + 
			"INNER JOIN customer \r\n" + 
			"ON wi.business_code=business.business_code AND wi.cust_number=customer.cust_number ;");  

	while(rs.next())  

	System.out.println(rs.getInt(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"    "+rs.getInt(4)+"    "+rs.getString(5)+"     "+rs.getString(6)+"     "+rs.getInt(7)+"     "+rs.getLong(8)+"     "+rs.getDate(9)+"     "+rs.getDate(10)+"     "+rs.getDate(11)+"     "+rs.getDate(12)+"     "+rs.getString(13)+"     "+rs.getString(14)+"     "+rs.getInt(15)+"     "+rs.getString(16)+"     "+rs.getDouble(17)+"     "+rs.getDate(18)+"     "+rs.getString(19)+"     "+rs.getInt(20)+"      "+rs.getInt(21)+"      "+rs.getString(22)+"      "+rs.getInt(23)+"      "+rs.getString(24));  
	con.close();  
	}
	catch(Exception e)
	{ System.out.println(e);
	}  

	}  
}