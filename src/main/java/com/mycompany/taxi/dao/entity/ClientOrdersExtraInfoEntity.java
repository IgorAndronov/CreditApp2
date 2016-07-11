package com.mycompany.taxi.dao.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by admin on 28.06.2016.
 */
@Entity
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE, region="kiev")
@Table(name = "client_orders_extra_info", schema = "taxi", catalog = "postgres")
public class ClientOrdersExtraInfoEntity {
    private long id;
    private Boolean animal;
    private Boolean baggage;
    private Boolean noSmoking;
    private String note;
    private ClientOrdersEntity clientOrder;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_client_orders")
    @GenericGenerator(name = "seq_client_orders",
            strategy = "sequence",
            parameters = {@org.hibernate.annotations.Parameter(name="sequence", value = "taxi.seq_client_orders")})
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "animal", nullable = true)
    public Boolean getAnimal() {
        return animal;
    }

    public void setAnimal(Boolean animal) {
        this.animal = animal;
    }

    @Basic
    @Column(name = "baggage", nullable = true)
    public Boolean getBaggage() {
        return baggage;
    }

    public void setBaggage(Boolean baggage) {
        this.baggage = baggage;
    }

    @Basic
    @Column(name = "no_smoking", nullable = true)
    public Boolean getNoSmoking() {
        return noSmoking;
    }

    public void setNoSmoking(Boolean noSmoking) {
        this.noSmoking = noSmoking;
    }

    @Basic
    @Column(name = "note", nullable = true, length = -1)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientOrdersExtraInfoEntity that = (ClientOrdersExtraInfoEntity) o;

        if (id != that.id) return false;
        if (animal != null ? !animal.equals(that.animal) : that.animal != null) return false;
        if (baggage != null ? !baggage.equals(that.baggage) : that.baggage != null) return false;
        if (noSmoking != null ? !noSmoking.equals(that.noSmoking) : that.noSmoking != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (animal != null ? animal.hashCode() : 0);
        result = 31 * result + (baggage != null ? baggage.hashCode() : 0);
        result = 31 * result + (noSmoking != null ? noSmoking.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
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
