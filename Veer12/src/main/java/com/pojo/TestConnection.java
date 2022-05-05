package com.pojo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
   public static void main(String[] args) throws Exception {

      
      Class.forName("com.mysql.jdbc.Driver");

      final String url = "jdbc:mysql://localhost:3306/grey_goose";
      final String user = "root";
      final String password = "Kiit@11041998";

      Connection con = DriverManager.getConnection(url, user, password);

      if (con == null) {
         System.out.println("JDBC connection is not established");
         return;
      } else
         System.out.println(" JDBC connection is established successfully.\n");

    
     con.close();
     
   }
}