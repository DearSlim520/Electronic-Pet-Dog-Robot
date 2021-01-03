package dao;

import java.sql.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import jspservlet.servlet.LoginServlet;
import entity.Items;
import jspservlet.db.DBConnect;
import jspservlet.vo.User;
public class ItemsDAOS {
    //获取数据库内所有的商品资料
    public ArrayList<Items> getAllItems(){
       DBConnect dbc1 = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Items> list = new ArrayList<>();  //商品集合
        
        try{
            dbc1 = new DBConnect();
            String sql = "select id, name, price, picture from items;";  
            stmt = dbc1.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Items item = new Items();
                item.setId(rs.getString("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getInt("price"));
                item.setPicture(rs.getString("picture"));
                list.add(item);  //加入集合
            }
            
            return list;  //返回集合
            
        }catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}finally {
			dbc1.close();
		}
		
    }
    
    //根据商品编号获取商品资料
    public Items getItemById(String id){
    	DBConnect dbc2 = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            dbc2 = new DBConnect();
            String sql = "select id, name, price, picture, introduct from items where id=?;";  
            stmt = dbc2.getConnection().prepareStatement(sql);
            stmt.setString(1,id);
            rs = stmt.executeQuery();
            if(rs.next()){
                Items item = new Items();
                item.setId(rs.getString("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getInt("price"));
                item.setPicture(rs.getString("picture"));
                item.setIntroduct(rs.getString("introduct"));
                return item;
            }else{
                return null;
            }
            
        }catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}finally {
			dbc2.close();
		}
	
    }
    
    //添加购物车
    public void shopcart(String username,String id,String product,int price){
        DBConnect dbc3 =null;
        PreparedStatement stmt = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        int amounts = 0;
        int sumprice = 0;
        
        try{
            dbc3 = new DBConnect();
            String sql0 = "select * from shoppingcart where username = '"+username+"' and id = '"+id+"';";
            stmt = dbc3.getConnection().prepareStatement(sql0);
            stmt.executeQuery();
            ResultSet rs =  stmt.executeQuery();
            if(rs.next())
            {
            	amounts = rs.getInt("amount")+1;
            	sumprice = amounts*price;
            	String sql1 = "UPDATE shoppingcart SET amount = '"+amounts+"', price = '"+sumprice+"' WHERE username = '"+username+"' AND id = '"+id+"';";
            	stmt1 = dbc3.getConnection().prepareStatement(sql1);
            	stmt1.executeUpdate();
            }
            else
            {
            	 amounts = 1;
            	 String sql2 = "insert into shoppingcart values('"+username+"','"+id+"','"+product+"','1','"+price+"');";  
                 stmt2 = dbc3.getConnection().prepareStatement(sql2);
                 stmt2.executeUpdate();
            }
         
        }catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {	
			dbc3.close();
		}
    }
    
    //获取购物车内容
    public ArrayList<Items> getshopcart(String username1){
        DBConnect dbc4 = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         ArrayList<Items> list = new ArrayList<>();  //商品集合
         
         try{
             dbc4 = new DBConnect();
             String sql = "select username, id , product, amount , price from shoppingcart where username='"+username1+"'; ";  
             stmt = dbc4.getConnection().prepareStatement(sql);
             rs = stmt.executeQuery();
             
             while(rs.next()){
                 Items item = new Items();
                 item.setId(rs.getString("id"));
                 item.setName(rs.getString("product"));
                 item.setSum(rs.getInt("amount"));
                 item.setSumprice(rs.getInt("price"));
                 list.add(item);  //加入集合
             }
             
             return list;  //返回集合
             
         }catch(SQLException e) {
 			System.out.println(e.getMessage());
 			return null;
 		}finally {
 			dbc4.close();
 		}
     }
    
    //获取订单内容
    public ArrayList<Items> getorder(String username2){
        DBConnect dbc5 = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         ArrayList<Items> list = new ArrayList<>();  //商品集合
         
         try{
             dbc5 = new DBConnect();
             String sql = "select * from orderinfo where username='"+username2+"'; ";  
             stmt = dbc5.getConnection().prepareStatement(sql);
             rs = stmt.executeQuery();
             
             while(rs.next()){
                 Items item = new Items();
                 User user = new User();
                 item.setOrderid(rs.getInt("orderid"));
                 user.setUsername(rs.getString("id"));
                 item.setId(rs.getString("id"));
                 item.setName(rs.getString("product"));
                 item.setPrice(rs.getInt("price"));
                 item.setOrdertime(rs.getString("ordertime"));
                 list.add(item);  //加入集合
             }
             
             return list;  //返回集合
             
         }catch(SQLException e) {
 			System.out.println(e.getMessage());
 			return null;
 		}finally {
 			dbc5.close();
 		}
 		
     }
    
  
}
   