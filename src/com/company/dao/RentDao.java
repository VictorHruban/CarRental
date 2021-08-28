package com.company.dao;

import com.company.model.Car;
import com.company.model.Customer;
import com.company.model.Rent;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentDao extends GenericDao {

    public List<Rent> getAllRents() {
        String query = "select rent.id,id_client,client.nume,client.prenume,id_car,cars.maker,cars.model,rent_date,return_date from rent\n" +
                "inner join cars on cars.id=id_car\n" +
                "inner join client on client.id=id_client";
        List<Rent> rentList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                int id = resultSet.getInt("rent.id");
                Customer customer = new Customer();
                customer.setNume(resultSet.getString("client.nume"));
                customer.setPrenume(resultSet.getString("client.prenume"));
                Car car = new Car();
                car.setMaker(resultSet.getString("cars.maker"));
                car.setCarModel(resultSet.getString("cars.model"));
                Date rentDate = resultSet.getDate("rent_date");
                Date returnDate = resultSet.getDate("return_date");

                rentList.add(new Rent(id, car, customer, rentDate, returnDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentList;
    }

    public double priceForRent(int days, int comfortTypeId) {
        String query = "select  price - (price * discount) " +
                "from " +
                "(select  price_day * ? as price  from confort_type where id = ?) as price , " +
                "(select discount from discount  where days_for_discount <= ? order by days_for_discount desc limit 1) as discount";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, days);
            preparedStatement.setInt(2, comfortTypeId);
            preparedStatement.setInt(3, days);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double price = resultSet.getDouble(1);
                return price;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    public void save(Rent rent) {
        String query = "insert into rent(id_car,id_client,rent_date,return_date) values (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, rent.getCar().getId());
            preparedStatement.setInt(2, rent.getCustomer().getId());
            preparedStatement.setDate(3, rent.getRentDate());
            preparedStatement.setDate(4, rent.getReturnDate());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public List<Rent> getRents(int idClient) {
        String query = "select rent.id,id_client,client.nume,client.prenume,id_car,cars.maker,cars.model,rent_date,return_date from rent\n" +
                "inner join cars on cars.id=id_car\n" +
                "inner join client on client.id=id_client\n" +
                "where id_client=?";
        List<Rent> rentListClient = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, idClient);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                int id = resultSet.getInt("rent.id");
                Customer customer = new Customer();
                customer.setNume(resultSet.getString("client.nume"));
                customer.setPrenume(resultSet.getString("client.prenume"));
                Car car = new Car();
                car.setMaker(resultSet.getString("cars.maker"));
                car.setCarModel(resultSet.getString("cars.model"));
                Date rentDate = resultSet.getDate("rent_date");
                Date returnDate = resultSet.getDate("return_date");

                rentListClient.add(new Rent(id, car, customer, rentDate, returnDate));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rentListClient;

    }
}
