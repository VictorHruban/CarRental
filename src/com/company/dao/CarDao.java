package com.company.dao;

import com.company.model.Car;
import com.company.model.ComfortType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao extends GenericDao {

    public Car findByCarId(int id) {
        String query = "select cars.id, maker,model,car_type,km,confort_type_id from cars\n" +
                "inner join confort_type on confort_type.id = confort_type_id\n" +
                "where confort_type.id = ?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String maker = resultSet.getString("maker");
                String model = resultSet.getString("model");
                String car_type = resultSet.getString("car_type");
                String km = resultSet.getString("km");

                ComfortType confortType = new ComfortType();
                confortType.setConfortType("confort_type_id");

                return new Car(id, maker, model, car_type, km, confortType);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


    public void save(Car car) {
        String query = "insert into cars(maker,model,car_type,km,confort_type_id)values(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, car.getMaker());
            preparedStatement.setString(2, car.getCarModel());
            preparedStatement.setString(3, car.getCarType());
            preparedStatement.setString(4, car.getKm());
            preparedStatement.setInt(5, car.getConfortType().getId());
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void deleteByCarId(int id) {
        String query = "delete from cars where cars.id = ?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<ComfortType> getAllComfortType() {
        String query = "select id, confort_type,price_day from confort_type ";
        List<ComfortType> comfortTypeList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String comfort_type = resultSet.getString("confort_type");
                int priceDay = resultSet.getInt("price_day");

                comfortTypeList.add(new ComfortType(id, comfort_type, priceDay));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return comfortTypeList;
    }

    public List<Car> getAllCars() {
        String query = "select cars.id, maker,model,car_type,km,confort_type_id,confort_type from cars " +
                "inner join confort_type on confort_type.id = confort_type_id order by cars.id";
        List<Car> carList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String maker = resultSet.getString("maker");
                String model = resultSet.getString("model");
                String car_type = resultSet.getString("car_type");
                String km = resultSet.getString("km");
                ComfortType comfortType = new ComfortType();
                comfortType.setId(resultSet.getInt("confort_type_id"));
                comfortType.setConfortType((resultSet.getString("confort_type")));

                carList.add(new Car(id, maker, model, car_type, km, comfortType));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return carList;
    }

    public List<Car> getUnRentedCars() {
        String query = "select cars.id, maker,model,car_type,km,confort_type_id,confort_type from cars " +
                "inner join confort_type on confort_type.id = confort_type_id " +
                "where cars.id not in (select id_car from rent) " +
                "order by cars.id";
        List<Car> carList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()) {

                int id = resultSet.getInt("cars.id");
                String maker = resultSet.getString("maker");
                String model = resultSet.getString("model");
                String car_type = resultSet.getString("car_type");
                String km = resultSet.getString("km");
                ComfortType comfortType = new ComfortType();
                comfortType.setId(resultSet.getInt("confort_type_id"));
                comfortType.setConfortType(resultSet.getString("confort_type"));

                carList.add(new Car(id,maker,model,car_type,km,comfortType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return carList;
    }


    public void modifyCar(Car car) {
        String query = "update cars set maker=? , model=? , car_type=? , km=? , confort_type_id=? where id = ?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, car.getMaker());
            preparedStatement.setString(2, car.getCarModel());
            preparedStatement.setString(3, car.getCarType());
            preparedStatement.setString(4, car.getKm());
            preparedStatement.setInt(5, car.getConfortType().getId());
            preparedStatement.setInt(6, car.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
