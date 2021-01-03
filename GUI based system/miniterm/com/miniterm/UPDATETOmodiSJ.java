package com.miniterm;
import java.sql.*;
import com.qjj.jdbc.*;

public class UPDATETOmodiSJ {
	private int id;
	private String name;
	private String password;
	
	private Connection conn;
    private Statement stat;
    
    public UPDATETOmodiSJ(int id, String name, String password) {
    	this.id = id;
    	this.name = name;
    	this.password = password;
    }
    
    public void insert() {
    	conn = testconnction.getConnection();
		try {
			stat = conn.createStatement();
			stat.executeUpdate("UPDATE SHOP SET nameShop= '" + this.name + "', passShop='" + this.password +"' WHERE idShop = "+this.id);
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
}

