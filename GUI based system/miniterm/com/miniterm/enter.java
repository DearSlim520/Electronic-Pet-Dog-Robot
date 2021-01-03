package com.miniterm;

import javax.swing.*;
import com.qjj.jdbc.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class enter extends JFrame {
    JRadioButton admin = new JRadioButton("管理员登录");
    JRadioButton owner = new JRadioButton("商家登录");
    JLabel label1 = new JLabel("I   D");
    JLabel label2 = new JLabel("密码");
    JButton exit = new JButton("退 出");
    JButton sure = new JButton("确 定");
    JButton va = new JButton("验证");
    JLabel label5 = new JLabel(" ");
    JTextField text = new JTextField();
    JPasswordField pass = new JPasswordField();
    //public static int flag=-1;
    public static int flag2=-1;
    JPanel myPanel;
	JLabel label;
	ImageIcon background;
	private Connection conn;
    private Statement stat;

    public enter() {
    setBounds(470,260,470,315);
    text.setColumns(18);
    text.setText("请输入ID...");
    text.setFont(new Font("黑体",Font.PLAIN,15));
    pass.setColumns(18);
    pass.setEchoChar('\u2605');
    pass.setFont(new Font("黑体",Font.PLAIN,15));

    Container c = getContentPane(); 
    c.setLayout(new BorderLayout());
    
    ButtonGroup group= new ButtonGroup();
    group.add(admin);
    group.add(owner);
    admin.setSelected(true);

    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p2 = new JPanel(new GridLayout(3,1,0,-5));
    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    background = new ImageIcon("/Users/hey/Desktop/b.png");	//创建一个背景图片
	label = new JLabel(background);		//把背景图片添加到标签里
	label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	//把标签设置为和图片等高等宽
	myPanel = (JPanel)this.getContentPane();		//把我的面板设置为内容面板
	myPanel.setOpaque(false);					//把我的面板设置为不可视
	myPanel.setLayout(new FlowLayout());
	
	p1.add(label, new Integer(Integer.MIN_VALUE));
    p4.add(label1);
    p4.add(text);
    p5.add(label2);
    p5.add(pass);
    p5.add(label5);
    p3.add(exit);
    p3.add(va);
    p3.add(sure);
    sure.setVisible(false);
    p6.add(admin);
    p6.add(owner);
    p2.add(p6);
    p2.add(p4);
    p2.add(p5);
    c.add(p1,BorderLayout.NORTH);
    c.add(p2,BorderLayout.CENTER);
    c.add(p3,BorderLayout.SOUTH);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    admin.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			numbers.flag=0;
			System.out.println("0");
		}
	});
    
    owner.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			numbers.flag=1;
			System.out.println("1");
		}
	});
    
    va.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String s1 = text.getText();
			int id1 = Integer.parseInt(s1);
			char ch[]=pass.getPassword();
			String pass1 = new String(ch);
			System.out.println(s1+" "+pass1);
			conn = testconnction.getConnection();
		    stat = testconnction.getStatement(conn);
		    if(owner.isSelected()==true) {
		    	numbers.flag=1;
		    	System.out.println("1");
    			ResultSet ret = null;
		        try {
		            ret = stat.executeQuery("SELECT passShop FROM mydb.Shop WHERE idShop="+id1);
		            System.out.println("101");
		            if(ret.next()){
		            	System.out.println("11");
		            	String passRight = ret.getString("passShop");
		            	ret.close(); 
			            stat.close();//关闭连接  
			            if(pass1.equals(passRight)) {
			            	System.out.println("111"+pass1+" "+passRight);
			            	label5.setText("√");
			    			label5.setForeground(new Color(0,205,0));
			    			va.setVisible(false);
			    			sure.setVisible(true);
			    			enter.flag2 = 2;
				        }else {
				        	System.out.println("444"+pass1+" "+passRight);
				        	label5.setText("✕");
			    			label5.setForeground(new Color(220,20,60));
				         }
			        }
		        } catch (SQLException ex) {  
		            ex.printStackTrace();  
		        }  
		        
    		}
    		else if(admin.isSelected()==true) {
    			numbers.flag=0;
    			System.out.println("2");
    			ResultSet ret2 = null;
    			try {
    				ret2 = stat.executeQuery("SELECT passStaff FROM mydb.Staff WHERE idStaff="+id1);
    				 if(ret2.next()){
    					 String passRight = ret2.getString("passStaff");   
 		            	ret2.close(); 
 			            stat.close();//关闭连接  
 			            if(pass1.equals(passRight)) {
 			            	label5.setText("√");
 			    			label5.setForeground(new Color(0,205,0));
 			    			va.setVisible(false);
 			    			sure.setVisible(true);
 			            	enter.flag2=3;
 				        }else {
 				        	label5.setText("✕");
 			    			label5.setForeground(new Color(220,20,60));
 				         }
 			        }
		        } catch (SQLException ex) {  
		            ex.printStackTrace();  
		        }  	
    	}
    	}
    });
    
    sure.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String s1 = text.getText();
			int id1 = Integer.parseInt(s1);
    		if(enter.flag2==2) {
    			GLYSJ g = new GLYSJ(id1,1);  
    			setVisible(false);
    		}
    		else if(enter.flag2==3) {
    			GLY gly = new GLY(id1);  
	    		setVisible(false);	
    	    }
    	}
    });
    
    exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
    }

    public static void main(String[] args) {
    enter s = new enter();
	}
}