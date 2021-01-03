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

 public class testttttttttt extends JFrame{
  Vector rowData,columnNames;
  JTable jTable=null;
  JScrollPane jScrollPane=null;
  PreparedStatement preparedStatement=null;
  Connection connection=null;
  ResultSet resultSet=null;
  JLabel label2 = new JLabel("起始时间");
  JLabel label3 = new JLabel("截至时间");
  JButton back = new JButton("返回");
  JButton va = new JButton("确定");
  JTextField text1 = new JTextField();
  JTextField text2 = new JTextField();
  public static final String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT%2B8&useSSL=false";  
  public static final String driver = "com.mysql.cj.jdbc.Driver";  
  public static final String user = "root";
  public static final String password = "fondndgdsbyr"; 
  
  public testttttttttt(){
   this.setTitle("某时段下单成功的前十用户");
   JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   columnNames=new Vector<>();
   columnNames.add("商家id");
   columnNames.add("销售数量");
   text1.setColumns(8);
   text2.setColumns(8);   
   Container c = getContentPane(); 
   c.setLayout(new BorderLayout());
   p1.add(label2);
   p1.add(text1);
   p1.add(label3);
   p1.add(text2);
   p1.add(va);
   p2.add(back);
   //时间要通过TJ传过来
   String time1 = text1.getText();
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime dateTime1 = LocalDateTime.parse(time1, formatter);
   String time2 = text2.getText();
	LocalDateTime dateTime2 = LocalDateTime.parse(time2, formatter);
   rowData=new Vector<>();
   try {
    Class.forName(driver);  
             connection = DriverManager.getConnection(url, user, password);
    preparedStatement=connection.prepareStatement("SELECT u.idUser, SUM(i.priceItem * o.numOrders) AS Total FROM ORDERS o, ITEM i, USER u WHERE i.idItem = o.ITEM_idItem AND u.idUser = o.USER_idUser AND o.timeOrders>='"+dateTime1+"' AND o.timeOrders<='"+dateTime2+"'GROUP BY u.idUser ORDER BY Total LIMIT 10;");
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
   c.add(p1,BorderLayout.NORTH);
   c.add(jScrollPane,BorderLayout.CENTER);
   c.add(p2,BorderLayout.SOUTH);
   this.setBounds(520,233,350, 300);
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.setVisible(true);
   back.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
   
  }
 
  public static void main(String[] args) {
   // TODO Auto-generated method stub
   testttttttttt demo2=new testttttttttt();
  
  }
  
 }