package com.miniterm;
import java.sql.*;
import com.qjj.jdbc.*;

public class INSERTTOaddYH {
	private int id;
	private String name;
	private String address;
	private String tel;
	
	private Connection conn;
    private Statement stat;
    
    public INSERTTOaddYH(int id, String name, String address, String tel) {
    	this.id = id;
    	this.name = name;
    	this.address = address;
    	this.tel = tel;
    }
    
    public void insert(int gly) {
    	conn = testconnction.getConnection();
		try {
			stat = conn.createStatement();
			stat.executeUpdate("INSERT INTO USER VALUES (" + this.id + ", '" + this.name + "', '" + this.address +  "', '" + this.tel + "', 1)");
			stat.close();
			conn.close();
			GLY g =new GLY(gly);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			T2addYH t = new T2addYH(gly);
			e.printStackTrace();
		}
		
    }
}
