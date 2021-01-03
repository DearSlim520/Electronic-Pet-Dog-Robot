package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class modiDD2 extends JFrame{
	JLabel title = new JLabel("编辑订单信息");
    JLabel label2 = new JLabel("订单状态");
    JLabel label3 = new JLabel("相关评论");
    JLabel label4 = new JLabel("商品数量");
    JLabel label6 = new JLabel("评     分");
    JButton exit = new JButton("返  回");
    JButton sure = new JButton("确  定");
   // JTextField users = new JTextField();
    //JTextField item = new JTextField();
    //JTextField ID = new JTextField();
    JTextField state = new JTextField();
    JTextField comment = new JTextField();
    JTextField amount = new JTextField();
    //JTextField time = new JTextField();
    JTextField score = new JTextField();

    public modiDD2(int gly,int dd) {
    	setBounds(470,250,470,260);
    title.setFont(new Font("黑体",Font.BOLD,23));
    //users.setColumns(10);
    state.setColumns(10);
    state.setFont(new Font("黑体",Font.PLAIN,15));
    comment.setColumns(10);
    comment.setFont(new Font("黑体",Font.PLAIN,15));
    amount.setColumns(10);
    amount.setFont(new Font("黑体",Font.PLAIN,15));
    score.setText("仅数字...");
    score.setColumns(10);
    score.setFont(new Font("黑体",Font.PLAIN,15));

    Container c = getContentPane(); 
    c.setLayout(new BorderLayout());

    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p2 = new JPanel(new GridLayout(4,1,0,0));
    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    //JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    //JPanel p9 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p10 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    //JPanel p11 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    //JPanel p12 = new JPanel(new FlowLayout(FlowLayout.CENTER));

    p1.add(title);
    p7.add(label2);
    p7.add(state);
    p5.add(label3);
    p5.add(comment);
    p8.add(label4);
    p8.add(amount);
    p10.add(label6);
    p10.add(score);
    p3.add(exit);
    p3.add(sure);
    p2.add(p7);
    p2.add(p5);
    p2.add(p8);
    p2.add(p10);
    c.add(p1,BorderLayout.NORTH);
    c.add(p2,BorderLayout.CENTER);
    c.add(p3,BorderLayout.SOUTH);
    setVisible(true);
    
    sure.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			//String s = users.getText();
			//int us = Integer.parseInt(s);
			//String ss = item.getText();
			//int it = Integer.parseInt(ss);
			//String s1 = ID.getText();
			//int dd = Integer.parseInt(s1);
			String s2 = state.getText();
			String s3 = comment.getText();
			String s4 = amount.getText();
			//String str = time.getText();
			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			//LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
			int s6 = Integer.parseInt(score.getText());
			UPDATETOmodiDD i = new UPDATETOmodiDD(dd,s2,s3,s4,s6,gly);
			i.insert();
			GLYDD2 g =new GLYDD2(gly,dd);
			setVisible(false);
		}
	});
    
    exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			GLYDD2 g =new GLYDD2(gly,dd);
			setVisible(false);
		}
	});
    
    }
    
    //public static void main(String[] args) {
    //	modiDD m = new modiDD(1,'111111');
    //}
}
