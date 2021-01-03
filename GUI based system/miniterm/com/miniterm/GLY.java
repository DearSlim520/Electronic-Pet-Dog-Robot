package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GLY extends JFrame{
	    JLabel L = new JLabel("管理员管理");
		JButton b1 = new JButton("店铺");
		JButton b2 = new JButton("用户");
		JButton b4 = new JButton("订单");
		JButton b3 = new JButton("统计");
		JButton exit = new JButton("退	出");
		public GLY(int gly) {
			setBounds(500,260,380,300);
			L.setFont(new Font("Dialog", Font.BOLD, 24));

			Dimension preferredSize = new Dimension(10,5);
  			b1.setPreferredSize(preferredSize);

			Container c = getContentPane(); 
  		    c.setLayout(new BorderLayout());

			JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel p2 = new JPanel(new GridLayout(4,1,0,0));
            JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p1.add(L);
			p2.add(b1);
			p2.add(b2);
			p2.add(b4);
			p2.add(b3);
			p3.add(exit);
			c.add(p1,BorderLayout.NORTH);
    		c.add(p2,BorderLayout.CENTER);
    		c.add(p3,BorderLayout.SOUTH);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					search_add s = new search_add(gly);
				}
			});	
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					search_add3 s = new search_add3(gly);
				}
			});	
			b3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					TJ t = new TJ (0,gly);
				}
			});
			b4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					search s = new search(gly);
				}
			});
			
			exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					enter en = new enter();
					setVisible(false);
				}
			});
		}

	}

