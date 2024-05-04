package com.abhiyantrikitech.model;

import java.sql.Date;

public class Logininfo {

	private long ldId=0;
	private String ldLoginId=null;
	private Date ldLoginDt=null;
	private Date ldLogoutDt=null;
	private String ldIp=null;
	private String ldMacId="";
	private String ldHostName=null;
	public String getLdHostName() {
		return ldHostName;
	}
	public void setLdHostName(String ldHostName) {
		this.ldHostName = ldHostName;
	}
	private Date ldCrtDt=null;
	public long getLdId() {
		return ldId;
	}
	public void setLdId(long ldId) {
		this.ldId = ldId;
	}
	public String getLdLoginId() {
		return ldLoginId;
	}
	public void setLdLoginId(String ldLoginId) {
		this.ldLoginId = ldLoginId;
	}
	public Date getLdLoginDt() {
		return ldLoginDt;
	}
	public void setLdLoginDt(Date ldLoginDt) {
		this.ldLoginDt = ldLoginDt;
	}
	public Date getLdLogoutDt() {
		return ldLogoutDt;
	}
	public void setLdLogoutDt(Date ldLogoutDt) {
		this.ldLogoutDt = ldLogoutDt;
	}
	public String getLdIp() {
		return ldIp;
	}
	public void setLdIp(String ldIp) {
		this.ldIp = ldIp;
	}
	public String getLdMacId() {
		return ldMacId;
	}
	public void setLdMacId(String ldMacId) {
		this.ldMacId = ldMacId;
	}
	public Date getLdCrtDt() {
		return ldCrtDt;
	}
	public void setLdCrtDt(Date ldCrtDt) {
		this.ldCrtDt = ldCrtDt;
	}
	public String getLdCrtBy() {
		return ldCrtBy;
	}
	public void setLdCrtBy(String ldCrtBy) {
		this.ldCrtBy = ldCrtBy;
	}
	private String ldCrtBy;
}
