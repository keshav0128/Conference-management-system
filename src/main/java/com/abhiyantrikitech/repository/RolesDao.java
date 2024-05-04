package com.abhiyantrikitech.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Repository;

import com.abhiyantrikitech.model.RoleMaster;
import com.abhiyantrikitech.model.SubRoleMaster;


@Repository
public class RolesDao {

	public RolesDao(){
		connBean=new ConnectionBean();
	}

	//Connection conn=null;
	ConnectionBean connBean=null;
	//PreparedStatement pstmt=null;
	//ResultSet rs=null;
	
	
	public int createRole(RoleMaster roleMaster) {

		System.out.println("createRole");
		int count=0;
		int sub_role_count=0;
		int in_seq_id=0;
		int in_sub_seq_id=0;
		Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		try{
			
			conn=connBean.getConnectionObj();
			//conn.setAutoCommit(false);
	   		
	   		String sql="SELECT nextval('seq_role_mas_id') LC_SEQ_ID from dual ";
			
	   		pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
		    
		     
			while(rs.next()){
				
				in_seq_id= rs.getInt("LC_SEQ_ID");
			}
			System.out.println("Seq id---"+in_seq_id);
			
			pstmt.close();
			rs.close();
	   		

			pstmt=conn.prepareStatement("insert into tbl_role_mas (rm_id,rm_role_name,rm_status"
					+ ",rm_create_by,rm_create_dt)"
					+ "values(?,?,?,?,now())");	
			pstmt.setLong(1, in_seq_id);
			pstmt.setString(2, roleMaster.getRoleName());
			pstmt.setString(3, "Y");
			pstmt.setString(4, roleMaster.getCreateBy());
		
			
			count=pstmt.executeUpdate();
			
			
			if(count!=0){
				
					SubRoleMaster subRoleMaster=null;
					System.out.println("roleMaster.getSubRoleMaster()"+roleMaster.getSubRoleMaster());
					
					for (int i=0;i<roleMaster.getSubRoleMaster().size();i++)
			    	{
			    		
						   
						subRoleMaster=roleMaster.getSubRoleMaster().get(i);
				 

					   	    sql="SELECT nextval('seq_sub_role_id') LC_SEQ_ID from dual ";
							
					   		pstmt=conn.prepareStatement(sql);
							
							rs=pstmt.executeQuery();
						    
						     
							while(rs.next()){
								
								in_sub_seq_id= rs.getInt("LC_SEQ_ID");
							}
							System.out.println("Sub Seq id---"+in_sub_seq_id);
							
							pstmt.close();
							rs.close();
					   		
	
							pstmt=conn.prepareStatement("insert into tbl_sub_role_mas (srm_id,srm_rm_id,srm_mam_id,"
									+ "srm_status,srm_create_by,srm_create_dt)"
									+ "values(?,?,?,?,?,now())");	
							pstmt.setInt(1, in_sub_seq_id);
							pstmt.setInt(2, in_seq_id);
							pstmt.setString(3, subRoleMaster.getSubMenuAccessId());
							if (subRoleMaster.getSubRoleStatus()==null)
							{
								pstmt.setString(4, "N");
							}
							else
							{
								pstmt.setString(4, subRoleMaster.getSubRoleStatus());
							}

							pstmt.setString(5, roleMaster.getCreateBy());
						
							
							sub_role_count=pstmt.executeUpdate();
				    	
							if(sub_role_count==0){
								
								System.out.println("error in sub role creation -"+in_sub_seq_id);
								return sub_role_count;
							}
				    	
			    	}//end for loop
				    
				
				//return count;
			}
			
			rs.close();
			pstmt.close();
			//conn.commit();
			conn.close();
			System.out.println("End role creation ");
			return count;
			}catch(Exception e){
				try {
					System.out.println(e);
					//conn.rollback();
					return 0;
					//throw new GeneralException("Error in saving role master");
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
		
		return count;
	}


	public int updateRole(RoleMaster roleMaster) {

		System.out.println("updateRole");
		int count=0;
		int sub_role_count=0;
		int in_seq_id=0;
		int in_sub_seq_id=0;
		String sql="";
		Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		try{
			
			conn=connBean.getConnectionObj();
			//conn.setAutoCommit(false);
	   		
	   		
			pstmt=conn.prepareStatement("UPDATE tbl_role_mas SET rm_role_name=?,rm_status=? "
					+ ",rm_lst_upd_by=?,rm_lst_upd_dt=now() WHERE rm_id=?");

			
			pstmt.setString(1, roleMaster.getRoleName());
			
			pstmt.setString(2, roleMaster.getRoleStatus());
			pstmt.setString(3, roleMaster.getCreateBy());
			pstmt.setString(4, roleMaster.getRoleId());
		
			
			count=pstmt.executeUpdate();
			

			if(count!=0){
				
					SubRoleMaster subRoleMaster=null;
					
					for (int i=0;i<roleMaster.getSubRoleMaster().size();i++)
			    	{
			    		
				    	   subRoleMaster=roleMaster.getSubRoleMaster().get(i);
				    	   
				 
							if(!subRoleMaster.getSubRoleId().equals("0"))
							{

								pstmt=conn.prepareStatement("UPDATE tbl_sub_role_mas SET "
										+ "srm_status=?,srm_lst_upd_by=?,srm_lst_upd_dt=now() WHERE "
										+ "srm_id=? AND srm_rm_id=?");
								
								
								if (subRoleMaster.getSubRoleStatus()==null)
								{
									pstmt.setString(1, "N");
									//System.out.println("status null");
								}
								else
								{
									pstmt.setString(1, subRoleMaster.getSubRoleStatus());
								}
								pstmt.setString(2, roleMaster.getCreateBy());
								pstmt.setString(3, subRoleMaster.getSubRoleId());
								pstmt.setString(4, roleMaster.getRoleId());
							
								
								sub_role_count=pstmt.executeUpdate();
					    	
								if(sub_role_count==0){
									
									return sub_role_count;
								}
							}
							else
							{ // if new record
								
								
								 sql="SELECT nextval('seq_sub_role_id') LC_UA_ID from dual ";
								
								pstmt=conn.prepareStatement(sql);
								
								rs=pstmt.executeQuery();
							    
							     
								while(rs.next()){
									
									in_sub_seq_id= rs.getInt("LC_UA_ID");
								}
								
									
								pstmt.close();
								rs.close();
						   		
								
								pstmt=conn.prepareStatement("insert into tbl_sub_role_mas (srm_id,srm_rm_id,srm_mam_id,"
										+ "srm_status,srm_create_by,srm_create_dt)"
										+ "values(?,?,?,?,?,now())");	
								pstmt.setInt(1, in_sub_seq_id);
								pstmt.setString(2, roleMaster.getRoleId());
								pstmt.setString(3, subRoleMaster.getSubMenuAccessId());
								
								if (subRoleMaster.getSubRoleStatus()==null)
								{
									pstmt.setString(4, "N");
								}
								else
								{
									pstmt.setString(4, subRoleMaster.getSubRoleStatus());
								}
								
								pstmt.setString(5, roleMaster.getCreateBy());
							
								
								sub_role_count=pstmt.executeUpdate();
					    	
								if(sub_role_count==0){
									
									return sub_role_count;
								}

							} // end if
				    	
			    	}//end for loop

				//conn.commit();
				return count;
				
			}

			rs.close();
			pstmt.close();
			conn.close();
			
			}catch(Exception e){
				try {
					System.out.println("In exception");
					e.printStackTrace();
					//conn.rollback();
					conn.close();
					System.out.println("rollback");
					return 0;

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
		
		return count;
	}
	
	
	
	
	public RoleMaster getRoleDataById(String roleId) {		
		
		//ArrayList ar=new ArrayList<>();
		RoleMaster roleMaster=null;
		Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		try{
			
			conn=connBean.getConnectionObj();

			pstmt=conn.prepareStatement("select rm_id,rm_role_name,rm_status,rm_create_by,rm_create_dt,"
					+ "rm_lst_upd_by, rm_lst_upd_dt "
					+ " from tbl_role_mas where rm_id=? order by rm_create_dt desc");	
			
			pstmt.setString(1, roleId);
			
		    rs=pstmt.executeQuery();
		    
			RolesDao rd =new RolesDao();
			
			while(rs.next()){

				roleMaster=new RoleMaster();
				roleMaster.setRoleId(rs.getString("rm_id"));
				roleMaster.setRoleName(rs.getString("rm_role_name"));
				roleMaster.setRoleStatus(rs.getString("rm_status"));
				roleMaster.setCreateBy(rs.getString("rm_create_by"));
				roleMaster.setCreateDt(rs.getString("rm_create_dt"));
				
				roleMaster.setSubRoleMaster(rd.getSubRoleByRoleId(rs.getString("rm_id")));
							

			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
			}catch(Exception e){
				try {
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
			   }//end try
		return roleMaster;
	}
	
	
	public ArrayList<RoleMaster> getRoleData() {		
		
		ArrayList ar=new ArrayList<>();
		RoleMaster roleMaster=null;
		Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		try{
			
			conn=connBean.getConnectionObj();

			pstmt=conn.prepareStatement("select rm_id,rm_role_name,rm_status,rm_create_by,"
					+ "date_format(rm_create_dt,'%d-%b-%Y') rm_create_dt,"
					+ "rm_lst_upd_by, date_format(rm_lst_upd_dt,'%d-%b-%Y') rm_lst_upd_dt "
					+ " from tbl_role_mas where 1=1 order by rm_create_dt desc");	
			
			
			
		    rs=pstmt.executeQuery();
		    
			RolesDao rd =new RolesDao();
			
			while(rs.next()){

				roleMaster=new RoleMaster();
				roleMaster.setRoleId(rs.getString("rm_id"));
				roleMaster.setRoleName(rs.getString("rm_role_name"));
				roleMaster.setRoleStatus(rs.getString("rm_status"));
				roleMaster.setCreateBy(rs.getString("rm_create_by"));
				roleMaster.setCreateDt(rs.getString("rm_create_dt"));
				roleMaster.setLastUpdateBy(rs.getString("rm_lst_upd_by"));
				roleMaster.setLastUpdateDt(rs.getString("rm_lst_upd_dt"));
				
				ar.add(roleMaster);

			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
			}catch(Exception e){
				try {
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
			   }//end try
		return ar;
	}
	
	
public boolean checkDuplicateRole (String roleName,String roleId)
{
	int cnt=0;
	Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	try{
		System.out.println("checkDuplicateRole--"+roleId);
		conn=connBean.getConnectionObj();
		
		if (roleId==null|| roleId.equals("0")||roleId.equals("")||roleId.equals("null"))
		{
		
			pstmt=conn.prepareStatement("select count(*) cnt "
					+ " from tbl_role_mas  where  upper(rtrim(rm_role_name))=upper(rtrim(?))");
			
			pstmt.setString(1, roleName);
		}
		else
		{
			pstmt=conn.prepareStatement("select count(*) cnt "
					+ " from tbl_role_mas  where  upper(rtrim(rm_role_name))=upper(rtrim(?)) and rm_id<>?");
			
			pstmt.setString(1, roleName);
			pstmt.setString(2, roleId);
		}
		
		
		
	    rs=pstmt.executeQuery();
		
		while(rs.next()){
			cnt=rs.getInt("cnt");
		}
		
		
		rs.close();
		pstmt.close();
		conn.close();
		
		if (cnt==0)
		return true;
		else
		return false;	
		
		}catch(Exception e){
			try {
				System.out.println(e);
				//throw new GeneralException("Error in getting sub role master");
				return false;	
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
	return true;


}
	
public ArrayList getSubRoleByRoleId(String roleId) {		
		System.out.println("getSubRoleByRoleId="+roleId);
		ArrayList ar=new ArrayList<>();
		SubRoleMaster subRoleMaster=null;
		Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		try{
			
			conn=connBean.getConnectionObj();
			
			pstmt=conn.prepareStatement("select * from (select srm_id,srm_rm_id,srm_mam_id,IFNULL(srm_status,'N') srm_status,mam_menu_name "
					 +"from tbl_sub_role_mas ,tbl_menu_access_mas   where srm_mam_id=mam_id AND "
					 +"mam_status='Active' AND  srm_rm_id=? "
           +"union "
           	+"select 0 srm_id,0 srm_rm_id,mam_id srm_mam_id,'N' srm_status,mam_menu_name "
			+"		 from tbl_menu_access_mas   where  mam_status='Active' AND  "
			+"(mam_id NOT IN (select srm_mam_id from tbl_sub_role_mas WHERE srm_rm_id=?)))AA order by mam_menu_name asc");
						
			
			pstmt.setString(1, roleId) ;
			pstmt.setString(2, roleId) ;
			
		    rs=pstmt.executeQuery();
			
			while(rs.next()){

				subRoleMaster=new SubRoleMaster();
				subRoleMaster.setSubRoleId(rs.getString("srm_id"));
				subRoleMaster.setRoleId(roleId);
				subRoleMaster.setSubMenuAccessId(rs.getString("srm_mam_id"));
				subRoleMaster.setSubRoleStatus(rs.getString("srm_status"));
				subRoleMaster.setSubRoleLabel(rs.getString("mam_menu_name"));
				
				ar.add(subRoleMaster);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
			}catch(Exception e){
				try {
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
			   }//end try
		return ar;
	}
	
public ArrayList getSubRoleList() {		
	
	ArrayList ar=new ArrayList<>();
	LinkedHashMap hm=null;
	SubRoleMaster subRoleMaster=null;
	Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	try{
		
		conn=connBean.getConnectionObj();
		
		pstmt=conn.prepareStatement("select mam_id,mam_menu_name"
				+ " from tbl_menu_access_mas  where mam_status='Active' order by mam_menu_name asc");
					
			
	    rs=pstmt.executeQuery();
		
		while(rs.next()){
			
			subRoleMaster=new SubRoleMaster();
			subRoleMaster.setSubRoleId("0");
			subRoleMaster.setRoleId("0");
			subRoleMaster.setSubMenuAccessId(rs.getString("mam_id"));
			subRoleMaster.setSubRoleStatus("N");
			subRoleMaster.setSubRoleLabel(rs.getString("mam_menu_name"));
			
			ar.add(subRoleMaster);
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		}catch(Exception e){
			try {
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
		   }//end try
	return ar;
}
	
	public synchronized  LinkedHashMap<String,String> getRoleAccessByRoleId(String roleId) {
		// TODO Auto-generated method stub	
		
		LinkedHashMap<String,String> hm= new LinkedHashMap<String,String>();
		Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		try{
			
			conn=connBean.getConnectionObj();

			pstmt=conn.prepareStatement("select srm_id,mam_menu_name,mam_menu_code from tbl_menu_access_mas,tbl_sub_role_mas "
					+ "where mam_id=srm_mam_id and srm_rm_id=? and mam_status='Active' and srm_status='Y' order by mam_menu_name asc");	
			pstmt.setString(1, roleId);
			//pstmt.setString(2, Password);
		    rs=pstmt.executeQuery();
			
			while(rs.next()){
				hm.put(rs.getString("mam_menu_code"), rs.getString("mam_menu_name"));
				//System.out.println(">>>>>>>>>><<<<<<<<<<");
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
			}catch(Exception e){
				try {
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
			   }//end try
		return hm;
	}

	

	public boolean checkMenuAccess(String roleId,String menuCode) {
		boolean status=false;
		Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		try{
			
			conn=connBean.getConnectionObj();

			pstmt=conn.prepareStatement("select srm_id,mam_menu_name,mam_menu_code from tbl_menu_access_mas,tbl_sub_role_mas "
					+ "where mam_id=srm_mam_id and srm_rm_id=? and upper(mam_menu_code)=? and mam_status='Active' and srm_status='Y' order by mam_menu_name asc");	
			pstmt.setString(1, roleId);
			pstmt.setString(2, menuCode.toUpperCase());
		    rs=pstmt.executeQuery();
			
			while(rs.next()){
				status=true;
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
			}catch(Exception e){
				try {
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
			   }//end try
		return status;
	}

	
	
	

	public HashMap getRoleLOV() {		
		
		
		HashMap hm=new HashMap();
		Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		
		try{
			
			conn=connBean.getConnectionObj();

			pstmt=conn.prepareStatement("select rm_id,rm_role_name "
					+ " from tbl_role_mas where rm_status='Y' order by rm_create_dt desc");	
			
			
			
		    rs=pstmt.executeQuery();
		    
			RolesDao rd =new RolesDao();
			
			while(rs.next()){

				
				hm.put(rs.getString("rm_id"),rs.getString("rm_role_name"));
				

			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
			}catch(Exception e){
				try {
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
			   }//end try
		return hm;
	}
		
	
	
	
	
	
	
	

}
