package com.abhiyantrikitech.model;

import java.sql.Date;
import java.util.List;

public class QuizRegisterDetailDTO {

	public int draw;
	public int recordsTotal;
	public int recordsFiltered;

	public List<Conference> data;

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

	public List<Conference> getData() {
		return data;
	}

	public void setData(List<Conference> data) {
		this.data = data;
	}

	
	
}
