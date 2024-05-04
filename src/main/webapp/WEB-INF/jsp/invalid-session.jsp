<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	<!-- main-css -->
	<link rel="stylesheet" href="css/page-not-found.css">

    <title>Invalid Session</title>
  </head>
  <style>
  	   @media only screen and (max-width:980px){
    		.error-404 h1{
    			font-size:70px;
    			font-weight:bold;
    		}
    		.error-404 h3{
    			font-size:20px;
    			margin:20px 0px;
    			font-weight:500;
    		}
    	}
  </style>
  <body>
  
  <header>
      <div class="container">
          <a class="navbar-brand" href="#">
                    <img src="images/logo.png"> 
	                        <!-- Kotak -->
	      </a> 
      </div>
  </header>
  <section class="cmspage">
    <div class="container">
    
        
	      <div class="error-404">
	       
	        <!-- <h2>There is nothing here!</h2>
	        <p>Sorry, the page you were looking i.e. does not exist.</p>-->
	        <c:if test="${errorMessage!=null}">
	        	<div class="alert alert-danger">${errorMessage}</div>
	        </c:if>
	        
	         <c:if test="${errorMessage==null}">
	        	<div class="alert alert-warning">Session is expired,Please login again.</div>
	        </c:if>
	      </div>
	      	      
    </div>
  </section>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>
