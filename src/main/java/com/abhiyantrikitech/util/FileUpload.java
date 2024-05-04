package com.abhiyantrikitech.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
String status="";
String attachmentFilePath= "C://temp//";
//String validExtn= ".jpeg|.JPEG|.jpg|.JPG|.gif|.GIF|.bmp|.BMP|.png|.png";
String validExtn= ".JPEG|.JPG|.GIF|.BMP|.PNG";
String validFileExtn= ".PDF|.ZIP"; 
String validXlsExtn= ".XLSX|.XLS"; 
String validVideoExtn= ".MP4";
String validExtnEssay= ".JPEG|.JPG|.GIF|.BMP|.PNG|.DOC|.DOCX|PDF";
String validIdentityProof= ".JPEG|.JPG|.PNG|.PDF";

	public String fileUpload (MultipartFile file,String filePath,String newFileName)
	{
	try {
		if (file.isEmpty()) {
			status= "Please select file for upload";
			return status;
        }
		
		String msg=fileValidation(file,"Image");
		if (!msg.equals("")) {
			status= msg;
			return status;
        }
		System.out.println("---status---"+status);
       
    	   if (filePath.equals("")||filePath.equals("null"))
    	   {
    		   filePath=attachmentFilePath;
    	   }
           byte[] bytes = file.getBytes();
           Path path = Paths.get(filePath + file.getOriginalFilename());
           
           File theDir = new File(filePath);
           if (!theDir.exists()){
        	   boolean dirCreated =theDir.mkdirs();
        	   System.out.println("image Folder create status=="+dirCreated);
           }
           
          
          // if (!Files.isExecutable(path))
          // {
        	   Files.write(path, bytes);
        	   Path tpath = Paths.get(filePath + newFileName);
        	   Files.move(path, tpath);
          /* }
           else
           {
        	   status= "File should not executable";
        	   return status;
           }*/
           
             
           

       } catch (Exception e) {
           e.printStackTrace();
           status= "Error in file upload-"+e.getMessage();
       }
       return status;
		
	}
	
	public String pdfFileUpload (MultipartFile file,String filePath,String newFileName)
	{
	try {
		if (file.isEmpty()) {
			status= "Please select file for upload";
			return status;
        }
		
		String msg=fileValidation(file,"pdf");
		if (!msg.equals("")) {
			status= msg;
			return status;
        }
		System.out.println("---status---"+status);
       
    	   if (filePath.equals("")||filePath.equals("null"))
    	   {
    		   filePath=attachmentFilePath;
    	   }
           byte[] bytes = file.getBytes();
           Path path = Paths.get(filePath + file.getOriginalFilename());
           
           File theDir = new File(filePath);
           if (!theDir.exists()){
        	   boolean dirCreated =theDir.mkdirs();
        	   System.out.println("image Folder create status=="+dirCreated);
           }
           
          // if (!Files.isExecutable(path))
          // {
        	   Files.write(path, bytes);
        	   Path tpath = Paths.get(filePath + newFileName);
        	   Files.move(path, tpath);
          /* }
           else
           {
        	   status= "File should not executable";
        	   return status;
           }*/
           
             
           

       } catch (Exception e) {
           e.printStackTrace();
           status= "Error in file upload-"+e.getMessage();
       }
       return status;
		
	}
	
	public String videoFileUpload (MultipartFile file,String filePath,String newFileName)
	{
	try {
		if (file.isEmpty()) {
			status= "Please select file for upload";
			return status;
        }
		
		String msg=fileValidation(file,"video");
		if (!msg.equals("")) {
			status= msg;
			return status;
        }
		System.out.println("---status---"+status);
       
    	   if (filePath.equals("")||filePath.equals("null"))
    	   {
    		   filePath=attachmentFilePath;
    	   }
           byte[] bytes = file.getBytes();
           Path path = Paths.get(filePath + file.getOriginalFilename());
           
           
           File theDir = new File(filePath);
           if (!theDir.exists()){
        	   boolean dirCreated =theDir.mkdirs();
        	   System.out.println("image Folder create status=="+dirCreated);
           }
           
          // if (!Files.isExecutable(path))
          // {
        	   Files.write(path, bytes);
        	   Path tpath = Paths.get(filePath + newFileName);
        	   Files.move(path, tpath);
          /* }
           else
           {
        	   status= "File should not executable";
        	   return status;
           }*/
           
             
           

       } catch (Exception e) {
           e.printStackTrace();
           status= "Error in file upload-"+e.getMessage();
       }
       return status;
		
	}
	
	
	public String xlsFileUpload (MultipartFile file,String filePath,String newFileName)
	{
	try {
		if (file.isEmpty()) {
			status= "Please select file for upload";
			return status;
        }
		
		String msg=fileValidation(file,"xls");
		if (!msg.equals("")) {
			status= msg;
			return status;
        }
		System.out.println("---status---"+status);
       
    	   if (filePath.equals("")||filePath.equals("null"))
    	   {
    		   filePath=attachmentFilePath;
    	   }
           byte[] bytes = file.getBytes();
           Path path = Paths.get(filePath + file.getOriginalFilename());
           
          // if (!Files.isExecutable(path))
          // {
        	   System.out.println("path="+path);
        	   
        	   File theDir = new File(filePath);
               if (!theDir.exists()){
            	   boolean dirCreated =theDir.mkdirs();
            	   System.out.println("image Folder create status=="+dirCreated);
               }
               
           	   Files.write(path, bytes);
        	   Path tpath = Paths.get(filePath + newFileName);
        	   System.out.println("tpath="+tpath);
        	   Files.move(path, tpath);
          /* }
           else
           {
        	   status= "File should not executable";
        	   return status;
           }*/
           
             
           

       } catch (Exception e) {
           e.printStackTrace();
           status= "Error in file upload-"+e.getMessage();
       }
       return status;
		
	}
	
	public String essayFileUpload (MultipartFile file,String filePath,String newFileName)
	{
	try {
		if (file.isEmpty()) {
			status= "Please select file for upload";
			return status;
        }
		
		String msg=fileValidation(file,"essay");
		if (!msg.equals("")) {
			status= msg;
			return status;
        }
		System.out.println("---status---"+status);
       
    	   if (filePath.equals("")||filePath.equals("null"))
    	   {
    		   filePath=attachmentFilePath;
    	   }
           byte[] bytes = file.getBytes();
           Path path = Paths.get(filePath + file.getOriginalFilename());
           
          // if (!Files.isExecutable(path))
          // {
        	   System.out.println("path="+path);
        	   
        	   File theDir = new File(filePath);
               if (!theDir.exists()){
            	   boolean dirCreated =theDir.mkdirs();
            	   System.out.println("image Folder create status=="+dirCreated);
               }
               
           	   Files.write(path, bytes);
        	   Path tpath = Paths.get(filePath + newFileName);
        	   System.out.println("tpath="+tpath);
        	   Files.move(path, tpath);
          /* }
           else
           {
        	   status= "File should not executable";
        	   return status;
           }*/
           
             
           

       } catch (Exception e) {
           e.printStackTrace();
           status= "Error in file upload-"+e.getMessage();
       }
       return status;
		
	}
	
	public String identityTypeFileUpload (MultipartFile file,String filePath,String newFileName)
	{
	try {
		if (file.isEmpty()) {
			status= "Please select file for upload";
			return status;
        }
		
		String msg=fileValidation(file,"identity");
		if (!msg.equals("")) {
			status= msg;
			return status;
        }
		System.out.println("---status---"+status);
       
    	   if (filePath.equals("")||filePath.equals("null"))
    	   {
    		   filePath=attachmentFilePath;
    	   }
           byte[] bytes = file.getBytes();
           Path path = Paths.get(filePath + file.getOriginalFilename());
           
          // if (!Files.isExecutable(path))
          // {
        	   System.out.println("path="+path);
        	   
        	   File theDir = new File(filePath);
               if (!theDir.exists()){
            	   boolean dirCreated =theDir.mkdirs();
            	   System.out.println("image Folder create status=="+dirCreated);
               }
               
           	   Files.write(path, bytes);
        	   Path tpath = Paths.get(filePath + newFileName);
        	   System.out.println("tpath="+tpath);
        	   Files.move(path, tpath);
          /* }
           else
           {
        	   status= "File should not executable";
        	   return status;
           }*/
           
             
           

       } catch (Exception e) {
           e.printStackTrace();
           status= "Error in file upload-"+e.getMessage();
       }
       return status;
		
	}
	
	public String dateApendFileName(String oldfilename)
	{
		String newfiename="";
		String fienamewithoutextn="";
		String extn="";
		Date todate = new Date();
		DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
		String finaltodate = df.format(todate);
		System.out.println("fnaltodate-"+finaltodate);
		
		int pos = oldfilename.lastIndexOf(".");
		fienamewithoutextn=oldfilename.substring(0, pos);
		extn=oldfilename.substring(pos+1, oldfilename.length());
		
		newfiename=fienamewithoutextn.replaceAll(" ", "_")+"_"+finaltodate+"."+extn;
		newfiename=newfiename.replaceAll("\\s", "_");
		
		return newfiename;
		
	}
	
	public String fileValidation (MultipartFile file,String fileType)
	{
		String Status="";
		boolean flag;
		String fileName=file.getOriginalFilename();
		if( fileName.trim().matches("[a-zA-Z0-9\\s\\.\\[\\]\\(\\)\\_\\-]"))
		{
			Status=fileName+" :File name should have valid special character. Valid special Character are []()_-. ";
			return Status;
	
		}	
		if (fileType.equalsIgnoreCase("Image"))
		{
			if (validExtn != null)
			{
				flag = fileName.toUpperCase().matches("^.+("+validExtn.toUpperCase()+")$");
				if (!flag)
				{
					Status="File extension should be valid and valid extensions are "+validExtn;
					return Status;
				}
			}
		}
		
		else if (fileType.equalsIgnoreCase("video"))
		{	
			if (validVideoExtn != null)
			{   
				
				flag = fileName.toUpperCase().matches("^.+("+validVideoExtn.toUpperCase()+")$");
				if (!flag)
				{
					Status="File extension should be valid and valid extensions are "+validVideoExtn;
					return Status;
				}
				
			}
		}
		
		else if (fileType.equalsIgnoreCase("xls"))
		{
			if (validXlsExtn != null)
			{
				flag = fileName.toUpperCase().matches("^.+("+validXlsExtn.toUpperCase()+")$");
				if (!flag)
				{
					Status="File extension should be valid and valid extensions are "+validXlsExtn;
					return Status;
				}
			}
		}
		else if (fileType.equalsIgnoreCase("essay"))
		{
			if (validExtnEssay != null)
			{
				flag = fileName.toUpperCase().matches("^.+("+validExtnEssay.toUpperCase()+")$");
				if (!flag)
				{
					Status="File extension should be valid and valid extensions are "+validXlsExtn;
					return Status;
				}
			}
		}
		else if (fileType.equalsIgnoreCase("identity"))
		{
			if (validIdentityProof != null)
			{
				flag = fileName.toUpperCase().matches("^.+("+validIdentityProof.toUpperCase()+")$");
				if (!flag)
				{
					Status="File extension should be valid and valid extensions are "+validIdentityProof;
					return Status;
				}
			}
		}
		else
		{
			if (validFileExtn != null)
			{
				flag = fileName.toUpperCase().matches("^.+("+validFileExtn.toUpperCase()+")$");
				if (!flag)
				{
					Status="File extension should be valid and valid extensions are "+validFileExtn;
					return Status;
				}
			}
		}
		
		
		
		return Status;
	
			
	}
	
	public boolean isExecutable(File file) {
		byte[] firstBytes = new byte[4];
		try {
			FileInputStream input = new FileInputStream(file);
			input.read(firstBytes);
			input.close();
			// Check for Windows executable
			if (firstBytes[0] == 0x4d && firstBytes[1] == 0x5a) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
}
