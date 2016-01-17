package com.mycompany.credit.dao.entity;

import javax.persistence.*;

/**
 * Created by igor on 11.08.15.
 */
@Entity
@Table(name = "dic_street_type", schema = "icredit", catalog = "postgres")
public class DicStreetType {
    private int idRow;
    private String name;
    private String value;
    private String comments;
    private int localization;

    @Id
    @Column(name = "id_row", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getIdRow() {
        return idRow;
    }

    public void setIdRow(int idRow) {
        this.idRow = idRow;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "value", nullable = false, insertable = true, updatable = true, length = 30)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "comments", nullable = false, insertable = true, updatable = true, length = 100)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "localization", nullable = false, insertable = true, updatable = true)
    public int getLocalization() {
        return localization;
    }

    public void setLocalization(int localization) {
        this.localization = localization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DicStreetType that = (DicStreetType) o;

        if (idRow != that.idRow) return false;
        if (localization != that.localization) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRow;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + localization;
        return result;
    }
}
