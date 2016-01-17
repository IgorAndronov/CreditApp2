package com.mycompany.credit.dao.entity.client;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by igor on 19.08.15.
 */
@Entity
@Table(name = "contacts_pwd", schema = "icredit", catalog = "postgres")
public class ContactsPwd {
    private int id;
    private Timestamp created;
    private Timestamp lastUpdated;
    private String loginName;
    private String pwd;
    private int contactId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getIdRow() {
        return id;
    }

    public void setIdRow(int idRow) {
        this.id = idRow;
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
    @Column(name = "login_name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "pwd", nullable = false, insertable = true, updatable = true, length = 100)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column(name = "id_contact", nullable = false, insertable = true, updatable = true)
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactsPwd that = (ContactsPwd) o;

        if (id != that.id) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (lastUpdated != null ? !lastUpdated.equals(that.lastUpdated) : that.lastUpdated != null) return false;
        if (loginName != null ? !loginName.equals(that.loginName) : that.loginName != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }
}
