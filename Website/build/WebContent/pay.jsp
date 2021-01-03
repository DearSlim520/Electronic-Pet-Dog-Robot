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

	<title>Pay</title>
	
	<!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/tooplate-main.css">
    <link rel="stylesheet" href="assets/css/owl.css">
</head>

<body>
<body style="background-color:#3a8bcd7d;"></body>
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
 
 <div class="subscribe-form">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
              <div class="line-dec"></div>
              <h1>Please pay your order.</h1>
            </div>
          </div>
          <div class="col-md-8 offset-md-2">
            <div class="main-content">
              <p>You need to select one of the three payment methods bellow and input your payment password.</p></br>
              <div class="container">
               <form name="pay1"  method="post" action="./pay" onsubmit="return check1()">
                   <%String id = (String)session.getAttribute("id"); %>
                      
                   
                      Wechat<input type="radio" name="payment1" value="Wechat">
                      Credit card<input type="radio" name="payment1" value="Credit card">
                      Alipay<input type="radio" name="payment1" value="Alipay">
                      username: <input type="text" class="form-control" name="username"/><br>
                      payment password: <input type="password" class="form-control" name="paypassword"/><br><br>
                      <button type="SUBMIT" id="form-submit" class="button">PAY</button><br/>
                </form>

               
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  
	<script >
    function check1(){ 
    var flag=0 ;
    for(i=0;i<pay1.payment1.length;i++) 
    if(pay1.payment1[i].checked==true){ 
        flag=1 ;
        break ;
    } 
    if(!flag){ 
        alert("Please choose a payment way!") ;
        return false ;
    } 
} 
</script>
</body>
</html>


