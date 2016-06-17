package com.mycompany.credit.logic.taxi;

/**
 * Created by iandronov on 15.06.2016.
 */
public class CarDetails {
    private String carModel="";
    private String carNumber="";
    private String driverName="";
    private String driverPhone="";
    private String carQuality="";
    private String carExtraInfo="";
    private String driverQuality="";
    private String arrivalTime="";

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getDriverQuality() {
        return driverQuality;
    }

    public void setDriverQuality(String driverQuality) {
        this.driverQuality = driverQuality;
    }

    public String getCarExtraInfo() {
        return carExtraInfo;
    }

    public void setCarExtraInfo(String carExtraInfo) {
        this.carExtraInfo = carExtraInfo;
    }

    public String getCarQuality() {
        return carQuality;
    }

    public void setCarQuality(String carQuality) {
        this.carQuality = carQuality;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
