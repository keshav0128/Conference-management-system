package com.abhiyantrikitech.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.abhiyantrikitech.model.Conference;



public class ConferenceDao {
ConnectionBean connBean=null;
	public ConferenceDao()
	{
		connBean=new ConnectionBean();
	}
	
	public Conference saveConference(Conference conf, String loggedInUser) throws Exception
	{	
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 int count=0; 
		 try{
			 System.out.println("save conference in conference dao");
			 conn=connBean.getConnectionObj();
					pstmt=conn.prepareStatement("insert into tbl_conference (c_conf_name, c_acronym, c_webpage,"
							+ "c_venue, c_city, c_country, c_est_no_of_submission, c_start_dt, c_end_dt, c_deadline_paper_submit_dt,"
							+ "c_area_note, c_organizer, c_organizer_webpage, c_contact_no, c_your_role, c_any_other_detail,"
							+ "c_eval_para_marke_jury, c_eval_para_marke_chair, c_status, c_create_dt, c_create_by,"
							+ " c_display_comment_to_author, c_email_notification_to_author)"
							+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,?,?)");	
					pstmt.setString(1, conf.getNameOfConference());
					pstmt.setString(2, conf.getAcronym());
					pstmt.setString(3, conf.getWebPage());
					pstmt.setString(4, conf.getVenue());
					pstmt.setString(5, conf.getCity());
					pstmt.setString(6, conf.getCountry());
					pstmt.setString(7, conf.getEstimatedNoOfSubmission());
					pstmt.setString(8, conf.getStartDt());
					pstmt.setString(9, conf.getEndDt());
					pstmt.setString(10, conf.getPaperSubmissionDeadline());
					pstmt.setString(11, conf.getAreaNote());
					pstmt.setString(12, conf.getOrganizer());
					pstmt.setString(13, conf.getOrganizerWebPage());
					pstmt.setString(14, conf.getContactNo());
					pstmt.setString(15, conf.getYourRole());
					pstmt.setString(16, conf.getAnyOtherDetail());
					pstmt.setString(17, conf.getEvaluationParameterMarksForJury());
					pstmt.setString(18, conf.getEvaluationParameterMarksForChair());
					pstmt.setString(19, conf.getStatus());
					pstmt.setString(20, loggedInUser);
					pstmt.setString(21, conf.getDisplayReviewCommentTOAuthor());
					pstmt.setString(22, conf.getEmailNotificationToAuthor());
					
				    count = pstmt.executeUpdate();
				    if(count!=0){
				    	
				    	System.out.println(">>>SAVE Conference<<<");
				    	
				    	conf.setRecordUpdate("true");
				    	
				    }
				    else
				    {
				    	System.out.println(">>> Conference SAVED FAILED<<<");
				    	conf.setRecordUpdate("false");
				    }
	
				pstmt.close();
				conn.close();
			
			}
		 catch(Exception e){
				try {
					//conn.rollback(); 
					System.out.println(e);
				} 
				catch (Exception e1) {
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
	
	return conf;
			
	}	
	
	public Conference getConferenceListById(String confernceId ) throws Exception {
		System.out.println("Inside get conference by id DAo :");
		Conference conf=new Conference();   
		Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		try{

		conn=connBean.getConnectionObj();
		
		
			pstmt=conn.prepareStatement("select * from tbl_conference where c_id=? ");
			
			pstmt.setString(1,confernceId );
			
		rs=pstmt.executeQuery();
		
		 
		
		while(rs.next()){
		
			
			conf.setConferenceId(rs.getString("c_id"));
			conf.setNameOfConference(rs.getString("c_conf_name"));
			conf.setAcronym(rs.getString("c_acronym"));
			conf.setWebPage(rs.getString("c_webpage"));
			conf.setVenue(rs.getString("c_venue"));
			conf.setCity(rs.getString("c_city"));
			conf.setCountry(rs.getString("c_country"));
			conf.setEstimatedNoOfSubmission(rs.getString("c_est_no_of_submission"));
			conf.setStartDt(rs.getString("c_start_dt"));
			conf.setEndDt(rs.getString("c_end_dt"));
			conf.setPaperSubmissionDeadline(rs.getString("c_deadline_paper_submit_dt"));
			conf.setAreaNote(rs.getString("c_area_note"));
			conf.setOrganizer(rs.getString("c_organizer"));
			conf.setOrganizerWebPage(rs.getString("c_organizer_webpage"));
			conf.setContactNo(rs.getString("c_contact_no"));
			conf.setYourRole(rs.getString("c_your_role"));
			conf.setAnyOtherDetail(rs.getString("c_any_other_detail"));
			conf.setEvaluationParameterMarksForJury(rs.getString("c_eval_para_marke_jury"));
			conf.setEvaluationParameterMarksForChair(rs.getString("c_eval_para_marke_chair"));
			conf.setStatus(rs.getString("c_status"));
			conf.setCreatBy(rs.getString("c_create_dt"));
			conf.setCreatDt(rs.getString("c_create_by"));
			conf.setDisplayReviewCommentTOAuthor(rs.getString("c_display_comment_to_author, "));
			conf.setEmailNotificationToAuthor(rs.getString("c_email_notification_to_author)"));
		
		
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
			
			
			return conf;	
	}
	
	/*------------------------------------------------------------------------------------------------------*/
	@SuppressWarnings("rawtypes")
	public ArrayList<Conference> getConferenceList() throws Exception {
		System.out.println("Inside getConferenceList :");
		ArrayList<Conference> ar=new ArrayList<Conference>(); 
		Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;

		
		try{

			conn=connBean.getConnectionObj();
			
			
			pstmt=conn.prepareStatement("select * from tbl_conference");
			
		
			rs=pstmt.executeQuery();
		
		 
		
		while(rs.next()){
		
			Conference conf = new Conference();
			conf.setConferenceId(rs.getString("c_id"));
			conf.setNameOfConference(rs.getString("c_conf_name"));
			conf.setAcronym(rs.getString("c_acronym"));
			conf.setWebPage(rs.getString("c_webpage"));
			conf.setVenue(rs.getString("c_venue"));
			conf.setCity(rs.getString("c_city"));
			conf.setCountry(rs.getString("c_country"));
			conf.setEstimatedNoOfSubmission(rs.getString("c_est_no_of_submission"));
			conf.setStartDt(rs.getString("c_start_dt"));
			conf.setEndDt(rs.getString("c_end_dt"));
			conf.setPaperSubmissionDeadline(rs.getString("c_deadline_paper_submit_dt"));
			conf.setAreaNote(rs.getString("c_area_note"));
			conf.setOrganizer(rs.getString("c_organizer"));
			conf.setOrganizerWebPage(rs.getString("c_organizer_webpage"));
			conf.setContactNo(rs.getString("c_contact_no"));
			conf.setYourRole(rs.getString("c_your_role"));
			conf.setAnyOtherDetail(rs.getString("c_any_other_detail"));
			conf.setEvaluationParameterMarksForJury(rs.getString("c_eval_para_marke_jury"));
			conf.setEvaluationParameterMarksForChair(rs.getString("c_eval_para_marke_chair"));
			conf.setStatus(rs.getString("c_status"));
			conf.setCreatBy(rs.getString("c_create_dt"));
			conf.setCreatDt(rs.getString("c_create_by"));
			conf.setDisplayReviewCommentTOAuthor(rs.getString("c_display_comment_to_author, "));
			conf.setEmailNotificationToAuthor(rs.getString("c_email_notification_to_author)"));
			
			
			ar.add(conf);
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
	
	
	
	
	public Conference modifyConference(Conference conf,String logedInUser) throws Exception{	
		
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
	try{
		System.out.println("modify Confeence dao in ssDao");
			conn=connBean.getConnectionObj();
			

			 pstmt=conn.prepareStatement("update tbl_conference set  c_conf_name=?, c_acronym=?, c_webpage=?,"
						+ "c_venue=?, c_city=?, c_country=?, c_est_no_of_submission=?, c_start_dt=?, c_end_dt=?,"
						+ " c_deadline_paper_submit_dt=?, c_area_note=?, c_organizer=?, c_organizer_webpage=?, c_contact_no=?, "
						+ "c_your_role=?, c_any_other_detail=?, c_eval_para_marke_jury=?, c_eval_para_marke_chair=?, "
						+ "c_status=?,c_lst_upd_dt=now(), c_lst_upd_by=?, c_display_comment_to_author=?,"
						+ " c_email_notification_to_author=? where c_id=? ");	
				
			 pstmt.setString(1, conf.getNameOfConference());
				pstmt.setString(2, conf.getAcronym());
				pstmt.setString(3, conf.getWebPage());
				pstmt.setString(4, conf.getVenue());
				pstmt.setString(5, conf.getCity());
				pstmt.setString(6, conf.getCountry());
				pstmt.setString(7, conf.getEstimatedNoOfSubmission());
				pstmt.setString(8, conf.getStartDt());
				pstmt.setString(9, conf.getEndDt());
				pstmt.setString(10, conf.getPaperSubmissionDeadline());
				pstmt.setString(11, conf.getAreaNote());
				pstmt.setString(12, conf.getOrganizer());
				pstmt.setString(13, conf.getOrganizerWebPage());
				pstmt.setString(14, conf.getContactNo());
				pstmt.setString(15, conf.getYourRole());
				pstmt.setString(16, conf.getAnyOtherDetail());
				pstmt.setString(17, conf.getEvaluationParameterMarksForJury());
				pstmt.setString(18, conf.getEvaluationParameterMarksForChair());
				pstmt.setString(19, conf.getStatus());
				pstmt.setString(20, logedInUser);
				pstmt.setString(21, conf.getDisplayReviewCommentTOAuthor());
				pstmt.setString(22, conf.getEmailNotificationToAuthor());
				pstmt.setString(23, conf.getConferenceId());
				
				
				
			    int count = pstmt.executeUpdate();
			    
			    
			    if(count!=0){		    	
			    	System.out.println(">>>SAVE Conference <<<");		    	
			    	conf.setRecordUpdate("true");		    	
			    }
			    else
			    {
			    	System.out.println(">>>Conference SAVED FAILED<<<");
			    	conf.setRecordUpdate("false");
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

	return conf;
			
	}
}
