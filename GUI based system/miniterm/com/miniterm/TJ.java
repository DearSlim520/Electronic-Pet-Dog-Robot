package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class TJ extends JFrame{
	JLabel label2 = new JLabel("起始时间");
	JLabel label3 = new JLabel("截至时间");
	JTextField text1 = new JTextField();
	JTextField text2 = new JTextField();
	JButton b1 = new JButton("按照商家统计某时段订单数和总金额（输入时间）");      //都可以看到，加普通限制
	JButton b2 = new JButton("某时段销量排名以及前十商家（输入时间）");           //都可以看到
	JButton b3 = new JButton("某时段下单成功的前十用户（输入时间）");             //都可以看到，加普通限制
	JButton b4 = new JButton("每月订单数和金额情况统计");                       //都可以看到，加普通限制
	JButton b5 = new JButton("24小时订单数量分布情况统计");                     //都可以看到，加普通限制
	JButton b6 = new JButton("某时段某个类别商品订单数和总金额（输入时间）");      //都可以看到，加普通限制
	JButton b7 = new JButton("某时段所有订单单数和总金额（输入时间）");           //都可以看到，加普通限制
	JButton b8 = new JButton("某时段前十热销商品（输入时间）");                  //都可以看到，加普通限制
	JButton b9 = new JButton("评价数量前十的商品");                            //都可以看到
	JButton b10 = new JButton("平均评分前十的商品");                            //都可以看到
	JButton back = new JButton("返	回");
	
	public TJ(int shop,int gly) {
		setTitle("统计数据");
		setLayout(new BorderLayout(10,10));
		setBounds(500,200,430,505);
		text1.setColumns(10);
		text1.setText("yyyy/MM/dd HH:mm:ss");
		text2.setColumns(10); 
		text2.setText("yyyy/MM/dd HH:mm:ss");
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p2 = new JPanel(new GridLayout(10,1));
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Container c = getContentPane();
        c.setLayout(new BorderLayout());
		p1.add(label2);
		p1.add(text1);
		p1.add(label3);
		p1.add(text2);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(b10);
		p3.add(back);
		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.CENTER);
		c.add(p3,BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		String time1 = text1.getText();
		String time2 = text2.getText();
		//按照商家统计某时段订单数和总金额
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time1 = text1.getText();
				String time2 = text2.getText();
				TJb1 t = new TJb1(time1,time2,shop);
			}
		});
		//某时段销量排名以及前十商家
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time1 = text1.getText();
				String time2 = text2.getText();
				TJb2 t = new TJb2(time1,time2,shop);
			}
		});
		
		//某时段下单成功的前十用户
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time1 = text1.getText();
				String time2 = text2.getText();
				TJb3 t = new TJb3(time1,time2,shop);
				
			}
		});
		
		//每月订单数和金额情况统计
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TJb4 t = new TJb4(shop);
			}
		});
		
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time1 = text1.getText();
				String time2 = text2.getText();
				TJb5 t = new TJb5(shop);
			}
		});
		
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time1 = text1.getText();
				String time2 = text2.getText();
				TJb6 t = new TJb6(time1,time2,shop);
			}
		});
		//某时段所有订单单数和总金额
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time1 = text1.getText();
				String time2 = text2.getText();
				TJb7 t = new TJb7(time1,time2,shop);
			}
		});
		//某时段前十热销商品
		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time1 = text1.getText();
				String time2 = text2.getText();
				TJb8 t = new TJb8(time1,time2,shop);
			}
		});
		//评价数量前十的商品
		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TJb9 t = new TJb9();
			}
		});
		//平均评分前十的商品
		b10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TJb10 t = new TJb10();
			}
		});
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(shop==0) {
					GLY g = new GLY(gly);
				}
				else {
					GLYSJ g2 = new GLYSJ(shop,gly);
				}
				setVisible(false);
			}
		});
	}
	//public static void main(String[] args) {
	//	TJ t = new TJ(0,1);
	//}
}
