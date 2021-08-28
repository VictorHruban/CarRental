package com.company.model;

import java.util.Objects;

public class ComfortType {
    private int id;
    private String confortType;
    private int priceDay;

    public ComfortType() {

    }

    public ComfortType(int id, String confortType,int priceDay) {
        this.id = id;
        this.confortType = confortType;
        this.priceDay = priceDay;
    }

    public ComfortType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConfortType() {
        return confortType;
    }

    public void setConfortType(String confortType) {
        this.confortType = confortType;
    }

    public int getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    @Override
    public String toString() {
        return confortType;
    }


}
