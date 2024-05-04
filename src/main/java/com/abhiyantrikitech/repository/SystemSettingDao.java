package com.abhiyantrikitech.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;


import com.abhiyantrikitech.model.SystemSetting;
import com.abhiyantrikitech.util.Utility;

@Repository
public class SystemSettingDao {
	
	ConnectionBean connBean=null;
	//Connection conn=null;
	//PreparedStatement pstmt=null;
	//ResultSet rs=null;

public SystemSettingDao(){
	connBean=new ConnectionBean();
}
public SystemSetting saveSystemSetting(SystemSetting ss, String loggedInUser) throws Exception{	
	
	 int in_ua_id = 0;
	 Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
try{
	System.out.println("saveSystemSetting in SystemSettingDao");
		conn=connBean.getConnectionObj();
		
		
			
			pstmt=conn.prepareStatement("SELECT nextval('SEQ_SystemSetting_ID') LC_UA_ID");
			
		    rs=pstmt.executeQuery();
		    
		     
			while(rs.next()){
				//System.out.println("---ss id---"+rs.getString("LC_UA_ID"));
				in_ua_id= rs.getInt("LC_UA_ID");
			}
			System.out.println("ss id---"+in_ua_id);
			
			pstmt.close();
			rs.close();

			pstmt=conn.prepareStatement("insert into tbl_system_setting_mas (ssm_id,ssm_company_name,ssm_smtp_host,"
					+ "ssm_smtp_port,ssm_smtp_userName,ssm_smtp_password,ssm_creat_by,ssm_creat_date,"
					+ "ssm_sender,ssm_mailFrom,ssm_program_name,ssm_issue_auth_name1,ssm_issue_auth_sign1,"
					+ "ssm_issue_auth_designation1,ssm_issue_department_name,ssm_issue_department_phone,"
					+ "ssm_issue_department_email,ssm_contact_person_name,ssm_contact_person_phone,"
					+ "ssm_contact_person_email,ssm_issue_auth_name2,ssm_issue_auth_sign2,ssm_issue_auth_designation2,"
					+ "ssm_quiz_marks_limit,ssm_project_name,ssm_contact_person_designation,ssm_dean_name,ssm_dean_phone,ssm_dean_email,"
					+ "ssm_dean_designation,ssm_dean_sig,ssm_submission_email,ssm_subject_id,ssm_essay_submit_due_in_hrs)"
					+ "VALUES(?,?,?,?,?,?,?,NOW(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");	
			
			pstmt.setInt(1,in_ua_id);
			pstmt.setString(2, ss.getCompanyName());
			pstmt.setString(3, ss.getSmtpHost());
			pstmt.setString(4, ss.getSmtpPort());
			pstmt.setString(5, ss.getSmtpUserName());
			pstmt.setString(6, ss.getSmtpPassword());		
			pstmt.setString(7, loggedInUser);			
			pstmt.setString(8, ss.getSmsSender());
			pstmt.setString(9, ss.getEmailFrom());
			
			pstmt.setString(10, ss.getProgramName());
			pstmt.setString(11, ss.getIssueAuthName1());
			pstmt.setString(12, ss.getIssueAuthNameSign1());
			pstmt.setString(13, ss.getIssueAuthDesignation1());
			pstmt.setString(14, ss.getDepartmentName());
			pstmt.setString(15, ss.getDepartmentPhone());
			pstmt.setString(16, ss.getDepartmentEmail());
			pstmt.setString(17, ss.getContactName());
			pstmt.setString(18, ss.getContactPhone());
			pstmt.setString(19, ss.getContactEmail());
			pstmt.setString(20, ss.getIssueAuthName2());
			pstmt.setString(21, ss.getIssueAuthNameSign2());
			pstmt.setString(22, ss.getIssueAuthDesignation2());
			if (ss.getQuizMarksLimit()==null||ss.getQuizMarksLimit().equals(""))
			{
				pstmt.setString(23, null);
			}
			else
			{
				pstmt.setString(23, ss.getQuizMarksLimit());
			}
			pstmt.setString(24, ss.getProgramName());
			pstmt.setString(25, ss.getContactDesignation());
			
			pstmt.setString(26, ss.getDeanName());
			pstmt.setString(27, ss.getDeanPhone());
			pstmt.setString(28, ss.getDeanEmail());
			pstmt.setString(29, ss.getDeanDesignation());
			pstmt.setString(30, ss.getDeanSign());
			pstmt.setString(31, ss.getSubmissionEmailId());
			pstmt.setString(32, ss.getSubjectId());
			pstmt.setString(33, ss.getEssaySubmitDueDateInHrs());
			
		
		    int count = pstmt.executeUpdate();
		    
		    
		    if(count!=0){
		    	
		    	System.out.println(">>>SAVE System Setting MAS<<<");
		    	
		    	ss.setRecordUpdate("true");
		    	ss.setId(in_ua_id+"");
		    	
		    }
		    else
		    {
		    	System.out.println(">>>System Setting SAVED FAILED<<<");
		    	ss.setRecordUpdate("false");
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

return ss;
		
}	
	
@SuppressWarnings("rawtypes")
public SystemSetting getSystemSettingListById(String id ) throws Exception {
	System.out.println("Inside getSystemSettingListById ssdao :");
	SystemSetting ss=new SystemSetting();   
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{

	conn=connBean.getConnectionObj();
	
		if (id==null||id.equals(""))
		{
			pstmt=conn.prepareStatement("select * from tbl_system_setting_mas limit 1 ");
		}
		else
		{
			pstmt=conn.prepareStatement("select * from tbl_system_setting_mas where ssm_id=? ");
			pstmt.setString(1, id);
		}
		
		
		//pstmt.setString(1, id);
		
	rs=pstmt.executeQuery();
	
	 
	
	while(rs.next()){
	
		
		ss.setId(rs.getString("ssm_id"));
		ss.setCompanyName(rs.getString("ssm_company_name"));
		ss.setSmtpHost(rs.getString("ssm_smtp_host"));
		ss.setSmtpPort(rs.getString("ssm_smtp_port"));
		ss.setSmtpUserName(rs.getString("ssm_smtp_userName"));
		ss.setSmtpPassword(rs.getString("ssm_smtp_password"));
		ss.setCreateBy(rs.getString("ssm_creat_by"));
		ss.setCreateDate(rs.getString("ssm_creat_date"));		
		ss.setSmsSender(rs.getString("ssm_sender"));
		ss.setEmailFrom(rs.getString("ssm_mailFrom"));
		
		ss.setProgramName(rs.getString("ssm_program_name"));
		ss.setIssueAuthName1(rs.getString("ssm_issue_auth_name1"));
		ss.setIssueAuthNameSign1(rs.getString("ssm_issue_auth_sign1"));
		ss.setIssueAuthDesignation1(rs.getString("ssm_issue_auth_designation1"));
		ss.setDepartmentName(rs.getString("ssm_issue_department_name"));
		ss.setDepartmentPhone(rs.getString("ssm_issue_department_phone"));
		ss.setDepartmentEmail(rs.getString("ssm_issue_department_email"));
		ss.setContactName(rs.getString("ssm_contact_person_name"));
		ss.setContactPhone(rs.getString("ssm_contact_person_phone"));
		ss.setContactEmail(rs.getString("ssm_contact_person_email"));
		ss.setContactDesignation(rs.getString("ssm_contact_person_designation"));
		ss.setIssueAuthName2(rs.getString("ssm_issue_auth_name2"));
		ss.setIssueAuthNameSign2(rs.getString("ssm_issue_auth_sign2"));
		ss.setIssueAuthDesignation2(rs.getString("ssm_issue_auth_designation2"));
		ss.setQuizMarksLimit(rs.getString("ssm_quiz_marks_limit"));
		ss.setProjectName(rs.getString("ssm_project_name"));
		
		ss.setDeanName(rs.getString("ssm_dean_name"));
		ss.setDeanPhone(rs.getString("ssm_dean_phone"));
		ss.setDeanEmail(rs.getString("ssm_dean_email"));
		ss.setDeanDesignation(rs.getString("ssm_dean_designation"));
		ss.setDeanSign(rs.getString("ssm_dean_sig"));
		ss.setSubmissionEmailId(rs.getString("ssm_submission_email"));
		ss.setSubjectId(rs.getString("ssm_subject_id"));
		
		ss.setEssaySubmitDueDateInHrs(rs.getString("ssm_essay_submit_due_in_hrs"));
		
	
	}
	
	rs.close();
	pstmt.close();
	conn.close();
	
	}catch(Exception e){
		try {
			System.out.println(e);
			//throw new GeneralException("Error in ");
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
	   }//end try
		
		
		return ss;	
}


@SuppressWarnings("rawtypes")
public SystemSetting getSystemSettingListBySubjectId(String id ) throws Exception {
	System.out.println("Inside getSystemSettingListBySubjectId ssdao :");
	SystemSetting ss=new SystemSetting();   
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{

	conn=connBean.getConnectionObj();
	
		if (id==null||id.equals(""))
		{
			pstmt=conn.prepareStatement("select * from tbl_system_setting_mas limit 1 ");
		}
		else
		{
			pstmt=conn.prepareStatement("select * from tbl_system_setting_mas where ssm_subject_id=? ");
			pstmt.setString(1, id);
		}
		
		
		//pstmt.setString(1, id);
		
	rs=pstmt.executeQuery();
	
	 
	
	while(rs.next()){
	
		
		ss.setId(rs.getString("ssm_id"));
		ss.setCompanyName(rs.getString("ssm_company_name"));
		ss.setSmtpHost(rs.getString("ssm_smtp_host"));
		ss.setSmtpPort(rs.getString("ssm_smtp_port"));
		ss.setSmtpUserName(rs.getString("ssm_smtp_userName"));
		ss.setSmtpPassword(rs.getString("ssm_smtp_password"));
		ss.setCreateBy(rs.getString("ssm_creat_by"));
		ss.setCreateDate(rs.getString("ssm_creat_date"));		
		ss.setSmsSender(rs.getString("ssm_sender"));
		ss.setEmailFrom(rs.getString("ssm_mailFrom"));
		
		ss.setProgramName(rs.getString("ssm_program_name"));
		ss.setIssueAuthName1(rs.getString("ssm_issue_auth_name1"));
		ss.setIssueAuthNameSign1(rs.getString("ssm_issue_auth_sign1"));
		ss.setIssueAuthDesignation1(rs.getString("ssm_issue_auth_designation1"));
		ss.setDepartmentName(rs.getString("ssm_issue_department_name"));
		ss.setDepartmentPhone(rs.getString("ssm_issue_department_phone"));
		ss.setDepartmentEmail(rs.getString("ssm_issue_department_email"));
		ss.setContactName(rs.getString("ssm_contact_person_name"));
		ss.setContactPhone(rs.getString("ssm_contact_person_phone"));
		ss.setContactEmail(rs.getString("ssm_contact_person_email"));
		ss.setContactDesignation(rs.getString("ssm_contact_person_designation"));
		ss.setIssueAuthName2(rs.getString("ssm_issue_auth_name2"));
		ss.setIssueAuthNameSign2(rs.getString("ssm_issue_auth_sign2"));
		ss.setIssueAuthDesignation2(rs.getString("ssm_issue_auth_designation2"));
		ss.setQuizMarksLimit(rs.getString("ssm_quiz_marks_limit"));
		ss.setProjectName(rs.getString("ssm_project_name"));
		
		ss.setDeanName(rs.getString("ssm_dean_name"));
		ss.setDeanPhone(rs.getString("ssm_dean_phone"));
		ss.setDeanEmail(rs.getString("ssm_dean_email"));
		ss.setDeanDesignation(rs.getString("ssm_dean_designation"));
		ss.setDeanSign(rs.getString("ssm_dean_sig"));
		ss.setSubmissionEmailId(rs.getString("ssm_submission_email"));
		ss.setSubjectId(rs.getString("ssm_subject_id"));
		ss.setEssaySubmitDueDateInHrs(rs.getString("ssm_essay_submit_due_in_hrs"));
	
	}
	
	rs.close();
	pstmt.close();
	conn.close();
	
	}catch(Exception e){
		try {
			System.out.println(e);
			//throw new GeneralException("Error in ");
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
	   }//end try
		
		
		return ss;	
}

@SuppressWarnings("rawtypes")
public ArrayList getSystemSettingList() throws Exception {
	System.out.println("11Inside getSystemSettingList ssdao :");
	ArrayList<SystemSetting> ar=new ArrayList<SystemSetting>(); 
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	
	try{

		conn=connBean.getConnectionObj();
		
		
		pstmt=conn.prepareStatement("select * from tbl_system_setting_mas,tbl_subject_mas where "
				+ " ssm_subject_id=sm_id ");
		
		
	
		rs=pstmt.executeQuery();
	
	 
	
	while(rs.next()){
	
		SystemSetting ss = new SystemSetting();
		ss.setId(rs.getString("ssm_id"));
		ss.setCompanyName(rs.getString("ssm_company_name"));
		ss.setSmtpHost(rs.getString("ssm_smtp_host"));
		ss.setSmtpPort(rs.getString("ssm_smtp_port"));
		ss.setSmtpUserName(rs.getString("ssm_smtp_userName"));
		ss.setSmtpPassword(rs.getString("ssm_smtp_password"));
		ss.setCreateBy(rs.getString("ssm_creat_by"));
		ss.setCreateDate(rs.getString("ssm_creat_date"));
		ss.setProgramName(rs.getString("ssm_program_name"));

		ss.setSmsSender(rs.getString("ssm_sender"));
		ss.setEmailFrom(rs.getString("ssm_mailFrom"));
		ss.setSubjectId(rs.getString("ssm_subject_id"));
		ss.setSubjectName(rs.getString("sm_name"));

		
		ar.add(ss);
	}
	
	rs.close();
	pstmt.close();
	conn.close();
	
	System.out.println("end");
	
	}catch(Exception e){
		try {
			System.out.println(e);
			//throw new GeneralException("Error in ");
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
	   }//end try
		
		
		return ar;	
}
public SystemSetting modifySystemSetting(SystemSetting ss, String loggedInUser) throws Exception{	
	
	 int in_ua_id = 0;
	 Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
try{
	System.out.println("modifySystemSetting in ssDao");
		conn=connBean.getConnectionObj();
		

		 pstmt=conn.prepareStatement("update tbl_system_setting_mas set ssm_company_name=?,ssm_smtp_host=?,"
					+ "ssm_smtp_port=?,ssm_smtp_userName=?,ssm_smtp_password=?,ssm_last_upd_by=?,ssm_last_upd_date=now(),"
					+ "ssm_sender=?,ssm_mailFrom=?,ssm_program_name=?,ssm_issue_auth_name1=?,ssm_issue_auth_sign1=ifnull(?,ssm_issue_auth_sign1),"
					+ "ssm_issue_auth_designation1=?,ssm_issue_department_name=?,ssm_issue_department_phone=?,"
					+ "ssm_issue_department_email=?,ssm_contact_person_name=?,ssm_contact_person_phone=?,"
					+ "ssm_contact_person_email=?,ssm_issue_auth_name2=?,ssm_issue_auth_sign2=ifnull(?,ssm_issue_auth_sign2),ssm_issue_auth_designation2=?,"
					+ "ssm_quiz_marks_limit=?,ssm_project_name=?,ssm_contact_person_designation=?,"
					+ "ssm_dean_name=?,ssm_dean_phone=?,ssm_dean_email=?,"
					+ "ssm_dean_designation=?,ssm_dean_sig=ifnull(?,ssm_dean_sig),ssm_submission_email=?,ssm_subject_id=?,ssm_essay_submit_due_in_hrs=? "				
					+ " where ssm_id=? ");	
			
			pstmt.setString(1, ss.getCompanyName());
			pstmt.setString(2, ss.getSmtpHost());
			pstmt.setString(3, ss.getSmtpPort());
			pstmt.setString(4, ss.getSmtpUserName());
			pstmt.setString(5, ss.getSmtpPassword());		
			pstmt.setString(6, loggedInUser);			
			pstmt.setString(7, ss.getSmsSender());	
			pstmt.setString(8, ss.getEmailFrom());	
			
			pstmt.setString(9, ss.getProgramName());
			pstmt.setString(10, ss.getIssueAuthName1());
			pstmt.setString(11, ss.getIssueAuthNameSign1());
			pstmt.setString(12, ss.getIssueAuthDesignation1());
			pstmt.setString(13, ss.getDepartmentName());
			pstmt.setString(14, ss.getDepartmentPhone());
			pstmt.setString(15, ss.getDepartmentEmail());
			pstmt.setString(16, ss.getContactName());
			pstmt.setString(17, ss.getContactPhone());
			pstmt.setString(18, ss.getContactEmail());
			pstmt.setString(19, ss.getIssueAuthName2());
			pstmt.setString(20, ss.getIssueAuthNameSign2());
			pstmt.setString(21, ss.getIssueAuthDesignation2());
			pstmt.setString(22, ss.getQuizMarksLimit());
			pstmt.setString(23, ss.getProjectName());
			pstmt.setString(24, ss.getContactDesignation());
			
			pstmt.setString(25, ss.getDeanName());
			pstmt.setString(26, ss.getDeanPhone());
			pstmt.setString(27, ss.getDeanEmail());
			pstmt.setString(28, ss.getDeanDesignation());
			pstmt.setString(29, ss.getDeanSign());
			pstmt.setString(30, ss.getSubmissionEmailId());
			pstmt.setString(31, ss.getSubjectId());
			pstmt.setString(32, ss.getEssaySubmitDueDateInHrs());
			pstmt.setString(33,ss.getId());
			
			
			
		    int count = pstmt.executeUpdate();
		    
		    
		    if(count!=0){		    	
		    	System.out.println(">>>SAVE System Setting MAS<<<");		    	
		    	ss.setRecordUpdate("true");		    	
		    }
		    else
		    {
		    	System.out.println(">>>System Setting SAVED FAILED<<<");
		    	ss.setRecordUpdate("false");
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

return ss;
		
}

public boolean checkDuplicateSystemConfiguration(String id,String subjectId ) throws Exception {
	System.out.println("Inside checkDuplicateSystemConfiguration SystemSettingDao :");
	String count="0"; 
	boolean status=true;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{

	conn=connBean.getConnectionObj();
	
		if (id==null||id.equals("")||id.equals("0"))
		{
			pstmt=conn.prepareStatement("select count(*) cnt from tbl_system_setting_mas where  "
					+ " ssm_subject_id=? ");
			
			pstmt.setString(1, subjectId);
		}
		else
		{
			pstmt=conn.prepareStatement("select count(*) cnt from tbl_system_setting_mas where  "
					+ " ssm_subject_id=? and ssm_id<>?");
			
			pstmt.setString(1, subjectId);
			pstmt.setString(2, id);
		}
	
		
		
	rs=pstmt.executeQuery();
	
	 
	
	while(rs.next()){
	
		
		count=rs.getString("cnt");
		
	
	}
	
	if (count.equals("0"))
	{
		status=false;
	}
	else
	{
		status=true;
	}
	
	rs.close();
	pstmt.close();
	conn.close();
	
	}catch(Exception e){
		try {
			System.out.println(e);
			//throw new GeneralException("Error in ");
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
	   }//end try
		
		
		return status;	
}




}
