package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class search_add2 extends JFrame{
    JLabel title = new JLabel("请输入要搜索的订单ID");
    JButton sure = new JButton("查找");
    JTextField text = new JTextField();
    JButton add = new JButton("新  增");
    
    public search_add2(int shop, int gly){
        JFrame f = new JFrame("查询");
        f.setBounds(560,300,280,140);
        title.setFont(new Font("黑体",Font.BOLD,21));
        text.setColumns(10);
        text.setText("请输入ID...");
        text.setFont(new Font("黑体",Font.PLAIN,15));

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p1.add(title);
        p2.add(text);
        p2.add(sure);
        p3.add(add);
        
        c.add(p1,BorderLayout.NORTH);
        c.add(p2,BorderLayout.CENTER);
        c.add(p3,BorderLayout.SOUTH);
        
        f.add(c);
        f.setVisible(true);     
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        sure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String s1 = text.getText();
				int dd = Integer.parseInt(s1);
				if(numbers.flag==0) {
					GLYDD g =new GLYDD(shop,gly,dd);
					f.setVisible(false);
					}
				if(numbers.flag==1) {
					GLYDD g = new GLYDD(shop,1,dd);
					f.setVisible(false);
				}
				
			}
		});

        add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(numbers.flag==0) {
					addDD a = new addDD(shop,gly);
					f.setVisible(false);
					}
				if(numbers.flag==1) {
					addDD a = new addDD(shop,1);
					f.setVisible(false);
				}
				
			}
		});
        
    }
}
