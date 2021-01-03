package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class modiYH extends JFrame{
	JLabel title = new JLabel("编辑用户信息");
    JLabel label2 = new JLabel("姓 名");
    JLabel label3 = new JLabel("地 址");
    JLabel label4 = new JLabel("电 话");
    JButton exit = new JButton("返 回");
    JButton sure = new JButton("确 定");
    JTextField textname = new JTextField();
    JTextField textadd = new JTextField();
    JTextField texttel = new JTextField();

    public modiYH(int gly, int yh) {
    setBounds(470,260,470,230);
    title.setFont(new Font("黑体",Font.BOLD,23));
    textname.setColumns(10);
    textname.setFont(new Font("黑体",Font.PLAIN,15));
    texttel.setColumns(10);
    texttel.setFont(new Font("黑体",Font.PLAIN,15));
    textadd.setColumns(10);
    textadd.setFont(new Font("黑体",Font.PLAIN,15));

    Container c = getContentPane(); 
    c.setLayout(new BorderLayout());

    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p2 = new JPanel(new GridLayout(4,1,0,0));
    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p8 = new JPanel(new FlowLayout(FlowLayout.CENTER));

    p1.add(title);
    p7.add(label2);
    p7.add(textname);
    p5.add(label3);
    p5.add(textadd);
    p8.add(label4);
    p8.add(texttel);
    p3.add(exit);
    p3.add(sure);
    p2.add(p7);
    p2.add(p5);
    p2.add(p8);
    c.add(p1,BorderLayout.NORTH);
    c.add(p2,BorderLayout.CENTER);
    c.add(p3,BorderLayout.SOUTH);
    setVisible(true);
    
    sure.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String s2 = textname.getText();
			String s3 = textadd.getText();
			String s4 = texttel.getText();
			UPDATETOmodiYH i = new UPDATETOmodiYH(yh,s2,s3,s4);
			i.insert();
			GLYYH g =new GLYYH(gly,yh);
			setVisible(false);
		}
	});
    
    exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			GLYYH g =new GLYYH(gly,yh);
			setVisible(false);
		}
	});
    }
   // public static void main(String[] args) {
    //	modiYH m = new modiYH(1,1000);
    //}
}
