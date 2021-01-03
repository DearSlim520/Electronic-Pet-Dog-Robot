package jspservlet.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    static final String DB_URL = "jdbc:mysql://localhost:3306/shopping";
	    static final String USER = "root";
	    static final String PASS = "123qwe";
	    
	private Connection conn = null;
	
	public DBConnect() {
		try {
			Class.forName(JDBC_DRIVER);
			this.conn=DriverManager.getConnection(DB_URL,USER,PASS);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	public void close() {
		try {
			this.conn.close();
		}catch(Exception e) {}
	}
}
