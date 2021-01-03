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

	<title>Login</title>
	
	<!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/tooplate-main.css">
    <link rel="stylesheet" href="assets/css/owl.css">
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
				<a href="Register.jsp" class="yongyin">Register</a>
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
        <img src="assets/images/header-logo.png" alt="">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </nav>

    <!-- Page Content -->
 
 <div class="subscribe-form">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
              <div class="line-dec"></div>
              <h1>Please login your account.</h1>
            </div>
          </div>
          <div class="col-md-8 offset-md-2">
            <div class="main-content">
              <p>If you don't have an account yet, you can click the registration button to register.</p></br>
              <div class="container">
                <form method="post" action="./login">
                  
                    
                    <fieldset >
                        Username:<input name="username" type="text" class="form-control"  >
                        Password:<input name="password" type="password" class="form-control" ><br><br>
                         <button type="submit" id="form-submit" class="button" >Login</button>
                        <a href="Register.jsp">Register</a>|
				<a href="changepassword.jsp">Change your password</a>
                  </fieldset>
                    
                   
                 
                </form>
               
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
 
</body>
</html>