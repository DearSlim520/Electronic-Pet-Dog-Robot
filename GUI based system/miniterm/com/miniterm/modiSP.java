package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class modiSP extends JFrame{
	JLabel title = new JLabel("编辑商品信息");
    JLabel label2 = new JLabel("名 称");
    JLabel label3 = new JLabel("价 格");
    JLabel label4 = new JLabel("类 别");
    JLabel label5 = new JLabel("说 明");
    JButton exit = new JButton("返 回");
    JButton sure = new JButton("确 定");
    JTextField textname = new JTextField();
    JTextField textprice = new JTextField();
    JTextField texttype = new JTextField();
    JTextField textadd = new JTextField();

    public modiSP(int shop, int gly,int item) {
    setBounds(470,260,470,248);
    title.setFont(new Font("黑体",Font.BOLD,23));
    textname.setColumns(10);
    textname.setFont(new Font("黑体",Font.PLAIN,15));
    textprice.setColumns(10);
    textprice.setFont(new Font("黑体",Font.PLAIN,15));
    texttype.setColumns(10);
    texttype.setFont(new Font("黑体",Font.PLAIN,15));
    textadd.setColumns(10);
    textadd.setFont(new Font("黑体",Font.PLAIN,15));

    Container c = getContentPane(); 
    c.setLayout(new BorderLayout());

    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p2 = new JPanel(new GridLayout(5,1,0,0));
    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p9 = new JPanel(new FlowLayout(FlowLayout.CENTER));

    p1.add(title);
    p7.add(label2);
    p7.add(textname);
    p5.add(label3);
    p5.add(textprice);
    p8.add(label4);
    p8.add(texttype);
    p9.add(label5);
    p9.add(textadd);
    p3.add(exit);
    p3.add(sure);
    p2.add(p7);
    p2.add(p5);
    p2.add(p8);
    p2.add(p9);
    c.add(p1,BorderLayout.NORTH);
    c.add(p2,BorderLayout.CENTER);
    c.add(p3,BorderLayout.SOUTH);
    setVisible(true);
    
    sure.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String s2 = textname.getText();
			String s3 = textprice.getText();
			int price1 = Integer.parseInt(s3);
			String s4 = texttype.getText();
			String s5 = textadd.getText();
			UPDATETOmodiSP i = new UPDATETOmodiSP(item,s2,price1,s4,s5,shop);
			i.insert();
			GLYSP g =new GLYSP(shop,gly);
			setVisible(false);
		}
	});
    
    exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			GLYSP g =new GLYSP(shop,gly);
			setVisible(false);
		}
	});
    
    }
}
