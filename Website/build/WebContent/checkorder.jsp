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

	<title>products</title>
	
	<!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/tooplate-main.css">
    <link rel="stylesheet" href="assets/css/owl.css">
</head>

<body>
<body style="background-color :rgba(0, 58, 255, 0.25)"></body>
	<!-- Pre Header -->
    <div id="pre-header">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="homelogreg">
				<a href="login.jsp">Login</a>|
				<a href="Register.jsp">Register</a>
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
              <a class="nav-link" href="about.html">About Us</a>
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
              <h1>Previous orders</h1>
            </div>
          </div>
          
        </div>
      </div>
    </div>
  
 <%      String username3 = (String)session.getAttribute("username");
         
          ItemsDAOS itemsDao = new ItemsDAOS();
          ArrayList<Items> list = itemsDao.getorder(username3);
          if(list!=null&&list.size()>0){
          for(int i=0;i<list.size();i++){
          Items item = list.get(i);%>
   <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
      <tr>
    
        <td width="70%" valign="top">
          <table>
           
            <tr>
              <td><script>
for (var i=1; i<= 50; i++)
{
document.write ("&nbsp;")
}
</script>Username:<%=username3 %>&nbsp;&nbsp;&nbsp;&nbsp;Order id:<%=item.getOrderid() %>&nbsp;&nbsp;&nbsp;&nbsp;Product id:<%=item.getId()%>&nbsp;&nbsp;&nbsp;&nbsp;Price:<%=item.getPrice()%></td>
            </tr>
  
          </table>
        </td>
     
        <%
   
      }
            }
         %>
   
      </tr>
    </table>
   
 
	
	<div class="page-navigation">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
			<ul>
        	<div class="main-button">
                <a href="products.jsp">back to product</a>
        	</div>
			</ul>
          </div>
        </div>
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


  
</body>
</html>
