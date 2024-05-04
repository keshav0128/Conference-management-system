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
    

    <title>Role Master</title>

    
    
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
			            Role Master
			          </div>
			          <div class="action">
			                    
			            <a href="createRoleMasterLink"><span><i class="fas fa-plus"></i></span>Add New Role</a>
			           
			            <!-- <a href="#" onclick ="ExportButton('#mydatatable','RoleList.csv');"><span><i class="fas fa-file-csv"></i></span>download file </a>-->
			          </div> 
			          
		        </div>
		        <div class="report_container">
		          <div class="table_outer"> 
		            <table class="table table-sm table-bordered table-striped roleList" id="mydatatable">
		              <thead> 
		                 <tr>
		                                 <th scope="col" >View</th> 
		                                 <th scope="col" >Role Name</th>
		                                 <th scope="col" >Status</th>
					                     <th scope="col" >Create Date</th>			                     
					                     <th scope="col" >Create By</th>
					                     <th scope="col" >Last Update Date</th>
					                     <th scope="col" >Last Update By</th>
					                         
		                 </tr>       
		              </thead>
		              <tbody>
		 
		                  <c:forEach items="${data}" var="userListData" varStatus="status">
			                            <tr>
			                            
			                               	<td class="action_td">	
					                       	     <form action="viewRole" method="post" name="viewformsubmit" id="viewformsubmit">
			                                       	  <button class="" id="submitButton" type="submit" ><i class="fas fa-eye" title="View" data-toggle="tooltip"></i></button>
				                                      <input type="hidden" name="roleId" id="roleId" value="${userListData.roleId}">
				                        		 </form>					                        					
			                                 </td>	
			                                <td data-col-title="Role Name">${userListData.roleName}</td>
			                                <td data-col-title="Status">${userListData.roleStatus}</td>
					                        <td data-col-title="Create Date">${userListData.createDt}</td>	                                 
					                        <td data-col-title="Create By">${userListData.createBy}</td>
					                        <td data-col-title="Last Update Date">${userListData.lastUpdateDt}</td>
					                        <td data-col-title="Last Update By">${userListData.lastUpdateBy}</td>
					                                                              
			                                       	                                     
			                                 <input type="hidden" name="buttonAction" id="buttonAction"></input>
		
		                  
		                     <!-- ========GRID============== -->   
											      
			                                   
			                               
			                            </tr>
			                           
									</c:forEach>
		              </tbody>
		            </table>
		          </div>
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
        	$('.roleMaster').addClass("activeLink");
        	//$('.home').removeClass("activeLink");
        	$('.accordion-item-masters .accordion-button').addClass("active");
    	 })
    </script>

  <script type="text/javascript">
   
   
   $(document).ready(function(){
	   
	   //alert("userlist working...");

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
            info:true,
            responsive: true,
            lengthMenu:[[10,25,50,-1] , [10,25,50,"All"]] ,
            fixedHeader: {
                header: true,
                //footer: true
            },
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

function formSubmit(){
alert("formSubmit");
	$('#formsubmit').submit();
};

</script>
</body>
</html>