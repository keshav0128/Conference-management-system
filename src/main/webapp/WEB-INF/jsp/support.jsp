<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    
<title>AYTBizz Software : Support</title>
</head>
<body>


<!-- =============header========== -->
<%@ include file ="header.jsp" %>
<!-- =============header============= --> 


<!-- =============menu============= -->  
 
  <%@ include file ="sideMenu.jsp" %>

<!-- =============================== -->  
  
  <div class="content" name="fr">

	
	<section class="support_contact">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="card">
						
						<div class="card-body">
							<div class="row support_content_row">
								<div class="col-lg-6 col-md-6 col-sm-12 ayt_logo">
									<div class="ayt_img"></div>
								</div>
								
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="ayt_address">
										<ul>
											<li>
												<h3>Address</h3>
												<p>C 21 Corporate Zone, 3rd Floor , Hoshangabad Road.</p> 
												<p>Bhopal - <span>462026</span> , Madhya Pradesh</p>									
											</li>
											<hr class="contact_line" />
											<!-- <li>
												<h3>Landline Number</h3>
												<a href="07554054110">07554054110</a>
											</li>
											<hr class="contact_line" />-->
											<li>
												<h3>Email</h3>
												<a href="support@abhiyantrikitech.com">support@abhiyantrikitech.com</a>
											</li>
											<hr class="contact_line" />
											<li>
												<h3>Website</h3>
												<a href="http://www.abhiyantrikitech.com">www.abhiyantrikitech.com</a>
											</li>
											<hr class="contact_line" />
											<li>
												<h3>Office Time</h3>
												<p>10:00 A.M to 7:00 P.M</p>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				
				</div>
			</div>
		</div>
	</section>
	
</div>	
	
<!-- =============footer========== -->
 <%@ include file ="footer.jsp" %> 
<!-- =============footer============= --> 

	   <script>
	// jquery for change the navigation background color when scroll 50px of the document/window
	    $(window).scroll(function(){
	       $('header').toggleClass('scrolled',$(this).scrollTop() > 60)
	    });

    </script>
    
    <!-- =====tooltip====== -->
    <script>
    	$(document).ready(function(){
    		$('[data-toggle="tooltip"]').tooltip();
    		$('.support').addClass("activeLink");
    	})
    </script>


</body>
</html>