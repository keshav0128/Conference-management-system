package com.abhiyantrikitech.model;

import java.sql.Date;
import java.util.List;

public class LoginMasterDTO {

	public int draw;
	public int recordsTotal;
	public int recordsFiltered;

	public List<LoginMaster> data;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<LoginMaster> getData() {
		return data;
	}

	public void setData(List<LoginMaster> data) {
		this.data = data;
	}
	
	
}
