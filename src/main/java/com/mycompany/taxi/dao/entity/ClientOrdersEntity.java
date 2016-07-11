package com.mycompany.taxi.dao.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;


import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created by admin on 28.06.2016.
 */
@Entity
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE, region="kiev")
@Table(name = "client_orders", schema = "taxi", catalog = "postgres")
public class ClientOrdersEntity {

    private Long id;
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
    private Timestamp orderTime;
    private Timestamp arrivalTime;
    private Double orderInitialPrise;
    private Double distance;
    private String status;
    private ClientOrderResultEntity clientOrderResult;
    private ClientOrdersExtraInfoEntity clientOrderExtraInfo;
    private ClientsEntity client;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_client_orders")
    @GenericGenerator(name = "seq_client_orders",
                      strategy = "sequence",
                      parameters = {@Parameter(name="sequence", value = "taxi.seq_client_orders")})
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "arrival_time", nullable = true)
    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
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

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    public ClientsEntity getClient() {
        return client;
    }

    public void setClient(ClientsEntity client) {
        this.client = client;
    }
}
