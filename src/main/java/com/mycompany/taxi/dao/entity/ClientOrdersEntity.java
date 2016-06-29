package com.mycompany.taxi.dao.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Date;
import org.hibernate.annotations.Cache;

/**
 * Created by admin on 28.06.2016.
 */
@Entity
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE, region="kiev")
@Table(name = "client_orders", schema = "taxi", catalog = "postgres")
public class ClientOrdersEntity {
    private long id;
    private String region;
    private String addressCityFrom;
    private String addressDistrictFrom;
    private String addressStreetFrom;
    private String addressHomeFrom;
    private String addressNoteFrom;
    private String addressCityTo1;
    private String addressDistrictTo1;
    private String addressStreetTo1;
    private String addressHomeTo1;
    private String addressNoteTo1;
    private String addressCityTo2;
    private String addressDistrictTo2;
    private String addressStreetTo2;
    private String addressHomeTo2;
    private String addressNoteTo2;
    private String addressCityTo3;
    private String addressDistrictTo3;
    private String addressStreetTo3;
    private String addressHomeTo3;
    private String addressNoteTo3;
    private Date orderTime;
    private Date arrivalTime;
    private Double orderInitialPrise;
    private Double distance;
    private String status;
    private ClientOrderResultEntity clientOrderResult;
    private ClientOrdersExtraInfoEntity clientOrderExtraInfo;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "region", nullable = true, length = -1)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "address_city_from", nullable = true, length = -1)
    public String getAddressCityFrom() {
        return addressCityFrom;
    }

    public void setAddressCityFrom(String addressCityFrom) {
        this.addressCityFrom = addressCityFrom;
    }

    @Basic
    @Column(name = "address_district_from", nullable = true, length = -1)
    public String getAddressDistrictFrom() {
        return addressDistrictFrom;
    }

    public void setAddressDistrictFrom(String addressDistrictFrom) {
        this.addressDistrictFrom = addressDistrictFrom;
    }

    @Basic
    @Column(name = "address_street_from", nullable = true, length = -1)
    public String getAddressStreetFrom() {
        return addressStreetFrom;
    }

    public void setAddressStreetFrom(String addressStreetFrom) {
        this.addressStreetFrom = addressStreetFrom;
    }

    @Basic
    @Column(name = "address_home_from", nullable = true, length = -1)
    public String getAddressHomeFrom() {
        return addressHomeFrom;
    }

    public void setAddressHomeFrom(String addressHomeFrom) {
        this.addressHomeFrom = addressHomeFrom;
    }

    @Basic
    @Column(name = "address_note_from", nullable = true, length = -1)
    public String getAddressNoteFrom() {
        return addressNoteFrom;
    }

    public void setAddressNoteFrom(String addressNoteFrom) {
        this.addressNoteFrom = addressNoteFrom;
    }

    @Basic
    @Column(name = "address_city_to1", nullable = true, length = -1)
    public String getAddressCityTo1() {
        return addressCityTo1;
    }

    public void setAddressCityTo1(String addressCityTo1) {
        this.addressCityTo1 = addressCityTo1;
    }

    @Basic
    @Column(name = "address_district_to1", nullable = true, length = -1)
    public String getAddressDistrictTo1() {
        return addressDistrictTo1;
    }

    public void setAddressDistrictTo1(String addressDistrictTo1) {
        this.addressDistrictTo1 = addressDistrictTo1;
    }

    @Basic
    @Column(name = "address_street_to1", nullable = true, length = -1)
    public String getAddressStreetTo1() {
        return addressStreetTo1;
    }

    public void setAddressStreetTo1(String addressStreetTo1) {
        this.addressStreetTo1 = addressStreetTo1;
    }

    @Basic
    @Column(name = "address_home_to1", nullable = true, length = -1)
    public String getAddressHomeTo1() {
        return addressHomeTo1;
    }

    public void setAddressHomeTo1(String addressHomeTo1) {
        this.addressHomeTo1 = addressHomeTo1;
    }

    @Basic
    @Column(name = "address_note_to1", nullable = true, length = -1)
    public String getAddressNoteTo1() {
        return addressNoteTo1;
    }

    public void setAddressNoteTo1(String addressNoteTo1) {
        this.addressNoteTo1 = addressNoteTo1;
    }

    @Basic
    @Column(name = "address_city_to2", nullable = true, length = -1)
    public String getAddressCityTo2() {
        return addressCityTo2;
    }

    public void setAddressCityTo2(String addressCityTo2) {
        this.addressCityTo2 = addressCityTo2;
    }

    @Basic
    @Column(name = "address_district_to2", nullable = true, length = -1)
    public String getAddressDistrictTo2() {
        return addressDistrictTo2;
    }

    public void setAddressDistrictTo2(String addressDistrictTo2) {
        this.addressDistrictTo2 = addressDistrictTo2;
    }

    @Basic
    @Column(name = "address_street_to2", nullable = true, length = -1)
    public String getAddressStreetTo2() {
        return addressStreetTo2;
    }

    public void setAddressStreetTo2(String addressStreetTo2) {
        this.addressStreetTo2 = addressStreetTo2;
    }

    @Basic
    @Column(name = "address_home_to2", nullable = true, length = -1)
    public String getAddressHomeTo2() {
        return addressHomeTo2;
    }

    public void setAddressHomeTo2(String addressHomeTo2) {
        this.addressHomeTo2 = addressHomeTo2;
    }

    @Basic
    @Column(name = "address_note_to2", nullable = true, length = -1)
    public String getAddressNoteTo2() {
        return addressNoteTo2;
    }

    public void setAddressNoteTo2(String addressNoteTo2) {
        this.addressNoteTo2 = addressNoteTo2;
    }

    @Basic
    @Column(name = "address_city_to3", nullable = true, length = -1)
    public String getAddressCityTo3() {
        return addressCityTo3;
    }

    public void setAddressCityTo3(String addressCityTo3) {
        this.addressCityTo3 = addressCityTo3;
    }

    @Basic
    @Column(name = "address_district_to3", nullable = true, length = -1)
    public String getAddressDistrictTo3() {
        return addressDistrictTo3;
    }

    public void setAddressDistrictTo3(String addressDistrictTo3) {
        this.addressDistrictTo3 = addressDistrictTo3;
    }

    @Basic
    @Column(name = "address_street_to3", nullable = true, length = -1)
    public String getAddressStreetTo3() {
        return addressStreetTo3;
    }

    public void setAddressStreetTo3(String addressStreetTo3) {
        this.addressStreetTo3 = addressStreetTo3;
    }

    @Basic
    @Column(name = "address_home_to3", nullable = true, length = -1)
    public String getAddressHomeTo3() {
        return addressHomeTo3;
    }

    public void setAddressHomeTo3(String addressHomeTo3) {
        this.addressHomeTo3 = addressHomeTo3;
    }

    @Basic
    @Column(name = "address_note_to3", nullable = true, length = -1)
    public String getAddressNoteTo3() {
        return addressNoteTo3;
    }

    public void setAddressNoteTo3(String addressNoteTo3) {
        this.addressNoteTo3 = addressNoteTo3;
    }

    @Basic
    @Column(name = "order_time", nullable = true)
    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "arrival_time", nullable = true)
    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "order_initial_prise", nullable = true, precision = 0)
    public Double getOrderInitialPrise() {
        return orderInitialPrise;
    }

    public void setOrderInitialPrise(Double orderInitialPrise) {
        this.orderInitialPrise = orderInitialPrise;
    }

    @Basic
    @Column(name = "distance", nullable = true, precision = 0)
    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientOrdersEntity that = (ClientOrdersEntity) o;

        if (id != that.id) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (addressCityFrom != null ? !addressCityFrom.equals(that.addressCityFrom) : that.addressCityFrom != null)
            return false;
        if (addressDistrictFrom != null ? !addressDistrictFrom.equals(that.addressDistrictFrom) : that.addressDistrictFrom != null)
            return false;
        if (addressStreetFrom != null ? !addressStreetFrom.equals(that.addressStreetFrom) : that.addressStreetFrom != null)
            return false;
        if (addressHomeFrom != null ? !addressHomeFrom.equals(that.addressHomeFrom) : that.addressHomeFrom != null)
            return false;
        if (addressNoteFrom != null ? !addressNoteFrom.equals(that.addressNoteFrom) : that.addressNoteFrom != null)
            return false;
        if (addressCityTo1 != null ? !addressCityTo1.equals(that.addressCityTo1) : that.addressCityTo1 != null)
            return false;
        if (addressDistrictTo1 != null ? !addressDistrictTo1.equals(that.addressDistrictTo1) : that.addressDistrictTo1 != null)
            return false;
        if (addressStreetTo1 != null ? !addressStreetTo1.equals(that.addressStreetTo1) : that.addressStreetTo1 != null)
            return false;
        if (addressHomeTo1 != null ? !addressHomeTo1.equals(that.addressHomeTo1) : that.addressHomeTo1 != null)
            return false;
        if (addressNoteTo1 != null ? !addressNoteTo1.equals(that.addressNoteTo1) : that.addressNoteTo1 != null)
            return false;
        if (addressCityTo2 != null ? !addressCityTo2.equals(that.addressCityTo2) : that.addressCityTo2 != null)
            return false;
        if (addressDistrictTo2 != null ? !addressDistrictTo2.equals(that.addressDistrictTo2) : that.addressDistrictTo2 != null)
            return false;
        if (addressStreetTo2 != null ? !addressStreetTo2.equals(that.addressStreetTo2) : that.addressStreetTo2 != null)
            return false;
        if (addressHomeTo2 != null ? !addressHomeTo2.equals(that.addressHomeTo2) : that.addressHomeTo2 != null)
            return false;
        if (addressNoteTo2 != null ? !addressNoteTo2.equals(that.addressNoteTo2) : that.addressNoteTo2 != null)
            return false;
        if (addressCityTo3 != null ? !addressCityTo3.equals(that.addressCityTo3) : that.addressCityTo3 != null)
            return false;
        if (addressDistrictTo3 != null ? !addressDistrictTo3.equals(that.addressDistrictTo3) : that.addressDistrictTo3 != null)
            return false;
        if (addressStreetTo3 != null ? !addressStreetTo3.equals(that.addressStreetTo3) : that.addressStreetTo3 != null)
            return false;
        if (addressHomeTo3 != null ? !addressHomeTo3.equals(that.addressHomeTo3) : that.addressHomeTo3 != null)
            return false;
        if (addressNoteTo3 != null ? !addressNoteTo3.equals(that.addressNoteTo3) : that.addressNoteTo3 != null)
            return false;
        if (orderTime != null ? !orderTime.equals(that.orderTime) : that.orderTime != null) return false;
        if (arrivalTime != null ? !arrivalTime.equals(that.arrivalTime) : that.arrivalTime != null) return false;
        if (orderInitialPrise != null ? !orderInitialPrise.equals(that.orderInitialPrise) : that.orderInitialPrise != null)
            return false;
        if (distance != null ? !distance.equals(that.distance) : that.distance != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (addressCityFrom != null ? addressCityFrom.hashCode() : 0);
        result = 31 * result + (addressDistrictFrom != null ? addressDistrictFrom.hashCode() : 0);
        result = 31 * result + (addressStreetFrom != null ? addressStreetFrom.hashCode() : 0);
        result = 31 * result + (addressHomeFrom != null ? addressHomeFrom.hashCode() : 0);
        result = 31 * result + (addressNoteFrom != null ? addressNoteFrom.hashCode() : 0);
        result = 31 * result + (addressCityTo1 != null ? addressCityTo1.hashCode() : 0);
        result = 31 * result + (addressDistrictTo1 != null ? addressDistrictTo1.hashCode() : 0);
        result = 31 * result + (addressStreetTo1 != null ? addressStreetTo1.hashCode() : 0);
        result = 31 * result + (addressHomeTo1 != null ? addressHomeTo1.hashCode() : 0);
        result = 31 * result + (addressNoteTo1 != null ? addressNoteTo1.hashCode() : 0);
        result = 31 * result + (addressCityTo2 != null ? addressCityTo2.hashCode() : 0);
        result = 31 * result + (addressDistrictTo2 != null ? addressDistrictTo2.hashCode() : 0);
        result = 31 * result + (addressStreetTo2 != null ? addressStreetTo2.hashCode() : 0);
        result = 31 * result + (addressHomeTo2 != null ? addressHomeTo2.hashCode() : 0);
        result = 31 * result + (addressNoteTo2 != null ? addressNoteTo2.hashCode() : 0);
        result = 31 * result + (addressCityTo3 != null ? addressCityTo3.hashCode() : 0);
        result = 31 * result + (addressDistrictTo3 != null ? addressDistrictTo3.hashCode() : 0);
        result = 31 * result + (addressStreetTo3 != null ? addressStreetTo3.hashCode() : 0);
        result = 31 * result + (addressHomeTo3 != null ? addressHomeTo3.hashCode() : 0);
        result = 31 * result + (addressNoteTo3 != null ? addressNoteTo3.hashCode() : 0);
        result = 31 * result + (orderTime != null ? orderTime.hashCode() : 0);
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (orderInitialPrise != null ? orderInitialPrise.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "clientOrder")
    public ClientOrderResultEntity getClientOrderResult() {
        return clientOrderResult;
    }

    public void setClientOrderResult(ClientOrderResultEntity clientOrderResult) {
        this.clientOrderResult = clientOrderResult;
    }

    @OneToOne(mappedBy = "clientOrder")
    public ClientOrdersExtraInfoEntity getClientOrderExtraInfo() {
        return clientOrderExtraInfo;
    }

    public void setClientOrderExtraInfo(ClientOrdersExtraInfoEntity clientOrderExtraInfo) {
        this.clientOrderExtraInfo = clientOrderExtraInfo;
    }
}
