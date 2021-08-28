package com.company.service;

import com.company.dao.RentDao;
import com.company.model.Car;
import com.company.model.Customer;
import com.company.model.Rent;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class RentService {
    private RentDao rentDao;

    public RentService() {
        rentDao = new RentDao();
    }

    public List<Rent> getRents() {
        return rentDao.getAllRents();
    }

    public double rentPrice(int days, int comfortTypeId) {
        return rentDao.priceForRent(days, comfortTypeId);
    }

    public void createRent(Car car, Customer customer, Date rentDate, Date returnDate) {
        Rent rent = new Rent(car, customer, rentDate, returnDate);
        rentDao.save(rent);
    }

    public List<Rent> getCustomerRents(int id) {
        return rentDao.getRents(id);
    }

    public java.util.Date convertStringToDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }

    }


}
