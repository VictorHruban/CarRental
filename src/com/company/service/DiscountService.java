package com.company.service;

import com.company.dao.DiscountDao;
import com.company.model.Discount;

import java.util.List;

public class DiscountService {
    private DiscountDao discountDao;

    public DiscountService() {
        discountDao = new DiscountDao();
    }

    public List<Discount> getAllDaysForDiscount() {
        return discountDao.getAllDiscounts();
    }

    public void updateDiscount(double discount,int daysForDiscount) {

        discountDao.updateDiscountByDays(discount, daysForDiscount);



    }
}
