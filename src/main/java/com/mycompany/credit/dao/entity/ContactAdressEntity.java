package com.mycompany.credit.dao.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by igor on 11.08.15.
 */
@Entity
@Table(name = "contact_adress", schema = "icredit", catalog = "postgres")
public class ContactAdressEntity {
    private int rowId;
    private Timestamp created;
    private Timestamp lastUpdated;
    private BigInteger area;
    private int district;
    private String city;
    private int postIndex;
    private String street;
    private String house;
    private String corp;
    private String flat;

    @Id
    @Column(name = "row_id", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "created", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "last_updated", nullable = false, insertable = true, updatable = true)
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Basic
    @Column(name = "area", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getArea() {
        return area;
    }

    public void setArea(BigInteger area) {
        this.area = area;
    }

    @Basic
    @Column(name = "district", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    @Basic
    @Column(name = "city", nullable = false, insertable = true, updatable = true, length = 30)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "post_index", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(int postIndex) {
        this.postIndex = postIndex;
    }

    @Basic
    @Column(name = "street", nullable = false, insertable = true, updatable = true, length = 30)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "house", nullable = true, insertable = true, updatable = true, length = 10)
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Basic
    @Column(name = "corp", nullable = true, insertable = true, updatable = true, length = 5)
    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    @Basic
    @Column(name = "flat", nullable = true, insertable = true, updatable = true, length = 4)
    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactAdressEntity that = (ContactAdressEntity) o;

        if (rowId != that.rowId) return false;
        if (district != that.district) return false;
        if (postIndex != that.postIndex) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (lastUpdated != null ? !lastUpdated.equals(that.lastUpdated) : that.lastUpdated != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (house != null ? !house.equals(that.house) : that.house != null) return false;
        if (corp != null ? !corp.equals(that.corp) : that.corp != null) return false;
        if (flat != null ? !flat.equals(that.flat) : that.flat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + district;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + postIndex;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (corp != null ? corp.hashCode() : 0);
        result = 31 * result + (flat != null ? flat.hashCode() : 0);
        return result;
    }
}
