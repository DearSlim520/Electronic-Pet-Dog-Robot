package com.miniterm;
import java.sql.*;
import com.qjj.jdbc.*;

public class INSERTTOaddSJ {
	private int id;
	private String name;
	private String password;
	
	private Connection conn;
    private Statement stat;
    
    public INSERTTOaddSJ(int id, String name, String password) {
    	this.id = id;
    	this.name = name;
    	this.password = password;
    }
    
    public void insert(int gly) {
    	conn = testconnction.getConnection();
		try {
			stat = conn.createStatement();
			stat.executeUpdate("INSERT INTO SHOP VALUES ('" + this.id + "', '" + this.name + "', '" + this.password + "', 1)");
			stat.close();
			conn.close();
			GLY g =new GLY(gly);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			T2 t = new T2(gly);
			e.printStackTrace();
		}
		
    }
}
