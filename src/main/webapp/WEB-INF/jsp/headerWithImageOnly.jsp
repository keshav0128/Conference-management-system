<!doctype html>
<html lang="en">
  <head>
     <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<link rel="stylesheet" href="css/jquery-ui.css">
	<link rel="stylesheet" href="css/bootstrap-multiselect.css" />
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">    
    <link rel="stylesheet" href="css/nism.css"> 
    <link rel="stylesheet" href="css/footer.css">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/blog/">
    <link rel="stylesheet" href="css/jquery-editable-select.min.css">
  
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    

    <script src="js/fontawesome.js"></script>
    
     <!-- multiple select -->
    <link rel="stylesheet" href="css/tail.select-light.css">
    <script src="js/tail.select-full.min.js"></script>
    
    <script src="js/jquery-1.12.4.js"></script> 
	<Script src="js/jquery.validate.min.js"></Script>
	<script src="js/jquery-ui.js"></script> 
    <script src="js/jquery.dataTables.min.js"></script> 
    	 
    <Script src="js/bootstrap.min.js"></Script>
    <script src="js/bootstrap3-typeahead.min.js"></script>  
    <script src="js/bootstrap-multiselect.js"></script>
    <script src="js/jquery-editable-select.min.js"></script>
    
    
    
    <Script src="js/popper.js"></Script>
    <Script src="js/popper.min.js"></Script>
      
	<script src="js/dataTables.bootstrap4.min.js"></script>
	<script src="js/JsonToCsv.js"></script>
	<script src="js/header.js"></script>
	
	
	<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	      <!-- magnific for image gallery -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css" integrity="sha512-+EoPw+Fiwh6eSeRK7zwIKG2MA8i3rV/DGa3tdttQGgWyatG/SkncT53KHQaS5Jh9MNOT3dmFL0FjTY08And/Cw==" crossorigin="anonymous" />
    

<!-- ======================image upload======================== -->
      <!-- 
       <link rel="stylesheet" type="text/css" href="https://unpkg.com/file-upload-with-preview@4.0.2/dist/file-upload-with-preview.min.css">
       <script src="https://unpkg.com/file-upload-with-preview@4.0.2/dist/file-upload-with-preview.min.js"></script>
      -->
      <link rel="stylesheet" href="css/file-upload-with-preview.min.css">
      <script src="js/file-upload-with-preview.min.js"></script>
      
    <title>${sessionScope.projectName}</title>
  </head>
    <%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1); //prevent caching at the proxy server
%>
  <body>
  
    <input type="checkbox" id="check">


   <!-- =======================new header========================== -->
    
 <nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
 
  <div class="container-fluid">
    <!-- <a class="navbar-brand" href="#">Navbar</a> -->
      <div class="header_brand">
	         <label for="check" class="side_menu_mobile">
	              <!-- <i class="fas fa-bars" id="sideMenu_btn"></i>-->
	               <i class="fas fa-ellipsis-v"></i>
	          </label> 
	                    
	          <a class="navbar-brand" href="#">
                    <img src="images/logo.png"> 
	                        <!-- Kotak -->
	           </a> 
        </div>
        
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span><i class="fas fa-align-left" aria-hidden="true"></i></span>   
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 text-dark">
        <li class="nav-item">
          <!-- <a class="nav-link active" aria-current="page" href="#">Home</a> -->
          <label for="check" class="side_menu_web">
               <i class="fas fa-bars" id="sideMenu_btn"></i>
           </label>
        </li>
       </ul>
 
      <!-- =======================top right content==================== -->
     
               			          
    </div>
  </div>
</nav>

<!-- ====================================================================================== -->


   
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    
  <script>
	// jquery for change the navigation background color when scroll 50px of the document/window
	    $(window).scroll(function(){
	       //$('header').toggleClass('scrolled',$(this).scrollTop() > 60)
	       $('.highlit_text').toggleClass('scrolled',$(this).scrollTop() > 60)
	       $('.search_icon').toggleClass('scrolled',$(this).scrollTop() > 60)
	    });
    </script>
    
     <!-- =====tooltip====== -->
    <script>
    	$(document).ready(function(){
    		$('[data-toggle="tooltip"]').tooltip()
    	})
    </script>
    </body>
</html>