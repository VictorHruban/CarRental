package com.company.model;

public class Car {
    private int id;
    private String maker;
    private String carModel;
    private String carType;
    private String km;
    private ComfortType confortType;

    public Car() {

    }

    public Car(int id, String maker, String carModel, String carType, String km, ComfortType confortType) {
        this.id = id;
        this.maker = maker;
        this.carModel = carModel;
        this.carType = carType;
        this.km = km;
        this.confortType = confortType;
    }

    public Car(int id) {
        this.id = id;
    }

    public Car(String maker, String carModel, String carType, String km, ComfortType confortType) {
        this.maker = maker;
        this.carModel = carModel;
        this.carType = carType;
        this.km = km;
        this.confortType = confortType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public ComfortType getConfortType() {
        return confortType;
    }

    public void setConfortType(ComfortType confortType) {
        this.confortType = confortType;
    }

    @Override
    public String toString() {
        return

                maker + "/" +
                        carModel + "/" +
                        carType + "/" +
                        km + "/" +
                        confortType
                ;
    }
}
