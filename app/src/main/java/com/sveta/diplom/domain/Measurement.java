package com.sveta.diplom.domain;

import java.util.Date;

/**
 * Created by User on 20.04.2016.
 */
public class Measurement {
    private Long id_measurement;

    private Date date_time;

    private Long value;

    private HistoryOfSick history;

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

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
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
}
