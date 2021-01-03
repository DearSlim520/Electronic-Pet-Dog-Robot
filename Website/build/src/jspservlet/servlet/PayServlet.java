package jspservlet.servlet;
import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.db.DBConnect;
import jspservlet.vo.*;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PayServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws IOException, ServletException{
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	   throws IOException, ServletException{
		DBConnect connection = new DBConnect();
		HttpSession session=req.getSession();
		String id = (String)session.getAttribute("id");
		String username1 = (String)session.getAttribute("username");
		Integer price = (Integer)session.getAttribute("price");
		User user = new User();
		user.setUsername(req.getParameter("username"));
		user.setPaypassword(req.getParameter("paypassword"));
		UserDAOImpl dao = new UserDAOImpl();
		int flag=0;
		int orderids=0;
		try {
			flag = dao.paycheck(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(flag==1) {
			 PreparedStatement psmt = null;
			 PreparedStatement psmt1 = null;
			 String sql1 = "SELECT * FROM orderinfo  ORDER BY orderid DESC LIMIT 1; ";
			 psmt1 =connection.getConnection().prepareStatement(sql1);	
			 psmt1.executeQuery();
			 ResultSet rs = psmt1.executeQuery();
			 if(rs.next())
			 {
				 orderids=rs.getInt("orderid")+1;
			 }
			 else {orderids=1;}
			 String sql2  ="insert into orderinfo(orderid,username,id,price)values(?,?,?,?);";
			 psmt =connection.getConnection().prepareStatement(sql2);	
	     	 psmt.setInt(1,orderids);
			 psmt.setString(2,username1);
			 psmt.setString(3,id);	 
			 psmt.setInt(4,price);	 
			 psmt.executeUpdate();	
			 res.sendRedirect("./paysuccess.jsp");
			}else if(flag==0){
				res.sendRedirect("./payfail.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}
}
