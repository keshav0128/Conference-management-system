package com.abhiyantrikitech.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhiyantrikitech.model.RefCodeMas;
import com.abhiyantrikitech.repository.RefCodeMasDao;

@Service
public class RefCodeMasService {
	@Autowired
	RefCodeMasDao RefCodeMasDao;
	public RefCodeMas saveRefCodeMas(RefCodeMas ss, String loggedInUser) throws Exception{
		return RefCodeMasDao.saveRefCodeMas(ss, loggedInUser);
	}
	
	public RefCodeMas getRefCodeMasListById(String id ) throws Exception {
		return RefCodeMasDao.getRefCodeMasListById(id);
	}
	
	public ArrayList getRefCodeMasList() throws Exception {
		return RefCodeMasDao.getRefCodeMasList();
	}
	
	public RefCodeMas modifyRefCodeMas(RefCodeMas ss, String loggedInUser) throws Exception{
		return RefCodeMasDao.modifyRefCodeMas(ss,loggedInUser);
	}
	
	public boolean duplicateRefCode(String id,String type,String desc) throws Exception{
		return RefCodeMasDao.duplicateRefCode(id,type,desc);
	}
		
	public HashMap getRefCodeLov(String type) throws Exception {
		return RefCodeMasDao.getRefCodeLov(type);
	}
	
	public HashMap getRefCodeLov1(String type) throws Exception {
		return RefCodeMasDao.getRefCodeLov1(type);
	}
	
	public HashMap getAllType() throws Exception {
		return RefCodeMasDao.getAllType();
	}
	
	public String getRefCodeId(String type,String desc) throws Exception {
		return RefCodeMasDao.getRefCodeId(type,desc);
	}
	
	public RefCodeMas getRefCodeValue(String type) throws Exception {
		return RefCodeMasDao.getRefCodeValue(type);
	}
}
