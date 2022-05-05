package com.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteFunction")
public class DeleteFunction extends HttpServlet {
  private static final long serialVersionUID = 1L;
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/grey_goose?zeroDateTimeBehavior=convertToNull";
	private static final String USER = "root";
	private static final String PASSWORD = "Kiit@11041998";

    public DeleteFunction() {
        super();
        // TODO Auto-generated constructor stub
    }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    
    try {
      HashMap<Object, Object> Response = new HashMap<Object, Object>();
      String sl_no = request.getParameter("sl_no");
//      System.out.println(sl_no);
      Class.forName(JDBC_DRIVER);
      Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
      String query = "delete from winter_internship where sl_no in (" + sl_no + ")";
//      System.out.println(query);
      PreparedStatement ps = con.prepareStatement(query);
//      ps.setString(1, sl_no);
      
      if (ps.executeUpdate() > 0) {
      Response.put("update", true);
      } else {
      Response.put("update", false);
      }
      Gson gson = new Gson();
      response.setHeader("Access-Control-Allow-Origin", "*");
      String Responsejson = gson.toJson(Response);
      response.getWriter().append(Responsejson);
      } catch (Exception e) {
      e.printStackTrace();
      }
      }

    
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}