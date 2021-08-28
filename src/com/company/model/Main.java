package com.company.model;


import com.company.service.CustomerService;

public class Main {


    public static void main(String[] args) {
        Customer customer = new Customer();
        CustomerService customerService = new CustomerService();

        String username = "Shaco";

        int id;

        id= customerService.getUserId(username);

        System.out.println(id);

    }


}

