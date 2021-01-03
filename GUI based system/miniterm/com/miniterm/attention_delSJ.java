package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.qjj.jdbc.*;

public class attention_delSJ extends JFrame {
	JLabel title = new JLabel("您确定要提交修改吗？");
	JButton b1 = new JButton("取消");
	JButton b2 = new JButton("确定");
	
	private Connection conn;
    private Statement stat;
	
	public attention_delSJ(int shop ,int gly) {
		JFrame f = new JFrame("提示");
		title.setFont(new Font("黑体", Font.PLAIN, 16));
        f.setBounds(560,300,210,120);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p2 = new JPanel(new GridLayout(1,3));
		p1.add(title);
		p2.add(b1);
		p2.add(b2);
		c.add(p1,BorderLayout.CENTER);
        c.add(p2,BorderLayout.SOUTH);
        f.add(c);
        f.setVisible(true);
        
        b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				GLYSJ g =new GLYSJ(shop,gly);
			}
		});
        
        b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				delete(shop);
				f.setVisible(false);
				GLYSJ g =new GLYSJ(shop,gly);
			}
		});
	}
	
	public void delete(int shop) {
    	conn = testconnction.getConnection();
		try {
			stat = conn.createStatement();
			stat.executeUpdate("UPDATE SHOP SET delShop= '0' WHERE idShop = "+shop);
			stat.executeUpdate("UPDATE ORDERS SET delOrders= '0' WHERE ITEM_SHOP_idShop = "+shop);
			stat.executeUpdate("UPDATE ITEM SET delItem= '0' WHERE SHOP_idShop = "+shop);
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	
	//public static void main(String[] args) {
	//	attention_delSJ a = new attention_delSJ(1000);
	//}

}
