package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class addYH extends JFrame{
	JLabel title = new JLabel("新增用户信息");
	JLabel label1 = new JLabel("I   D");
    JLabel label2 = new JLabel("姓 名");
    JLabel label3 = new JLabel("地 址");
    JLabel label4 = new JLabel("电 话");
    JButton exit = new JButton("返 回");
    JButton sure = new JButton("确 定");
    JTextField textID = new JTextField();
    JTextField textname = new JTextField();
    JTextField textadd = new JTextField();
    JTextField texttel = new JTextField();

    public addYH(int gly) {
    setBounds(470,260,470,250);
    title.setFont(new Font("黑体",Font.BOLD,23));
    textID.setColumns(10);
    textID.setText("仅数字...");
    textID.setFont(new Font("黑体",Font.PLAIN,15));
    textname.setColumns(10);
    textname.setFont(new Font("黑体",Font.PLAIN,15));
    texttel.setColumns(10);
    texttel.setFont(new Font("黑体",Font.PLAIN,15));
    textadd.setColumns(10);
    textadd.setFont(new Font("黑体",Font.PLAIN,15));

    Container c = getContentPane(); 
    c.setLayout(new BorderLayout());

    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p2 = new JPanel(new GridLayout(5,1,0,0));
    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p8 = new JPanel(new FlowLayout(FlowLayout.CENTER));

    p1.add(title);
    p4.add(label1);
    p4.add(textID);
    p7.add(label2);
    p7.add(textname);
    p5.add(label3);
    p5.add(textadd);
    p8.add(label4);
    p8.add(texttel);
    p3.add(exit);
    p3.add(sure);
    p2.add(p4);
    p2.add(p7);
    p2.add(p5);
    p2.add(p8);
    c.add(p1,BorderLayout.NORTH);
    c.add(p2,BorderLayout.CENTER);
    c.add(p3,BorderLayout.SOUTH);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    sure.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String s1 = textID.getText();
			int id1 = Integer.parseInt(s1);
			String s2 = textname.getText();
			String s3 = textadd.getText();
			String s4 = texttel.getText();
			INSERTTOaddYH i = new INSERTTOaddYH(id1,s2,s3,s4);
			i.insert(gly);
			setVisible(false);
		}
	});
    
    exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			GLY g =new GLY(gly);
			setVisible(false);
		}
	});
    
    }
}
