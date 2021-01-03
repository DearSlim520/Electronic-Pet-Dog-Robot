package com.miniterm;
import java.sql.*;
import java.time.LocalDateTime;

import com.qjj.jdbc.*;

public class UPDATETOmodiDD {
	private int id;
	private String state;
	private String comment;
	private String amount;
	private int score;
	private int gly;
	
	private Connection conn;
    private Statement stat;
    
    public UPDATETOmodiDD( int id, String state, String comment, String amount,int score ,int gly) {
    	this.id = id;
    	this.state = state;
    	this.comment = comment;
    	this.amount = amount;
    	this.score = score;
    	this.gly = gly;
    }
    
    public void insert() {
    	conn = testconnction.getConnection();
		try {
			stat = conn.createStatement();
			stat.executeUpdate("UPDATE ORDERS SET stateOrders='"+this.state+"',commentOrders='"+this.comment+"',numOrders='"+this.amount+"',scoreOrders="+this.score+" WHERE idOrders ="+this.id+";");
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    
}

