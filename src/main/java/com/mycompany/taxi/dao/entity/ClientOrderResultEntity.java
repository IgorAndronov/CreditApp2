package com.mycompany.taxi.dao.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import org.hibernate.annotations.Cache;

/**
 * Created by admin on 26.06.2016.
 */
@Entity
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE, region="kiev")
@Table(name = "client_order_result", schema = "taxi", catalog = "postgres")
public class ClientOrderResultEntity {
    private long id;
    private int driverId;
    private int carEstimation;
    private String clientComment;
    private String driverComment;
    private ClientOrdersEntity order;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "driver_id")
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }


    @Basic
    @Column(name = "car_estimation")
    public int getCarEstimation() {
        return carEstimation;
    }

    public void setCarEstimation(int carEstimation) {
        this.carEstimation = carEstimation;
    }

    @Basic
    @Column(name = "client_comment")
    public String getClientComment() {
        return clientComment;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }

    @Basic
    @Column(name = "driver_comment")
    public String getDriverComment() {
        return driverComment;
    }

    public void setDriverComment(String driverComment) {
        this.driverComment = driverComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientOrderResultEntity that = (ClientOrderResultEntity) o;

        if (id != that.id) return false;
        if (driverId != that.driverId) return false;
        if (carEstimation != that.carEstimation) return false;
        if (clientComment != null ? !clientComment.equals(that.clientComment) : that.clientComment != null)
            return false;
        if (driverComment != null ? !driverComment.equals(that.driverComment) : that.driverComment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + driverId;
        result = 31 * result + carEstimation;
        result = 31 * result + (clientComment != null ? clientComment.hashCode() : 0);
        result = 31 * result + (driverComment != null ? driverComment.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public ClientOrdersEntity getOrder() {
        return order;
    }

    public void setOrder(ClientOrdersEntity order) {
        this.order = order;
    }
}
