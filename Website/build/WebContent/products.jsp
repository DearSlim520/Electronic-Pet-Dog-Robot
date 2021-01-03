<%@ page language="java" import="java.util.*"  import="jspservlet.servlet.*" import="javax.servlet.http.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ItemsDAOS" %>
<%@ page import="entity.Items"  %>
<!DOCTYPE HTML >
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
     <link rel="stylesheet" href="assets/css/flex-slider.css">
</head>

<body>

<style>
.img-box{
	padding-bottom:100%;
}
.img-box img{
	position:absolute;
    top:0;
	bottom:0;
	left:0;
	right:0;
	width:65%;
	margin:auto;
}
</style>
	<!-- Pre Header -->
    <div id="pre-header">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="homelogreg">
           <%String u = (String)session.getAttribute("username"); %>
				<a href="login.jsp">Login</a>|
				<a href="index.jsp">Home</a>|
				User:<%=u %>
			  </div>
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
              <a class="nav-link" href="about.jsp">About Us</a>
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
              <div class="line-dec"></div>
              <h1> <input type="button" class="yongyin" value=" Order"onclick="window.location.href='checkorder.jsp';"> <input type="button" class="yongyin" value="Cart"onclick="window.location.href='shoppingcart.jsp';"></h1>
            </div>
          </div>
        </div>
      </div>
    </div>
   
    
        <div class="featured container no-gutter">
          <div class="row posts">
          <!-- 商品循环开始  -->
          <%
            ItemsDAOS itemsDao = new ItemsDAOS();
            ArrayList<Items> list = itemsDao.getAllItems();
            if(list!=null&&list.size()>0){
                for(int i=0;i<list.size();i++){
                    Items item = list.get(i);
          %>  
         
           <div id="<%=Integer.valueOf(item.getId()) %>" class="item new col-md-4">
                <div class="featured-item">
                  <a href="single-product.jsp?id=<%=Integer.valueOf(item.getId()) %>"><div class="img-box"><img src="pimages/<%=item.getPicture()%>"></div></a>
                  <h4><a href="single-product.jsp?id=<%=Integer.valueOf(item.getId())  %>"><%=item.getName() %></a></h4>
                  <h6>￥<%=item.getPrice() %></h6>
                </div>
            </div>
         
          <!-- 商品循环结束  -->
          <%
                }
            }  
           %>
             </div>
            </div>
   
  
  

   
    <!-- Featred Page Ends Here -->


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
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
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
    <script src="assets/js/isotope.js"></script>


   
</body>
</html>
