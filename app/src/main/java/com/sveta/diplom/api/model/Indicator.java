package com.sveta.diplom.api.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Indicator {

	private Long id_indicator;
	
	private String name;

	private List<Measurement> measurements;
	
	@JsonIgnore
	private List<HistoryOfSick> histories;
	
	public Long getId_indicator() {
		return id_indicator;
	}

	public void setId_indicator(Long id_indicator) {
		this.id_indicator = id_indicator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Measurement> getMeasurements() {
		return measurements;
	}

	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;
	}

	public List<HistoryOfSick> getHistories() {
		return histories;
	}

	public void setHistories(List<HistoryOfSick> histories) {
		this.histories = histories;
	}
	
	
	
}
