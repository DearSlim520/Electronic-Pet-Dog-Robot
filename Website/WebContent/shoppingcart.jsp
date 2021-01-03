<%@ page language="java" import="java.util.*"  import="jspservlet.servlet.*" import="javax.servlet.http.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ItemsDAOS" %>
<%@ page import="entity.Items"  %>

<!doctype html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

	<title>products</title>
	
	<!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/tooplate-main.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link rel="stylesheet" href="assets/css/scart.css" />
</head>

<body>
<body background = "backimage/back1.jpg"></body>
  <script>
    function getXHR(){  
        var xmlHttp;  
        try {  
            xmlHttp=new XMLHttpRequest();  
        }catch(e)  
        {  
            try{  
                xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");  
        }  
            catch(e)  
            {  
                try{  
                    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");  
                } 
                catch(e)  
                {  
                    alert("你的浏览器不支持ajax");  
                    return false;  
                }   
            }   
        }  
       return xmlHttp;  

    }  
    window.onload=function(){  
        document.getElementById("btn1").onclick=function(){  
            //发出已补请求  

            //1/得到xhr对象  
            var xhr=getXHR();  
            //2.注册状态变化监听器  
            xhr.onreadystatechange=function(){  
               if(xhr.readyState==4)  
                    {  
                    if(xhr.status==200)  
                        {  
                        
                        alert(xhr.responseText);
                        }         
                    }
            }  
            //3.建立与服务器的连接  
            xhr.open("GET","emptycart"+"?time="+new Date().getTime());  
            //4.向服务器发出请求  
            xhr.send();  
        }  
    }  
    </script>
 
	<!-- Pre Header -->
    <div id="pre-header">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
             <div class="homelogreg">
           <%String u = (String)session.getAttribute("username"); %>
				<a href="login.jsp" class="yongyin">Login</a>
				<a href="index.jsp" class="yongyin">Home</a>
				User:<%=u %>
			  </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
      <div class="container">
        <a class="navbar-brand" href="#"><img src="assets/images/header-logo.png" alt=""></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="products.jsp">Products
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="about.jsp">About Dog</a>
            </li>
           
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <!-- Items Starts Here -->
    <div class="featured-page">
      <div class="container">
        <div class="row">
          <div class="col-md-4 col-sm-12">
            <div class="section-heading">
 
              <h1>Shopping Cart</h1>
            </div>
          </div>
          
        </div>
      </div>
    </div>
    
    <div id="Box">	
	      	<div id="dataDiv" ng-show="isdataShow">
				<table id="dataTable" ng-show="istableShow" border="1px" cellpadding="5" cellspacing="0">
					<thead>
						<tr>
							<td>username</td>
							<td>product id</td>
							<td>product</td>
							<td>amount</td>
							<td>sum price</td>
							
						</tr>
			     	</thead>
			     	
					<tbody >
					 <%      String username2 = (String)session.getAttribute("username");
          session.setAttribute("id2","");
          session.setAttribute("products","");
          session.setAttribute("price1",0);
          ItemsDAOS itemsDao = new ItemsDAOS();
          ArrayList<Items> list = itemsDao.getshopcart(username2);
          if(list!=null&&list.size()>0){
          for(int i=0;i<list.size();i++){
          Items item = list.get(i);%>
						<tr>
							<td><%=username2 %></td>
							<td><%=item.getId() %></td>
							<td><%=item.getName() %></td>
							<td><%=item.getSum()%></td>
							<td><%=item.getSumprice()%></td>
						</tr>
						 <%
         String id2 = (String)session.getAttribute("id2");
         session.setAttribute("id2",id2+"|"+item.getId()+"("+item.getSum()+")");
         String products = (String)session.getAttribute("products");
         session.setAttribute("products",products+"|"+item.getName()+"("+item.getSum()+")");
         Integer price1 = (Integer)session.getAttribute("price1");
         session.setAttribute("price1",price1+item.getSumprice());
      }
            }
         %>
					</tbody>
				</table>
				 <button id="btn1" class="yongyin1">Empty</button> 
				 <%Integer prices = (Integer)session.getAttribute("price1"); %>
				 Total price:<%=prices %>
				 <button class="yongyin2"  onclick="window.location.href='./settlecart.jsp'">Pay</button>    
              </div>
		</div>
  



    
    <!-- Footer Starts Here -->
    <div class="footer">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="logo">
              <img src="assets/images/header-logo.png" alt="">
            </div>
          </div>
          <div class="col-md-12">
            <div class="footer-menu">
              <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Help</a></li>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">How It Works ?</a></li>
              
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Footer Ends Here -->


    <!-- Sub Footer Starts Here -->
  
    <!-- Sub Footer Ends Here -->


  
</body>
</html>
