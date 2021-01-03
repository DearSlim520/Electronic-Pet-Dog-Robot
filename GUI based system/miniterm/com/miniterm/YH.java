package com.miniterm;
import com.qjj.jdbc.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

	public class YH extends JFrame{
		Vector rowData,columnNames;
		JTable jTable=null;
		JScrollPane jScrollPane=null;
		PreparedStatement preparedStatement=null;
		Connection connection=null;
		ResultSet resultSet=null;
		public static final String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT%2B8&useSSL=false";  
		public static final String driver = "com.mysql.cj.jdbc.Driver";  
		public static final String user = "root";  
		public static final String password = "fondndgdsbyr"; 
		
		public YH(){
			columnNames=new Vector<>();
			columnNames.add("商品ID");
			columnNames.add("名称");
			columnNames.add("价格");
			columnNames.add("类别");
			columnNames.add("说明");
			columnNames.add("删除标记");
			columnNames.add("店铺ID");
			
			rowData=new Vector<>();
			try {
				Class.forName(driver);  
	            connection = DriverManager.getConnection(url, user, password);
				preparedStatement=connection.prepareStatement("select * from mydb.item");
				resultSet=preparedStatement.executeQuery();
				while (resultSet.next()) {
					Vector hang=new Vector<>();
					hang.add(resultSet.getInt(1));
					hang.add(resultSet.getString(2));
					hang.add(resultSet.getInt(3));
					hang.add(resultSet.getString(4));
					hang.add(resultSet.getString(5));
					hang.add(resultSet.getString(6));
					hang.add(resultSet.getInt(7));
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
			ListSelectionModel rowSelectionModel = jTable.getSelectionModel();
			rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
			      public void valueChanged(ListSelectionEvent e) {
			        int selectedData =0;

			        int[] selectedRow = jTable.getSelectedRows();
			        int[] selectedColumns = jTable.getSelectedColumns();

			        for (int i = 0; i < selectedRow.length; i++) {
			          for (int j = 0; j < selectedColumns.length; j++) {
			            selectedData = (int) jTable.getValueAt(selectedRow[i], 0);
			          }
			        }
			        
			        System.out.println("Selected: " + selectedData);
			      }
			    });
			this.add(jScrollPane);
			
			//this.setBounds(425,233,550, 330);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			this.setVisible(true);
			
			
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			YH demo2=new YH();
	 
		}
	 
	}
