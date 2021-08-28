package com.company.service;

import com.company.dao.CarDao;
import com.company.model.Car;
import com.company.model.ComfortType;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private CarDao carDao;


    public CarService() {
        carDao = new CarDao();

    }

    public void createCar(String maker, String model, String carType, String km, ComfortType comfortType) {
        Car car = new Car(maker, model, carType, km, comfortType);
        carDao.save(car);


    }

    public void deleteCar(int id) {

        carDao.deleteByCarId(id);
    }

    public List<ComfortType> getComfortTypes() {

        return carDao.getAllComfortType();
    }

    public void updateCar(Car car) {

        carDao.modifyCar(car);

    }

    public List<Car> getCars() {
        return carDao.getAllCars();
    }

    public List<Car> getUnRentedCars() {
        return carDao.getUnRentedCars();
    }


}
