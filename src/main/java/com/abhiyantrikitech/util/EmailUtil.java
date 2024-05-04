package com.abhiyantrikitech.util;

import java.util.Properties;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.activation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.abhiyantrikitech.repository.ConnectionBean;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;



public class EmailUtil {
	String mailfrom;
	String mailto;
	String mailcc;
	String mailbcc;
	String mailsubject;
	String host;
	String username;
	String password;
	//String DefaultMailBody;
	String port;
	String content;
	String mailAttachmentFileNames; 
	String filePath;
	private byte [] out;
	String clientFileName;
	Properties smtpprops ;
	Session session;
	
	String email1="sebiquiz101@nism.ac.in";
	String email2="sebiquiz102@nism.ac.in";
	String email3="sebiquiz103@nism.ac.in";
	String email4="sebiquiz104@nism.ac.in";
	String email5="sebiquiz105@nism.ac.in";
	String email6="sebiquiz106@nism.ac.in";
	String email7="sebiquiz107@nism.ac.in";
	String email8="sebiquiz108@nism.ac.in";
	String email9="sebiquiz109@nism.ac.in";
	String email10="sebiquiz110@nism.ac.in";
	
	String email11="sebiquiz111@nism.ac.in";
	String email12="sebiquiz112@nism.ac.in";
	String email13="sebiquiz113@nism.ac.in";
	String email14="sebiquiz114@nism.ac.in";
	String email15="sebiquiz115@nism.ac.in";
	
	String email16="sebiquiz116@nism.ac.in";
	String email17="sebiquiz117@nism.ac.in";
	String email18="sebiquiz118@nism.ac.in";
	String email19="sebiquiz119@nism.ac.in";
	String email20="sebiquiz120@nism.ac.in";
	String email21="sebiquiz121@nism.ac.in";
	String email22="sebiquiz122@nism.ac.in";
	String email23="sebiquiz123@nism.ac.in";
	String email24="sebiquiz124@nism.ac.in";
	String email25="sebiquiz125@nism.ac.in";
	
	String email26="sebiquiz126@nism.ac.in";
	String email27="sebiquiz127@nism.ac.in";
	String email28="sebiquiz128@nism.ac.in";
	String email29="sebiquiz129@nism.ac.in";
	String email30="sebiquiz130@nism.ac.in";
	
	static int emailNo=16;
	static int emailNoReminder=6;
	static int emailNoCertificate=1;
	
	static int count=1;
	static int countReminder=1;
	static int countCertificate=1;
	
	static String activeusername="";
	static String activeusernameReminder="";
	static String activeusernameCertificate="";
	
	//static String activepassword="";
	//static String activemailfrom="";	
	
	//static String activeusernameReminder="";
	//static String activepasswordReminder="";
	//static String activemailfromReminder="";
	  
	MimeMessage message;
	
	public String getClientFileName() {
		return clientFileName;
	}
	public void setClientFileName(String clientFileName) {
		this.clientFileName = clientFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getMailAttachmentFileNames() {
		return mailAttachmentFileNames;
	}
	public void setMailAttachmentFileNames(String mailAttachmentFileNames) {
		this.mailAttachmentFileNames = mailAttachmentFileNames;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getMailfrom() {
		return mailfrom;
	}
	public void setMailfrom(String mailfrom) {
		this.mailfrom = mailfrom;
	}
	public String getMailto() {
		return mailto;
	}
	public void setMailto(String mailto) {
		this.mailto = mailto;
	}
	public String getMailcc() {
		return mailcc;
	}
	public void setMailcc(String mailcc) {
		this.mailcc = mailcc;
	}
	public String getMailbcc() {
		return mailbcc;
	}
	public void setMailbcc(String mailbcc) {
		this.mailbcc = mailbcc;
	}
	public String getMailsubject() {
		return mailsubject;
	}
	public void setMailsubject(String mailsubject) {
		this.mailsubject = mailsubject;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public void setUpdateEmail()
	{
		System.out.println("=========Existing Email Count========="+count);
		
		if (count>5)
		{
			
			
			if (emailNo==16)
			{
				activeusername=email17;
				emailNo=17;
			}
			else if (emailNo==17)
			{
				activeusername=email18;
				emailNo=18;
			}
			else if (emailNo==18)
			{
				activeusername=email19;
				emailNo=19;
			}
			else if (emailNo==19)
			{
				activeusername=email20;
				emailNo=20;
			}
			else if (emailNo==20)
			{
				activeusername=email21;
				emailNo=21;
			}
			else if (emailNo==21)
			{
				activeusername=email22;
				emailNo=22;
			}
			else if (emailNo==22)
			{
				activeusername=email23;
				emailNo=23;
			}
			else if (emailNo==23)
			{
				activeusername=email24;
				emailNo=24;
			}
			else if (emailNo==24)
			{
				activeusername=email25;
				emailNo=25;
			}
			else if (emailNo==25)
			{
				activeusername=email26;
				emailNo=26;
			}
			else if (emailNo==26)
			{
				activeusername=email27;
				emailNo=27;
			}
			else if (emailNo==27)
			{
				activeusername=email28;
				emailNo=28;
			}
			else if (emailNo==28)
			{
				activeusername=email29;
				emailNo=29;
			}
			else if (emailNo==29)
			{
				activeusername=email30;
				emailNo=30;
			}
			else if (emailNo==30)
			{
				activeusername=email1;
				emailNo=1;
			}
			else if (emailNo==1)
			{
				activeusername=email2;
				emailNo=2;
			}
			else if (emailNo==2)
			{
				activeusername=email3;
				emailNo=3;
			}
			else if (emailNo==3)
			{
				activeusername=email4;
				emailNo=4;
			}
			else if (emailNo==4)
			{
				activeusername=email5;
				emailNo=5;
			}
			else if (emailNo==5)
			{
				activeusername=email16;
				emailNo=16;
			}
			count=1;
			System.out.println("==========Count Reset=========New Email id========"+activeusername);
			
			
		}
		else
		{
			
			
			if (emailNo==16)
			{
				activeusername=email16;
			}
			else if (emailNo==17)
			{
				activeusername=email17;
			}
			else if (emailNo==18)
			{
				activeusername=email18;
			}
			else if (emailNo==19)
			{
				activeusername=email19;
			}
			else if (emailNo==20)
			{
				activeusername=email20;
			}
			else if (emailNo==21)
			{
				activeusername=email21;
			}
			else if (emailNo==22)
			{
				activeusername=email22;
			}
			else if (emailNo==23)
			{
				activeusername=email23;
			}
			else if (emailNo==24)
			{
				activeusername=email24;
			}
			else if (emailNo==25)
			{
				activeusername=email25;
			}
			else if (emailNo==26)
			{
				activeusername=email26;
			}
			else if (emailNo==27)
			{
				activeusername=email27;
			}
			else if (emailNo==28)
			{
				activeusername=email28;
			}
			else if (emailNo==29)
			{
				activeusername=email29;
			}
			else if (emailNo==30)
			{
				activeusername=email30;
			}
			else if (emailNo==1)
			{
				activeusername=email1;
				
			}
			else if (emailNo==2)
			{
				activeusername=email2;
				
			}
			else if (emailNo==3)
			{
				activeusername=email3;
				
			}
			else if (emailNo==4)
			{
				activeusername=email4;
				
			}
			else if (emailNo==5)
			{
				activeusername=email5;
				
			}
		}
		
	}
	
	public void setUpdateReminderEmail()
	{
		System.out.println("setUpdateReminderEmail=========Existing Email Count========="+countReminder);
		
		if (countReminder>5)
		{
			
			
			if (emailNoReminder==6)
			{
				activeusernameReminder=email7;
				emailNoReminder=7;
			}
			else if (emailNoReminder==7)
			{
				activeusernameReminder=email8;
				emailNoReminder=8;
			}
			else if (emailNoReminder==8)
			{
				activeusernameReminder=email9;
				emailNoReminder=9;
			}
			else if (emailNoReminder==9)
			{
				activeusernameReminder=email10;
				emailNoReminder=10;
			}
			else if (emailNoReminder==10)
			{
				activeusernameReminder=email11;
				emailNoReminder=11;
			}
			else if (emailNoReminder==11)
			{
				activeusernameReminder=email12;
				emailNoReminder=12;
			}
			else if (emailNoReminder==12)
			{
				activeusernameReminder=email13;
				emailNoReminder=13;
			}
			else if (emailNoReminder==13)
			{
				activeusernameReminder=email14;
				emailNoReminder=14;
			}
			else if (emailNoReminder==14)
			{
				activeusernameReminder=email15;
				emailNoReminder=15;
			}
			else if (emailNoReminder==15)
			{
				activeusernameReminder=email6;
				emailNoReminder=6;
			}
			countReminder=1;
			System.out.println("========== Reminder Count Reset=========New Email id========"+activeusernameReminder);
			
			
		}
		else
		{
			
			
			if (emailNoReminder==6)
			{
				activeusernameReminder=email6;
			}
			else if (emailNoReminder==7)
			{
				activeusernameReminder=email7;
			}
			else if (emailNoReminder==8)
			{
				activeusernameReminder=email8;
			}
			else if (emailNoReminder==9)
			{
				activeusernameReminder=email9;
			}
			else if (emailNoReminder==10)
			{
				activeusernameReminder=email10;
			}
			else if (emailNoReminder==11)
			{
				activeusernameReminder=email11;
			}
			else if (emailNoReminder==12)
			{
				activeusernameReminder=email12;
			}
			else if (emailNoReminder==13)
			{
				activeusernameReminder=email13;
			}
			else if (emailNoReminder==14)
			{
				activeusernameReminder=email14;
			}
			else if (emailNoReminder==15)
			{
				activeusernameReminder=email15;
			}
		}
		
	}
	
	
	public void setUpdateCertificateEmail()
	{
		System.out.println("setUpdateCertificateEmail=========Existing Email Count========="+countCertificate);
		
		if (countCertificate>5)
		{
			
			
			if (emailNoCertificate==1)
			{
				activeusernameCertificate=email2;
				emailNoCertificate=2;
			}
			else if (emailNoCertificate==2)
			{
				activeusernameCertificate=email3;
				emailNoCertificate=3;
			}
			else if (emailNoCertificate==3)
			{
				activeusernameCertificate=email4;
				emailNoCertificate=4;
			}
			else if (emailNoCertificate==4)
			{
				activeusernameCertificate=email5;
				emailNoCertificate=5;
			}
			else if (emailNoCertificate==5)
			{
				activeusernameCertificate=email1;
				emailNoCertificate=1;
			}
			countCertificate=1;
			System.out.println("==========Certificate Count Reset=========New Email id========"+activeusernameCertificate);
			
			
		}
		else
		{
			
			if (emailNoCertificate==1)
			{
				activeusernameCertificate=email1;
			}
			else if (emailNoCertificate==2)
			{
				activeusernameCertificate=email2;
			}
			else if (emailNoCertificate==3)
			{
				activeusernameCertificate=email3;
			}
			else if (emailNoCertificate==4)
			{
				activeusernameCertificate=email4;
			}
			else if (emailNoCertificate==5)
			{
				activeusernameCertificate=email5;
			}
			
		}
		
	}
	
	/*public void  testMethod()
	{
		//setUpdateEmail();	
		
		count=count+1;
		
		System.out.println(count+"=========Active user Name======="+activeusername);
	}*/
	
	
	public void setMailServerProperties() {
		    //String emailPort = "587";
		    this.smtpprops = System.getProperties();
		    this.smtpprops.put("mail.smtp.port", port);
		    this.smtpprops.put("mail.smtp.auth", "true");
		    this.smtpprops.put("mail.smtp.starttls.enable", "true");
		    this.smtpprops.put("mail.smtp.ssl.protocols", "TLSv1.2");
		  }
	  
	  public PasswordAuthentication getPasswordAuthentication() {
		    return new PasswordAuthentication(username, password);
		  }
	
	public String sendMail() throws Exception {
		try {
			
			setUpdateEmail();
			
			System.out.println("=========Active user Name======="+activeusername);
			
			if (activeusername!=null && !activeusername.equals(""))
			{
				username=activeusername;
				//password=password;
				mailfrom=activeusername;	
			}
			
			
			 count=count+1;
			 System.out.println("*********Email Count********"+count);

			
			
			setMailServerProperties();
			
				session = Session.getInstance(smtpprops,
						new javax.mail.Authenticator() {

							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(username,
										password);
							}
						});
				
				//session = Session.getInstance(this.smtpprops, new GmailAuthenticator(String.valueOf(this.username), this.username));
				
				
			
			message = new MimeMessage(session);
						
			
			if (mailfrom == null || mailfrom.equals("")) {
				throw new Exception("Mail From cannot be blank.");
			}
			if (mailto == null || mailto.equals("")) {
				throw new Exception("Mail To cannot be blank.");
			}

			//String fromrec = mailfrom;
			
			//InternetAddress addressFrom = new InternetAddress();
			
			//addressFrom=new InternetAddress(mailfrom);
			String[] fromemail = mailfrom.trim().split(",");
			
			InternetAddress[] addressFrom = new InternetAddress[fromemail.length];
			
			for (int i = 0; i < fromemail.length; i++) {
				addressFrom[i] = new InternetAddress(fromemail[i].trim());
			}
			
			message.addFrom(addressFrom);
			
			//---------------			
			String[] recipients = mailto.trim().split(",");
			
			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			
			for (int i = 0; i < recipients.length; i++) {
				addressTo[i] = new InternetAddress(recipients[i].trim());
			}
			
			
			message.addRecipients(Message.RecipientType.TO, addressTo);
			
			if (mailbcc != null && !mailbcc.trim().equals("")) {
				String[] recipients1 = mailbcc.trim().split(",");
				InternetAddress[] addressBCC = new InternetAddress[recipients1.length];
				for (int i = 0; i < recipients1.length; i++) {
					addressBCC[i] = new InternetAddress(recipients1[i].trim());
				}
				message.addRecipients(Message.RecipientType.BCC, addressBCC);
			}
			
			
			if (mailcc != null && !mailcc.trim().equals("")) {
				String[] recipients2 = mailcc.trim().split(",");
				InternetAddress[] addressCC = new InternetAddress[recipients2.length];
				for (int i = 0; i < recipients2.length; i++) {
					addressCC[i] = new InternetAddress(recipients2[i].trim());
				}
				message.addRecipients(Message.RecipientType.CC, addressCC);
			}
			
			
			if (mailsubject == null) {
				message.setSubject("");
			} else {
				message.setSubject(mailsubject);
			}
			
			
			// Create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			
			messageBodyPart.setContent(getContent(), "text/html");
			
			Multipart multipart = new MimeMultipart("related");
			
			multipart.addBodyPart((BodyPart)messageBodyPart);
			
			String[] strAttachFiles;
			String strAttachClientFileName, strAttachServerFileName;
		
			if (mailAttachmentFileNames != null) {
				if (!mailAttachmentFileNames.equals("")) {
					
					String[] strFiles = mailAttachmentFileNames.split("~");
					int intCnt = 0;
					int intLen = strFiles.length;
					for (intCnt = 0; intCnt < intLen; intCnt++) {
						strAttachFiles = strFiles[intCnt].split(",");
						strAttachClientFileName = strAttachFiles[0].toString();
						strAttachServerFileName = strAttachFiles[0].toString();//made 0 , for 1
						messageBodyPart = new MimeBodyPart();
						DataSource source = new FileDataSource(strAttachServerFileName);// removing filepath
						//DataSource source = new FileDataSource(filePath
								//+ strAttachServerFileName);// removing filepath
						
						messageBodyPart.setDataHandler(new DataHandler(source));
						System.out.println("strAttachClientFileName==="+strAttachClientFileName);
						File f = new File(strAttachClientFileName);
						System.out.println("fileName=="+f.getName());
						messageBodyPart.setFileName(f.getName());
						multipart.addBodyPart(messageBodyPart);
					}
				}
			}
			
			if(out != null){
				System.out.println(clientFileName);
				DataSource aAttachment = new  ByteArrayDataSource(out,"application/octet-stream");
				MimeBodyPart attachmentPart = new MimeBodyPart();
				attachmentPart.setDataHandler(new DataHandler(aAttachment));
				if (clientFileName!="")
				{
					attachmentPart.setFileName(clientFileName);
				}
				else
				{
					attachmentPart.setFileName(mailAttachmentFileNames);
				}
				multipart.addBodyPart(attachmentPart);
			}
				message.setContent((Multipart)multipart);
				
			
			    Transport transport = session.getTransport("smtp");
			    System.out.println("Emailing in progress..");
			    transport.connect(host, username, password);
			    transport.sendMessage((Message) message, message.getAllRecipients());
			    transport.close();
			    System.out.println("Emailing sent successfully for "+mailto);
			    
			   			   /////////////////////////////////////////////////////////////////
			    
			    //Log Save in table
			    
			    saveEmailLog(mailfrom,mailto,mailsubject);
			    
			   ////////////////////////////////////////////////////////////////// 

			//Transport.send(message);
		} catch (Exception e) {
			
			//throw e;
			System.out.println("Exception in sendin email to "+mailto+" for host="+host+" & username="+username+" & error= "  +e.getMessage());
			e.printStackTrace();
			//count=50; // change next sender email id
			return "false";
		}
		return "true";
	}
	
	
	
	
	public String sendMailReminder() throws Exception {
		try {
			
			setUpdateReminderEmail();
			
			System.out.println("sendMailReminder=========Active user Name======="+activeusernameReminder);
			
			if (activeusernameReminder!=null && !activeusernameReminder.equals(""))
			{
				username=activeusernameReminder;
				//password=password;
				mailfrom=activeusernameReminder;	
			}
			
			
			countReminder=countReminder+1;
			 System.out.println("*********Email Count********"+countReminder);

			
			
			setMailServerProperties();
			
				session = Session.getInstance(smtpprops,
						new javax.mail.Authenticator() {

							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(username,
										password);
							}
						});
				
				//session = Session.getInstance(this.smtpprops, new GmailAuthenticator(String.valueOf(this.username), this.username));
				
				
			
			message = new MimeMessage(session);
						
			
			if (mailfrom == null || mailfrom.equals("")) {
				throw new Exception("Mail From cannot be blank.");
			}
			if (mailto == null || mailto.equals("")) {
				throw new Exception("Mail To cannot be blank.");
			}

			//String fromrec = mailfrom;
			
			//InternetAddress addressFrom = new InternetAddress();
			
			//addressFrom=new InternetAddress(mailfrom);
			String[] fromemail = mailfrom.trim().split(",");
			
			InternetAddress[] addressFrom = new InternetAddress[fromemail.length];
			
			for (int i = 0; i < fromemail.length; i++) {
				addressFrom[i] = new InternetAddress(fromemail[i].trim());
			}
			
			message.addFrom(addressFrom);
			
			//---------------			
			String[] recipients = mailto.trim().split(",");
			
			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			
			for (int i = 0; i < recipients.length; i++) {
				addressTo[i] = new InternetAddress(recipients[i].trim());
			}
			
			
			message.addRecipients(Message.RecipientType.TO, addressTo);
			
			if (mailbcc != null && !mailbcc.trim().equals("")) {
				String[] recipients1 = mailbcc.trim().split(",");
				InternetAddress[] addressBCC = new InternetAddress[recipients1.length];
				for (int i = 0; i < recipients1.length; i++) {
					addressBCC[i] = new InternetAddress(recipients1[i].trim());
				}
				message.addRecipients(Message.RecipientType.BCC, addressBCC);
			}
			
			
			if (mailcc != null && !mailcc.trim().equals("")) {
				String[] recipients2 = mailcc.trim().split(",");
				InternetAddress[] addressCC = new InternetAddress[recipients2.length];
				for (int i = 0; i < recipients2.length; i++) {
					addressCC[i] = new InternetAddress(recipients2[i].trim());
				}
				message.addRecipients(Message.RecipientType.CC, addressCC);
			}
			
			
			if (mailsubject == null) {
				message.setSubject("");
			} else {
				message.setSubject(mailsubject);
			}
			
			
			// Create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			
			messageBodyPart.setContent(getContent(), "text/html");
			
			Multipart multipart = new MimeMultipart("related");
			
			multipart.addBodyPart((BodyPart)messageBodyPart);
			
			String[] strAttachFiles;
			String strAttachClientFileName, strAttachServerFileName;
		
			if (mailAttachmentFileNames != null) {
				if (!mailAttachmentFileNames.equals("")) {
					
					String[] strFiles = mailAttachmentFileNames.split("~");
					int intCnt = 0;
					int intLen = strFiles.length;
					for (intCnt = 0; intCnt < intLen; intCnt++) {
						strAttachFiles = strFiles[intCnt].split(",");
						strAttachClientFileName = strAttachFiles[0].toString();
						strAttachServerFileName = strAttachFiles[0].toString();//made 0 , for 1
						messageBodyPart = new MimeBodyPart();
						DataSource source = new FileDataSource(strAttachServerFileName);// removing filepath
						//DataSource source = new FileDataSource(filePath
								//+ strAttachServerFileName);// removing filepath
						
						messageBodyPart.setDataHandler(new DataHandler(source));
						System.out.println("strAttachClientFileName==="+strAttachClientFileName);
						File f = new File(strAttachClientFileName);
						System.out.println("fileName=="+f.getName());
						messageBodyPart.setFileName(f.getName());
						multipart.addBodyPart(messageBodyPart);
					}
				}
			}
			
			if(out != null){
				System.out.println(clientFileName);
				DataSource aAttachment = new  ByteArrayDataSource(out,"application/octet-stream");
				MimeBodyPart attachmentPart = new MimeBodyPart();
				attachmentPart.setDataHandler(new DataHandler(aAttachment));
				if (clientFileName!="")
				{
					attachmentPart.setFileName(clientFileName);
				}
				else
				{
					attachmentPart.setFileName(mailAttachmentFileNames);
				}
				multipart.addBodyPart(attachmentPart);
			}
				message.setContent((Multipart)multipart);
				
			
			    Transport transport = session.getTransport("smtp");
			    System.out.println("Emailing in progress..");
			    transport.connect(host, username, password);
			    transport.sendMessage((Message) message, message.getAllRecipients());
			    transport.close();
			    System.out.println("Emailing sent successfully for "+mailto);
			    
			   			   /////////////////////////////////////////////////////////////////
			    
			    //Log Save in table
			    
			    saveEmailLog(mailfrom,mailto,mailsubject);
			    
			   ////////////////////////////////////////////////////////////////// 

			//Transport.send(message);
		} catch (Exception e) {
			
			//throw e;
			System.out.println("Exception in sendMailReminder email to "+mailto+" for host="+host+" & username="+username+" & error= "  +e.getMessage());
			e.printStackTrace();
			return "false";
		}
		return "true";
	}
	
	
	public String sendMailFeedback() throws Exception {
		try {
			
			String username="feedback-noreply@nism.ac.in";
			String password="FlipsFeedback@nism";
			String mailfrom="feedback-noreply@nism.ac.in";
						
			setMailServerProperties();
			
			
			
				session = Session.getInstance(smtpprops,
						new javax.mail.Authenticator() {

							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(username,
										password);
							}
						});
				
				//session = Session.getInstance(this.smtpprops, new GmailAuthenticator(String.valueOf(this.username), this.username));
				
				
			
			message = new MimeMessage(session);
						
			
			if (mailfrom == null || mailfrom.equals("")) {
				throw new Exception("Mail From cannot be blank.");
			}
			if (mailto == null || mailto.equals("")) {
				throw new Exception("Mail To cannot be blank.");
			}

			//String fromrec = mailfrom;
			
			//InternetAddress addressFrom = new InternetAddress();
			
			//addressFrom=new InternetAddress(mailfrom);
			String[] fromemail = mailfrom.trim().split(",");
			
			InternetAddress[] addressFrom = new InternetAddress[fromemail.length];
			
			for (int i = 0; i < fromemail.length; i++) {
				addressFrom[i] = new InternetAddress(fromemail[i].trim());
			}
			
			message.addFrom(addressFrom);
			
			//---------------			
			String[] recipients = mailto.trim().split(",");
			
			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			
			for (int i = 0; i < recipients.length; i++) {
				addressTo[i] = new InternetAddress(recipients[i].trim());
			}
			
			
			message.addRecipients(Message.RecipientType.TO, addressTo);
			
			if (mailbcc != null && !mailbcc.trim().equals("")) {
				String[] recipients1 = mailbcc.trim().split(",");
				InternetAddress[] addressBCC = new InternetAddress[recipients1.length];
				for (int i = 0; i < recipients1.length; i++) {
					addressBCC[i] = new InternetAddress(recipients1[i].trim());
				}
				message.addRecipients(Message.RecipientType.BCC, addressBCC);
			}
			
			
			if (mailcc != null && !mailcc.trim().equals("")) {
				String[] recipients2 = mailcc.trim().split(",");
				InternetAddress[] addressCC = new InternetAddress[recipients2.length];
				for (int i = 0; i < recipients2.length; i++) {
					addressCC[i] = new InternetAddress(recipients2[i].trim());
				}
				message.addRecipients(Message.RecipientType.CC, addressCC);
			}
			
			
			if (mailsubject == null) {
				message.setSubject("");
			} else {
				message.setSubject(mailsubject);
			}
			
			
			// Create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			
			messageBodyPart.setContent(getContent(), "text/html");
			
			Multipart multipart = new MimeMultipart("related");
			
			multipart.addBodyPart((BodyPart)messageBodyPart);
			
			String[] strAttachFiles;
			String strAttachClientFileName, strAttachServerFileName;
		
			if (mailAttachmentFileNames != null) {
				if (!mailAttachmentFileNames.equals("")) {
					
					String[] strFiles = mailAttachmentFileNames.split("~");
					int intCnt = 0;
					int intLen = strFiles.length;
					for (intCnt = 0; intCnt < intLen; intCnt++) {
						strAttachFiles = strFiles[intCnt].split(",");
						strAttachClientFileName = strAttachFiles[0].toString();
						strAttachServerFileName = strAttachFiles[0].toString();//made 0 , for 1
						messageBodyPart = new MimeBodyPart();
						DataSource source = new FileDataSource(strAttachServerFileName);// removing filepath
						//DataSource source = new FileDataSource(filePath
								//+ strAttachServerFileName);// removing filepath
						
						messageBodyPart.setDataHandler(new DataHandler(source));
						System.out.println("strAttachClientFileName==="+strAttachClientFileName);
						File f = new File(strAttachClientFileName);
						System.out.println("fileName=="+f.getName());
						messageBodyPart.setFileName(f.getName());
						multipart.addBodyPart(messageBodyPart);
					}
				}
			}
			
			if(out != null){
				System.out.println(clientFileName);
				DataSource aAttachment = new  ByteArrayDataSource(out,"application/octet-stream");
				MimeBodyPart attachmentPart = new MimeBodyPart();
				attachmentPart.setDataHandler(new DataHandler(aAttachment));
				if (clientFileName!="")
				{
					attachmentPart.setFileName(clientFileName);
				}
				else
				{
					attachmentPart.setFileName(mailAttachmentFileNames);
				}
				multipart.addBodyPart(attachmentPart);
			}
				message.setContent((Multipart)multipart);
				
			
			    Transport transport = session.getTransport("smtp");
			    System.out.println("Emailing in progress..");
			    transport.connect(host, username, password);
			    transport.sendMessage((Message) message, message.getAllRecipients());
			    transport.close();
			    System.out.println("Emailing sent successfully");

			//Transport.send(message);
		} catch (Exception e) {
			
			//throw e;
			System.out.println("Exception in sendMailFeedback email for host="+host+" & username="+username+" & error= "  +e.getMessage());
			e.printStackTrace();
			return "false";
		}
		return "true";
	}
	
	public String sendMailQuiz() throws Exception {
		try {
			
			String username="no-reply50@nism.ac.in";
			String password="FlipsQuiz@nism";
			String mailfrom="no-reply50@nism.ac.in";
						
			setMailServerProperties();
			
			
			
				session = Session.getInstance(smtpprops,
						new javax.mail.Authenticator() {

							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(username,
										password);
							}
						});
				
				//session = Session.getInstance(this.smtpprops, new GmailAuthenticator(String.valueOf(this.username), this.username));
				
				
			
			message = new MimeMessage(session);
						
			
			if (mailfrom == null || mailfrom.equals("")) {
				throw new Exception("Mail From cannot be blank.");
			}
			if (mailto == null || mailto.equals("")) {
				throw new Exception("Mail To cannot be blank.");
			}

			//String fromrec = mailfrom;
			
			//InternetAddress addressFrom = new InternetAddress();
			
			//addressFrom=new InternetAddress(mailfrom);
			String[] fromemail = mailfrom.trim().split(",");
			
			InternetAddress[] addressFrom = new InternetAddress[fromemail.length];
			
			for (int i = 0; i < fromemail.length; i++) {
				addressFrom[i] = new InternetAddress(fromemail[i].trim());
			}
			
			message.addFrom(addressFrom);
			
			//---------------			
			String[] recipients = mailto.trim().split(",");
			
			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			
			for (int i = 0; i < recipients.length; i++) {
				addressTo[i] = new InternetAddress(recipients[i].trim());
			}
			
			
			message.addRecipients(Message.RecipientType.TO, addressTo);
			
			if (mailbcc != null && !mailbcc.trim().equals("")) {
				String[] recipients1 = mailbcc.trim().split(",");
				InternetAddress[] addressBCC = new InternetAddress[recipients1.length];
				for (int i = 0; i < recipients1.length; i++) {
					addressBCC[i] = new InternetAddress(recipients1[i].trim());
				}
				message.addRecipients(Message.RecipientType.BCC, addressBCC);
			}
			
			
			if (mailcc != null && !mailcc.trim().equals("")) {
				String[] recipients2 = mailcc.trim().split(",");
				InternetAddress[] addressCC = new InternetAddress[recipients2.length];
				for (int i = 0; i < recipients2.length; i++) {
					addressCC[i] = new InternetAddress(recipients2[i].trim());
				}
				message.addRecipients(Message.RecipientType.CC, addressCC);
			}
			
			
			if (mailsubject == null) {
				message.setSubject("");
			} else {
				message.setSubject(mailsubject);
			}
			
			
			// Create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			
			messageBodyPart.setContent(getContent(), "text/html");
			
			Multipart multipart = new MimeMultipart("related");
			
			multipart.addBodyPart((BodyPart)messageBodyPart);
			
			String[] strAttachFiles;
			String strAttachClientFileName, strAttachServerFileName;
		
			if (mailAttachmentFileNames != null) {
				if (!mailAttachmentFileNames.equals("")) {
					
					String[] strFiles = mailAttachmentFileNames.split("~");
					int intCnt = 0;
					int intLen = strFiles.length;
					for (intCnt = 0; intCnt < intLen; intCnt++) {
						strAttachFiles = strFiles[intCnt].split(",");
						strAttachClientFileName = strAttachFiles[0].toString();
						strAttachServerFileName = strAttachFiles[0].toString();//made 0 , for 1
						messageBodyPart = new MimeBodyPart();
						DataSource source = new FileDataSource(strAttachServerFileName);// removing filepath
						//DataSource source = new FileDataSource(filePath
								//+ strAttachServerFileName);// removing filepath
						
						messageBodyPart.setDataHandler(new DataHandler(source));
						System.out.println("strAttachClientFileName==="+strAttachClientFileName);
						File f = new File(strAttachClientFileName);
						System.out.println("fileName=="+f.getName());
						messageBodyPart.setFileName(f.getName());
						multipart.addBodyPart(messageBodyPart);
					}
				}
			}
			
			if(out != null){
				System.out.println(clientFileName);
				DataSource aAttachment = new  ByteArrayDataSource(out,"application/octet-stream");
				MimeBodyPart attachmentPart = new MimeBodyPart();
				attachmentPart.setDataHandler(new DataHandler(aAttachment));
				if (clientFileName!="")
				{
					attachmentPart.setFileName(clientFileName);
				}
				else
				{
					attachmentPart.setFileName(mailAttachmentFileNames);
				}
				multipart.addBodyPart(attachmentPart);
			}
				message.setContent((Multipart)multipart);
				
			
			    Transport transport = session.getTransport("smtp");
			    System.out.println("Emailing in progress..");
			    transport.connect(host, username, password);
			    transport.sendMessage((Message) message, message.getAllRecipients());
			    transport.close();
			    System.out.println("Emailing sent successfully");

			//Transport.send(message);
		} catch (Exception e) {
			
			//throw e;
			System.out.println("Exception in sendMailQuiz email for host="+host+" & username="+username+" & error= "  +e.getMessage());
			e.printStackTrace();
			return "false";
		}
		return "true";
	}
	

	public String sendMailCertificate() throws Exception {
		try {
			
			
			setUpdateCertificateEmail();
			
			System.out.println("sendMailCertificate=========Active user Name======="+activeusernameCertificate);
			
			if (activeusernameCertificate!=null && !activeusernameCertificate.equals(""))
			{
				username=activeusernameCertificate;
				//password=password;
				mailfrom=activeusernameCertificate;	
			}
			
			
			countCertificate=countCertificate+1;
			 System.out.println("*********Email Count********"+countCertificate);

			
			
			setMailServerProperties();
			
				session = Session.getInstance(smtpprops,
						new javax.mail.Authenticator() {

							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(username,
										password);
							}
						});
				
				//session = Session.getInstance(this.smtpprops, new GmailAuthenticator(String.valueOf(this.username), this.username));
				
				
			
			message = new MimeMessage(session);
						
			
			if (mailfrom == null || mailfrom.equals("")) {
				throw new Exception("Mail From cannot be blank.");
			}
			if (mailto == null || mailto.equals("")) {
				throw new Exception("Mail To cannot be blank.");
			}

			//String fromrec = mailfrom;
			
			//InternetAddress addressFrom = new InternetAddress();
			
			//addressFrom=new InternetAddress(mailfrom);
			String[] fromemail = mailfrom.trim().split(",");
			
			InternetAddress[] addressFrom = new InternetAddress[fromemail.length];
			
			for (int i = 0; i < fromemail.length; i++) {
				addressFrom[i] = new InternetAddress(fromemail[i].trim());
			}
			
			message.addFrom(addressFrom);
			
			//---------------			
			String[] recipients = mailto.trim().split(",");
			
			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			
			for (int i = 0; i < recipients.length; i++) {
				addressTo[i] = new InternetAddress(recipients[i].trim());
			}
			
			
			message.addRecipients(Message.RecipientType.TO, addressTo);
			
			if (mailbcc != null && !mailbcc.trim().equals("")) {
				String[] recipients1 = mailbcc.trim().split(",");
				InternetAddress[] addressBCC = new InternetAddress[recipients1.length];
				for (int i = 0; i < recipients1.length; i++) {
					addressBCC[i] = new InternetAddress(recipients1[i].trim());
				}
				message.addRecipients(Message.RecipientType.BCC, addressBCC);
			}
			
			
			if (mailcc != null && !mailcc.trim().equals("")) {
				String[] recipients2 = mailcc.trim().split(",");
				InternetAddress[] addressCC = new InternetAddress[recipients2.length];
				for (int i = 0; i < recipients2.length; i++) {
					addressCC[i] = new InternetAddress(recipients2[i].trim());
				}
				message.addRecipients(Message.RecipientType.CC, addressCC);
			}
			
			
			if (mailsubject == null) {
				message.setSubject("");
			} else {
				message.setSubject(mailsubject);
			}
			
			
			// Create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			
			messageBodyPart.setContent(getContent(), "text/html");
			
			Multipart multipart = new MimeMultipart("related");
			
			multipart.addBodyPart((BodyPart)messageBodyPart);
			
			String[] strAttachFiles;
			String strAttachClientFileName, strAttachServerFileName;
		
			if (mailAttachmentFileNames != null) {
				if (!mailAttachmentFileNames.equals("")) {
					
					String[] strFiles = mailAttachmentFileNames.split("~");
					int intCnt = 0;
					int intLen = strFiles.length;
					for (intCnt = 0; intCnt < intLen; intCnt++) {
						strAttachFiles = strFiles[intCnt].split(",");
						strAttachClientFileName = strAttachFiles[0].toString();
						strAttachServerFileName = strAttachFiles[0].toString();//made 0 , for 1
						messageBodyPart = new MimeBodyPart();
						DataSource source = new FileDataSource(strAttachServerFileName);// removing filepath
						//DataSource source = new FileDataSource(filePath
								//+ strAttachServerFileName);// removing filepath
						
						messageBodyPart.setDataHandler(new DataHandler(source));
						System.out.println("strAttachClientFileName==="+strAttachClientFileName);
						File f = new File(strAttachClientFileName);
						System.out.println("fileName=="+f.getName());
						messageBodyPart.setFileName(f.getName());
						multipart.addBodyPart(messageBodyPart);
					}
				}
			}
			
			if(out != null){
				System.out.println(clientFileName);
				DataSource aAttachment = new  ByteArrayDataSource(out,"application/octet-stream");
				MimeBodyPart attachmentPart = new MimeBodyPart();
				attachmentPart.setDataHandler(new DataHandler(aAttachment));
				if (clientFileName!="")
				{
					attachmentPart.setFileName(clientFileName);
				}
				else
				{
					attachmentPart.setFileName(mailAttachmentFileNames);
				}
				multipart.addBodyPart(attachmentPart);
			}
				message.setContent((Multipart)multipart);
				
			
			    Transport transport = session.getTransport("smtp");
			    System.out.println("Emailing in progress..");
			    transport.connect(host, username, password);
			    transport.sendMessage((Message) message, message.getAllRecipients());
			    transport.close();
			    System.out.println("Emailing sent successfully for "+mailto);
			    
			   			   /////////////////////////////////////////////////////////////////
			    
			    //Log Save in table
			    
			    saveEmailLog(mailfrom,mailto,mailsubject);
			    
			   ////////////////////////////////////////////////////////////////// 

			//Transport.send(message);
		} catch (Exception e) {
			
			//throw e;
			System.out.println("Exception in sendCertificate email to "+mailto+" for host="+host+" & username="+username+" & error= "  +e.getMessage());
			e.printStackTrace();
			return "false";
		}
		return "true";
	}
	
	
	public void saveEmailLog(String mailFrom,String mailTo,String subject) throws Exception{	
		
		 int in_ua_id = 0;
		 int in_rec_cnt = 0;
		 Connection conn=null;
			ConnectionBean connBean=new ConnectionBean();;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
	try{
		System.out.println("saveEmailLog in EmailUtil");
			conn=connBean.getConnectionObj();
			
			
				

				pstmt=conn.prepareStatement("insert into tbl_email_log (el_email_from,el_email_to,el_email_subject,el_create_dt"
						+ ")  "				
						+ "VALUES(?,?,?,now())");	
				
				pstmt.setString(1,mailFrom);			
				pstmt.setString(2, mailTo);
				pstmt.setString(3, subject);
				
		
		
				
			    int count = pstmt.executeUpdate();
			    
			    
			    if(count!=0){
			    	
			    	System.out.println(">>>SAVE Email Log MAS<<<");
			    	
			    				    	
			    }
			    else
			    {
			    	System.out.println(">>>Email Log SAVED FAILED<<<");
			    	
			    }
			
			
			pstmt.close();
			conn.close();
			
			}catch(Exception e){
				try {
					//conn.rollback(); 
					System.out.println(e);
					//throw new GeneralException("Error in insertLoginDtls");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				
			}finally{
				   try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				         
				      }finally{//end finally try
			      }
			   }

	
			
	}	
	
}
