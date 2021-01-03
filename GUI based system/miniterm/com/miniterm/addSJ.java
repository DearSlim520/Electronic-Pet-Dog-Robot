package com.miniterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class addSJ extends JFrame{
	JLabel title = new JLabel("新增店铺信息");
	JLabel label1 = new JLabel("店铺ID");
    JLabel label2 = new JLabel("店铺名字");
    JLabel label3 = new JLabel("店铺密码");
    JLabel label4 = new JLabel("再次输入");
    JButton va = new JButton("验证");
    JButton exit = new JButton("返回");
    JButton sure = new JButton("确定");
    JTextField text = new JTextField();
    JTextField textname = new JTextField();
    JPasswordField pass = new JPasswordField();
    JPasswordField pass2 = new JPasswordField();
    JLabel label5 = new JLabel(" ");

    public addSJ(int gly) {
    setBounds(460,260,470,260);
    title.setFont(new Font("黑体",Font.BOLD,23));
    text.setColumns(10);
    text.setText("仅限纯数字...");
    text.setFont(new Font("黑体",Font.PLAIN,15));
    textname.setColumns(10);
    textname.setText("请输入名字...");
    textname.setFont(new Font("黑体",Font.PLAIN,15));
    pass.setColumns(10);
    pass.setEchoChar('*');
    pass.setFont(new Font("黑体",Font.PLAIN,15));
    pass2.setColumns(10);
    pass2.setEchoChar('*');
    pass2.setFont(new Font("黑体",Font.PLAIN,15));

    Container c = getContentPane(); 
    c.setLayout(new BorderLayout());

    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p2 = new JPanel(new GridLayout(4,1,0,0));
    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p8 = new JPanel(new FlowLayout(FlowLayout.CENTER));

    p1.add(title);
    p4.add(label1);
    p4.add(text);
    p7.add(label2);
    p7.add(textname);
    p5.add(label3);
    p5.add(pass);
    p8.add(label4);
    p8.add(pass2);
    p8.add(label5);
    p3.add(exit);
    p3.add(va);
    p3.add(sure);
    sure.setVisible(false);
    p2.add(p4);
    p2.add(p7);
    p2.add(p5);
    p2.add(p8);
    c.add(p1,BorderLayout.NORTH);
    c.add(p2,BorderLayout.CENTER);
    c.add(p3,BorderLayout.SOUTH);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    va.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		char ch1[]= pass.getPassword();
    		char ch2[]= pass2.getPassword();
    		if(Arrays.equals(ch1,ch2)==true) {
    			label5.setText("√");
    			label5.setForeground(new Color(0,205,0));
    			va.setVisible(false);
    			sure.setVisible(true);
    		}
    		else { 
    			label5.setText("✕");
    			label5.setForeground(new Color(220,20,60));
    		}
    	}
    });
    
    sure.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String s1 = text.getText();
			int id1 = Integer.parseInt(s1);
			String name1 = textname.getText();
			char ch[]=pass2.getPassword();
			String pass1 = new String(ch);
			INSERTTOaddSJ i = new INSERTTOaddSJ(id1,name1,pass1);
			i.insert(gly);
			setVisible(false);
			//GLY g =new GLY(gly);
		}
	});
    
    exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			GLY s = new GLY(gly);
		}
	});
    
    }
    
}
