package com.abhiyantrikitech.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abhiyantrikitech.model.SystemSetting;
import com.abhiyantrikitech.service.SystemSettingService;

@Component
public class ZipFiles {
	
	//@Autowired
	//SystemSettingService systemSettingService;
    
    List<String> filesListInDir = new ArrayList<String>();
    public static final String STUDENT = "C:/Users/HP/Desktop/imageUploadvv/certificateScore.pdf";

    public static void main(String[] args) throws Exception {
        //File file = new File("/Users/pankaj/sitemap.xml");
        //String zipFileName = "/Users/pankaj/sitemap.zip";
    	//SystemSettingService systemSettingService=new SystemSettingService();
    	File dir = new File("D://AYT/tmp");
    	for(int i=0;i<20;i++){
    		//Utility.pdfGenerate("Testing text", "D://AYT//tmp//", i+"_certificate.pdf");
    		//new CertificateGenerator().createPdfForStudentWithMarks("D://AYT//tmp//"+ i+"_certificate.pdf");
    	}
        
        
        String zipDirName = "D://AYT/tmp.zip";
        
        //zipSingleFile(file, zipFileName);
        
        ZipFiles zipFiles = new ZipFiles();
        zipFiles.zipDirectory(dir, zipDirName);
        
        //SystemSetting ss=systemSettingService.getSystemSettingListById("1");
        ////////////////////////////////////////////
        
		String mailBody = null;
		String mailSubject=null;
		String mailTo="ashishparashar10@yahoo.com";
		EmailUtil eu =new EmailUtil();
		/*eu.setMailfrom(ss.getEmailFrom());
		eu.setHost(ss.getSmtpHost());
		eu.setPassword(ss.getSmtpPassword());
		eu.setUsername(ss.getSmtpUserName());
		eu.setPort(ss.getSmtpPort());
		eu.setMailto(mailTo);
		*/
		eu.setMailfrom("ashishparashar10@yahoo.com");
		eu.setHost(MailConstantBackup.smtpHost);
		eu.setPassword(MailConstantBackup.smtpPassword);
		eu.setUsername(MailConstantBackup.smtpUserName);
		eu.setPort(MailConstantBackup.smtpPort);
		eu.setMailto(mailTo);
		
		mailSubject="Certificate Details";

		mailBody="Dear Sir/Madam, <br/>Please find attached certificate."+
				"<br/><br/>"+
				"Regards"+
				"<br/>NISM";
		
		eu.setContent(mailBody);			
		eu.setMailsubject(mailSubject);
		System.out.println("zipDirName>>>>>>"+zipDirName);
		eu.setMailAttachmentFileNames(zipDirName);
		
		String emailResponse=eu.sendMail();
		
		if (emailResponse==null||!emailResponse.equals("true"))
		{
			System.out.println("Email sent failed for -"+mailTo);
		}
    }

    /**
     * This method zips the directory
     * @param dir
     * @param zipDirName
     */
    public void zipDirectory(File dir, String zipDirName) {
        try {
            populateFilesList(dir);
            //now zip files one by one
            //create ZipOutputStream to write to the zip file
            FileOutputStream fos = new FileOutputStream(zipDirName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            for(String filePath : filesListInDir){
                System.out.println("Zipping "+filePath);
                //for ZipEntry we need to keep only relative file path, so we used substring on absolute path
                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
                zos.putNextEntry(ze);
                //read the file and write to ZipOutputStream
                FileInputStream fis = new FileInputStream(filePath);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method populates all the files in a directory to a List
     * @param dir
     * @throws IOException
     */
    private void populateFilesList(File dir) throws IOException {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
            else populateFilesList(file);
        }
    }

    /**
     * This method compresses the single file to zip format
     * @param file
     * @param zipFileName
     */
    private static void zipSingleFile(File file, String zipFileName) {
        try {
            //create ZipOutputStream to write to the zip file
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            //add a new Zip Entry to the ZipOutputStream
            ZipEntry ze = new ZipEntry(file.getName());
            zos.putNextEntry(ze);
            //read the file and write to ZipOutputStream
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            
            //Close the zip entry to write to zip file
            zos.closeEntry();
            //Close resources
            zos.close();
            fis.close();
            fos.close();
            System.out.println(file.getCanonicalPath()+" is zipped to "+zipFileName);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
