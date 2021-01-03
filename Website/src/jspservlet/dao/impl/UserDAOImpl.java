package jspservlet.dao.impl;



import java.sql.*;
import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.User;

//验证用户名密码是否匹配
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
	
	//支付验证
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
	
	//添加新用户
	public void addUser(User user) {
		DBConnect connection = null;
		PreparedStatement psmt = null;
		try {
			 connection = new DBConnect();
			 
			 String sql  ="insert into userinfo(username,password,paypassword,email)values(?,?,?,?);";
			 
			 psmt =connection.getConnection().prepareStatement(sql);

			
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
	
	//查找此用户名是否存在
	public int select(String name) { 
		String sql = "select * from userinfo ";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		int result=0;
		
		try { 
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
	
	//修改密码
	public void change(User user) {
		DBConnect connection = null;
		PreparedStatement psmt = null;
		try {
			 connection = new DBConnect();
			 
			 String sql  ="update userinfo set password=?where username=?";
			 
			 psmt =connection.getConnection().prepareStatement(sql);
			 
			 //运用实体对象进行参数赋值
			 psmt.setString(1, user.getPassword1());
			 psmt.setString(2,user.getUsername());
			 //执行
			 psmt.executeUpdate();		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}	


}
