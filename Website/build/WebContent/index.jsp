<%@ page language="java" import="java.util.*"  import="jspservlet.servlet.*" import="javax.servlet.http.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ItemsDAOS" %>
<%@ page import="entity.Items"  %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">
	
	<title>Robot Dog</title>
	
	<!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/tooplate-main.css">
    <link rel="stylesheet" href="assets/css/owl.css">
</head>

<body>
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
        document.getElementById("btn2").onclick=function(){  
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
            xhr.open("GET","logout"+"?time="+new Date().getTime());  
            //4.向服务器发出请求  
            xhr.send();  
        }  
    }  
    </script>

<%String log = (String)session.getAttribute("loginstate");
if(log==null){session.setAttribute("loginstate","0");}%>
<%String u = (String)session.getAttribute("username"); %>
	<!-- Pre Header -->
    <div id="pre-header">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            
			  <div class="homelogreg">
				<input type="button" class="yongyin" value="Login"onclick="window.location.href='login.jsp';">|
				<input type="button" class="yongyin" value="Register"onclick="window.location.href='Register.jsp';">|
				<button id="btn2" class="yongyin" >Logout</button>|
				User:<%=u%>
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
            <li class="nav-item active">
              <a class="nav-link" href="index.jsp">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="products.jsp">Products</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="about.html">About Us</a>
            </li> 
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <!-- Banner Starts Here -->
    <div class="banner">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="caption">
              <h2>Intelligent Robot</h2>
              <div class="line-dec"></div>
              <p>Pixie HTML Template can be converted into your desired CMS theme. Total <strong>5 pages</strong> included. You can use this Bootstrap v4.1.3 layout for any CMS. 
              <br><br>Please tell your friends about <a rel="nofollow" href="#">Tooplate</a> free template site. Thank you. Photo credit goes to <a rel="nofollow" href="#">Pexels website</a>.</p>
              <div class="main-button">
                <a href="products.jsp">Order Now!</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Banner Ends Here -->
    
    <!-- Featured Starts Here -->
    <div class="featured-items">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
              <div class="line-dec"></div>
              <h1>Featured Items</h1>
            </div>
          </div>
        
          <div class="col-md-12">
            <div class="owl-carousel owl-theme">
            <%
            ItemsDAOS itemsDao = new ItemsDAOS();
            ArrayList<Items> list = itemsDao.getAllItems();
            if(list!=null&&list.size()>0){
                for(int i=0;i<list.size();i++){
                    Items item = list.get(i);
             %> 
                <div class="featured-item">
                <a href="products.jsp">
                 <img src="pimages/<%=item.getPicture()%>"width="120" height="180">
                  <h4><%=item.getName() %></h4>
                  </a>
                </div>
          <%
                }
            }  
           %>
            </div>
          </div>
         
        </div>
      </div>
    </div>
    <!-- Featred Ends Here -->


    <!-- Subscribe Form Starts Here -->
    
    <!-- Subscribe Form Ends Here -->


    
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
          <div class="col-md-12">
            <div class="social-icons">
              <ul>
                <li><a href="https://www.baidu.com/index.jsp"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                <li><a href="#"><i class="fa fa-rss"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Footer Ends Here -->


    <!-- Sub Footer Starts Here -->
    
    <!-- Sub Footer Ends Here -->


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


    <!-- Additional Scripts -->
    <script src="assets/js/custom.js"></script>
    <script src="assets/js/owl.js"></script>


    <script > 
      cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
      function clearField(t){                   //declaring the array outside of the
      if(! cleared[t.id]){                      // function makes it static and global
          cleared[t.id] = 1;  // you could use true and false, but that's more typing
          t.value='';         // with more chance of typos
          t.style.color='#fff';
          }
      }
    </script>
</body>
</html>
