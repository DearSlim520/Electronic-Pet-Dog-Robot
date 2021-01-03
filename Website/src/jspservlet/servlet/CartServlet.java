package jspservlet.servlet;
import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.db.DBConnect;
import jspservlet.vo.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//购物车清算
public class CartServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws IOException, ServletException{
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	   throws IOException, ServletException{
		DBConnect connection = new DBConnect();
		HttpSession session=req.getSession();
		String id2 = (String)session.getAttribute("id2");
		String username1 = (String)session.getAttribute("username");
		String products = (String)session.getAttribute("products");
		Integer sprice = (Integer)session.getAttribute("price1");
		User user = new User();
		user.setUsername(req.getParameter("username"));
		user.setPaypassword(req.getParameter("paypassword"));
		UserDAOImpl dao = new UserDAOImpl();
		int flag=0;
		int orderids=0;
		int total = 0;
		try {
			 PreparedStatement psmt0 = null;
			 String sql0 = "SELECT COUNT(*) total FROM shoppingcart where username=?; ";
			 psmt0 =connection.getConnection().prepareStatement(sql0);	
			 psmt0.setString(1,username1);
			 psmt0.executeQuery();
			 ResultSet rs0 = psmt0.executeQuery();
			 if(rs0.next()) {
			 total=rs0.getInt("total");}
			 session.setAttribute("total",total);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			flag = dao.paycheck(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(total>0) {
			if(flag==1) {
			 PreparedStatement psmt = null;
			 PreparedStatement psmt1 = null;
			 PreparedStatement psmt2 = null;
			 String sql1 = "SELECT * FROM orderinfo  ORDER BY orderid DESC LIMIT 1; ";
			 psmt1 =connection.getConnection().prepareStatement(sql1);	
			 psmt1.executeQuery();
			 ResultSet rs = psmt1.executeQuery();
			 if(rs.next())
			 {
				 orderids=rs.getInt("orderid")+1;
			 }
			 else {orderids=1;}
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 String ordertime = df.format(new Date());
			 String sql2  ="insert into orderinfo(orderid,username,id,product,price,ordertime)values(?,?,?,?,?,?);";
			 psmt =connection.getConnection().prepareStatement(sql2);	
	     	 psmt.setInt(1,orderids);
			 psmt.setString(2,username1);
			 psmt.setString(3,id2);	 
			 psmt.setString(4,products);	 
			 psmt.setInt(5,sprice);	 
			 psmt.setString(6,ordertime);	 
			 psmt.executeUpdate();	
			 String sql3 = "delete from shoppingcart where username=?;";
			 psmt2 =connection.getConnection().prepareStatement(sql3);
			 psmt2.setString(1,username1); 	
			 psmt2.executeUpdate();	
			 res.sendRedirect("./paysuccess.jsp");
			}else if(flag==0){
				res.sendRedirect("./cartpayfail.jsp");
			}
		} else {  res.sendRedirect("./cartempty.jsp");}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}
	
/** 
     * 被调用的方法 
     */  
   
}
