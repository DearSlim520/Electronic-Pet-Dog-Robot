<%@ page language="java" import="java.util.*"  import="jspservlet.servlet.*" import="javax.servlet.http.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">
	
	<title>More</title>
	
	<!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/tooplate-main.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link rel="stylesheet" href="assets/css/flex-slider.css">
</head>

<body>
<body background = "backimage/back1.jpg"></body>
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
              <a class="nav-link" href="index.jsp" >Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="products.jsp">Products
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="about.jsp">About Dog</a>
              <span class="sr-only">(current)</span>
            </li>
           
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <!-- About Page Starts Here -->
    <div class="about-page">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
 
              <h1>More</h1>
            </div>
          </div>
          <div class="col-md-6">
            <div class="left-image">
             <img src="proimages/poster.jpg" ></img> 

            </div>
          </div>
          <div class="col-md-6">
            <div class="right-content">
              <h4>Division of Main Tasks</h4>
              <p style="text-align:left;"><b>Jianni SONG:</b> built up the motor part of Ulrica, create appearance of Ulrica.
              <br><b>Wentao WU:</b> designed the hardware of Ulrica, do multiple testing job.
              <br><b>Sining HAO:</b> designed the software and hardware of Ulrica.
              <br><b>Huiyi WANG:</b> designed the software and hardware of Ulrica.
              <br><b>Yingqi LI:</b> built up the motor part of Ulrica, create appearance of Ulrica.
              <br><b>Tuo LIANG (back end):</b> designed the log-in, log-out, order, product list, database design part of the PIXIE and participated in integration of the front end and the back end.
              <br><b>Mingyao LI (back end):</b> designed the registration, changing the password, shopping cart, payment progress part of the PIXIE and did the adjustment job.
              <br><b>Xudong LI (front end):</b> designed product, shopping cart, order, company introduction, log-in, log-out, registration, password modification interface design.
              <br><b>Jiajie QIN:</b> build the java programme of IOT, collect data with scrapy, user menu, advertising post and video.
              <br><b>Zhenfei ZHANG:</b> design the database, collecting data for iot database, write report of the java program.</p> 
              <br>
              
              <div class="share">
                <h6>Find us on: <span><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-linkedin"></i></a><a href="#"><i class="fa fa-twitter"></i></a></span></h6>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- About Page Ends Here -->

   

    
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


   


   

</body>
</html>
