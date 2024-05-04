package com.abhiyantrikitech.repository;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


import org.springframework.stereotype.Repository;

import com.abhiyantrikitech.repository.ConnectionBean;
import com.abhiyantrikitech.util.Utility;
import com.abhiyantrikitech.model.LoginTrack;
import com.abhiyantrikitech.model.EmailLog;
import com.abhiyantrikitech.model.LoginMaster;
import com.abhiyantrikitech.model.LoginMasterDTO;

@Repository
public class LoginDao {

	ConnectionBean connBean=null;


public LoginDao(){
	connBean=new ConnectionBean();
}


public LoginMaster registerUser(LoginMaster loginMaster,Connection conn1) throws Exception{	
	
	Connection conntemp=null;	
	PreparedStatement pstmttemptemp=null;
	ResultSet rstemp=null;
	
	 int in_ua_id = 0;
	 int in_cnt = 0;
try{
	System.out.println("registerUser in LoginDao for="+loginMaster.getLoginId());
		
			conntemp=connBean.getConnectionObj();
		
			
				pstmttemptemp=conntemp.prepareStatement("insert into tbl_register (r_id,"
						+ "r_name,r_mobile,r_email,r_login_id,r_password,r_status,r_rp_id,r_creat_by,"
						+ "r_creat_dt,r_first_time_login,r_next_time_password_change,r_role_id,r_remarks )"
						+ "values(nextval('SEQ_REGISTER_ID'),?,?,?,?,?,?,?,?,now(),?,(DATE_ADD(now(), INTERVAL 90 DAY)),?,?)");	
						
						pstmttemptemp.setString(1, Utility.capitalizeString(loginMaster.getUserName()));
						pstmttemptemp.setString(2, loginMaster.getMobileNo());
						pstmttemptemp.setString(3, loginMaster.getEmail());
						pstmttemptemp.setString(4, loginMaster.getLoginId().trim());
						String password=Utility.randomAlphaNumeric(6);
						loginMaster.setPassword(password);
						pstmttemptemp.setString(5, password);
						pstmttemptemp.setString(6, "Active");
						if (loginMaster.getRpId()==null||loginMaster.getRpId().equals(""))
						{
							pstmttemptemp.setString(7, null);
						}
						else
						{
							pstmttemptemp.setString(7, loginMaster.getRpId());
						}
						
						pstmttemptemp.setString(8, loginMaster.getCreatBy());
						pstmttemptemp.setString(9, "Yes");
						pstmttemptemp.setString(10, loginMaster.getRoleId());
						pstmttemptemp.setString(11, loginMaster.getRemarks());
						
		                int count = pstmttemptemp.executeUpdate();
				    
				    
				    if(count!=0){				    	
				    	
				    	System.out.println(">>>SAVE REGISTER<<<"+loginMaster.getLoginId());				    	
				    	
				    	//loginMaster.setUserId(in_ua_id+"");
				    	loginMaster.setRecordUpdate("true");
				    	
				    }
				    else
				    {
				    	System.out.println(">>>SAVE REGISTER FAILED<<<"+loginMaster.getLoginId());
				    	//loginMaster.setUserId("0");
				    	loginMaster.setRecordUpdate("false");
				    	
				    }
			
			
	
		
		    pstmttemptemp.close();
		
			 conntemp.close();
	      
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				loginMaster.setRecordUpdate("false");
				System.out.println("exception in user creation for "+loginMaster.getLoginId()+" and exception is="+e.getMessage());
				System.out.println(e);
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			      
			    	    if(conntemp!=null)
			    	    	conntemp.close();
			      
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return loginMaster;
		
}


public LoginMaster updateUser(LoginMaster loginMaster,Connection conn1) throws Exception{	
	
	
	 int in_ua_id = 0;
	 
	 Connection conntemp=null;	
		PreparedStatement pstmttemp=null;
		ResultSet rstemp=null;
try{
	System.out.println("updateUser in LoginDao");
	
		conntemp=connBean.getConnectionObj();
	
		
		
			
			
			pstmttemp=conntemp.prepareStatement("UPDATE tbl_register SET "
				+ "r_name=?,r_mobile=?,r_status=?,"
				+ "r_lst_upd_by=?,r_lst_upd_dt=now(),r_role_id=?,r_remarks=? WHERE r_id=? ");
	
				pstmttemp.setString(1, Utility.capitalizeString(loginMaster.getUserName()));	
				pstmttemp.setString(2, loginMaster.getMobileNo());
				pstmttemp.setString(3, loginMaster.getStatus());
				pstmttemp.setString(4, loginMaster.getCreatBy());
				pstmttemp.setString(5, loginMaster.getRoleId());
				pstmttemp.setString(6, loginMaster.getRemarks());
				pstmttemp.setString(7, loginMaster.getUserId());
				
				
				
            
             int count = pstmttemp.executeUpdate();
		    
		    
		    if(count!=0){
		    	
		    	
		    	
		    	System.out.println(">>>SAVE USER<<<");
		    	
		    	loginMaster.setRecordUpdate("true");
		    	
		    	
		    }
		    else
		    {
		    	System.out.println(">>>SAVE USER FAILED<<<");
		    	
		    	loginMaster.setRecordUpdate("false");
		    	
		    }
		
		
		    pstmttemp.close();
		 
			 conntemp.close();
	      
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}
finally{
	   try{
	      
	    	    if(conntemp!=null)
	    	    	conntemp.close();
	      
	      }catch(SQLException se){
	         se.printStackTrace();
	         
	      }finally{//end finally try
   }
}

return loginMaster;
		
}




public LoginMaster updateProfile(LoginMaster loginMaster) throws Exception{	
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
	
	 int in_ua_id = 0;
try{
	System.out.println("updateProfile in LoginDao=="+loginMaster.getUserId());
	conntemp=connBean.getConnectionObj();
		
		
			
		pstmttemp=conntemp.prepareStatement("UPDATE tbl_register SET "
				+ "r_name=?,r_mobile=?,"
				+ "r_lst_upd_by=?,r_lst_upd_dt=now() WHERE r_id=? ");
	
				pstmttemp.setString(1, Utility.capitalizeString(loginMaster.getUserName()));				
				pstmttemp.setString(2, loginMaster.getMobileNo());				
				pstmttemp.setString(3, loginMaster.getCreatBy());
				pstmttemp.setString(4, loginMaster.getUserId());
				
				
           
            int count = pstmttemp.executeUpdate();
		    

		    if(count!=0){
		    	
		    
		    	System.out.println(">>>SAVE PROFILE<<<");
		    	
		    	loginMaster.setRecordUpdate("true");
		    	
		    	
		    	
		    }
		    else
		    {
		    	System.out.println(">>>SAVE PROFILE FAILED<<<");
		    	
		    	loginMaster.setRecordUpdate("false");
		    	
		    }
		
		
		pstmttemp.close();
		conntemp.close();
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			        	 conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return loginMaster;
		
}
public LoginMaster resetPassword(LoginMaster loginMaster) throws Exception{	
	
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
	
	 int in_ua_id = 0;
try{
	System.out.println("resetPassword in LoginDao"+loginMaster.getUserId());
	conntemp=connBean.getConnectionObj();
		
		
			
			
			pstmttemp=conntemp.prepareStatement("UPDATE tbl_register SET r_password=?,"				
				+ " r_lst_upd_by=?,r_lst_upd_dt=now(),r_next_time_password_change=(DATE_ADD(now(), INTERVAL 60 DAY)),r_first_time_login=?"
				+ " WHERE r_id=? ");
				
		
				
				pstmttemp.setString(1, loginMaster.getPassword());
				pstmttemp.setString(2, loginMaster.getCreatBy());
				pstmttemp.setString(3, "No");
				pstmttemp.setString(4, loginMaster.getUserId());
				
            
             int count = pstmttemp.executeUpdate();
		    
		    
		    if(count!=0){
		    	
		    	
		    	System.out.println(">>>SAVE password<<<");
		    	
		    	
		    	loginMaster.setRecordUpdate("true");
		    	
		    }
		    else
		    {
		    	System.out.println(">>>SAVE password FAILED<<<");
		    	
		    	loginMaster.setRecordUpdate("false");
		    	
		    }
		
		
		pstmttemp.close();
		conntemp.close();
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			        	 conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return loginMaster;
		
}


public LoginMaster validateLogin(String login,String Password,String subjectId,String loginRole) throws Exception{	
	
	LoginMaster loginmaster= null;
	//int recexistcnt=0;
	int recordCount=0; 
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
try{
	System.out.println("validateLogin in LoginDao="+login+" & loginRole="+loginRole+" & password="+Password+" & subjectId="+subjectId);
	conntemp=connBean.getConnectionObj();
		
	synchronized(this)
	{
			
	
						pstmttemp=conntemp.prepareStatement("SELECT * FROM tbl_register,   "
								//+ "left outer join tbl_akam_register_person_mas on r_rp_id=ar_id and r_role_id<>'3' , "
								+ "tbl_role_mas where r_role_id=rm_id and rm_status='Y' and "
								+ "upper(r_login_id)=? AND r_password =? AND r_status='Active' "
								+ "");	
					
							pstmttemp.setString(1, login.toUpperCase().trim());
							pstmttemp.setString(2, Password.trim());
							
					
		              rstemp = pstmttemp.executeQuery();
		              
	}        
		            
				    while (rstemp.next())
				    {
				    	recordCount=recordCount+1;
				    	
				    	loginmaster=new LoginMaster();
				    	loginmaster.setUserId(rstemp.getString("r_id"));
				    	loginmaster.setUserName(rstemp.getString("r_name"));
				    	
				    	
				    	loginmaster.setMobileNo(rstemp.getString("r_mobile"));
				    	loginmaster.setEmail(rstemp.getString("r_email"));
				    	loginmaster.setLoginId(rstemp.getString("r_login_id"));
				    	loginmaster.setRoleName(rstemp.getString("rm_role_name"));
				    	loginmaster.setRoleId(rstemp.getString("r_role_id"));
				    	loginmaster.setCreatBy(rstemp.getString("r_creat_by"));	
				    	loginmaster.setCreatDate(rstemp.getString("r_creat_dt"));	
				    	loginmaster.setFirstTimeLogin(rstemp.getString("r_first_time_login"));				    	
				    	loginmaster.setRemarks(rstemp.getString("r_remarks"));
				    	loginmaster.setStatus(rstemp.getString("r_status"));
				    	
				    	loginmaster.setRpId(rstemp.getString("r_rp_id"));	
				    		
				    	loginmaster.setRpName(rstemp.getString("r_name"));
				    	loginmaster.setNextTimePasswordChangeDate(rstemp.getString("r_next_time_password_change"));
				    				    	
				    	loginmaster.setRecordUpdate("true");
				    	
				    }
				  
				    
				    if (recordCount==0)
				    {
				    	System.out.println("Either Login Id or password is incorrect. Please try again=="+login+"  & password=="+ Password+"  & role=="+loginRole+"& subject=="+subjectId);
				    }
		              
				
				pstmttemp.close();
				conntemp.close();
			
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println("Exception in valid login for login="+login+" & error is=="+e.getMessage());
				loginmaster.setRecordUpdate("error");
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return loginmaster;
		
}

public LoginMaster getLoginById(String loginId,String roleId) throws Exception{	
	
	LoginMaster loginmaster= null;
	int recexistcnt=0;
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
try{
	System.out.println("getLoginById in LoginDao");
	conntemp=connBean.getConnectionObj();
		
			
					pstmttemp=conntemp.prepareStatement("SELECT * FROM tbl_register , "
							+ "tbl_role_mas where r_role_id=rm_id and rm_status='Y' and "
							+ "r_login_id=? and r_role_id=? ");	
				
						pstmttemp.setString(1, loginId);
						pstmttemp.setString(2, roleId);
		
		
						
						
		              rstemp = pstmttemp.executeQuery();
		              
		              
				    while (rstemp.next())
				    {
				    	
				    	loginmaster=new LoginMaster();
				    	loginmaster.setUserId(rstemp.getString("r_id"));
				    	loginmaster.setUserName(rstemp.getString("r_name"));
				    	 	
				    	loginmaster.setMobileNo(rstemp.getString("r_mobile"));
				    	loginmaster.setEmail(rstemp.getString("r_email"));
				    	loginmaster.setLoginId(rstemp.getString("r_login_id"));
				    	loginmaster.setRoleName(rstemp.getString("rm_role_name"));
				    	loginmaster.setRoleId(rstemp.getString("r_role_id"));
				    	loginmaster.setCreatBy(rstemp.getString("r_creat_by"));
				    	loginmaster.setCreatDate(rstemp.getString("r_creat_dt"));
				    	loginmaster.setLastUpdateDate(rstemp.getString("r_lst_upd_dt"));
				    	loginmaster.setFirstTimeLogin(rstemp.getString("r_first_time_login"));
				    	
				    	loginmaster.setRemarks(rstemp.getString("r_remarks"));
				    	loginmaster.setStatus(rstemp.getString("r_status"));
				    	loginmaster.setPassword(rstemp.getString("r_password"));
				    	
				    	loginmaster.setRpId(rstemp.getString("r_rp_id"));				    	
				    	loginmaster.setRpName(rstemp.getString("r_name"));	
				    				    	
				    	loginmaster.setRecordUpdate("true");
				    }
		              
				
				pstmttemp.close();
				conntemp.close();
			
			
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				loginmaster.setRecordUpdate("error");
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return loginmaster;
		
}


public LoginMaster getLoginByRPId(String rpId) throws Exception{	
	
	LoginMaster loginmaster= new LoginMaster();
	int recexistcnt=0;
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
try{
	System.out.println("getLoginByRPId in LoginDao");
	
	conntemp=connBean.getConnectionObj();
		
						
					pstmttemp=conntemp.prepareStatement(""+
									" SELECT a.*,b.* FROM tbl_register a ,tbl_role_mas b,tbl_akam_register_person_mas where  r_role_id=rm_id and rm_status='Y' "+
									" and r_rp_id=ar_id and r_role_id<>'3' and r_status='Active' and r_rp_id=? ");	
				
						pstmttemp.setString(1, rpId);
						pstmttemp.setString(2, rpId);
						
						
						
		              rstemp = pstmttemp.executeQuery();
		              
		              
				    while (rstemp.next())
				    {
				    	
				    	loginmaster=new LoginMaster();
				    	loginmaster.setUserId(rstemp.getString("r_id"));
				    	loginmaster.setUserName(rstemp.getString("r_name"));
				    	
				    	
				    	loginmaster.setMobileNo(rstemp.getString("r_mobile"));
				    	loginmaster.setEmail(rstemp.getString("r_email"));
				    	loginmaster.setLoginId(rstemp.getString("r_login_id"));
				    	loginmaster.setRoleName(rstemp.getString("rm_role_name"));
				    	loginmaster.setRoleId(rstemp.getString("r_role_id"));
				    	loginmaster.setCreatBy(rstemp.getString("r_creat_by"));
				    	loginmaster.setCreatDate(rstemp.getString("r_creat_dt"));
				    	loginmaster.setLastUpdateDate(rstemp.getString("r_lst_upd_dt"));
				    	loginmaster.setFirstTimeLogin(rstemp.getString("r_first_time_login"));
				    	
				    	loginmaster.setRemarks(rstemp.getString("r_remarks"));
				    	loginmaster.setStatus(rstemp.getString("r_status"));
				    	loginmaster.setPassword(rstemp.getString("r_password"));
				    	
				    	loginmaster.setRpId(rstemp.getString("r_rp_id"));				    	
				    	loginmaster.setRpName(rstemp.getString("r_name"));	
				    				    	
				    	loginmaster.setRecordUpdate("true");
				    }
				    if (!loginmaster.getRecordUpdate().equals("true"))
				    {
				    	loginmaster.setRecordUpdate("notregister");
				    }
		              
				
				pstmttemp.close();
				conntemp.close();
			
			
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				loginmaster.setRecordUpdate("error");
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return loginmaster;
		
}

public boolean duplicateLoginCheck(String login) throws Exception{	
	
	
	int recexistcnt=0;
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
try{
	System.out.println("duplicateLoginCheck in LoginDao");
		conntemp=connBean.getConnectionObj();
		
		pstmttemp=conntemp.prepareStatement("SELECT COUNT(*) cnt FROM ( "+
		   "SELECT r_login_id FROM tbl_register WHERE upper(r_login_id)=? "+
		  // "union "+
		  // "select ar_email from tbl_akam_register_person_mas where ar_status in ('Pending','Rework') and upper(ar_email)=?  "+
		   " ) b ");
	
			pstmttemp.setString(1, login.toUpperCase().trim());
			//pstmttemp.setString(2, login.toUpperCase().trim());
			
			
			rstemp = pstmttemp.executeQuery();
			
			while (rstemp.next())
		    {				
				recexistcnt=Integer.parseInt(rstemp.getString("cnt"));
		    }
			rstemp=null;
			pstmttemp=null;
			System.out.println("recexistcnt=="+recexistcnt);
			if (recexistcnt > 0)
				return true;
			else
				return false;
			
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return true;
		
}

public boolean duplicateEmailCheck(String email,String userId) throws Exception{	
	
	
	int recexistcnt=0;
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
try{
	System.out.println("duplicateEmailCheck in LoginDao");
		conntemp=connBean.getConnectionObj();
		
		if (userId==null||userId.equals("")||userId.equals("0"))
		{
			pstmttemp=conntemp.prepareStatement("SELECT COUNT(*) cnt FROM tbl_register WHERE upper(r_email)=? ");
			pstmttemp.setString(1, email.toUpperCase().trim());
		}
		else
		{
			pstmttemp=conntemp.prepareStatement("SELECT COUNT(*) cnt FROM tbl_register WHERE upper(r_email)=? and r_id<>?");
			pstmttemp.setString(1, email.toUpperCase().trim());
			pstmttemp.setString(2, userId);
		}
					
			rstemp = pstmttemp.executeQuery();
			
			while (rstemp.next())
		    {				
				recexistcnt=Integer.parseInt(rstemp.getString("cnt"));
		    }
			rstemp=null;
			pstmttemp=null;
			System.out.println("recexistcnt=="+recexistcnt);
			if (recexistcnt > 0)
				return true;
			else
				return false;
			
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return true;
		
}


public boolean duplicateMobileCheck(String mobile,String userId) throws Exception{	
	
	
	int recexistcnt=0;
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
try{
	System.out.println("duplicateMobileCheck in LoginDao");
		conntemp=connBean.getConnectionObj();
		
		if (userId==null||userId.equals("")||userId.equals("0"))
		{
			pstmttemp=conntemp.prepareStatement("SELECT COUNT(*) cnt FROM tbl_register WHERE upper(r_mobile)=? ");
			pstmttemp.setString(1, mobile.toUpperCase().trim());
		}
		else
		{
			pstmttemp=conntemp.prepareStatement("SELECT COUNT(*) cnt FROM tbl_register WHERE upper(r_mobile)=? and r_id<>?");
			pstmttemp.setString(1, mobile.toUpperCase().trim());
			pstmttemp.setString(2, userId);
		}
					
			rstemp = pstmttemp.executeQuery();
			
			while (rstemp.next())
		    {				
				recexistcnt=Integer.parseInt(rstemp.getString("cnt"));
		    }
			rstemp=null;
			pstmttemp=null;
			System.out.println("recexistcnt=="+recexistcnt);
			if (recexistcnt > 0)
				return true;
			else
				return false;
			
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return true;
		
}


public LoginMaster getPassword(String login,String roleId) throws Exception{	
	
	LoginMaster loginmaster= new LoginMaster();
	int recexistcnt=0;
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
try{
	System.out.println("getPassword in LoginDao=="+login+" & roleid="+roleId);
		conntemp=connBean.getConnectionObj();
		
		
			
			
					/*pstmttemp=conntemp.prepareStatement("SELECT * FROM tbl_register WHERE "
							+ " r_login_id=? and r_status='Active' ");	*/
		
		
					pstmttemp=conntemp.prepareStatement("SELECT * FROM tbl_register ,  "
							//+ "left outer join tbl_akam_register_person_mas on r_rp_id=ar_id and r_role_id<>'3' , "
							+ "tbl_role_mas where r_role_id=rm_id and rm_status='Y' and "
							+ "upper(r_login_id)=? AND r_status='Active' ");	
				
						pstmttemp.setString(1, login.toUpperCase());
						
			
					
		              rstemp = pstmttemp.executeQuery();
		              
		              
				    while (rstemp.next())
				    {
				    	System.out.println("inside loop");
				    	loginmaster.setLoginId(rstemp.getString("r_login_id"));
					    loginmaster.setUserId(rstemp.getString("r_id"));
				    	loginmaster.setPassword(rstemp.getString("r_password"));
				    	loginmaster.setUserName(rstemp.getString("r_name"));
				    	
				    	
				    	loginmaster.setMobileNo(rstemp.getString("r_mobile"));
				    	loginmaster.setEmail(rstemp.getString("r_email"));
				    	loginmaster.setRecordUpdate("true");
				    	
				    	loginmaster.setRpId(rstemp.getString("r_rp_id"));	
				        
				    }
				    if (!loginmaster.getRecordUpdate().equals("true"))
				    {
				    	loginmaster.setRecordUpdate("notregister");
				    }
		              
				
				pstmttemp.close();
				conntemp.close();
			
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				loginmaster.setRecordUpdate("error");
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return loginmaster;
		
}



public ArrayList getUserList() throws Exception{	
	

	ArrayList ar=new ArrayList();
	LoginMaster loginmaster;
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
try{
	System.out.println("getUserList in LoginDao");
		conntemp=connBean.getConnectionObj();
		
				
				pstmttemp=conntemp.prepareStatement("SELECT date_format(r_creat_dt,'%d-%b-%y') r_creat_dt,"
						+ "date_format(r_lst_upd_dt,'%d-%b-%y') r_lst_upd_dt,a.*,b.*,c.*,d.* FROM tbl_register a, "
						//+ "left outer join tbl_akam_register_person_mas b on r_rp_id=ar_id and r_role_id<>'3'"
						+ "tbl_role_mas c where r_role_id=rm_id   "
						+ " ");	
				
				rstemp = pstmttemp.executeQuery();	 
				
				
			    while (rstemp.next())
			    {
			    	
			    	loginmaster=new LoginMaster();
			    	loginmaster.setUserId(rstemp.getString("r_id"));
			    	loginmaster.setUserName(rstemp.getString("r_name"));
			    	
			    	
			    	loginmaster.setMobileNo(rstemp.getString("r_mobile"));
			    	loginmaster.setEmail(rstemp.getString("r_email"));
			    	loginmaster.setLoginId(rstemp.getString("r_login_id"));
			    	loginmaster.setRoleName(rstemp.getString("rm_role_name"));
			    	loginmaster.setRoleId(rstemp.getString("r_role_id"));
			    	loginmaster.setCreatBy(rstemp.getString("r_creat_by"));
			    	loginmaster.setCreatDate(rstemp.getString("r_creat_dt"));
			    	loginmaster.setLastUpdateDate(rstemp.getString("r_lst_upd_dt"));
			    	
			    	loginmaster.setFirstTimeLogin(rstemp.getString("r_first_time_login"));
			    	loginmaster.setRemarks(rstemp.getString("r_remarks"));
			    	loginmaster.setStatus(rstemp.getString("r_status"));
			    	
			    	loginmaster.setRpId(rstemp.getString("r_rp_id"));				    	
			    	loginmaster.setRpName(rstemp.getString("r_name"));
			    
			    	ar.add(loginmaster);   	
			    	
			    }
	              
			
			pstmttemp.close();
			conntemp.close();
			System.out.println("end user list");
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return ar;
		
}


public HashMap getRoleName() throws Exception{	
	
	HashMap hm = new HashMap();
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;

try{
	System.out.println("getRoleName in LoginDao");
		conntemp=connBean.getConnectionObj();
		
		
			
			
					pstmttemp=conntemp.prepareStatement("SELECT * FROM tbl_role_mas where rm_status='Y' "
							+ " and RM_ID not in (3,5,6,7,8,9,10)  order by rm_id asc ");	
				
							
		              rstemp = pstmttemp.executeQuery();
		              
		              
				    while (rstemp.next())
				    {	    	
				    	hm.put(rstemp.getString("rm_id"), rstemp.getString("rm_role_name"));
				    }
		              
				
				pstmttemp.close();
				conntemp.close();
			
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return hm;
		
}

public String insertLoginTrack(LoginTrack loginTrack) throws Exception {
	System.out.println("Inside insertLoginTrack in LoginDao Dao :>>>"+loginTrack.getLoginId());
			int ln_seq_no =0;
			Connection conntemp=null;	
			PreparedStatement pstmttemp=null;
			ResultSet rstemp=null;

		try{			
				conntemp=connBean.getConnectionObj();
							
			
				
				pstmttemp=conntemp.prepareStatement("insert into tbl_login_track (lt_login_id,"
						+ "lr_machine_name,lr_ip,lr_mac_id,lr_login_time,lr_create_dt,lr_create_by,lr_login_machine_type )"
						+ "values(?,?,?,?,now(),now(),?,?)");	
				

				pstmttemp.setString(1, loginTrack.getLoginId());
				pstmttemp.setString(2, loginTrack.getMachineName());
				pstmttemp.setString(3, loginTrack.getIpAddress());
				pstmttemp.setString(4,loginTrack.getMacId());
				pstmttemp.setString(5, "System");
				pstmttemp.setString(6, loginTrack.getLoginMachineType());

				
	           int count = pstmttemp.executeUpdate();
		    

		    if(count!=0){    	
	    	
		    	pstmttemp=conntemp.prepareStatement("select LAST_INSERT_ID() orgid ");
				
		    	ResultSet rs=pstmttemp.executeQuery();
				while(rs.next()){
				
					loginTrack.setLoginTrackId(rs.getString("orgid")); 
				}
		    	rs.close();
		    	
		    	  	
		    }
		    else
		    {
		    	loginTrack.setLoginTrackId("0");   	
		    }
		
		//conntemp.commit();
		pstmttemp.close();
		conntemp.close();
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

	return ln_seq_no+"";
		
	}

public String updateLoginTrack(String id,String loginId) throws Exception {
	System.out.println("Inside updateLoginTrack in LoginDao Dao :"+id+"--"+loginId);
			int ln_seq_no =0;
			Connection conntemp=null;	
			PreparedStatement pstmttemp=null;
			ResultSet rstemp=null;

		try{			
				conntemp=connBean.getConnectionObj();
				
				
				pstmttemp=conntemp.prepareStatement("update tbl_login_track set lr_logout_time=now() where lt_id=? and lt_login_id=?");
				
				pstmttemp.setString(1,id);
				pstmttemp.setString(2, loginId);
				
				
	           int count = pstmttemp.executeUpdate();
		    

		    if(count!=0){    	
		    	System.out.println(">>>UPDATE LOGOUT TIME SUCCESS<<<");	    	
		    	  	
		    }
		    else
		    {
		    	System.out.println(">>>UPDATE LOGOUT TIME FAILED<<<");	   	
		    }
		
		//conntemp.commit();
		pstmttemp.close();
		conntemp.close();
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

	return "SUCCESS";
		
	}






public LoginMaster getLoginByUserId(String userId) throws Exception{	
	
	LoginMaster loginmaster= null;
	int recexistcnt=0;
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
try{
	System.out.println("getLoginByUserId in LoginDao");
		conntemp=connBean.getConnectionObj();
		
		
			pstmttemp=conntemp.prepareStatement("SELECT * FROM tbl_register , "
					+ "tbl_role_mas where r_role_id=rm_id and rm_status='Y' and "
					+ "r_id=? ");	
		
				pstmttemp.setString(1, userId);
		
						
						
		              rstemp = pstmttemp.executeQuery();
		              
		              
				    while (rstemp.next())
				    {
				    	
				    	loginmaster=new LoginMaster();
				    	loginmaster.setUserId(rstemp.getString("r_id"));
				    	loginmaster.setUserName(rstemp.getString("r_name"));
				    	 	
				    	loginmaster.setMobileNo(rstemp.getString("r_mobile"));
				    	loginmaster.setEmail(rstemp.getString("r_email"));
				    	loginmaster.setLoginId(rstemp.getString("r_login_id"));
				    	loginmaster.setRoleName(rstemp.getString("rm_role_name"));
				    	loginmaster.setRoleId(rstemp.getString("r_role_id"));
				    	loginmaster.setCreatBy(rstemp.getString("r_creat_by"));
				    	loginmaster.setCreatDate(rstemp.getString("r_creat_dt"));
				    	loginmaster.setLastUpdateDate(rstemp.getString("r_lst_upd_dt"));
				    	loginmaster.setFirstTimeLogin(rstemp.getString("r_first_time_login"));
				    	
				    	loginmaster.setRemarks(rstemp.getString("r_remarks"));
				    	loginmaster.setStatus(rstemp.getString("r_status"));
				    	loginmaster.setPassword(rstemp.getString("r_password"));
				    	
				    	loginmaster.setRpId(rstemp.getString("r_rp_id"));				    	
				    	loginmaster.setRpName(rstemp.getString("r_name"));	
				    				    	
				    	loginmaster.setRecordUpdate("true");
				    }
		              
				
				pstmttemp.close();
				conntemp.close();
			
			
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				loginmaster.setRecordUpdate("error");
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return loginmaster;
		
}

public LoginMasterDTO getUserListServerSidePagination(int start, int length , String filter,int sortColIndex,String order) throws Exception{	
	

	ArrayList ar=new ArrayList();
	LoginMaster loginmaster;
	Connection conntemp=null;	
	PreparedStatement pstmttemp=null;
	ResultSet rstemp=null;
	LoginMasterDTO loginMasterDTO=new LoginMasterDTO();
	String baseQuesry="";
	String totalCountQuesry="";
	String orderFilter="";
	String filterQuery="";
	int recordCnt=0;
try{
	System.out.println("getUserListServerSidePagination in LoginDao--------"+filter);
	
		conntemp=connBean.getConnectionObj();
		
		baseQuesry="SELECT date_format(r_creat_dt,'%d-%b-%y') r_creat_dt,"
				+ "date_format(r_lst_upd_dt,'%d-%b-%y') r_lst_upd_dt,a.*,b.*,c.*,d.* FROM tbl_register a "
				+ "left outer join tbl_akam_register_person_mas b on r_rp_id=ar_id,"
				+ "tbl_role_mas c where r_role_id=rm_id ";
		
		totalCountQuesry="SELECT count(*) cnt"
				+ " FROM tbl_register a "
				+ "left outer join tbl_akam_register_person_mas b on r_rp_id=ar_id ,"
				+ "tbl_role_mas c where r_role_id=rm_id ";
		
				if (sortColIndex==1)
				{
					orderFilter=" order by r_name "+order;
				}
				else if (sortColIndex==2)
				{
					orderFilter=" order by r_mobile "+order;
				}
				else if (sortColIndex==3)
				{
					orderFilter=" order by rm_role_name "+order;
				}
				else if (sortColIndex==4)
				{
					orderFilter=" order by r_login_id "+order;
				}
				else if (sortColIndex==5)
				{
					orderFilter=" order by r_email "+order;
				}
				else if (sortColIndex==6)
				{
					orderFilter=" order by r_creat_dt "+order;
				}
				else if (sortColIndex==7)
				{
					orderFilter=" order by r_lst_upd_dt "+order;
				}
				else if (sortColIndex==8)
				{
					orderFilter=" order by r_status "+order;
				}
				
				
				
				if (filter!=null && !filter.equals(""))
				{
					filterQuery=" and ( upper(r_name) like ? or "+
							" upper(r_mobile) like ? or "+
							" upper(rm_role_name) like ? or "+
							" upper(r_login_id) like ? or "+
							" upper(r_email) like ? or "+
							" upper(r_creat_dt) like ? or "+
							" upper(r_lst_upd_dt) like ? or "+
							" upper(r_status) like ? ) ";
				}
				
				
		
				if (length==-1)
				{
					if (filterQuery!=null && !filterQuery.equals(""))
					{
						System.out.println("1-------"+baseQuesry+filterQuery+orderFilter);
						
						pstmttemp=conntemp.prepareStatement(baseQuesry+filterQuery+orderFilter+ " ");	
						
						pstmttemp.setString(1,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(2,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(3,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(4,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(5,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(6,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(7,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(8,"%"+filter.toUpperCase()+"%") ;
						
						
						
					}
					else
					{
						pstmttemp=conntemp.prepareStatement(baseQuesry+orderFilter+ " ");	
						
						System.out.println("2-------"+baseQuesry+orderFilter);
					}
					
				}
				else
				{
					
					
					if (filterQuery!=null && !filterQuery.equals(""))
					{
						
						System.out.println("3-----------"+baseQuesry+filterQuery+orderFilter+"  limit ?,? ");
						pstmttemp=conntemp.prepareStatement(baseQuesry+filterQuery+orderFilter+"  limit ?,? ");	
						
						pstmttemp.setString(1,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(2,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(3,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(4,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(5,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(6,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(7,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setString(8,"%"+filter.toUpperCase()+"%") ;
						pstmttemp.setInt(9,start) ;
						pstmttemp.setInt(10,length) ;
						
						
					}
					else
					{
						System.out.println("4-------"+baseQuesry+orderFilter+"  limit ?,?");
						
						pstmttemp=conntemp.prepareStatement(baseQuesry+orderFilter+"  limit ?,? "
								+ " ");	
						
						pstmttemp.setInt(1,start) ;
						pstmttemp.setInt(2,length) ;
						
						
					}
					
					
				}
				
			
				
				
				rstemp = pstmttemp.executeQuery();	 
				
				
			    while (rstemp.next())
			    {
			    	
			    	loginmaster=new LoginMaster();
			    	loginmaster.setUserId(rstemp.getString("r_id"));
			    	loginmaster.setUserName(rstemp.getString("r_name"));
			    	
			    	
			    	loginmaster.setMobileNo(rstemp.getString("r_mobile"));
			    	loginmaster.setEmail(rstemp.getString("r_email"));
			    	loginmaster.setLoginId(rstemp.getString("r_login_id"));
			    	loginmaster.setRoleName(rstemp.getString("rm_role_name"));
			    	loginmaster.setRoleId(rstemp.getString("r_role_id"));
			    	loginmaster.setCreatBy(rstemp.getString("r_creat_by"));
			    	loginmaster.setCreatDate(rstemp.getString("r_creat_dt"));
			    	loginmaster.setLastUpdateDate(rstemp.getString("r_lst_upd_dt"));
			    	
			    	loginmaster.setFirstTimeLogin(rstemp.getString("r_first_time_login"));
			    	loginmaster.setRemarks(rstemp.getString("r_remarks"));
			    	loginmaster.setStatus(rstemp.getString("r_status"));
			    	
			    	loginmaster.setRpId(rstemp.getString("r_rp_id"));				    	
			    	loginmaster.setRpName(rstemp.getString("r_name"));
			    	
			    	//loginmaster.setCollegeId(collegeId);
			    	
			    	String url="<a href=viewRegisterGet?loginId="+rstemp.getString("r_login_id")+"&roleId="+rstemp.getString("r_role_id")+"><i class='fas fa-eye' title='View' data-toggle='tooltip'></i></a>";
			    	
			    	String sendemailurl="<a href=SendRegisterEmail?loginId="+rstemp.getString("r_login_id")+"&roleId="+rstemp.getString("r_role_id")+">Send Email</a>";
			    	
			    	
			    	loginmaster.setViewLink(url);
			    	loginmaster.setSendEmailLink(sendemailurl);
			    	
			    	
			    	
			    	ar.add(loginmaster);   	
			    	
			    }
			    
			    loginMasterDTO.setData(ar);
			   
			    ///////////////////////////////////////////FILTER COUNT/////////////////////////////////////////////////////////
			    
			    if (filterQuery!=null && !filterQuery.equals(""))
				{
					
					pstmttemp=conntemp.prepareStatement(totalCountQuesry+filterQuery);	
					
					pstmttemp.setString(1,"%"+filter.toUpperCase()+"%") ;
					pstmttemp.setString(2,"%"+filter.toUpperCase()+"%") ;
					pstmttemp.setString(3,"%"+filter.toUpperCase()+"%") ;
					pstmttemp.setString(4,"%"+filter.toUpperCase()+"%") ;
					pstmttemp.setString(5,"%"+filter.toUpperCase()+"%") ;
					pstmttemp.setString(6,"%"+filter.toUpperCase()+"%") ;
					pstmttemp.setString(7,"%"+filter.toUpperCase()+"%") ;
					pstmttemp.setString(8,"%"+filter.toUpperCase()+"%") ;
					
					
				}
			    else
			    {
			    	pstmttemp=conntemp.prepareStatement(totalCountQuesry);
			    }
			    
			    		
			    rstemp = pstmttemp.executeQuery();	
			    
			    while (rstemp.next())
			    {
			    	
			    	
			    	recordCnt=Integer.parseInt(rstemp.getString("cnt"));
			    }
			    
			    loginMasterDTO.setRecordsFiltered(recordCnt);
			    
	           
			    ///////////////////////////////////////////TOTAL COUNT/////////////////////////////////////////////////////////
			    
			   
			    pstmttemp=conntemp.prepareStatement(totalCountQuesry);
			    	
			    rstemp = pstmttemp.executeQuery();	
			    
			    while (rstemp.next())
			    {
			    	
			    	
			    	recordCnt=Integer.parseInt(rstemp.getString("cnt"));
			    }
			    
			    loginMasterDTO.setRecordsTotal(recordCnt); 
			    			    
			    ////////////////////////////////////////////////////////
			
			pstmttemp.close();
			conntemp.close();
			System.out.println("end user list");
		
		}catch(Exception e){
			try {
				//conntemp.rollback(); 
				System.out.println(e);
				
				//throw new GeneralException("Error in insertLoginDtls");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}finally{
			   try{
			         if(conntemp!=null)
			            conntemp.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }finally{//end finally try
		      }
		   }

return loginMasterDTO;
		
}



}
