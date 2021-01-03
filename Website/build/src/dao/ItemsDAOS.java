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
            String sql = "select * from items;";  //sql语句
            stmt = dbc1.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Items item = new Items();
                item.setId(rs.getString("id"));
                item.setName(rs.getString("name"));
                item.setCity(rs.getString("city"));
                item.setPrice(rs.getInt("price"));
                item.setNumber(rs.getInt("number"));
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
            String sql = "select * from items where id=?;";  //sql语句
            stmt = dbc2.getConnection().prepareStatement(sql);
            stmt.setString(1,id);
            rs = stmt.executeQuery();
            if(rs.next()){
                Items item = new Items();
                item.setId(rs.getString("id"));
                item.setName(rs.getString("name"));
                item.setCity(rs.getString("city"));
                item.setPrice(rs.getInt("price"));
                item.setNumber(rs.getInt("number"));
                item.setPicture(rs.getString("picture"));
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
    
    
    public void shopcart(String username,String id,int price){
        DBConnect dbc3 =null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            dbc3 = new DBConnect();
            String sql = "insert into shoppingcart values('"+username+"','"+id+"','1','"+price+"');";  //sql语句
            stmt = dbc3.getConnection().prepareStatement(sql);
            stmt.executeUpdate();
         
        }catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {	
			dbc3.close();
		}
    }
    public ArrayList<Items> getshopcart(String username1){
        DBConnect dbc4 = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         ArrayList<Items> list = new ArrayList<>();  //商品集合
         
         try{
             dbc4 = new DBConnect();
             String sql = "select username, id , sum(amount) as sum , sum(price) as sumprice from shoppingcart where username='"+username1+"' group by id; ";  //sql语句
             stmt = dbc4.getConnection().prepareStatement(sql);
             rs = stmt.executeQuery();
             
             while(rs.next()){
                 Items item = new Items();
                 item.setId(rs.getString("id"));
                 item.setSum(rs.getInt("sum"));
                 item.setSumprice(rs.getInt("sumprice"));
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
    public ArrayList<Items> getorder(String username2){
        DBConnect dbc5 = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         ArrayList<Items> list = new ArrayList<>();  //商品集合
         
         try{
             dbc5 = new DBConnect();
             String sql = "select * from orderinfo where username='"+username2+"'; ";  //sql语句
             stmt = dbc5.getConnection().prepareStatement(sql);
             rs = stmt.executeQuery();
             
             while(rs.next()){
                 Items item = new Items();
                 User user = new User();
                 item.setOrderid(rs.getInt("orderid"));
                 user.setUsername(rs.getString("id"));
                 item.setId(rs.getString("id"));
                 item.setPrice(rs.getInt("price"));

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
   