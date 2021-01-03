package jspservlet.servlet;
import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws IOException, ServletException{
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		 UserDAOImpl se = new UserDAOImpl();
         String username=request.getParameter("username");  
         String password=request.getParameter("password");
         String paypassword=request.getParameter("paypassword");
         String email=request.getParameter("email");
         int f=se.select(username);
         
         if((null==username||"".equals(username))||(null==password||"".equals(password))||(null==paypassword||"".equals(paypassword))||(null==email||"".equals(email)))
         {
        	 response.sendRedirect("./font.jsp");
        	 return;
         }
        if(username.length()<6||username.length()>12||password.length()<6||password.length()>12||paypassword.length()<6||paypassword.length()>12)
        {
        	response.sendRedirect("./font.jsp");
       	    return;
        }
        if(!email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"))
        {
        	response.sendRedirect("./font.jsp");
        	return;
        }
         char[] ch = username.toCharArray();  
         for (int i = 0; i < ch.length;i++) {  
             if (!((ch[i]>='0'&&ch[i]<='9')||(ch[i]>='a'&&ch[i]<='z')||(ch[i]>='A'&&ch[i]<='Z'))) {  
            	 response.sendRedirect("./font.jsp");
            	 return;
             }  
         }  
         if(f==0) {
         User user=new User();
         user.setUsername(username);
         user.setPassword(password);
         user.setPaypassword(paypassword);
         user.setEmail(email);
         UserDAOImpl userDAO1=new UserDAOImpl(); 
         userDAO1.addUser(user);
         response.sendRedirect("./success.jsp");
         return;
         }
         else {
 			 response.sendRedirect("./fail.jsp");
 			 return;
 		}
	}

}
