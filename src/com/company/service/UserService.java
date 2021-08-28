package com.company.service;

import com.company.dao.AgentDao;
import com.company.model.Agent;
import com.company.model.Customer;
import com.company.model.User;
import com.company.model.UserType;
import com.company.dao.CustomerDao;
import com.company.dao.UserDao;

public class UserService {
    private UserDao userDao;
    private CustomerDao customerDao;
    private AgentDao agentDao;

    public UserService() {
        userDao = new UserDao();
        customerDao = new CustomerDao();
        agentDao = new AgentDao();
    }


    public User correctCredentials(String username, String password) {
        return userDao.correctCredentials(username, password);
    }

    public Customer createCustomer(String username, String password, String nume, String prenume, String telefon, String email, String adresa) {
        User user = new User(username, password, UserType.Customer);
        User savedUser = userDao.save(user);

        Customer customer = new Customer(nume, prenume, telefon, email, adresa, savedUser);
        customerDao.save(customer);

        return customerDao.findByUserId(savedUser.getId());
    }

    public Agent createAdmin(String username, String password, String nume, String prenume, String telefon, String email, String adresa) {
        User user = new User(username, password, UserType.Admin);
        User savedUser = userDao.save(user);

        Agent agent = new Agent(nume, prenume, telefon, email, adresa, savedUser);
        agentDao.save(agent);

        return agentDao.findByUserId(savedUser.getId());


    }

    public Agent createAgent(String username, String password, String nume, String prenume, String telefon, String email, String adresa) {
        User user = new User(username, password, UserType.Agent);
        User savedUser = userDao.save(user);

        Agent agent = new Agent(nume, prenume, telefon, email, adresa, savedUser);
        agentDao.save(agent);

        return agentDao.findByUserId(savedUser.getId());
    }


}

