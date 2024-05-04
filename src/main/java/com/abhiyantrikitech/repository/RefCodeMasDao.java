package com.abhiyantrikitech.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;


import com.abhiyantrikitech.model.RefCodeMas;
import com.abhiyantrikitech.util.Utility;

@Repository
public class RefCodeMasDao {
	//Connection conn=null;
	ConnectionBean connBean=null;
	//PreparedStatement pstmt=null;
	//ResultSet rs=null;

public RefCodeMasDao(){
	connBean=new ConnectionBean();
}
public RefCodeMas saveRefCodeMas(RefCodeMas ss, String loggedInUser) throws Exception{	
	
	 int in_ua_id = 0;
	 int in_rec_cnt = 0;
	 Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
try{
	System.out.println("saveRefCodeMas in RefCodeMasDao");
		conn=connBean.getConnectionObj();
		
		
			
			pstmt=conn.prepareStatement("SELECT nextval('SEQ_RefCodeMas_ID') LC_UA_ID");
			
		    rs=pstmt.executeQuery();
		    
		     
			while(rs.next()){
				in_ua_id= rs.getInt("LC_UA_ID");
			}
			System.out.println("ss id---"+in_ua_id);
			
			pstmt.close();
			rs.close();
			
			//////////////////////////////////
			
			pstmt=conn.prepareStatement("SELECT count(*) cnt from  tbl_ref_code where rc_type=?");
			
			if (ss.getRefType()!=null && !ss.getRefType().equals(""))
			{
				pstmt.setString(1, ss.getRefType());
			}
			else
			{
				pstmt.setString(1, ss.getNewType());
			}
			
		    rs=pstmt.executeQuery();
		    
		     
			while(rs.next()){
				in_rec_cnt= rs.getInt("cnt");
			}
						
			pstmt.close();
			rs.close();

			pstmt=conn.prepareStatement("insert into tbl_ref_code (rc_id,rc_type,rc_val_1,rc_val_2,rc_desc,rc_status,rc_creat_date,rc_creat_by,"
					+ "rc_order )  "				
					+ "VALUES(?,?,?,?,?,?,now(),?,?)");	
			
			pstmt.setInt(1,in_ua_id);
			if (ss.getRefType()!=null && !ss.getRefType().equals(""))
			{
				pstmt.setString(2, ss.getRefType());
			}
			else
			{
				pstmt.setString(2, ss.getNewType());
			}
			
			pstmt.setString(3, ss.getRefVal1());
			pstmt.setString(4, ss.getRefVal2());
			pstmt.setString(5, ss.getRefDesc());
			pstmt.setString(6, "Active");
			pstmt.setString(7, loggedInUser);
			pstmt.setInt(8, in_rec_cnt+1);
	
			
		    int count = pstmt.executeUpdate();
		    
		    
		    if(count!=0){
		    	
		    	System.out.println(">>>SAVE Ref Code MAS<<<");
		    	
		    	ss.setRecordUpdate("true");
		    
		    	
		    }
		    else
		    {
		    	System.out.println(">>>Ref Code SAVED FAILED<<<");
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
public RefCodeMas getRefCodeMasListById(String id ) throws Exception {
	System.out.println("Inside getRefCodeMasListById ssdao :");
	RefCodeMas ss=new RefCodeMas();   
	Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	try{

	conn=connBean.getConnectionObj();
	
	
		pstmt=conn.prepareStatement("select date_format(rc_creat_date,'%d-%b-%Y') rc_creat_date,a.* from tbl_ref_code a where rc_id=? ");
		
		pstmt.setString(1, id);
		
	rs=pstmt.executeQuery();
	
	 
	
	while(rs.next()){
	
		
		ss.setRefId(rs.getString("rc_id"));
		ss.setRefType(rs.getString("rc_type"));
		ss.setRefVal1(rs.getString("rc_val_1"));
		ss.setRefVal2(rs.getString("rc_val_2"));
		ss.setRefDesc(rs.getString("rc_desc"));
		ss.setRefStatus(rs.getString("rc_status"));
		ss.setRefCreatDate(rs.getString("rc_creat_date"));
		ss.setRefCreatBy(rs.getString("rc_creat_by"));
		ss.setRefOrder(rs.getString("rc_order"));

		
		
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
public ArrayList getRefCodeMasList() throws Exception {
	System.out.println("Inside getRefCodeMasList ssdao :");
	ArrayList<RefCodeMas> ar=new ArrayList<RefCodeMas>(); 
	Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;

	
	try{

		conn=connBean.getConnectionObj();
		
		
		pstmt=conn.prepareStatement("select date_format(rc_creat_date,'%d-%b-%Y') rc_creat_date,a.* from tbl_ref_code a "
				+ " order by rc_id desc ");
		
		
	
		rs=pstmt.executeQuery();
	
	 
	
	while(rs.next()){
	
		RefCodeMas ss = new RefCodeMas();
		ss.setRefId(rs.getString("rc_id"));
		ss.setRefType(rs.getString("rc_type"));
		ss.setRefVal1(rs.getString("rc_val_1"));
		ss.setRefVal2(rs.getString("rc_val_2"));
		ss.setRefDesc(rs.getString("rc_desc"));
		ss.setRefStatus(rs.getString("rc_status"));
		ss.setRefCreatDate(rs.getString("rc_creat_date"));
		ss.setRefCreatBy(rs.getString("rc_creat_by"));
		ss.setRefOrder(rs.getString("rc_order"));
		
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



@SuppressWarnings("rawtypes")
public HashMap getAllType() throws Exception {
	System.out.println("Inside getAllType dao :");
	HashMap hm=new HashMap(); 
	Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;

	
	try{

		conn=connBean.getConnectionObj();
		
		
		pstmt=conn.prepareStatement("select distinct rc_type from tbl_ref_code  order by rc_type asc ");
		

	
		rs=pstmt.executeQuery();
	
	 
	
	while(rs.next()){
	
		hm.put(rs.getString("rc_type"), rs.getString("rc_type"));
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
		
		
		return hm;	
}


@SuppressWarnings("rawtypes")
public HashMap getRefCodeLov(String type) throws Exception {
	System.out.println("Inside getRefCdeLov dao :");
	HashMap hm=new HashMap(); 
	Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;

	
	try{

		conn=connBean.getConnectionObj();
		
		
		pstmt=conn.prepareStatement("select rc_val_1,rc_val_1 from tbl_ref_code where rc_status='Active' and upper(rc_type)=? order by rc_val_1 asc ");
		
		pstmt.setString(1, type.toUpperCase());
	
		rs=pstmt.executeQuery();
	
	 
	
	while(rs.next()){
	
		hm.put(rs.getString("rc_val_1"), rs.getString("rc_val_1"));
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
		
		
		return hm;	
}


@SuppressWarnings("rawtypes")
public HashMap getRefCodeLov1(String type) throws Exception {
	System.out.println("Inside getRefCdeLov1 dao :");
	HashMap hm=new HashMap(); 
	Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;

	
	try{

		conn=connBean.getConnectionObj();
		
		
		pstmt=conn.prepareStatement("select rc_val_1,ifnull(rc_desc,rc_val_1) rc_desc from tbl_ref_code where rc_status='Active' and upper(rc_type)=? order by rc_val_1 asc ");
		
		pstmt.setString(1, type.toUpperCase());
	
		rs=pstmt.executeQuery();
	
	 
	
	while(rs.next()){
	
		hm.put(rs.getString("rc_val_1"), rs.getString("rc_desc"));
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
		
		
		return hm;	
}


@SuppressWarnings("rawtypes")
public String getRefCodeId(String type,String desc) throws Exception {
	System.out.println("Inside getRefCodeId dao :");
	String id=""; 
	Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;

	
	try{

		conn=connBean.getConnectionObj();
		
		
		pstmt=conn.prepareStatement("select rc_id,rc_desc from tbl_ref_code where rc_status='Active' and upper(rc_type)=? "
				+ "and (upper(rc_desc)=? or upper(rc_val_1)=? ) limit 1");
		
		pstmt.setString(1, type.toUpperCase());
		pstmt.setString(2, desc.toUpperCase());
		pstmt.setString(3, desc.toUpperCase());
	
		rs=pstmt.executeQuery();
	
	 
	
	while(rs.next()){
	
		id= rs.getString("rc_id");
		
	}
	
	rs.close();
	pstmt.close();
	conn.close();
	
	System.out.println("end id="+id);
	
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
		
		
		return id;	
}


public RefCodeMas modifyRefCodeMas(RefCodeMas ss, String loggedInUser) throws Exception{	
	
	 int in_ua_id = 0;
	 Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
try{
	System.out.println("modifyRefCodeMas in ssDao");
		conn=connBean.getConnectionObj();
		

		 pstmt=conn.prepareStatement("update tbl_ref_code set rc_type=?,rc_val_1=?,rc_val_2=?,rc_desc=?,"
		 		+ "rc_status=?,rc_last_upd_date=now(),rc_last_upd_by=? "
					+ " where rc_id=? ");	
			
		 if (ss.getNewType()!=null && !ss.getNewType().equals(""))
			{
				pstmt.setString(1, ss.getNewType());
			}
			else
			{
				pstmt.setString(1, ss.getRefType());
			}
			pstmt.setString(2, ss.getRefVal1());
			pstmt.setString(3, ss.getRefVal2());
			pstmt.setString(4, ss.getRefDesc());
			pstmt.setString(5, ss.getRefStatus());
			pstmt.setString(6, loggedInUser);
			pstmt.setString(7, ss.getRefId());
		
			
		    int count = pstmt.executeUpdate();
		    
		    
		    if(count!=0){		    	
		    	System.out.println(">>>SAVE Ref Code MAS<<<");		    	
		    	ss.setRecordUpdate("true");		    	
		    }
		    else
		    {
		    	System.out.println(">>>Ref Code SAVED FAILED<<<");
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

public boolean duplicateRefCode(String id,String type,String desc) throws Exception{	
	

	String count="0";
	Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;

try{
		System.out.println("duplicateRefCode in RefCodeMasDao");
		conn=connBean.getConnectionObj();
		
					if (id==null||id.equals("")||id.equals("0"))
					{
						pstmt=conn.prepareStatement("SELECT count(*) cnt FROM tbl_ref_code WHERE upper(rc_type)=? and upper(rc_desc)=? ");	
					
							pstmt.setString(1, type.toUpperCase());
							pstmt.setString(2, desc.toUpperCase());
							
					}
					else
					{
						pstmt=conn.prepareStatement("SELECT count(*) cnt FROM tbl_ref_code WHERE upper(rc_type)=? and upper(rc_desc)=? and rc_id<>?");	
						
							pstmt.setString(1, type.toUpperCase());	
							pstmt.setString(2, desc.toUpperCase());
							pstmt.setString(3, id);
					}
			
							
		            rs = pstmt.executeQuery();
		              
		              
				    while (rs.next())
				    {
				    	
				    	count=rs.getString("cnt");
				    	
				    }
				    
				    pstmt.close();
					conn.close();
			          
				    if(!count.equals("0"))
				    {
				    	return true; // Duplicate
				    }
				    else
				    {
				    	return false;
				    }
					
		
		
		}catch(Exception e){
			try {
				//conn.rollback(); 
				System.out.println(e);
			
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

return false;
		
}


@SuppressWarnings("rawtypes")
public RefCodeMas getRefCodeValue(String type) throws Exception {
	System.out.println("Inside getRefCodeValue dao :");
	
	RefCodeMas ss =null;
	Connection conn1=null;
	PreparedStatement pstmt1=null;
	ResultSet rs1=null;
	Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	
	try{

		conn1=connBean.getConnectionObj();
		
		
		pstmt1=conn1.prepareStatement("select * from tbl_ref_code where rc_status='Active' and upper(rc_type)=? "
				+ " limit 1");
		
		pstmt1.setString(1, type.toUpperCase());
	
		rs1=pstmt1.executeQuery();
	
	 
	
	while(rs1.next()){
	
		ss = new RefCodeMas();
		ss.setRefId(rs1.getString("rc_id"));
		ss.setRefType(rs1.getString("rc_type"));
		ss.setRefVal1(rs1.getString("rc_val_1"));
		ss.setRefVal2(rs1.getString("rc_val_2"));
		ss.setRefDesc(rs1.getString("rc_desc"));
		ss.setRefStatus(rs1.getString("rc_status"));
		ss.setRefCreatDate(rs1.getString("rc_creat_date"));
		ss.setRefCreatBy(rs1.getString("rc_creat_by"));
		ss.setRefOrder(rs1.getString("rc_order"));
		
		
	}
	
	rs1.close();
	pstmt1.close();
	conn1.close();
	
		
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
		         if(conn1!=null)
		            conn1.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		         
		      }finally{//end finally try
	      }
	   }//end try
		
		
		return ss;	
}

}
