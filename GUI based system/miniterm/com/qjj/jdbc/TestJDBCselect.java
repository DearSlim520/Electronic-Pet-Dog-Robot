package com.qjj.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DatabaseMetaData; 
import java.sql.ResultSet;  
import java.sql.SQLException; 

public class TestJDBCselect {
	private Connection conn;
    private Statement stat;
    
    public void showData(String sql) throws Exception
    {
     conn = testconnction.getConnection();
     stat = testconnction.getStatement(conn);
     ResultSet ret = null;

        try {
            ret = stat.executeQuery(sql);//执行语句，得到结果集  
            String pass = ret.getString(1);
        	
            while (ret.next()) { 
                String bnum = ret.getString(1);  
                String bstreet = ret.getString(2);  
                String bcity = ret.getString(3);  
                String bcode = ret.getString(4); 
                System.out.println(bnum + "\t" + bstreet + "\t" + bcity + "\t" + bcode);
            }//显示数据  	
            
            ret.close(); 
            stat.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }
    
 public static void main(String[] args) throws Exception
 {
  TestJDBCselect test = new TestJDBCselect();
  String sql = null; 
  sql = "SELECT password FROM mydb.Shop WHERE idShop=";//SQL语句 
  test.showData(sql);
 }
  
}