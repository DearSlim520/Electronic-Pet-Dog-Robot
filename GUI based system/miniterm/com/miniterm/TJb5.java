package com.miniterm;
import com.qjj.jdbc.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.event.ListSelectionEvent;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

 public class TJb5 extends JFrame{
  Vector rowData,columnNames;
  JTable jTable=null;
  JScrollPane jScrollPane=null;
  PreparedStatement preparedStatement=null;
  Connection connection=null;
  ResultSet resultSet=null;
  JButton back = new JButton("返回");
  
  public static final String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT%2B8&useSSL=false";  
  public static final String driver = "com.mysql.cj.jdbc.Driver";  
  public static final String user = "root";
  public static final String password = "fondndgdsbyr"; 
  
  public TJb5(int shop){
   this.setTitle("24小时订单数量分布情况统计");
   JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   columnNames=new Vector<>();
   columnNames.add("时间");
   columnNames.add("销售数量"); 
   Container c = getContentPane(); 
   c.setLayout(new BorderLayout());
   p2.add(back);
   
   rowData=new Vector<>();
   try {
    Class.forName(driver);  
    connection = DriverManager.getConnection(url, user, password);
    if(shop==0) {
    	preparedStatement=connection.prepareStatement("SELECT TIMESTAMPDIFF(hour,now(),timeOrders) AS hours,COUNT(idOrders) AS NUMofORDERS FROM ORDERS WHERE TIMESTAMPDIFF(hour,now(),timeOrders) >=-24 group by hours;");
    }
    //商家
    else {
    	preparedStatement=connection.prepareStatement("SELECT TIMESTAMPDIFF(hour,now(),timeOrders) AS hours,COUNT(idOrders) AS NUMofORDERS FROM ORDERS WHERE TIMESTAMPDIFF(hour,now(),timeOrders) >=-24 AND ITEM_SHOP_idShop ="+shop+" group by hours;");
    }
    
   
    resultSet=preparedStatement.executeQuery();
    while (resultSet.next()) {
     Vector hang=new Vector<>();
     hang.add(resultSet.getInt(1));
     hang.add(resultSet.getInt(2));
     rowData.add(hang);
    }
   } catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();
   }finally {
    //关闭流
    try {
     if (resultSet!=null) {
      resultSet.close();
     }
     if (preparedStatement!=null) {
      preparedStatement.close();
     }
     if (connection!=null) {
      connection.close();
     }
    } catch (Exception e2) {
     // TODO: handle exception
     e2.printStackTrace();
    }
    if (resultSet!=null) {
     
    }
   }
  
   jTable=new JTable(rowData, columnNames);
   jScrollPane=new JScrollPane(jTable);
   c.add(jScrollPane,BorderLayout.CENTER);
   c.add(p2,BorderLayout.SOUTH);
   this.setBounds(520,233,350, 300);
   this.setVisible(true);
   back.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
   
  }
 
 // public static void main(String[] args) {
  // TJb3 demo2=new TJb3();}
  
 }