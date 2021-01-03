package jspservlet.dao.impl;

import javax.swing.JOptionPane;

import java.sql.*;
import java.sql.Connection;
import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.User;


public class UserDAOImpl implements UserDAO {

	@Override
	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag=0;
		String sql = "select * from userinfo where username=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		
		try {
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				if(rs.getString("password").contentEquals(user.getPassword())) {
					flag=1;
				}
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			
			dbc.close();
		}
		
		return flag;
	}
	
	public int paycheck(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag=0;
		String sql = "select * from userinfo where username=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		
		try {
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				if(rs.getString("paypassword").contentEquals(user.getPaypassword())) {
					flag=1;
				}
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			
			dbc.close();
		}
		
		return flag;
	}
	
	
	public void addUser(User user) {
		DBConnect connection = null;
		PreparedStatement psmt = null;
		try {
			 connection = new DBConnect();
			 
			 String sql  ="insert into userinfo(username,password,paypassword,email)values(?,?,?,?);";
			 
			 psmt =connection.getConnection().prepareStatement(sql);
			 
			 //����ʵ�������в�����ֵ
			
			 psmt.setString(1, user.getUsername());
			 psmt.setString(2,user.getPassword());
			 psmt.setString(3,user.getPaypassword());
			 psmt.setString(4,user.getEmail());

			 psmt.executeUpdate();		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}	
	public int select(String name) { 
		String sql = "select * from userinfo ";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		int result=0;
		
		try { 
		/*��ȡDBConnection������Ӷ���*/ 
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
	    	String username1 = rs.getString("username");
			if(username1.equals(name)) {
		    result=1;
		    break;
			}
		     else{ 
		     result=0; 
		   } 	
		}
		}catch (Exception ee) { 
		result=0; 
		}
		return result; 
		}
	
	public void change(User user) {
		DBConnect connection = null;
		PreparedStatement psmt = null;
		try {
			 connection = new DBConnect();
			 
			 String sql  ="update userinfo set password=?where username=?";
			 
			 psmt =connection.getConnection().prepareStatement(sql);
			 
			 //����ʵ�������в�����ֵ
			 psmt.setString(1, user.getPassword1());
			 psmt.setString(2,user.getUsername());
			 //ִ��
			 psmt.executeUpdate();		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}	


}
