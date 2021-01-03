package com.miniterm;
import java.sql.*;
import com.qjj.jdbc.*;

public class INSERTTOaddSP {
	private int id;
	private String name;
	private int price;
	private String type;
	private String addition;
	private int shopid;
	
	private Connection conn;
    private Statement stat;
    
    public INSERTTOaddSP(int id, String name, int price, String type, String addition, int shopid) {
    	this.id = id;
    	this.name = name;
    	this.price = price;
    	this.type = type;
    	this.addition = addition;
    	this.shopid = shopid;
    }
    
    public void insert(int gly) {
    	conn = testconnction.getConnection();
		try {
			stat = conn.createStatement();
			stat.executeUpdate("INSERT INTO ITEM VALUES (" + this.id + ", '" + this.name + "', " + this.price +  ", '" + this.type +  "', '" + this.addition +"', 1,'"+this.shopid+"')");
			stat.close();
			conn.close();
			GLYSP g = new GLYSP(shopid,gly);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			T2addSP t = new T2addSP(shopid,gly);
			e.printStackTrace();
		}
		
    }
}
