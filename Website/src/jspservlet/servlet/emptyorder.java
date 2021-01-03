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


//Çå¿Õ¶©µ¥
@WebServlet("/emptyorder")
public class emptyorder extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public emptyorder() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

        this.doPost(request, response);  

    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	HttpSession session=request.getSession();
    	String username1 = (String)session.getAttribute("username");
    	DBConnect connection = new DBConnect();
    	try {
    	PreparedStatement psmt = null;
        String sql = "delete from orderinfo where username=?;";
		psmt =connection.getConnection().prepareStatement(sql);
		psmt.setString(1,username1); 	
		psmt.executeUpdate();	
        response.setCharacterEncoding("utf-8");  
        PrintWriter write=response.getWriter();  
        write.println("Your order  has been deleted.");  
        write.flush();  
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
    }  

 

}
