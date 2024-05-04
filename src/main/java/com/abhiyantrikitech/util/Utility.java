package com.abhiyantrikitech.util;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.HttpsURLConnection;

import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.*;

import org.apache.commons.text.WordUtils;
import org.apache.tomcat.util.json.JSONParser;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Time;

import org.json.JSONArray;
import org.json.JSONObject;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.codec.Base64.InputStream;

import javax.swing.text.html.StyleSheet;

public class Utility {

	private static final Logger LOGGER = Logger.getLogger(Utility.class.getName());
	 private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		

	public static Date convertStringToDate(String dateInString, String inputStringDateFormat) throws Exception {
		
		LOGGER.info("=========================== Utility -> convertStringToDate() starts ===========================");
		DateFormat df = new SimpleDateFormat(inputStringDateFormat);
		Date date = df.parse(dateInString);
		//LOGGER.info("=========================== Utility -> convertStringToDate() end ===========================");
		return date;
	}
	
	 public static int differnceInYear(Date from_dt, Date to_dt) throws Exception {
			
	  		LOGGER.info("=========================== Utility -> differnceInYear() starts ===========================");
	  		System.out.println("from_dt="+from_dt);
	  		System.out.println("to_dt="+to_dt);
	  		
	  		long diff =to_dt.getTime()-from_dt.getTime();
	  		int no_of_day=(int) ((diff/ (1000 * 60 * 60 * 24))% 365);
	  		int yr=(int) ((diff/ (1000 * 60 * 60 * 24)) / 365);
	  		//LOGGER.info("=========================== Utility -> differnceInYear() end ===========================");
	  		return yr;
	  	}
	
    public static int differnceInDay(Date from_dt, Date to_dt) throws Exception {
		
		LOGGER.info("=========================== Utility -> differnceInDay() starts ===========================");
	
		long diff =to_dt.getTime()-from_dt.getTime();
		int no_of_day=(int)diff/(24*60*60*1000);
		//LOGGER.info("=========================== Utility -> differnceInDay() end ===========================");
		return no_of_day;
	}
    
 public static int differnceInDay(String from_dt_str, String to_dt_str) throws Exception {
		
		LOGGER.info("=========================== Utility -> differnceInDay() starts ===========================");
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date from_dt = df.parse(from_dt_str);
		Date to_dt = df.parse(to_dt_str);
		
		long diff =to_dt.getTime()-from_dt.getTime();
		int no_of_day=(int)diff/(24*60*60*1000);
		//LOGGER.info("=========================== Utility -> differnceInDay() end ===========================");
		return no_of_day;
	}
	
    public static String convertDateFormatInString(String dateInString, String currentFormat,String targetFormat) throws Exception {
		
		LOGGER.info("=========================== Utility -> convertDateFormatInString() starts ===========================");
		 String timezone = "CDT";
		 String targetDate="";
		 DateFormat srcDf = new SimpleDateFormat(currentFormat);
		 srcDf.setTimeZone(TimeZone.getTimeZone(timezone));
		 DateFormat destDf = new SimpleDateFormat(targetFormat);
		 try
		 {
		 Date date = srcDf.parse(dateInString.trim());
		 targetDate = destDf.format(date);
		 //System.out.println("targetDate-"+targetDate);
		 }
		 catch (Exception e)
		 {
			 System.out.println("exception in convertDateFormatInString");
			 e.printStackTrace();
		 }
		
		//LOGGER.info("=========================== Utility -> convertDateFormatInString() end ===========================");
		return targetDate;
	}
    
    
public static Date convertDateFormatInDate(String dateInString, String currentFormat,String targetFormat) throws Exception {
		
		LOGGER.info("=========================== Utility -> convertDateFormatInString() starts ===========================");
		 String timezone = "CDT";
		 String targetDate="";
		 Date finalDate = null;
		 DateFormat srcDf = new SimpleDateFormat(currentFormat);
		 srcDf.setTimeZone(TimeZone.getTimeZone(timezone));
		 DateFormat destDf = new SimpleDateFormat(targetFormat);
		 try
		 {
			 Date date = srcDf.parse(dateInString);
			 targetDate = destDf.format(date);
			 //System.out.println("targetDate-"+targetDate);
			 
			 finalDate = destDf.parse(targetDate);
			 //System.out.println("finalDate-"+finalDate);
			 
			 finalDate = Utility.convertStringToDate(targetDate, targetFormat);
			 //System.out.println("finalDate-"+finalDate);
		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }
		
		//LOGGER.info("=========================== Utility -> convertDateFormatInString() end ===========================");
		return finalDate;
	}

public static Date convertDateFormat(Date date,String targetFormat) throws Exception {
	
	LOGGER.info("=========================== Utility -> convertDateFormat() starts ===========================");
	 String timezone = "CDT";
	 String targetDate="";
	 Date finalDate = null;
	 
	 DateFormat destDf = new SimpleDateFormat(targetFormat);
	 try
	 {		 
		 targetDate = destDf.format(date);
	 
		 finalDate = destDf.parse(targetDate);
	 //System.out.println("finalDate-"+targetDate);
	 }
	 catch (Exception e)
	 {
		 e.printStackTrace();
	 }
	
	//LOGGER.info("=========================== Utility -> convertDateFormatInString() end ===========================");
	return finalDate;
}

public static String convertDateFormatString(Date date,String targetFormat) throws Exception {
	
	LOGGER.info("=========================== Utility -> convertDateFormatString() starts ===========================");
	 String timezone = "CDT";
	 String targetDate="";
	 Date finalDate = null;
	 
	 DateFormat destDf = new SimpleDateFormat(targetFormat);
	 try
	 {		 
		 targetDate = destDf.format(date);
	 
		 
	 //System.out.println("finalDate-"+targetDate);
	 }
	 catch (Exception e)
	 {
		 e.printStackTrace();
	 }
	
	//LOGGER.info("=========================== Utility -> convertDateFormatInString() end ===========================");
	return targetDate;
}
	
	public static String todayDateInStr(String inputStringDateFormat) throws Exception {
		
		LOGGER.info("=========================== Utility -> todayDateInStr() starts ===========================");
		Date todate = new Date();
		DateFormat df = new SimpleDateFormat(inputStringDateFormat);
		
		String date = df.format(todate);
		//LOGGER.info("=========================== Utility -> todayDateInStr() end ===========================");
		return date;
	}
	
	public static Date todayDate(String inputStringDateFormat) throws Exception {
		
		LOGGER.info("=========================== Utility -> todayDate() starts ===========================");
		Date todate = new Date();
		DateFormat df = new SimpleDateFormat(inputStringDateFormat);
		
		String date = df.format(todate);		
		Date date1 = df.parse(date);
		//LOGGER.info("=========================== Utility -> todayDate() end ===========================");
		return date1;
	}
	
	public static java.sql.Date todayDateSql(String inputStringDateFormat) throws Exception {
		
		LOGGER.info("=========================== Utility -> todayDateSql() starts ===========================");
		Date todate = new Date();
		DateFormat df = new SimpleDateFormat(inputStringDateFormat);
		
		String date = df.format(todate);		
		Date date1 = df.parse(date);
		
		java.sql.Date sqlDate=new java.sql.Date(date1.getTime());
		//LOGGER.info("=========================== Utility -> todayDateSql() end ===========================");
		return sqlDate;
	}
	
	public static java.sql.Date todayDateSql() throws Exception {
		
		LOGGER.info("=========================== Utility -> todayDateSql() starts ===========================");
		java.util.Date utilDate = new java.util.Date();
		
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
		//LOGGER.info("=========================== Utility -> todayDateSql() end ===========================");
		return sqlDate;
	}
	
    public static java.sql.Date convertSqlDate(java.util.Date utilDate) throws Exception {
		
		LOGGER.info("=========================== Utility -> convertSqlDate() starts ===========================");
				
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
		//LOGGER.info("=========================== Utility -> convertSqlDate() end ===========================");
		return sqlDate;
	}
    
    public static Time convertSqlTime(java.util.Date utilDate) throws Exception {
		
		LOGGER.info("=========================== Utility -> convertSqlTime() starts ===========================");
				
		//java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
		//LOGGER.info("=========================== Utility -> convertSqlTime() end ===========================");
		return new java.sql.Time(utilDate.getTime());
	}
	
	public static Date addDayDate(int noofday,String inputStringDateFormat) throws Exception {
		
		LOGGER.info("=========================== Utility -> addDayDate() starts ===========================");
		Date today = new Date();
		Date newdate = new Date( today.getYear(), today.getMonth(), today.getDate() + noofday );
		
		//Date todate = new Date();
		DateFormat df = new SimpleDateFormat(inputStringDateFormat);
		
		String date = df.format(newdate);		
		Date date1 = df.parse(date);
		//LOGGER.info("=========================== Utility -> addDayDate() end ===========================");
		return date1;
	}
	
public static Date addDayInTargetDate(int noofday,Date targetDate) throws Exception {
		
		LOGGER.info("=========================== Utility -> addDayInTargetDate() starts ===========================");
		//Date today = new Date();
		Date newdate = new Date( targetDate.getYear(), targetDate.getMonth(), targetDate.getDate() + noofday );
		
		//Date todate = new Date();
		//DateFormat df = new SimpleDateFormat(inputStringDateFormat);
		
		
		//LOGGER.info("=========================== Utility -> addDayInTargetDate() end ===========================");
		return newdate;
	}
	
	public static String compareDates(Date date1, Date date2) throws Exception {
		
		LOGGER.info("=========================== Utility -> compareDates() starts ===========================");
		String returnVal = "";
		
		long diff = date1.getTime() - date2.getTime();
		if(diff == 0) {
			returnVal = "date1_equal_to_date2";
		}else if (diff > 0) {
			returnVal = "date2_lesser_than_date1";
		}else if (diff < 0) {
			returnVal = "date2_grater_than_date1";
		}
		
		//LOGGER.info("=========================== Utility -> compareDates() end ===========================");
		return returnVal;
	}
	
	public static boolean validateStartEndSpaces(String val) throws Exception {
		LOGGER.info("=========================== Utility -> validateStartEndSpaces() starts ===========================");

		Pattern pspace = Pattern.compile("^[^\\ ].*[^\\ .]$");
		Matcher mspace = pspace.matcher(val); 
		
		//LOGGER.info("=========================== Utility -> validateStartEndSpaces() ends ===========================");
		return (mspace.find() && mspace.group().equals(val));
	}
	
	
	public static boolean validateEmail(String emailId) throws Exception {
		
		LOGGER.info("============= validateEmail() Utility Start =============================");
		
		if(!validateStartEndSpaces(emailId)) {
			return false;
		}
		
        Pattern p = Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$"); 
        Matcher m = p.matcher(emailId); 
        
		//LOGGER.info("============= validateEmail() Utility End =============================");

        return (m.find() && m.group().equals(emailId));
	}
	
	public static boolean validateMobileNo(String mabileNo) throws Exception {
		
		LOGGER.info("=========================== Utility -> validateMobileNo() starts ===========================");

        Pattern p = Pattern.compile("^((?!(0))[0-9]{10})$"); 
        Matcher m = p.matcher(mabileNo); 
        
        //LOGGER.info("=========================== Utility -> validateMobileNo() end ===========================");
        return (m.find() && m.group().equals(mabileNo)); 	
	}
	
	public static boolean validatePassword(String password) throws Exception {
		
		LOGGER.info("=========================== Utility -> validatePassword() starts ===========================");
		System.out.println("Utility -> validatePassword() starts"+password);
        //Pattern p = Pattern.compile("^[^\\ ].((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,30}).*[^\\ .]$");
		if(!validateStartEndSpaces(password)) {
			return false;
		}
		
		//Pattern p = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
		//Pattern p = Pattern.compile("(^(?=.*[0-9])(?=.*[a-z]).{6,32})");
		//Pattern p = Pattern.compile("(^(.*[0-9])((?i).*[a-z]){5,32})");
		//o-9 & a-z (ignore case) & total length 6 to 32
		
        //Matcher m = p.matcher(password); 
        
       // LOGGER.info("=========================== Utility -> validatePassword() end ===========================");
        //return (m.find() && m.group().equals(password));
        return true;
	}
	
	public static boolean vallidateLoginId(String loginId) throws Exception	{
		
		LOGGER.info("=========================== Utility -> vallidateLoginId() starts ===========================");
		System.out.println("Utility -> vallidateLoginId() starts-"+loginId);
		if (checkNull(loginId)=="")
		{
			return false;
		}
		
		
		if(!validateStartEndSpaces(loginId)) {
			return false;
		}
		//return true;
		
        Pattern p = Pattern.compile("^[a-zA-Z0-9@#()<>_.-]{3,100}+$"); 
        Matcher m = p.matcher(loginId); 
        
        //LOGGER.info("=========================== Utility -> vallidateLoginId() end ===========================");
        return (m.find() && m.group().equals(loginId));

	}
	
	
	
	public static String generateOTP(int length) throws Exception {
		
		LOGGER.info("=========================== Utility -> generateOTP() starts ===========================");
        // Using numeric values 
        String numbers = "0123456789"; 
  
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] otp = new char[length]; 
  
        for (int i = 0; i < length; i++)  { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
		
        String otpString = new String(otp);
        
        //LOGGER.info("=========================== Utility -> generateOTP() end ===========================");
	    return otpString;
	}

	public static boolean sendSms_backup(String mobileNo, String smsBody ,String sender) {
		LOGGER.info("=========================== Utility -> sendSms() starts ===========================");
		int responsecode=0;
		String data="";
		String sender1="AYTBPL";
		try {
				Date mydate = new Date(System.currentTimeMillis());
				
				String sms_url="http://sms.datagenit.in/API/sms-api.php?auth=D!~347441nToIHfv2&senderid="+sender1+"&msisdn="+mobileNo+"&message="+smsBody;
				System.out.println("SMS body -"+sms_url);
				URL url = new URL(sms_url);
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setUseCaches(false);
				conn.connect();
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				StringBuffer buffer = new StringBuffer();
				while ((line = rd.readLine()) != null)
				{
					//System.out.println("line-->"+line);
					buffer.append(line).append("\n");
				}
				//System.out.println(buffer.toString());
				
				System.out.println("Response Code -  "+conn.getResponseCode());
				responsecode=conn.getResponseCode();
				
				data=getDataFromJson(buffer.toString());
				System.out.println("Result------"+data);
				
				rd.close();
				conn.disconnect();
				
				if (data.equalsIgnoreCase("success"))
				{
					System.out.println("Message Sent");
					return true;
				}
				else
				{
					System.out.println("Message Sent failed");
					return false;
				}
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception");
				return false;
			}
		
		
		
		//LOGGER.info("=========================== Utility -> sendSms() end ===========================");
		//return true;
	}
	
	public static boolean sendSms(String mobileNo, String smsBody ,String sender) {
		LOGGER.info("=========================== Utility -> sendNISMSms() starts ===========================");
		int responsecode=0;
		String data="";
		String sender1="AYTBPL";
		System.out.println("SMS Body="+smsBody + "  ===For Mobile No==="+mobileNo);
		try {
				Date mydate = new Date(System.currentTimeMillis());
				//Date mydate = new Date(System.currentTimeMillis());
				//String data = "";
				data += "method=sendMessage";
				data += "&userid=2000193635"; // your loginId 
				data += "&password=" +
				URLEncoder.encode("Nism@1234!", "UTF-8"); // your password
				data += "&msg=" + URLEncoder.encode(smsBody, "UTF-8");
				data += "&send_to=" +
				URLEncoder.encode(mobileNo, "UTF-8"); // a valid 10 digit phone no.
				data += "&v=1.1" ;
				data += "&msg_type=TEXT"; // Can by "FLASH" or"UNICODE_TEXT" or “BINARY”
				data += "&auth_scheme=PLAIN";
				URL url = new URL("https://enterprise.smsgupshup.com/GatewayAPI/rest?" + data);
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setUseCaches(false);
				conn.connect();
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				StringBuffer buffer = new StringBuffer(); 
				while ((line = rd.readLine()) != null){
				buffer.append(line).append("\n");
				//System.out.println("line="+rd.readLine());
				}
				System.out.println(buffer.toString());
				
				String status=buffer.toString().substring(0, 7);
				rd.close();
				conn.disconnect();
				if (status.equalsIgnoreCase("success"))
				{
					System.out.println("Message Sent");
					return true;
				}
				else
				{
					System.out.println("Message Sent failed from first vendor");
					
					if (sendSmsAlternate(mobileNo, smsBody ,sender))
					{
						System.out.println("Message Sent from second vendor");
						return true;
					}
					else
					{
						System.out.println("Message Sent failed from second vendor");
						return false;
					}
					
				}
				
			}
			catch(Exception e){ 
				e.printStackTrace();
				return false;
			}
				
		
		
		//LOGGER.info("=========================== Utility -> sendSms() end ===========================");
		//return true;
	}
	
	
	public static boolean sendSmsAlternate(String mobileNo, String smsBody ,String sender) {
		LOGGER.info("=========================== Utility -> sendSmsAlternate() starts ===========================");
		int responsecode=0;
		String data="";
		String sender1="AYTBPL";
		try {
				Date mydate = new Date(System.currentTimeMillis());
				//Date mydate = new Date(System.currentTimeMillis());
				//String data = "";
				data += "method=sendMessage";
				data += "&userid=2000193635"; // your loginId 
				data += "&password=" +
				URLEncoder.encode("Nism@1234!", "UTF-8"); // your password
				data += "&msg=" + URLEncoder.encode(smsBody + mydate.toString(), "UTF-8");
				data += "&send_to=" +
				URLEncoder.encode(mobileNo, "UTF-8"); // a valid 10 digit phone no.
				data += "&v=1.1" ;
				data += "&msg_type=TEXT"; // Can by "FLASH" or"UNICODE_TEXT" or “BINARY”
				data += "&auth_scheme=PLAIN";
				URL url = new URL("https://enterprise.smsgupshup.com/GatewayAPI/rest?" + data);
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setUseCaches(false);
				conn.connect();
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				StringBuffer buffer = new StringBuffer(); 
				while ((line = rd.readLine()) != null){
				buffer.append(line).append("\n");
				//System.out.println("line="+rd.readLine());
				}
				System.out.println(buffer.toString());
				
				String status=buffer.toString().substring(0, 7);
				rd.close();
				conn.disconnect();
				if (status.equalsIgnoreCase("success"))
				{
					System.out.println("Message Sent");
					return true;
				}
				else
				{
					System.out.println("Message Sent failed");
					return false;
				}
				
			}
			catch(Exception e){ 
				e.printStackTrace();
				return false;
			}
				
		
		
		//LOGGER.info("=========================== Utility -> sendSms() end ===========================");
		//return true;
	}
	
	public static boolean sendWhatsupMessage(String mobileNo, String smsBody) {
		LOGGER.info("=========================== Utility -> sendWhatsupMessage() starts ===========================");
		int responsecode=0;
		String data="";
		String sender1="AYTBPL";
		System.out.println("Whatsup Body="+smsBody + "  ===For Mobile No==="+mobileNo);
		try {
				Date mydate = new Date(System.currentTimeMillis());
				//Date mydate = new Date(System.currentTimeMillis());
				//String data = "";
				data += "method=SendMessage";
				data += "&userid=2000203679"; // your loginId 
				data += "&password=" +
				URLEncoder.encode("ufWcTPEh", "UTF-8"); // your password
				data += "&msg=" + URLEncoder.encode(smsBody, "UTF-8");
				data += "&send_to=" +
				URLEncoder.encode(mobileNo, "UTF-8"); // a valid 10 digit phone no.
				data += "&v=1.1" ;
				data += "&msg_type=Text"; // Can by "FLASH" or"UNICODE_TEXT" or “BINARY”
				data += "&auth_scheme=plain";
				URL url = new URL("http://media.smsgupshup.com/GatewayAPI/rest?" + data);
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setUseCaches(false);
				conn.connect();
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				StringBuffer buffer = new StringBuffer(); 
				while ((line = rd.readLine()) != null){
				buffer.append(line).append("\n");
				System.out.println("line=="+rd.readLine());
				}
				
				System.out.println("output=="+buffer.toString());
				//String output=getDataFromJson(buffer.toString());
				
				//System.out.println("output=="+output);
				
				String status=buffer.toString().substring(0, 7);
				rd.close();
				conn.disconnect();
				if (status.equalsIgnoreCase("success"))
				{
					System.out.println("Whatsup Message Sent");
					return true;
				}
				else
				{
					System.out.println("Whatsup Message Sent failed from vendor due to "+buffer.toString());					
					
						return false;					
					
				}
				
			}
			catch(Exception e){ 
				e.printStackTrace();
				return false;
			}
				
		
		
		//LOGGER.info("=========================== Utility -> sendSms() end ===========================");
		//return true;
	}
	
	
	public static String checkNull(String str) throws Exception{
		if(str==null)
			return "";
		else
			return str.trim();
	}

	public static String checkNull(Object object) {
		// TODO Auto-generated method stub
		if(object==null)
			return "";
		else
			return object.toString();
	}
	
	
	
	public static String getDataFromJson(String jsonData) {
		// TODO Auto-generated method stub
		String data="";
		JSONObject obj = new JSONObject(jsonData);
		
		data = obj.getString("status");
		
		
		return data;
		
	}

	public static String stringToColor(String colorName) {
		String rgbcolor = "0";
		try{
		StyleSheet s = new StyleSheet();
		String rgb = colorName;
		Color c1 = s.stringToColor(rgb);
		int r1 = c1.getRed();
		int g1 = c1.getGreen();
		int b1 = c1.getBlue();
		rgbcolor=r1 + ", " + g1 + ", " + b1;
		//System.out.println(rgbcolor);
		}
		catch (Exception e)
		{e.printStackTrace();
		}
		return rgbcolor;
		
		}
	
	public static void pdfGenerate(String htmlData,String filePath,String fileName) {
		try {
			HtmlConverter.convertToPdf(htmlData, new FileOutputStream(filePath+fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        System.out.println( "PDF Created!" );
	}
	
	public static void txtGenerate(String Data,String filePath,String fileName) {		 
		try   
		{  
		
		  FileWriter myWriter = new FileWriter(filePath+fileName);
	      myWriter.write(Data);
	      myWriter.close();
		 
		}    catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
        System.out.println( "TXT Created!" );
	}
	
	 public static String convertToIndianCurrency(String num) {
	        BigDecimal bd = new BigDecimal(num);
	        long number = bd.longValue();
	        long no = bd.longValue();
	        int decimal = (int) (bd.remainder(BigDecimal.ONE).doubleValue() * 100);
	        int digits_length = String.valueOf(no).length();
	        int i = 0;
	        ArrayList<String> str = new ArrayList<>();
	        HashMap<Integer, String> words = new HashMap<>();
	        words.put(0, "");
	        words.put(1, "One");
	        words.put(2, "Two");
	        words.put(3, "Three");
	        words.put(4, "Four");
	        words.put(5, "Five");
	        words.put(6, "Six");
	        words.put(7, "Seven");
	        words.put(8, "Eight");
	        words.put(9, "Nine");
	        words.put(10, "Ten");
	        words.put(11, "Eleven");
	        words.put(12, "Twelve");
	        words.put(13, "Thirteen");
	        words.put(14, "Fourteen");
	        words.put(15, "Fifteen");
	        words.put(16, "Sixteen");
	        words.put(17, "Seventeen");
	        words.put(18, "Eighteen");
	        words.put(19, "Nineteen");
	        words.put(20, "Twenty");
	        words.put(30, "Thirty");
	        words.put(40, "Forty");
	        words.put(50, "Fifty");
	        words.put(60, "Sixty");
	        words.put(70, "Seventy");
	        words.put(80, "Eighty");
	        words.put(90, "Ninety");
	        String digits[] = {"", "Hundred", "Thousand", "Lakh", "Crore"};
	        while (i < digits_length) {
	            int divider = (i == 2) ? 10 : 100;
	            number = no % divider;
	            no = no / divider;
	            i += divider == 10 ? 1 : 2;
	            if (number > 0) {
	                int counter = str.size();
	                String plural = (counter > 0 && number > 9) ? "s" : "";
	                String tmp = (number < 21) ? words.get(Integer.valueOf((int) number)) + " " + digits[counter] + plural : words.get(Integer.valueOf((int) Math.floor(number / 10) * 10)) + " " + words.get(Integer.valueOf((int) (number % 10))) + " " + digits[counter] + plural;                
	                str.add(tmp);
	            } else {
	                str.add("");
	            }
	        }
	 
	        Collections.reverse(str);
	        String Rupees = String.join(" ", str).trim();
	 
	        String paise = (decimal) > 0 ? "And " + words.get(Integer.valueOf((int) (decimal - decimal % 10))) + " " + words.get(Integer.valueOf((int) (decimal % 10)))+" Paise" : "";
	        return Rupees+" Rupees " + paise+ "Only";
	    }
		
		public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
		}
		
		
	    private static void downloadUsingNIO(String urlStr, String file) throws IOException {
	        URL url = new URL(urlStr);
	        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
	        FileOutputStream fos = new FileOutputStream(file);
	        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	        fos.close();
	        rbc.close();
	    }
	    
	   

	    public static String getTimeStamp() {
	    	  DateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
	    	  String timeStamp = format.format(new Date());
	    	  return timeStamp;
	    	}
		
	    public static String capitalizeString(String string) {
	    	try
	    	{
	    		final char[] delimiters = { ' ', '-'};
	    		
	    	if (string!=null&&!string.equals(""))
	    	{
	    	
		    	return WordUtils.capitalizeFully(string,delimiters);
		    	/*  char[] chars = string.toLowerCase().toCharArray();
		    	  boolean found = false;
		    	  for (int i = 0; i < chars.length; i++) {
		    	    if (!found && Character.isLetter(chars[i])) {
		    	      chars[i] = Character.toUpperCase(chars[i]);
		    	      found = true;
		    	    } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { // You can add other chars here
		    	      found = false;
		    	    }
		    	  }
		    	  return String.valueOf(chars);
		    	  */
	    	}
	    	return string;
	    	}catch (Exception e)
	    	{
	    		e.printStackTrace();
	    		return string;
	    	}
	    	
	    	
	    	}
	    
	    
	    public static String convertFirstLetterInCapitalString(String string) {
	    	try
	    	{
	    		
	    		
	    	if (string!=null&&!string.equals(""))
	    	{
	    	
	    		String str = string;
	    		string = str.substring(0, 1).toUpperCase() + str.substring(1);
	    		

	    	}
	    	return string;
	    	}catch (Exception e)
	    	{
	    		e.printStackTrace();
	    		return string;
	    	}
	    	
    	
    	}
	    
public static String convertInOrdinal(String number){
	
	try{
		int d= Integer.parseInt(number);
	    if (d > 3 && d < 21) {
	    	return "th";
	    }
	    switch (d % 10) {
	      case 1:  return "st";
	      case 2:  return "nd";
	      case 3:  return "rd";
	      default: return "th";
	    }
	}catch(Exception e){
		e.printStackTrace();
		return "";
	}
} 
	 
	
	public static void main(String[] args) throws Exception 
	{
		/*System.out.println(">>>>>"+convertInOrdinal(1));
		System.out.println(">>>>>"+convertInOrdinal(2));
		System.out.println(">>>>>"+convertInOrdinal(3));
		System.out.println(">>>>>"+convertInOrdinal(10));
		System.out.println(">>>>>"+convertInOrdinal(27));
		System.out.println(">>>>>"+convertInOrdinal(32));*/
		//System.out.println(new Date()+"  generateQuiz in EnrolmentController for program id="+1+" and login by "+2);	
		//double i=Double.parseDouble("67.0");
		//double j=Double.parseDouble("60");
		//if(j<i)
		
		/*int score=((1/2)*100);
		System.out.println("score=="+score);
		System.out.println("score1=="+5.0/10.0);
		System.out.println("score2=="+(1/2)*100);*/
		/*
		Date todayDt=Utility.todayDate("dd-MM-yyyy HH:mm");
		System.out.println("todayDt=="+todayDt);
		
			Date validDate= Utility.convertStringToDate("2021-10-27 00:00", "yyyy-MM-dd HH:mm");
			System.out.println("validDate=="+validDate);
			
			if (todayDt.compareTo(validDate)>0)
			{
				System.out.println("today date is greater than valid date");
			}
		*/
		
		/*String details = "Hello \"world\"!";
		details = details.replace("\"","\\\"");
		System.out.println(details); */  
		
		//String str="1004,1,MOLDTKPAC,Updates,Mold-Tek Packaging Limited has informed the Exchange regarding 'Intimation of filing of application relating to re-classification of certain shareholders of MOLD-TEK PACKAGING LIMITED (  company ) from the  Promoter and Promoter Group  Category to the  Public  Category under Regulation 31A of Securities and Exchange board of India (Listing Obligations and Disclosure Requirements) Regulations, 2015 (Listing Regulations )'. A copy of the same shall be available on the NSE website (http://www.nseindia.com) under: Corporates > Latest Announcements and on the Extranet Server (/common/CorporateAnnouncements).,131020212003,MOLDTKPAC_13102021200316_Intimationapplication.pdf";
		//String dataArr[]=str.split("\\,");
		//System.out.println(dataArr.length);
		//String fileName="CASH_Trades_22022022.DAT";
		//fileName.toUpperCase().contains("COMDS_TRADES_*.DAT");
		
		//System.out.println(fileName.toUpperCase().matches("CASH_TRADES_.*.DAT"));
		
	/*	String msg="Dear  Deepak\n\n"+
"Your registration for Azadi Ka Amrit Mahotsav Program has been done. Kindly login and proceed. Here are your login credentials.\n\n"+
				"Email: - deepakp\n"+
				"Password - deepakp\n\n"+
				"Click Here to login - https://quiz.nism.ac.in/loginAzadiQuiz  \n\n"+
				"In case of  any difficulty feel free to contact on 8095210200 or write back on Sebiquiz@nism.ac.in \n\n"+
				"Regards,\n"+
				"NISM\n\n"+
				"Note: This is an auto generated message. Please do not respond.";
		
		System.out.println(msg);
		sendWhatsupMessage("8080886250",msg);*/
		
		String SMSBody="Dear Deepak ,\n\n"+
				"Your registration for Azadi Ka Amrit Mahotsav Program has been done. Kindly login and proceed. Here are your login credentials.\n\n"+
								"Email: - deepakp\n"+
								"Password - password\n\n"+
								"Click Here to login - https://quiz.nism.ac.in/loginAzadiQuiz\n\n"+
								"In case of  any difficulty feel free to contact on 8095210200 or write back on Sebiquiz@nism.ac.in .\n\n"+
								"Regards,\n"+
								"NISM";
		
		System.out.println(SMSBody);
		
		sendSms("8080886250", SMSBody, "AYTBPL");
		
	}
	
 }



