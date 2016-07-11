package com.mycompany.taxi.dao.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by admin on 09.07.2016.
 */
@Entity
@Table(name = "clients", schema = "taxi", catalog = "postgres")
public class ClientsEntity {
    private long id;
    private Long regionId;
    private String name;
    private String phoneReg;
    private String pkey;
    private String pkey2;

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
    @Column(name = "region_id", nullable = true)
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone_reg", nullable = true, length = -1)
    public String getPhoneReg() {
        return phoneReg;
    }

    public void setPhoneReg(String phoneReg) {
        this.phoneReg = phoneReg;
    }

    @Basic
    @Column(name = "pkey", nullable = true, length = -1)
    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public String getPkey2() {
        return pkey2;
    }

    public void setPkey2(String pkey2) {
        this.pkey2 = pkey2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (id != that.id) return false;
        if (regionId != null ? !regionId.equals(that.regionId) : that.regionId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phoneReg != null ? !phoneReg.equals(that.phoneReg) : that.phoneReg != null) return false;
        if (pkey != null ? !pkey.equals(that.pkey) : that.pkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phoneReg != null ? phoneReg.hashCode() : 0);
        result = 31 * result + (pkey != null ? pkey.hashCode() : 0);
        return result;
    }
}
