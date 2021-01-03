package jspservlet.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemsDAOS;

@WebServlet("/addcart1")
public class addcart1 extends HttpServlet {
//判断登录条件以及调用添加购物车函数
	private static final long serialVersionUID = 1L;

    public addcart1() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

        this.doPost(request, response);  

    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	HttpSession session=request.getSession();
    	String loginstate = (String)session.getAttribute("loginstate");
    	String username1 = (String)session.getAttribute("username");
    	String product = (String)session.getAttribute("product");
    	String id = (String)session.getAttribute("id");
    	Integer price = (Integer)session.getAttribute("price");
        response.setCharacterEncoding("utf-8");  
        ItemsDAOS itemsDao = new ItemsDAOS();
  
if(loginstate.equals("1")) {
	itemsDao.shopcart(username1,id,product,price);
        PrintWriter write=response.getWriter();  
        write.println("Add to Cart successfully!");  
        write.flush();  
}else {
	 PrintWriter write1=response.getWriter();  
     write1.println("You are not logged in!");  
     write1.flush(); 
}

    }  

}
