package com.miniterm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GLYDD extends JFrame{
	JLabel title = new JLabel("订单列表");
	JButton b1 = new JButton("删除订单");
	JButton b3 = new JButton("编辑订单");
	JButton exit = new JButton("返	回");
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
	
	public GLYDD(int shop,int gly,int dd) {
		JFrame f = new JFrame("订单管理");
		f.setBounds(350,180,750,400);
		title.setFont(new Font("黑体", Font.BOLD, 24));
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p2 = new JPanel(new BorderLayout());
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p4 = new JPanel(new GridLayout(1,2));
		
		Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        columnNames=new Vector<>();
        columnNames.add("用户ID");
		columnNames.add("商品ID");
		columnNames.add("店铺ID");
		columnNames.add("订单ID");
		columnNames.add("物流状态");
		columnNames.add("评价");
		columnNames.add("数量");
		columnNames.add("下单时间");
		columnNames.add("评分");
		columnNames.add("管理员ID");
		columnNames.add("删除标记");
		rowData=new Vector<>();

		try {
			Class.forName(driver);  
            connection = DriverManager.getConnection(url, user, password);
			preparedStatement=connection.prepareStatement("select * from mydb.Orders where idOrders=" + dd +" AND ITEM_SHOP_idShop="+shop+" AND delOrders <> '0'");
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				Vector hang=new Vector<>();
				hang.add(resultSet.getInt(1));
				hang.add(resultSet.getInt(2));
				hang.add(resultSet.getInt(3));
				hang.add(resultSet.getString(4));
				hang.add(resultSet.getString(5));
				hang.add(resultSet.getString(6));
				hang.add(resultSet.getString(7));
				hang.add(resultSet.getTimestamp(8));
				hang.add(resultSet.getInt(9));
				hang.add(resultSet.getInt(10));
				hang.add(resultSet.getInt(11));
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
		        String selectedData = null;

		        int[] selectedRow = jTable.getSelectedRows();
		        int[] selectedColumns = jTable.getSelectedColumns();

		        for (int i = 0; i < selectedRow.length; i++) {
		          for (int j = 0; j < selectedColumns.length; j++) {
		            selectedData = (String) jTable.getValueAt(selectedRow[i], 3);
		          }
		        }
		        System.out.println("Selected: " + selectedData);  //选出ID
		      }
		    });
		JScrollPane js = new JScrollPane(jTable);
		
        
        p1.add(title);
        p2.add(js,BorderLayout.CENTER);
		p4.add(b1);
		p4.add(b3);
		p2.add(p4,BorderLayout.SOUTH);
		p3.add(exit);
		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.CENTER);
		c.add(p3,BorderLayout.SOUTH);
		f.add(c);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				attention_delDD a = new attention_delDD(shop,dd,gly);
				f.setVisible(false);
			}
		});
		
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				modiDD m = new modiDD(shop,gly,dd);
				f.setVisible(false);
			}
		});
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				GLYSJ g = new GLYSJ (shop,gly);
			}
		});
	}
	
	//public static void main(String[] args) {
	//	GLYDD g = new GLYDD(1,"112110");
	//}
}


