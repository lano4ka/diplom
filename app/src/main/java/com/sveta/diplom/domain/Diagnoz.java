package com.sveta.diplom.domain;

import java.util.List;

/**
 * Created by User on 20.04.2016.
 */
public class Diagnoz {

    private Long id_diagnoz;

    private String name;

    private List<HistoryOfSick> histories;


    public Long getId_diagnoz() {
        return id_diagnoz;
    }

    public void setId_diagnoz(Long id_diagnoz) {
        this.id_diagnoz = id_diagnoz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HistoryOfSick> getHistories() {
        return histories;
    }

    public void setHistories(List<HistoryOfSick> histories) {
        this.histories = histories;
    }
}