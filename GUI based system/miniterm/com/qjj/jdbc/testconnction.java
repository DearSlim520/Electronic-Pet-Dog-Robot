package com.qjj.jdbc;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.Statement;

public class testconnction {
  public static final String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT%2B8&useSSL=false";  
  public static final String driver = "com.mysql.cj.jdbc.Driver";  
  public static final String user = "root";  
  public static final String password = "fondndgdsbyr";  
   
  public static Connection getConnection() {
   Connection conn = null;  
   try {  
       Class.forName(driver);//指定连接类型  
             conn = DriverManager.getConnection(url, user, password);//获取连接  
         } catch (Exception e) {  
             e.printStackTrace();  
         }
   return conn ;
     }  
  public static Statement getStatement(Connection conn){
   try {
    return conn.createStatement();
   }catch (Exception e) {  
       e.printStackTrace();
       return null ;
   }
  }

}

