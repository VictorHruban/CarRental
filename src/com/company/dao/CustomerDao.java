package com.company.dao;

import com.company.model.Customer;
import com.company.model.User;
import com.company.model.UserType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends GenericDao {
    public Customer findByUserId(int userId) {
        String query = "select client.id,nume,prenume,telefon,email,adresa,customer_user_id,username,password,type\n" +
                " from client\n" +
                " inner join user on user.id = customer_user_id\n" +
                " where user.id=?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("client.id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String telefon = resultSet.getString("telefon");
                String email = resultSet.getString("email");
                String adresa = resultSet.getString("adresa");

                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                UserType userType = UserType.valueOf(resultSet.getString("type"));
                User user = new User(userId, username, password, userType);

                return new Customer(id, nume, prenume, telefon, email, adresa, user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Customer save(Customer customer) {
        String query = "insert into client(nume,prenume,telefon,email,adresa,customer_user_id)values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, customer.getNume());
            preparedStatement.setString(2, customer.getPrenume());
            preparedStatement.setString(3, customer.getTelefon());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getAdresa());
            preparedStatement.setInt(6, customer.getUser().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return findByUserId(customer.getUser().getId());
    }

    public List<Customer> getAllCustomers() {
        String query = "select client.id,nume,prenume,telefon,email,adresa,customer_user_id from client";
        List<Customer> customerList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {

                int id = resultSet.getInt("client.id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String telefon = resultSet.getString("telefon");
                String email = resultSet.getString("email");
                String adresa = resultSet.getString("adresa");
                User user = new User();
                user.setId((resultSet.getInt("customer_user_id")));

                customerList.add(new Customer(id,nume,prenume,telefon,email,adresa,user));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    public Integer findIdByUsername(String username) {
        String query = "select client.id,username from client inner join user on client.customer_user_id = user.id where username = ?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
               int id = resultSet.getInt("id");

               return id;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


}
