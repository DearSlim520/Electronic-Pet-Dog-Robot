<%@ page language="java" import="java.util.*"  import="jspservlet.servlet.*" import="javax.servlet.http.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ItemsDAOS" %>
<%@ page import="entity.Items"  %>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>Product Detail</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/tooplate-main.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link rel="stylesheet" href="assets/css/flex-slider.css">

  </head>

  <body>
  <body style = "background-color:#3399ff29"></body>
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
    <!-- Single Starts Here -->
    <div class="single-product">
      <div class="container">
        <div class="row">
         <%
		    String loginstate = (String)session.getAttribute("loginstate");
		    String username1 = (String)session.getAttribute("username");
		    int flag=0;
            ItemsDAOS itemsDao = new ItemsDAOS();
            String a = request.getParameter("id");
            Items item = itemsDao.getItemById(request.getParameter("id"));
            session.setAttribute("id",request.getParameter("id"));
            session.setAttribute("price",item.getPrice());
            session.setAttribute("product",item.getName());
            if(item!=null){
         %>
          <div class="col-md-12">
            <div class="section-heading">

              <h1>Single Product</h1>
            </div>
          </div>
          <div class="col-md-6">
            <div class="product-slider">
              <div id="slider" class="flexslider">
                <ul class="slides">
                  <li>
                    <img src="proimages/<%=item.getPicture()%>"/>
                  </li>
                  <!-- items mirrored twice, total of 12 -->
                </ul>
              </div>
              <div id="carousel" class="flexslider">
            
              </div>
            </div>
          </div>
          
          <div class="col-md-6">
            <div class="right-content">
              <h4><%=item.getName() %></h4>
              <h6>￥<%=item.getPrice() %></h6>
              <p><%=item.getIntroduct() %></p>
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
            xhr.open("GET","addcart1"+"?time="+new Date().getTime());  
            //4.向服务器发出请求  
            xhr.send();  
        }  
    }  
    </script>

              <input type="button" class="yongyin" value="Buy Now!"onclick="window.location.href='pay.jsp';">
              <button id="btn1" class="yongyin" >Add to cart</button>
              <input type="button" class="yongyin" value="Check cart"onclick="window.location.href='shoppingcart.jsp';">
     
              <div class="down-content">
                
              <div class="share">
                  <h6>Share: <span><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-linkedin"></i></a><a href="#"><i class="fa fa-twitter"></i></a></span></h6>
                </div>
              </div>
            </div>
          </div>
           <%
            }
         %>
        </div>
      </div>
    </div>
    <!-- Single Page Ends Here -->


    <!-- Similar Starts Here -->
   
    <!-- Similar Ends Here -->


    <!-- Subscribe Form Starts Here -->
    
    <!-- Subscribe Form Ends Here -->


    
    <!-- Footer Starts Here -->
    
    <!-- Footer Ends Here -->


    <!-- Sub Footer Starts Here -->
   
    <!-- Sub Footer Ends Here -->


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


    <!-- Additional Scripts -->
    <script src="assets/js/custom.js"></script>
    <script src="assets/js/owl.js"></script>
    <script src="assets/js/isotope.js"></script>
    <script src="assets/js/flex-slider.js"></script>


 

  </body>

</html>
