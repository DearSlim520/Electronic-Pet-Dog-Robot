package com.miniterm;

import com.qjj.jdbc.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.event.ListSelectionEvent;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class T2addDD extends JDialog{
	public T2addDD(int shop,int gly) {
		Container c = getContentPane();
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton back = new JButton("好吧");
		JPanel myPanel;
		JLabel label;
		ImageIcon background;
		background = new ImageIcon("/Users/hey/Desktop/error.png");	//创建一个背景图片
		label = new JLabel(background);		//把背景图片添加到标签里
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	//把标签设置为和图片等高等宽
		myPanel = (JPanel)this.getContentPane();		//把我的面板设置为内容面板
		myPanel.setOpaque(false);					//把我的面板设置为不可视
		myPanel.setLayout(new FlowLayout());
		p1.add(label, new Integer(Integer.MIN_VALUE));
		p2.add(back);
		c.add(p1,BorderLayout.CENTER);
		c.add(p2,BorderLayout.SOUTH);
		setVisible(true);
		setBounds(620,300,210,175);
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				addDD a = new addDD(shop,gly);
			}
		});
	  }
	  
}

