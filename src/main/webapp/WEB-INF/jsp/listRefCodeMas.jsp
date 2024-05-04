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
    

    <title>Ref Code List</title>

    
    
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
	 
       <script>
		  $( function() {
		    
			  $("#datepickerfromdt").datepicker({
		      	changeMonth: true,
		          changeYear: true,
		          dateFormat: "dd-mm-yy",
		          yearRange: "-50:+1"
		          });
		    
		        $("#datepickertodt").datepicker({
		        	changeMonth: true,
		            changeYear: true,
		            dateFormat: "dd-mm-yy",
		            yearRange: "-50:+1"
		            });
		    
		  });
  
 
  </script>
  	
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
			            Reference Code List
			          </div>	          
			          <div class="action">
			            <a href="createRefCodeMas"><span><i class="fas fa-plus"></i></span>Add New Reference Code </a>
			           
			            <!-- <a href="#" onclick ="ExportButton('#mydatatable','Department.csv');"><span><i class="fas fa-file-csv"></i></span>download file </a>-->
			          </div> 
			          
			       </div> 
			       	
			     
		        <div class="report_container">
		          <div class="table_outer"> 
		            <table class="table table-sm table-bordered table-striped allRefCodeList" id="mydatatable">
		              <thead> 
		                 <tr>
		                      
		                                 <th scope="col" >View</th>
		                                 <th scope="col">Type</th>
		                                 <th scope="col">value1</th>
		                                 <th scope="col">value2</th>
		                                 <th scope="col">Description</th>
		                                 <th scope="col">order</th>
		                                 <th scope="col">Status</th>                                
					                          
		                 </tr>       
		              </thead>
		              <tbody>
		 
		                  <c:forEach items="${RefCodeMasList}" var="testData" varStatus="status">
			                         <tr>
			                                
			                                <td class="action_td">	
					                        	  <form action="viewRefCodeMas" method="post" name="viewformsubmit" id="viewformsubmit">
			                                       	
			                                       		    <button class="" id="submitButton" type="submit" ><i class="fas fa-eye" title="View" data-toggle="tooltip"></i></button>
				                                       		<input type="hidden" name="refId" id="refId" value="${testData.refId}">
				                                       		
				                                                             
			                                       </form>	
			                                       
			                                	                                       	                                     
			                                 <input type="hidden" name="buttonAction" id="buttonAction"></input>
											</td>
					                        <td data-col-title="Type">${testData.refType}</td>
					                        <td data-col-title="value1">${testData.refVal1}</td>
					                        <td data-col-title="value2">${testData.refVal2}</td>
					                        <td data-col-title="Description">${testData.refDesc}</td>
					                        <td data-col-title="Order">${testData.refOrder}</td>
					                        <td data-col-title="Status">${testData.refStatus}</td>
					                       
					                        
					                        
		                  
		                     <!-- ========GRID============== -->   
											      
			                                   
			                               
			                            </tr>
			                           
									</c:forEach>
		              </tbody>
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
    		$('#flush-collapseOne').addClass("show");
        	$('.refCodeMaster').addClass("activeLink");
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