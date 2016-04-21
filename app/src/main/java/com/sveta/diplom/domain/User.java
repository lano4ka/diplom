package com.sveta.diplom.domain;

import java.util.List;

/**
 * Created by User on 20.04.2016.
 */
public class User {

    private Long id_user;

    private String name;

    private String login;

    private String password;

    private String role;

    private String phone;

    private String address;

    private List<HistoryOfSick> historiesForPatient;

    private List<HistoryOfSick> historiesForDoctor;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<HistoryOfSick> getHistoriesForPatient() {
        return historiesForPatient;
    }

    public void setHistoriesForPatient(List<HistoryOfSick> historiesForPatient) {
        this.historiesForPatient = historiesForPatient;
    }

    public List<HistoryOfSick> getHistoriesForDoctor() {
        return historiesForDoctor;
    }

    public void setHistoriesForDoctor(List<HistoryOfSick> historiesForDoctor) {
        this.historiesForDoctor = historiesForDoctor;
    }
}
