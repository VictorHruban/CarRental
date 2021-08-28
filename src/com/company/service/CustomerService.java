package com.company.service;

import com.company.dao.CustomerDao;
import com.company.model.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService() {
        customerDao = new CustomerDao();
    }

    public List<Customer> getCustomers() {
        return customerDao.getAllCustomers();
    }

    public Integer getUserId(String username){
        return customerDao.findIdByUsername(username);
    }


}
