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

	<title>Prompt</title>
	
	<!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/tooplate-main.css">
    <link rel="stylesheet" href="assets/css/owl.css">
</head>

<body>

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
         <body style="background-color:#3a8bcd7d;"></body>
   
 <div class="subscribe-form">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
              <div class="line-dec"></div>
              <h1>Changed successfully!</h1>
            </div>
          </div>
          <div class="col-md-8 offset-md-2">
            <div class="main-content">
              <p>Go back to home or login:</p></br>
              <div class="container">
                <form method="post" action="./login">
                  
                    
                    <fieldset >
                        <div class="main-button"><a href="login.jsp">login</a></div><br><br>
                        <div class="main-button"><a href="index.jsp">home</a></div>
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




