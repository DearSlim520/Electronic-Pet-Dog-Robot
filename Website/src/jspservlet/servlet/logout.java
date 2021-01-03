package jspservlet.servlet;




import java.io.IOException;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemsDAOS;
import jspservlet.db.DBConnect;

//ÓÃ»§×¢Ïú

@WebServlet("/logout")
public class logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

        this.doPost(request, response);  

    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	HttpSession session=request.getSession();
    	String log= (String)session.getAttribute("loginstate");
        response.setCharacterEncoding("utf-8");  
        if(log.equals("1")) {
             session.setAttribute("username"," ");
             session.setAttribute("loginstate","0");
             PrintWriter write=response.getWriter();  
             write.println("Logout successfully!");  
             write.flush();  
        }
        else {
        	
        	 PrintWriter write=response.getWriter();  
             write.println("You are not logged in!");  
             write.flush();  
        }
    	
    }  

 

}