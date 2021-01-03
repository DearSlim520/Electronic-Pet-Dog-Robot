package com.miniterm;
import java.sql.*;
import com.qjj.jdbc.*;

public class UPDATETOmodiSP {
	private int id;
	private String name;
	private int price;
	private String type;
	private String addition;
	private int shopid;
	
	private Connection conn;
    private Statement stat;
    
    public UPDATETOmodiSP(int id, String name, int price, String type, String addition, int shopid) {
    	this.id = id;
    	this.name = name;
    	this.price = price;
    	this.type = type;
    	this.addition = addition;
    	this.shopid = shopid;
    }
    
    public void insert() {
    	conn = testconnction.getConnection();
		try {
			stat = conn.createStatement();
			stat.executeUpdate("UPDATE ITEM SET nameItem='"+this.name+"',priceItem="+this.price+",typeItem='"+this.type+"',addItem='"+this.addition+"'WHERE idItem="+this.id);
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
}
