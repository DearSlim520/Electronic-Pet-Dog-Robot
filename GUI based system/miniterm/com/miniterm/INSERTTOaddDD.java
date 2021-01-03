package com.miniterm;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.qjj.jdbc.*;

public class INSERTTOaddDD {
	private int users;
	private int item;
	private int shop;
	private int id;
	private String state;
	private String comment;
	private String amount;
	private LocalDateTime timeorder;
	private int score;
	private int gly;
	
	private Connection conn;
    private Statement stat;
    
    public INSERTTOaddDD(int users, int item, int shop, int id, String state, String comment, String amount, LocalDateTime dateTime,int score ,int gly) {
    	this.users = users;
    	this.item = item;
    	this.shop = shop;
    	this.id = id;
    	this.state = state;
    	this.comment = comment;
    	this.amount = amount;
    	this.timeorder = dateTime;
    	this.score = score;
    	this.gly = gly;
    }
    
    public void insert() {
    	conn = testconnction.getConnection();
		try {
			stat = conn.createStatement();
			stat.executeUpdate("INSERT INTO ORDERS VALUES (" + this.users + ", " + this.item + ", " + this.shop + ","+ this.id + ", '" + this.state + "', '" + this.comment + "',"+this.amount +",'"+this.timeorder +"',"+this.score +","+this.gly+",'1')");
			stat.close();
			conn.close();
			GLYSJ g =new GLYSJ(shop,gly);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			T2addDD t = new T2addDD(shop,gly);
			e.printStackTrace();
		}
		
    }
}
