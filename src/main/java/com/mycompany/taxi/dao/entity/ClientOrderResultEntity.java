package com.mycompany.taxi.dao.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import org.hibernate.annotations.Cache;

/**
 * Created by admin on 28.06.2016.
 */
@Entity
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE, region="kiev")
@Table(name = "client_order_result", schema = "taxi", catalog = "postgres")
public class ClientOrderResultEntity {
    private long id;
    private Long driverId;
    private Integer carEstimation;
    private String clientComment;
    private String driverComment;
    private double finalPrise;
    private ClientOrdersEntity clientOrder;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "driver_id", nullable = true)
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }


    @Basic
    @Column(name = "car_estimation", nullable = true)
    public Integer getCarEstimation() {
        return carEstimation;
    }

    public void setCarEstimation(Integer carEstimation) {
        this.carEstimation = carEstimation;
    }

    @Basic
    @Column(name = "client_comment", nullable = true, length = -1)
    public String getClientComment() {
        return clientComment;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }

    @Basic
    @Column(name = "driver_comment", nullable = true, length = -1)
    public String getDriverComment() {
        return driverComment;
    }

    public void setDriverComment(String driverComment) {
        this.driverComment = driverComment;
    }

    @Basic
    @Column(name = "final_prise", nullable = true, precision = 0)
    public double getFinalPrise() {
        return finalPrise;
    }

    public void setFinalPrise(double finalPrise) {
        this.finalPrise = finalPrise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientOrderResultEntity that = (ClientOrderResultEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.finalPrise, finalPrise) != 0) return false;
        if (driverId != null ? !driverId.equals(that.driverId) : that.driverId != null) return false;
        if (carEstimation != null ? !carEstimation.equals(that.carEstimation) : that.carEstimation != null)
            return false;
        if (clientComment != null ? !clientComment.equals(that.clientComment) : that.clientComment != null)
            return false;
        if (driverComment != null ? !driverComment.equals(that.driverComment) : that.driverComment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (driverId != null ? driverId.hashCode() : 0);
        result = 31 * result + (carEstimation != null ? carEstimation.hashCode() : 0);
        result = 31 * result + (clientComment != null ? clientComment.hashCode() : 0);
        result = 31 * result + (driverComment != null ? driverComment.hashCode() : 0);
        temp = Double.doubleToLongBits(finalPrise);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public ClientOrdersEntity getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrdersEntity clientOrder) {
        this.clientOrder = clientOrder;
    }
}
