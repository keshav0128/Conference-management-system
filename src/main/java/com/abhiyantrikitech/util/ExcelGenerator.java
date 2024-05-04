package com.abhiyantrikitech.util;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.ayt.model.Employee;
 
public class ExcelGenerator {
    
	
	//if header is not null then rowNo should be zero
	public static Workbook writeExcelFile(String excelFilePath,ArrayList header1,ResultSet rs,int columnNo,int rowNo) throws SQLException, EncryptedDocumentException, InvalidFormatException, IOException {
		System.out.println("writeExcelFile ="+excelFilePath);
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        // Excel with .xslx extension
       
       // workbook = new SXSSFWorkbook(); 
            
        // Creating sheet with in the workbook
       // Sheet sheet = workbook.createSheet("Data");
        Sheet sheet = workbook.getSheetAt(0);
        
        int rowCount = sheet.getLastRowNum();
        System.out.println("Last row count is ="+rowCount);
         /*Font and style For Header*/
         Font font = workbook.createFont();
         font.setFontName("VERDANA");
         font.setColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
         font.setBold(true);
         
         CellStyle style = workbook.createCellStyle();
         style.setFont(font);
         style.setWrapText(true);
         style.setAlignment(HorizontalAlignment.CENTER);
         style.setVerticalAlignment(VerticalAlignment.CENTER);
         style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
         style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
         style.setBorderRight(BorderStyle.THIN);
         style.setRightBorderColor(IndexedColors.BLACK.getIndex());
         style.setBorderLeft(BorderStyle.THIN);
         style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
         style.setBorderTop(BorderStyle.THIN);
         style.setTopBorderColor(IndexedColors.BLACK.getIndex());
         style.setBorderBottom(BorderStyle.THIN);
         style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
         
         DataFormat fmt = workbook.createDataFormat();
         style.setDataFormat(fmt.getFormat("@"));
        		//cell.setCellStyle(style);
         
         Row row = null;
         int rowNum;
         if (rowNo==0)
         {
        	 if (header1==null||header1.size()==0) 
        	 {
        		 rowNum = 0;
        	 }
        	 else
        	 {
        		 row = sheet.createRow(0);
                 // Writing header to excel
                 for(int i = 0; i < header1.size(); i++) {
                     // each column 20 characters wide
                     sheet.setColumnWidth(i, 20*256);
                     Cell cell = row.createCell(i);
                     cell.setCellValue((String)header1.get(i));
                     cell.setCellStyle(style);
                 }   
        		 
        		 rowNum = 1;
        	 }
        	
         }
         else
         {
        	  rowNum = rowNo;
         }
         
         
         // Header styling ends
         //Preparing column data for each row
         CellStyle dateStyle = workbook.createCellStyle();
         // Setting format For the date column
         dateStyle.setDataFormat(workbook.getCreationHelper().createDataFormat()
                  .getFormat("dd/MM/yyyy"));
         
         int row_num=rowNum;
         
         while(rs.next()) {
             // create new row
        	// System.out.println("row_num-----------"+row_num);
             row = sheet.createRow(row_num);
            // System.out.println("row=="+row);
             row_num=row_num+1;
            // System.out.println("start column="+columnNo);
             for(int i = 0; i < columnNo; i++) {
            	
               //  System.out.println("column="+i);
            	 row.createCell(i).setCellValue(rs.getString(i+1));
             }
           
         }
        // System.out.println("End Last Row="+sheet.getLastRowNum()); 
         /*FileOutputStream outputStream = null;
         outputStream = new FileOutputStream(excelFilePath);
         workbook.write(outputStream);*/
         return workbook;
    }
	
	private void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
    
   
}