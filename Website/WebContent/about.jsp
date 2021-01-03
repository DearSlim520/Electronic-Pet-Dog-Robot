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
	
	<title>about dog</title>
	
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
 
              <h1>About Dog</h1>
            </div>
          </div>
          <div class="col-md-6">
            <div class="left-image">
             <%   //<img src="proimages/poster.jpg" ></img> %>
              <video width="550" height="400" src="video/dog.mp4" controls="controls"></video> 
              
            </div>
          </div>
          <div class="col-md-6">
            <div class="left-image">
              <h4>User Manual</h4>
              1.1 Infrared remote control<br>It is the most fundamental way to give Ulrica orders which includes the basic actions such as go forward and stop, operation modes switchover and other services. The corresponding keys of each function are displayed in the picture.
              <p><img src="proimages/control.jpg" ></img></p>
              <br>
              1.2 Bluetooth voice control
             <p><img src="proimages/form1.jpg" ></img></p>
             <br>
             1.3 Voice module control (Advanced)<br>Users who bought an extra voice module are able to control Ulrica by voice command easily as well as getting speech information service. And the specific usages will be illustrated in the table.
             <p><img src="proimages/form2.jpg" ><img src="proimages/form3.jpg" ></img></p>
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
          
         
        </div>
      </div>
    </div>
    <!-- Footer Ends Here -->


   


   

</body>
</html>
