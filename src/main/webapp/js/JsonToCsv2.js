  function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {

    //If JSONData is not an object then JSON.parse will parse the JSON string in an Object

    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;

    var CSV = "";

    //Set Report title in first row or line

    //This condition will generate the Label/Header

    if (ShowLabel) {

    var row = "";

    //This loop will extract the label from 1st index of on array

    for (var index in arrData[0]) {

    if(index!='UserName1')

    //Now convert each value to string and comma-seprated

    row += index + ',';

    }

    row = row.slice(0, -1);

    //append Label row with line break

    CSV += row + '\r\n';

    }

    //1st loop is to extract each row

    for (var i = 0; i < arrData.length; i++) {

    var row = "";

    //2nd loop will extract each column and convert it in string comma-seprated

    for (var index in arrData[i]) {

    if (index != 'UserName1')

    row += '"' + arrData[i][index] + '",';

    }

    row.slice(0, row.length - 1);

    //add a line break after each row

    CSV += row + '\r\n';

    }

    if (CSV == '') {

    alert('Invalid data');

    return;

    }

    //Generate a file name

    var fileName = "";

    //this will remove the blank-spaces from the title and replace it with an underscore

    fileName += ReportTitle.replace(/ /g, "_");

    //Initialize file format you want csv or xls

    var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);

    /*//Running code Only for Chrome
    blob = new Blob([CSV], { type: 'text/csv' }); //new way as anchor tag download not supported in latest chrome so use Blob

    var csvUrl = URL.createObjectURL(blob);  //Now file with proper filename is downloaded with proper extension

    //this trick will generate a temp <a /> tag

    var link = document.createElement("a");

    link.href = csvUrl;

    //set the visibility hidden so it will not effect on your web-layout

    link.style = "visibility:hidden";

    link.download = fileName + ".csv";

    //this part will append the anchor tag and remove it after automatic click

    document.body.appendChild(link);

    link.click();

    document.body.removeChild(link);
    *///End running code only for chrome
    //Other browser including IE,chrome
    var a = document.createElement("a");
    var FILENAME=fileName + ".csv";
    
    if (navigator.msSaveBlob) { // IE10
    //alert('in main');
         navigator.msSaveBlob(new Blob([CSV], { type: "text/csv" }), FILENAME);
     } else if ('download' in a) { //html5 A[download]
     //alert("In chrome")
     
     blob1 = new Blob([CSV], { type: 'text/csv' }); //new way as anchor tag download not supported in latest chrome so use Blob

        var csvUrl = URL.createObjectURL(blob1);
     
         //a.href = csvEncoding + encodeURIComponent(CSV);
         a.href = csvUrl;
         a.download = FILENAME;
         document.body.appendChild(a);
         setTimeout(function() {
             a.click();
             document.body.removeChild(a);
         }, 66);
     } else if (document.execCommand) { // Other version of IE
    // alert('in main other');
         var oWin = window.open("about:blank", "_blank");
         oWin.document.write(csvOutput);
         oWin.document.close();
         oWin.document.execCommand('SaveAs', true, FILENAME);
         oWin.close();
     } else {
         alert("Support for your specific browser hasn't been created yet, please check back later.");
     } 
    
    }
    
    function DownloadReport(dynamicUrl,reportName) {

    $.ajax({

    type: "POST",

    url: dynamicUrl,

    contentType: "application/json; charset=utf-8",

    datatype: 'json',

    data: JSON.stringify({}),

    success: function (result) {

    if (result == '')
    return;
    else
    JSONToCSVConvertor(result, reportName, true);

    },

    error: function (error, a) {

    alert('Error in retrieving data..');

    }

    });

    }
    
    
    function download_csv(csv, filename) {
        var csvFile;
        var downloadLink;

        // CSV FILE
        csvFile = new Blob([csv], {type: "text/csv"});

        // Download link
        downloadLink = document.createElement("a");

        // File name
        downloadLink.download = filename;

        // We have to create a link to the file
        downloadLink.href = window.URL.createObjectURL(csvFile);

        // Make sure that the link is not displayed
        downloadLink.style.display = "none";

        // Add the link to your DOM
        document.body.appendChild(downloadLink);

        // Lanzamos
        downloadLink.click();
    }

    function export_table_to_csv(html, filename) {
    	var csv = [];
    	var row = [];
    	var rows = document.querySelectorAll("table tr");
    	var $headers = document.querySelectorAll("th input");
    	//alert("rows:"+rows);
    	
    	for(var k = 0; k < $headers.length; k++){
    		row.push($headers[k].placeholder);
    	}
    	csv.push(row.join(","));
        for (var i = 1; i < rows.length; i++) {
        	//console.log("th"+rows[i].querySelectorAll("th").length);
        	row = [];
    		var  cols = rows[i].querySelectorAll("td, th");
    		
            for (var j = 0; j < cols.length; j++) 
                row.push(cols[j].innerText);
            
    		csv.push(row.join(","));		
    	}

        // Download CSV
        download_csv(csv.join("\n"), filename);
    }

    

