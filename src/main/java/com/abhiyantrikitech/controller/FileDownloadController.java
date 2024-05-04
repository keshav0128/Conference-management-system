package com.abhiyantrikitech.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class FileDownloadController {
	
	
	@Value("${serverfilepath}")
	private String serverFilePath;
	@Value("${serverfilepathrp}")
	private String serverFilePathRP;
	@Value("${serverfilepathprogram}")
	private String serverFilePathProgram;
	@Value("${serverfilepathtemplate}")
	private String serverFilePathTemplate;
	
	@RequestMapping(value = "downloadRPFile", method = RequestMethod.GET)
    public void downloadRPFile(HttpServletRequest req,HttpServletResponse resp,@ModelAttribute("filename") String filename
    		,@ModelAttribute("mobile") String mobile
    		) throws IOException {
		String FilePath = "";
		String status="";
        FilePath=serverFilePathRP+mobile+"/"+filename;
        /**** Get The Absolute Path Of The File ****/  
        if (filename!=null && !filename.equals(""))
        {
	        File downloadFile = new File(FilePath);
	       
	        if(downloadFile.exists()) {
	        	status=downloadFileProperties(req, resp, FilePath, downloadFile);
	
	        } else {
	        	File downloadFile1 = new File(serverFilePath+filename);
	        	if(downloadFile1.exists()) {
	            	status=downloadFileProperties(req, resp, FilePath, downloadFile1);
	            } 
	        	else
	        	{
	        	System.out.println("Requested File Not Found At The Server ....!");
	        	status="Requested File Not Found At The Server ....!";
	        	}
	        }
        }

    }
	
	@RequestMapping(value = "downloadProgramFile", method = RequestMethod.GET)
    public void downloadProgramFile(HttpServletRequest req,HttpServletResponse resp,@ModelAttribute("filename") String filename
    		,@ModelAttribute("programId") String programId
    		) throws IOException {
		String FilePath = "";
		String status="";
        FilePath=serverFilePathProgram+programId+"/"+filename;
        /**** Get The Absolute Path Of The File ****/  
      
        File downloadFile = new File(FilePath);
       
        if(downloadFile.exists()) {
        	status=downloadFileProperties(req, resp, FilePath, downloadFile);
        	
        } else {
        	File downloadFile1 = new File(serverFilePath+filename);
        	if(downloadFile1.exists()) {
            	status=downloadFileProperties(req, resp, FilePath, downloadFile1);
            } 
        	else
        	{
        	System.out.println("Requested File Not Found At The Server ....!");
        	status="Requested File Not Found At The Server ....!";
        	}
        	
        }
        
       
    }
		
		@RequestMapping(value = "downloadFile/{filename}", method = RequestMethod.GET)
	    public void downloadFile(HttpServletRequest req,HttpServletResponse resp,@PathVariable("filename") String filename) throws IOException {
			
			String FilePath = "";
			String status="";
	        FilePath=serverFilePath+filename;
	        /**** Get The Absolute Path Of The File ****/  
	      
	        File downloadFile = new File(FilePath);
	       
	        if(downloadFile.exists()) {
	        	status=downloadFileProperties(req, resp, FilePath, downloadFile);
	        	
	        } else {
	        	System.out.println("Requested File Not Found At The Server ....!");
	        	status="Requested File Not Found At The Server ....!";
	        }
	        
	       
	    }
		
		@RequestMapping(value = "downloadTemplateFile/{filename}", method = RequestMethod.GET)
	    public void downloadTemplateFile(HttpServletRequest req,HttpServletResponse resp,@PathVariable("filename") String filename) throws IOException {
			
			String FilePath = "";
			String status="";
	        FilePath=serverFilePathTemplate+filename;
	        /**** Get The Absolute Path Of The File ****/  
	      System.out.println("downloadTemplateFile===="+FilePath);
	        File downloadFile = new File(FilePath);
	       
	        if(downloadFile.exists()) {
	        	status=downloadFileProperties(req, resp, FilePath, downloadFile);
	        	
	        } else {
	        	
	        	File downloadFile1 = new File(serverFilePath+filename);
	        	if(downloadFile1.exists()) {
	            	status=downloadFileProperties(req, resp, FilePath, downloadFile1);
	            } 
	        	else
	        	{
	        	System.out.println("Requested File Not Found At The Server ....!");
	        	status="Requested File Not Found At The Server ....!";
	        	}
	        }
	        
	       
	    }
		
		
		public static String downloadFileProperties(HttpServletRequest req,HttpServletResponse resp, String toBeDownloadedFile, File downloadFile) {
			try {
				
				/**** Get The Mime Type Of The File & Setting The Binary Type If The Mime Mapping Is Not Found ****/
				String mimeType = req.getSession().getServletContext().getMimeType(toBeDownloadedFile);
				if (mimeType == null) {
					mimeType = "application/octet-stream";
				}

				/**** Setting The Content Attributes For The Response Object ****/
				resp.setContentType(mimeType);
				resp.setContentLength((int) downloadFile.length());
				
				/**** Setting The Headers For The Response Object ****/
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
				resp.setHeader(headerKey, headerValue);
				
				/**** Get The Output Stream Of The Response ****/
				OutputStream outStream = resp.getOutputStream();
				
				FileInputStream inputStream = new FileInputStream(downloadFile);
				
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				/**** Write Each Byte Of Data Read From The Input Stream Write Each Byte Of Data  Read From The Input Stream Into The Output Stream ****/
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
				
				inputStream.close();
				outStream.close();
			} catch(IOException ioExObj) {
				System.out.println("Exception While Performing The I/O Operation?= " + ioExObj);
				return "error";
			}
			return "success";
		}
	

}
