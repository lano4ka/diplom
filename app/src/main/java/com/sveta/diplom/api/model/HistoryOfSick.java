package com.sveta.diplom.api.model;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class HistoryOfSick {
	
	private Long id_history;
	
	private String state;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date date_begin;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date date_end;

	private User patient;
	
	private Diagnoz diagnoz;
	
	private User doctor;
	
	@JsonIgnore
	private List<Measurement> measurements; 
	
	private List<Indicator> indicators;
	
	public Long getId_history() {
		return id_history;
	}

	public void setId_history(Long id_history) {
		this.id_history = id_history;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate_begin() {
		return date_begin;
	}

	public void setDate_begin(Date date_begin) {
		this.date_begin = date_begin;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public Diagnoz getDiagnoz() {
		return diagnoz;
	}

	public void setDiagnoz(Diagnoz diagnoz) {
		this.diagnoz = diagnoz;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public List<Measurement> getMeasurements() {
		return measurements;
	}

	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;
	}

	public List<Indicator> getIndicators() {
		return indicators;
	}

	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}
	
	
}
