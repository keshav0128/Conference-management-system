<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">
    

    <title>User List</title>

    
    
    <style>
    	#search_input_header{
    		display:none;
    	}
    </style>

</head>
  <%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1); //prevent caching at the proxy server
%>
<body>


 		<%@ include file ="header.jsp" %> 
	 
    
  	
<!-- =============menu============= -->  
 
  <%@ include file ="sideMenu.jsp" %>

<!-- =============================== -->  

  
  <div class="content" name="fr">
  
     <div class="content_container">
     
       <!-- =================repor jsp===================== -->
		<section class="income-section result_div">
	      <div class="container-fluid">
	        <div class="card">
	          <div class="card-header result_header">
	          
		          <div class="card-text">
		           All Users
		          </div>	          
		          <div class="action">
			           <a href="register"><span><i class="fas fa-plus"></i></span>Add New User</a>
			           
			            <!-- <a href="#" onclick ="ExportButton('#mydatatable','UserList.csv');"><span><i class="fas fa-file-csv"></i></span>download file </a>-->
			          </div>
		          
		       </div> 
		       	
		       	
		       	  <c:if test = "${successMessage != null || errorMessage!= null }">
		 	
			               <!-- Modal -->
							<div class="modal   alert_modal" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="staticBackdropLabel">Message!</h5>
							        <c:if test = "${errorMessage!= null }">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="closeAlertModal">
								          <span aria-hidden="true"><i class="fas fa-times"></i></span>
								        </button>
								    </c:if>   
								    <c:if test = "${successMessage!= null }">
							        	  <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="closeAlertModal">
								          <span aria-hidden="true"><i class="fas fa-times"></i></span>
								        </button>
							       </c:if>	 
						
							      </div>
							      <div class="modal-body">
							         <p><span style="color:#2ECC71;">${successMessage}</span> <span style="color:#E74C3C;"> ${errorMessage}</span> </p>
							      </div>
							      <div class="modal-footer">
							      <c:if test = "${errorMessage!= null }">
							        	<button type="button" class="btn btn-sm" data-dismiss="modal" id="closeAlertModalbtn">Close</button>
							       </c:if>	
							       
							       <c:if test = "${successMessage!= null }">
							        	<button type="button" class="btn btn-sm" data-dismiss="modal" id="closeAlertModalbtn">Close</button>
							       </c:if>	       
							      </div>
							    </div>
							  </div>
							</div>
		
			
		
		</c:if> 
		     
	        <div class="report_container">
	          <div class="table_outer"> 
	            <table class="table table-sm table-bordered table-striped allResourcePersonList" id="mydatatable">
	              <thead> 
	                 <tr>
	                      
	                                
	                                 <th scope="col" >View</th> 
		                                 <th scope="col" >User Name</th>
		                                 <th scope="col" >Mobile No</th>
					                     <th scope="col" >User Role</th>			                     
					                     <th scope="col" >Login Id</th>
					                     <th scope="col" >Email Id</th>
					                     <th scope="col" >Create Date</th>
					                     <th scope="col" >Last Update Date</th>
					                     <th scope="col" >Status</th>
					                     <th scope="col" >Send Register Email</th>   

	                                      
				                        
	                 </tr>       
	              </thead>
	              
	              <!--  
	              <tbody>
	 
	                   <c:forEach items="${userList}" var="userListData" varStatus="status">
			                            <tr>
			                                <td data-col-title="View">
			                                <input type="hidden" name="buttonAction" id="buttonAction"></input>
					                        	  <form action="viewRegister" method="post" name="viewformsubmit" id="viewformsubmit">
			                                       		    <button class="" id="submitButton" type="submit" ><i class="fas fa-eye" title="View" data-toggle="tooltip"></i></button>
				                                       		<input type="hidden" name="userId" id="userId" value="${userListData.userId}">
				                        					<input type="hidden" name="loginId" id="loginId" value="${userListData.loginId}">
												  </form>	
			                                 </td>                                       	                                     
			                               
			                                <td data-col-title="User Name">${userListData.userName}</td>
			                                <td data-col-title="Mobile No">${userListData.mobileNo}</td>
					                        <td data-col-title="User Role">${userListData.roleName}</td>	                                 
					                        <td data-col-title="Login Id">${userListData.loginId}</td>
					                        <td data-col-title="Create Date">${userListData.creatDate}</td>
					                        <td data-col-title="Last Update Date">${userListData.lastUpdateDate}</td>
					                        <td data-col-title="Status">${userListData.status}</td>
					                        <td data-col-title="Send Email">
					                       
						                         <form action="SendRegisterEmail" method="post" name="viewformsubmit" id="viewformsubmit">
		                                       		    <button class="" id="submitButton" type="submit" onClick="validationOnSubmit();">Send Email</button>
			                                       		<input type="hidden" name="userId" id="userId" value="${userListData.userId}">
			                        					<input type="hidden" name="loginId" id="loginId" value="${userListData.loginId}">
			                        					<input type="hidden" name="roleId" id="roleId" value="${userListData.roleId}">
			                        					<input type="hidden" name="subjectId" id="subjectId" value="${userListData.subjectId}">
												</form>		 	
			                                 </td>
					                         
		
		                                            
			                               
			                            </tr>
			                           
									</c:forEach>
	              </tbody>
	              -->
	            </table>
	          </div>
	        </div>
	    </div>
	    </section>
	    
	 </div>   
  
  </div>  
 

<!-- =============footer========== -->
 <%@ include file ="footer.jsp" %> 
<!-- =============footer============= --> 
    <!-- =====tooltip====== -->
    <script>
    	$(document).ready(function(){
    		$('[data-toggle="tooltip"]').tooltip();
        	//$('[data-toggle="tooltip"]').tooltip();
        	//alert("working...")
        	$('#flush-collapseOne').addClass("show");
        	$('.userManagement').addClass("activeLink");
        	$('.home').removeClass("activeLink");
        	$('.accordion-item-masters .accordion-button').addClass("active");
    	 })
    </script>
   <script>
     $(document).ready(function(){
    	 $("#closeAlertModal").click(function(){
    		
    		 $('.alert_modal').css('display','none');
    	 })
    	 
    	 
    	 
    	 $("#closeAlertModalbtn").click(function(){
    		
    		 $('.alert_modal').css('display','none');
    	 })
     })
   </script>  
  <script type="text/javascript">
   
   
   $(document).ready(function(){

       // code to read selected table row cell data (values).
       $("#mydatatable").on('click','.btnSelect',function(){
            // get the current row
            var currentRow=$(this).closest("tr"); 
            
            var col1=currentRow.find("td:eq(0)").text(); // get current row 1st TD value
          
            
            $('#societyId').val(this.id);
            $("#formsubmit").submit();
            
            
       });
   });

</script>

  <script>
        $('#mydatatable').DataTable({ 
            searching:true,
            ordering:true,
            // info:false,
            lengthMenu:[[10,25,50,-1] , [10,25,50,"All"]] ,
            "processing": true,
            "serverSide": true,
            "ajax": { url: "getUserListServerSidePagination" },
            "columns": [
    			{ "data": "viewLink" },
    			{ "data": "userName" },
    			{ "data": "mobileNo" },
    			{ "data": "roleName" },
    			{ "data": "loginId" },
    			{ "data": "email" },
    			{ "data": "creatDate" },
    			{ "data": "lastUpdateDate" },
    			{ "data": "status" },
    			{ "data": "sendEmailLink" }
            ],
            dom: 'Blfrtip',
            buttons: [
                'copyHtml5',
                'excelHtml5',
                'csvHtml5',
                'pdfHtml5','print'
            ]
            
           });
   </script>

<!-- 
    <script>
    
        var table = $('#mydatatable').DataTable();
          
           
            $('#mydatatable thead tr th').each( function (){
                var title = $(this).text();
                $(this).html('<input type="text" class="form-control form-control-sm search-input" placeholder="Search"/>');  // placeholder="  ' + title + '"
            });
    
            table.columns().every( function () {
                var that = this;
                $('input',this.header()).on('keyup change' , function () {
                    if (that.search() !== this.value ) {
                        that.search( this.value).draw();
                    }
                });
            });

            
            
	
    </script>
-->




<script>


function validationOnSubmit(){

	$("#wait").css("display", "block");
	
}
function formSubmit(){
alert("formSubmit");
	$('#formsubmit').submit();
};

</script>

   
 <div id="wait" style="display:none;width:100%;height:100%;position:fixed;top:0%;left:0%;justify-content:center;align-items:center;background-color:rgba(0,0,0,.3);"><div style="position:absolute; left:50% ; top:50%; transform:translate(-50% , -50%); width:100px;" />
 <img src='images/loading4.gif' width="100%" height="100%"><h3 style="margin-top:.5rem; margin-left:1rem;">Processing..</h3>
 </div>
 
 <script>
$(document).ready(function(){
  $(document).ajaxStart(function(){
    $("#wait").css("display", "block");
  });
  $(document).ajaxComplete(function(){
    $("#wait").css("display", "none");
  });
});



  </script>
</body>
</html>