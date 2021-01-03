package jspservlet.servlet;
import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.*;
import jspservlet.servlet.LoginServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//ÐÞ¸ÄÃÜÂë
public class Changepass extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws IOException, ServletException{
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	   throws IOException, ServletException{
		User user = new User();
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password1"));
		user.setPassword1(req.getParameter("password2"));
	    String password=req.getParameter("password2");
		UserDAO dao = new UserDAOImpl();
		int flag=0;
		try {
			flag = dao.queryByUsername(user);
			if (flag==1&&password.length()>=6&&password.length()<=12) {
			dao.change(user);
			res.sendRedirect("./changed.jsp");
			}else {
				 res.sendRedirect("./font1.jsp");
            	 return;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	


}
