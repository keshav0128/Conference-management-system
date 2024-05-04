package com.abhiyantrikitech.repository;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionBean {
	
	//Connection conn = null;
	

	//  Local
	String driver = "com.mysql.jdbc.Driver"; //Local
	String url="jdbc:mysql://localhost:3306/conference";
	String username = "admin";
	String password = "Ayt@2019";
	
	
	
	
	
	//AWS
	/*
	String driver = "com.mysql.cj.jdbc.Driver";
	String url ="jdbc:mysql://10.0.0.53:3306/azadi?useSSL=false";
	String username = "azadi";
	String password = "7B*}~]^mBQ3^B[t";
	*/
	
	//NISM UAT 
	
	/*String driver = "com.mysql.jdbc.Driver"; //Local
	String url="jdbc:mysql://localhost:3306/nism-kotak";
	String username = "root";
	String password = "5_YhCcfD%Elk";*/
	
	   public Connection getConnectionObj() {
	   
		   Connection conn = null; 
	   try{
	      
		   Class.forName(driver);		        
		   conn = DriverManager.getConnection(url,username,password);
		   
		   /*DataSource dataSource=HikariCPConnectionBean.getDataSource();
		   conn=dataSource.getConnection();
		   */
	       System.out.println("Connected");

	      
	   }catch(Exception e){
	      //Handle errors for Class.forName
		   System.out.println("exception in connection- "+e);
		   try{
		   conn.close();
		   }catch(SQLException se){
			   
		   }
		  System.out.println("Goodbye!connection closed.");
	      e.printStackTrace();   
	   }
	   //System.out.println("Connection ready..");
	   return conn;
	}//end main
	
	
}

