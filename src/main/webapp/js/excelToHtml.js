 



function ExportToTable(fileid,tableid) {  
     var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.xlsx|.xls)$/;  
     /*Checks whether the file is a valid excel file*/  
     if (regex.test($(fileid).val().toLowerCase())) {  
         var xlsxflag = false; /*Flag for checking whether excel is .xls format or .xlsx format*/  
         if ($(fileid).val().toLowerCase().indexOf(".xlsx") > 0) {  
             xlsxflag = true;  
         }  
         /*Checks whether the browser supports HTML5*/  
         if (typeof (FileReader) != "undefined") {  
             var reader = new FileReader();  
             reader.onload = function (e) {  
                 var data = e.target.result;  
                 /*Converts the excel data in to object*/  
                 if (xlsxflag) {  
                     var workbook = XLSX.read(data, { type: 'binary' });  
                 }  
                 else {  
                     var workbook = XLS.read(data, { type: 'binary' });  
                 }  
                 /*Gets all the sheetnames of excel in to a variable*/  
                 var sheet_name_list = workbook.SheetNames;  
  
                 var cnt = 0; /*This is used for restricting the script to consider only first sheet of excel*/  
                 sheet_name_list.forEach(function (y) { /*Iterate through all sheets*/  
                     /*Convert the cell value to Json*/  
                     if (xlsxflag) {  
                         var exceljson = XLSX.utils.sheet_to_json(workbook.Sheets[y]);  
                     }  
                     else {  
                         var exceljson = XLS.utils.sheet_to_row_object_array(workbook.Sheets[y]);  
                     }  
                     if (exceljson.length > 0 && cnt == 0) {  
                         BindTable(exceljson, tableid);  
                         cnt++;  
                     }  
                 });  
                 $(tableid).show();  
             }  
             if (xlsxflag) {/*If excel file is .xlsx extension than creates a Array Buffer from excel*/  
                 reader.readAsArrayBuffer($(fileid)[0].files[0]);  
             }  
             else {  
                 reader.readAsBinaryString($(fileid)[0].files[0]);  
             }  
         }  
         else {  
             alert("Sorry! Your browser does not support HTML5!");  
         }  
     }  
     else {  
         alert("Please upload a valid Excel file!");  
     }  
 }  
 
 
 function BindTable(jsondata, tableid) {/*Function used to convert the JSON array to Html Table*/  
	 
	 var table = document.getElementById('attrTableStudent');
	 
         
     var columns = BindTableHeader(jsondata, tableid); /*Gets all the column headings of Excel*/  
     for (var i = 0; i < jsondata.length; i++) {  
         var row$ = $('<tr/>');
         var fieldHTML="";
         
         var rowLength = table.rows.length;
         console.log("rowLength"+rowLength);
         rowLength=rowLength-1;
         
         for (var colIndex = 0; colIndex < columns.length; colIndex++) {  
             var cellValue = jsondata[i][columns[colIndex]];  
             if (cellValue == null)  
                 cellValue = "";
             
             /*Code for custom columns*/
             if(colIndex==0){//studentName column
				    fieldHTML="<input type='text' class='form-control form-control-sm' name='studentDetails["+rowLength+"].studentName' id='studentDetails["+rowLength+"].studentName' value='"+cellValue+"' required>";
				    row$.append($('<td/>').html(fieldHTML));
             }else if(colIndex==1){//studentStream column
					fieldHTML="<input type='text' class='form-control form-control-sm' name='studentDetails["+rowLength+"].studentStream' id='studentDetails["+rowLength+"].studentStream' value='"+cellValue+"' required>";
					row$.append($('<td/>').html(fieldHTML));
             }else if(colIndex==2){//studentMobile column
					fieldHTML="<input type='text' class='form-control form-control-sm' name='studentDetails["+rowLength+"].studentMobile' id='studentDetails["+rowLength+"].studentMobile' value="+cellValue+" required>";
					row$.append($('<td/>').html(fieldHTML));
             }else if(colIndex==3){//studentEmail column
					fieldHTML="<input type='text' class='form-control form-control-sm' name='studentDetails["+rowLength+"].studentEmail' id='studentDetails["+rowLength+"].studentEmail' value="+cellValue+" required>";
					row$.append($('<td/>').html(fieldHTML));
             }else if(colIndex==4){//studentYear column
					fieldHTML="<input type='text' class='form-control form-control-sm' name='studentDetails["+rowLength+"].studentYear' id='studentDetails["+rowLength+"].studentYear' value="+cellValue+" required>";
					row$.append($('<td/>').html(fieldHTML));
             }else if(colIndex==5){//studentMarks column
					fieldHTML="<input type='text' class='form-control form-control-sm' name='studentDetails["+rowLength+"].studentMarks' id='studentDetails["+rowLength+"].studentMarks' value="+cellValue+" required>";
					row$.append($('<td/>').html(fieldHTML));
					fieldHTML="<div class='last_td'><input type='radio' name='record' class='fas fa-times check-row'  id='delete-filter' onclick='deleteRowStudent();'></div>";
					row$.append($('<td/>').html(fieldHTML));
             }
             
             
				 /*else if(colIndex==5){//studentMarks column
						fieldHTML="<input type='radio' name='record' class='fas fa-times check-row'  id='delete-filter' onclick='deleteRowStudent();'>";
				//<td class='last_td'><input type='radio' name='record' class='fas fa-times check-row'  id='delete-filter' onclick='deleteRowStudent();'></td>
				 }*/
				 
         // row$.append($('<td/>').html(fieldHTML));  // cellValue
         }  
         $(tableid).append(row$);  
     }  
 }  
 function BindTableHeader(jsondata, tableid) {/*Function used to get all column names from JSON and bind the html table header*/  
     var columnSet = [];  
     var headerTr$ = $('<tr/>');  
     for (var i = 0; i < jsondata.length; i++) {  
         var rowHash = jsondata[i];  
         for (var key in rowHash) {  
             if (rowHash.hasOwnProperty(key)) {  
                 if ($.inArray(key, columnSet) == -1) {/*Adding each unique column names to a variable array*/  
                     columnSet.push(key);  
                     // header not required headerTr$.append($('<th/>').html(key));  
                 }  
             }  
         }  
     }  
     //header not required $(tableid).append(headerTr$);  
     return columnSet;  
 }  


