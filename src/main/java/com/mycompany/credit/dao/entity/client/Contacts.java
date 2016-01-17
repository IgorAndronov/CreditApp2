package com.mycompany.credit.dao.entity.client;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by igor on 24.08.15.
 */
@Entity
public class Contacts {
    private int id;
    private Timestamp created;
    private BigInteger createdBy;
    private Timestamp lastUpdated;
    private BigInteger lastUpdatedBy;
    private String lastName;
    private String firstName;
    private String midleName;
    private BigInteger sex;
    private BigInteger education;
    private Date dateBirsday;
    private BigInteger familyCount;
    private String idTax;
    private boolean married;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "created_by", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(BigInteger createdBy) {
        this.createdBy = createdBy;
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
    @Column(name = "last_updated_by", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(BigInteger lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Basic
    @Column(name = "last_name", nullable = false, insertable = true, updatable = true, length = 30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "first_name", nullable = false, insertable = true, updatable = true, length = 30)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "midle_name", nullable = false, insertable = true, updatable = true, length = 30)
    public String getMidleName() {
        return midleName;
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    @Basic
    @Column(name = "sex", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getSex() {
        return sex;
    }

    public void setSex(BigInteger sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "education", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getEducation() {
        return education;
    }

    public void setEducation(BigInteger education) {
        this.education = education;
    }

    @Basic
    @Column(name = "date_birsday", nullable = false, insertable = true, updatable = true)
    public Date getDateBirsday() {
        return dateBirsday;
    }

    public void setDateBirsday(Date dateBirsday) {
        this.dateBirsday = dateBirsday;
    }

    @Basic
    @Column(name = "family_count", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getFamilyCount() {
        return familyCount;
    }

    public void setFamilyCount(BigInteger familyCount) {
        this.familyCount = familyCount;
    }

    @Basic
    @Column(name = "id_tax", nullable = false, insertable = true, updatable = true, length = 10)
    public String getIdTax() {
        return idTax;
    }

    public void setIdTax(String idTax) {
        this.idTax = idTax;
    }

    @Basic
    @Column(name = "married", nullable = false, insertable = true, updatable = true)
    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacts contacts = (Contacts) o;

        if (id != contacts.id) return false;
        if (married != contacts.married) return false;
        if (created != null ? !created.equals(contacts.created) : contacts.created != null) return false;
        if (createdBy != null ? !createdBy.equals(contacts.createdBy) : contacts.createdBy != null) return false;
        if (lastUpdated != null ? !lastUpdated.equals(contacts.lastUpdated) : contacts.lastUpdated != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(contacts.lastUpdatedBy) : contacts.lastUpdatedBy != null)
            return false;
        if (lastName != null ? !lastName.equals(contacts.lastName) : contacts.lastName != null) return false;
        if (firstName != null ? !firstName.equals(contacts.firstName) : contacts.firstName != null) return false;
        if (midleName != null ? !midleName.equals(contacts.midleName) : contacts.midleName != null) return false;
        if (sex != null ? !sex.equals(contacts.sex) : contacts.sex != null) return false;
        if (education != null ? !education.equals(contacts.education) : contacts.education != null) return false;
        if (dateBirsday != null ? !dateBirsday.equals(contacts.dateBirsday) : contacts.dateBirsday != null)
            return false;
        if (familyCount != null ? !familyCount.equals(contacts.familyCount) : contacts.familyCount != null)
            return false;
        if (idTax != null ? !idTax.equals(contacts.idTax) : contacts.idTax != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (midleName != null ? midleName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (dateBirsday != null ? dateBirsday.hashCode() : 0);
        result = 31 * result + (familyCount != null ? familyCount.hashCode() : 0);
        result = 31 * result + (idTax != null ? idTax.hashCode() : 0);
        result = 31 * result + (married ? 1 : 0);
        return result;
    }
}
