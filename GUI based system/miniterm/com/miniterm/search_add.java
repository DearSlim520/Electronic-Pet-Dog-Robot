package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class search_add extends JFrame{
    JLabel title = new JLabel("请输入要搜索的商家ID");
    JButton sure = new JButton("查找");
    JTextField text = new JTextField();
    JButton add = new JButton("新  增");
    
    public search_add(int gly){
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
				int id1 = Integer.parseInt(s1);
				f.setVisible(false);
				GLYSJ g = new GLYSJ(id1,gly);
			}
		});
        
        add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				addSJ a = new addSJ(gly);
				f.setVisible(false);
			}
		});
        
    }
    
   
}
