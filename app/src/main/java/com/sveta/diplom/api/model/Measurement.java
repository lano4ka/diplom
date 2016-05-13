package com.sveta.diplom.api.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Measurement {
	
	@JsonIgnore
	private Long id_measurement;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date date_time;
	
	private Float value;

	@JsonIgnore
	private HistoryOfSick history;
	
	@JsonIgnore
	private Indicator indicator;
	
	public Long getId_measurement() {
		return id_measurement;
	}

	public void setId_measurement(Long id_measurement) {
		this.id_measurement = id_measurement;
	}

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

	public HistoryOfSick getHistory() {
		return history;
	}

	public void setHistory(HistoryOfSick history) {
		this.history = history;
	}

	public Indicator getIndicator() {
		return indicator;
	}

	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
	
	
}
