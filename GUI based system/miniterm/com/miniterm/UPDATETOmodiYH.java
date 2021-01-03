package com.miniterm;
import java.sql.*;
import com.qjj.jdbc.*;

public class UPDATETOmodiYH {
	private int id;
	private String name;
	private String address;
	private String tel;
	
	private Connection conn;
    private Statement stat;
    
    public UPDATETOmodiYH(int id, String name, String address, String tel) {
    	this.id = id;
    	this.name = name;
    	this.address = address;
    	this.tel = tel;
    }
    
    public void insert() {
    	conn = testconnction.getConnection();
		try {
			stat = conn.createStatement();
			stat.executeUpdate("UPDATE USER SET nameUser= '" + this.name + "', addrUser='" + this.address + "', telUser='" + this.tel +"' WHERE idUser = "+this.id);
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
}
