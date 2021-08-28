package com.company.model;

public class Discount {
    private int id;
    private double discount;
    private int daysForDiscount;


    public Discount() {

    }

    public Discount(int id, double discount) {
        this.id = id;
        this.discount = discount;
    }

    public Discount(int id, double discount, int daysForDiscount) {
        this.id = id;
        this.discount = discount;
        this.daysForDiscount = daysForDiscount;

    }

    public Discount(int id) {
        this.id = id;
    }

    public Discount(double discount, int daysForDiscount) {
        this.discount = discount;
        this.daysForDiscount = daysForDiscount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getDaysForDiscount() {
        return daysForDiscount;
    }

    public void setDaysForDiscount(int daysForDiscount) {
        this.daysForDiscount = daysForDiscount;
    }

    @Override
    public String toString() {
        return String.valueOf(daysForDiscount);

    }
}
