package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class addDD extends JFrame{
	JLabel title = new JLabel("新增订单信息");
	JLabel label0 = new JLabel("用户I D");
	JLabel label7 = new JLabel("商品I D");
	JLabel label1 = new JLabel("订单I D");
    JLabel label2 = new JLabel("订单状态");
    JLabel label3 = new JLabel("相关评论");
    JLabel label4 = new JLabel("商品数量");
    JLabel label5 = new JLabel("下单时间");
    JLabel label6 = new JLabel("评     分");
    JButton exit = new JButton("返  回");
    JButton sure = new JButton("确  定");
    JTextField users = new JTextField();
    JTextField item = new JTextField();
    JTextField ID = new JTextField();
    JTextField state = new JTextField();
    JTextField comment = new JTextField();
    JTextField amount = new JTextField();
    JTextField time = new JTextField();
    JTextField score = new JTextField();

    public addDD(int shop, int gly) {
    setBounds(470,250,470,322);
    title.setFont(new Font("黑体",Font.BOLD,23));
    users.setColumns(10);
    users.setFont(new Font("黑体",Font.PLAIN,15));
    users.setText("仅数字...");
    item.setColumns(10);
    item.setFont(new Font("黑体",Font.PLAIN,15));
    item.setText("仅数字...");
    ID.setColumns(10);
    ID.setFont(new Font("黑体",Font.PLAIN,15));
    state.setColumns(10);
    state.setFont(new Font("黑体",Font.PLAIN,15));
    comment.setColumns(10);
    comment.setFont(new Font("黑体",Font.PLAIN,15));
    amount.setColumns(10);
    amount.setFont(new Font("黑体",Font.PLAIN,15));
    time.setText("yyyy/MM/dd HH:mm:ss");
    time.setColumns(10);
    time.setFont(new Font("黑体",Font.PLAIN,15));
    score.setText("仅数字...");
    score.setColumns(10);
    score.setFont(new Font("黑体",Font.PLAIN,15));

    Container c = getContentPane(); 
    c.setLayout(new BorderLayout());

    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p2 = new JPanel(new GridLayout(8,1,0,0));
    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p9 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p10 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p11 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p12 = new JPanel(new FlowLayout(FlowLayout.CENTER));

    p1.add(title);
    p11.add(label0);
    p11.add(users);
    p12.add(label7);
    p12.add(item);
    p4.add(label1);
    p4.add(ID);
    p7.add(label2);
    p7.add(state);
    p5.add(label3);
    p5.add(comment);
    p8.add(label4);
    p8.add(amount);
    p9.add(label5);
    p9.add(time);
    p10.add(label6);
    p10.add(score);
    p3.add(exit);
    p3.add(sure);
    p2.add(p11);
    p2.add(p12);
    p2.add(p4);
    p2.add(p7);
    p2.add(p5);
    p2.add(p8);
    p2.add(p9);
    p2.add(p10);
    c.add(p1,BorderLayout.NORTH);
    c.add(p2,BorderLayout.CENTER);
    c.add(p3,BorderLayout.SOUTH);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    sure.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String s = users.getText();
			int us = Integer.parseInt(s);
			String ss = item.getText();
			int it = Integer.parseInt(ss);
			String ord = ID.getText();
			int s1 = Integer.parseInt(ord);
			String s2 = state.getText();
			String s3 = comment.getText();
			String s4 = amount.getText();
			String str = time.getText();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
			int s6 = Integer.parseInt(score.getText());
			INSERTTOaddDD i = new INSERTTOaddDD(us,it,shop,s1,s2,s3,s4,dateTime,s6,gly);
			i.insert();
			//GLYSJ g =new GLYSJ(shop,gly);
			setVisible(false);
		}
	});
    
    exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			GLYSJ g =new GLYSJ(shop,gly);
			setVisible(false);
		}
	});
    
    }
   // public static void main(String[] args) {
    //	addDD a = new addDD(69,1);
    //}
    //一定要找到已存在的对应商品的对应店铺！
}
