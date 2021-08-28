package com.company.model;

import java.sql.Date;

public class Rent {
    private int id;
    private Car car;
    private Customer customer;
    private Date rentDate;
    private Date returnDate;

    public Rent() {

    }

    public Rent(int id, Car car, Customer customer, Date rentDate, Date returnDate) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Rent(Car car, Customer customer, Date rentDate, Date returnDate) {
        this.car = car;
        this.customer = customer;
        this.rentDate = rentDate;
        this.returnDate = returnDate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", car=" + car +
                ", customer=" + customer +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
