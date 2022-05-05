package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import com.pojo.*;
import com.pojo.FetchDataPojo;

public class Crud {
	

	public Connection conn;
	public String url,user,pass;


	public Connection getConnection()
	{
		  conn =null;
		  url ="jdbc:mysql://localhost:3306/grey_goose";
		  user = "root";
		  pass ="AnuVeer@2611";
			
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn =DriverManager.getConnection(url,user,pass);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return conn;

		}
		
		public ArrayList<FetchDataPojo>getData()
		{
			ArrayList<FetchDataPojo> wintern_internship =new ArrayList<FetchDataPojo>();
			Integer sl_no;                             
			String business_code;                    
			Integer cust_number;                       
			String clear_date;                        
			String buisness_year;                     
			String doc_id;                            
			String posting_date;                      
			String document_create_date;              
			             
			String due_in_date;                       
			String invoice_currency;                  
			String document_type;                    
			Integer posting_id;                        
			                    
			Double total_open_amount;                 
			String baseline_create_date;              
			String cust_payment_terms;                
			Integer invoice_id;                        
			
			
			try {
			 Connection conn = getConnection();
			 String sql_query="SELECT * FROM winter_internship";
			 PreparedStatement pst = conn.prepareStatement(sql_query);
			 System.out.println(pst);
			 
			 ResultSet rs = pst.executeQuery();
			
			 while(rs.next())
			 {
					FetchDataPojo s = new FetchDataPojo();
					sl_no=rs.getInt("sl_no"); 
					business_code= rs.getString("business_code");
		             cust_number= rs.getInt("cust_number");
		           
		             clear_date = rs.getString("clear_date");
			         buisness_year = rs.getString("buisness_year");
		             doc_id = rs.getString("doc_id");
		             posting_date = rs.getString("posting_date");
			         document_create_date= rs.getString("document_create_date");
			        
			         due_in_date= rs.getString("due_in_date");
			         invoice_currency= rs.getString("invoice_currency");
			         document_type = rs.getString("document_type");
			         posting_id = rs.getInt("posting_id");
			         
			         total_open_amount = rs.getDouble("total_open_amount");
			         baseline_create_date = rs.getString("baseline_create_date");
			         cust_payment_terms = rs.getString("cust_payment_terms");
			         invoice_id = rs.getInt("invoice_id");
			         
			         
					
					//System.out.println("ID is "+id+" "+"Name is "+Name);
					s.setSl_no(sl_no);
					s.setBusiness_code(business_code);
	                s.setCust_number(cust_number);
	              
	                s.setClear_date(clear_date);
	                s.setBuisness_year(buisness_year);
	                s.setDoc_id(doc_id);
	                s.setPosting_date(posting_date);
	                s.setDocument_create_date(document_create_date);
	                
	                s.setDue_in_date(due_in_date);
	                s.setInvoice_currency(invoice_currency);
	                s.setDocument_type(document_type);
	                s.setPosting_id(posting_id);
	                
	                s.setTotal_open_amount(total_open_amount);
	                s.setBaseline_create_date(baseline_create_date);
	                s.setCust_payment_terms(cust_payment_terms);
	                s.setInvoice_id(invoice_id);
	                
	                
	                
					
	                wintern_internship.add(s);
					
					
			 }
			 
			 for(FetchDataPojo stud: wintern_internship)
			 {
				 System.out.println(stud.toString());
			 }
			 
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("exception occur");
			}
			
			return wintern_internship;
			
		
		}
		
		
		
}


