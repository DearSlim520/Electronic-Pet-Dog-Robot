package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class search extends JFrame{
    JLabel title = new JLabel("请输入要查找的订单ID");
    JButton sure = new JButton("查找");
    JTextField text = new JTextField();
    
    public search(int gly){
        JFrame f = new JFrame("搜索");
        f.setBounds(560,300,280,120);
        title.setFont(new Font("黑体",Font.BOLD,21));
        text.setColumns(10);
        text.setText("请输入ID...");
        text.setFont(new Font("黑体",Font.PLAIN,15));

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p1.add(title);
        p2.add(text);
        p2.add(sure);
        
        c.add(p1,BorderLayout.NORTH);
        c.add(p2,BorderLayout.CENTER);
        
        f.add(c);
        f.setVisible(true);  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        sure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String d1 = text.getText();
				int dd = Integer.parseInt(d1);
				GLYDD2 g =new GLYDD2(gly,dd);
				f.setVisible(false);
			}
		});
        
    }
}
