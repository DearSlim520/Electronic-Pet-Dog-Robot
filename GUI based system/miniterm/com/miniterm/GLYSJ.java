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

public class GLYSJ extends JFrame{
	JLabel title = new JLabel("店铺信息");
	JButton b1 = new JButton("删除店铺");
	JButton b2 = new JButton("编辑店铺");
	JButton b3 = new JButton("商品管理");
	JButton b4 = new JButton("订单管理");
	JButton b5 = new JButton("统计数据");
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
	
	public GLYSJ(int shop,int gly) {
		System.out.println(numbers.flag);
	    if(numbers.flag==1) {exit.setText("退出登录");}
	    else if(numbers.flag==0) {exit.setText("返  回");};System.out.println(numbers.flag);
		JFrame f = new JFrame("店铺管理");
		f.setBounds(400,180,600,550);
		title.setFont(new Font("黑体", Font.BOLD, 24));
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p2 = new JPanel(new BorderLayout());
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p4 = new JPanel(new GridLayout(1,5));
		
		Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        columnNames=new Vector<>();
		columnNames.add("店铺ID");
		columnNames.add("名称");
		columnNames.add("密码");
		columnNames.add("删除标记");
		rowData=new Vector<>();
		try {
			Class.forName(driver);  
            connection = DriverManager.getConnection(url, user, password);
			preparedStatement=connection.prepareStatement("select * from mydb.shop where idShop="+shop+" and delShop <> '0'");
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				Vector hang=new Vector<>();
				hang.add(resultSet.getInt(1));
				hang.add(resultSet.getString(2));
				hang.add(resultSet.getString(3));
				hang.add(resultSet.getString(4));
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
		        System.out.println("Selected: " + selectedData);  //选出商品ID
		      }
		    });
		JScrollPane js = new JScrollPane(jTable);
		f.setSize(550,400);
        
        p1.add(title);
        p2.add(js,BorderLayout.CENTER);
		p4.add(b1);
		p4.add(b2);
		p4.add(b3);
		p4.add(b4);
		p4.add(b5);
		p2.add(p4,BorderLayout.SOUTH);
		p3.add(exit);
		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.CENTER);
		c.add(p3,BorderLayout.SOUTH);
		f.add(c);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				attention_delSJ a = new attention_delSJ(shop,gly);
				f.setVisible(false);
			}
		});
		
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				modiSJ m = new modiSJ(shop,gly);
				f.setVisible(false);
			}
		});
		
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				GLYSP g = new GLYSP(shop,gly);
				f.setVisible(false);
			}
		});
		
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(numbers.flag==0) {
					search_add2 s = new search_add2(shop,gly);
					f.setVisible(false);}
				if(numbers.flag==1) {
					search_add2 s = new search_add2(shop,1);
					f.setVisible(false);
				}
			}
		});
		
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TJ t = new TJ (shop,gly);
				f.setVisible(false);
			}
		});
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(numbers.flag==0) {
					GLY g = new GLY(gly);
					f.setVisible(false);
				}
				else if(numbers.flag==1) {
					enter en = new enter();
					f.setVisible(false);
				}
				
			}
		});
	}
	
	//public static void main(String[] args) {
	//	GLYSJ g = new GLYSJ(89,1);
	//}

}
