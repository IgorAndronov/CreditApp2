package com.mycompany.credit.dao.entity;

import javax.persistence.*;

/**
 * Created by igor on 07.09.15.
 */
@Entity
@Table(name = "v_contacts_tech_spec", schema = "icredit", catalog = "postgres")
public class VContactsTechSpec {
    private String tableSchema;
    private String tableName;
    private String columnName;
    private Integer idRole;
    private String captionName;
    private String localisation;
    private String dataType;
    private Integer len;
    private Integer numericScale;
    private String mandatory;
    private String dicNameR;
    private String visible;
    private String readOnly;
    private Integer pageNumber;
    private Integer sorting;
    private Integer groupNumber;
    private Integer groupSorting;
    private String fieldViewType;
    private Boolean repeated;
    private String dependsType;

    @Basic
    @Column(name = "table_schema", nullable = true, insertable = true, updatable  = true)
    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    @Basic
    @Id
    @Column(name = "table_name", nullable = true, insertable = true, updatable  = true, length = 2147483647)
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "column_name", nullable = true, insertable = true, updatable  = true, length = 2147483647)
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Basic
    @Column(name = "id_role", nullable = true, insertable = true, updatable  = true)
    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "caption_name", nullable = true, insertable = true, updatable  = true, length = 2147483647)
    public String getCaptionName() {
        return captionName;
    }

    public void setCaptionName(String captionName) {
        this.captionName = captionName;
    }

    @Basic
    @Column(name = "localisation", nullable = true, insertable = true, updatable  = true, length = 5)
    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Basic
    @Column(name = "data_type", nullable = true, insertable = true, updatable  = true, length = 2147483647)
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Basic
    @Column(name = "len", nullable = true, insertable = true, updatable  = true)
    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    @Basic
    @Column(name = "numeric_scale", nullable = true, insertable = true, updatable  = true)
    public Integer getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(Integer numericScale) {
        this.numericScale = numericScale;
    }

    @Basic
    @Column(name = "mandatory", nullable = true, insertable = true, updatable  = true, length = 2147483647)
    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    @Basic
    @Column(name = "dic_name_r", nullable = true, insertable = true, updatable  = true, length = 2147483647)
    public String getDicNameR() {
        return dicNameR;
    }

    public void setDicNameR(String dicNameR) {
        this.dicNameR = dicNameR;
    }

    @Basic
    @Column(name = "visible", nullable = true, insertable = true, updatable  = true, length = 2147483647)
    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    @Basic
    @Column(name = "read_only", nullable = true, insertable = true, updatable  = true, length = 2147483647)
    public String getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

    @Basic
    @Column(name = "page_number", nullable = true, insertable = true, updatable  = true)
    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Basic
    @Column(name = "sorting", nullable = true, insertable = true, updatable  = true)
    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }

    @Basic
    @Column(name = "group_number", nullable = true, insertable = true, updatable  = true)
    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Basic
    @Column(name = "group_sorting", nullable = true, insertable = true, updatable  = true)
    public Integer getGroupSorting() {
        return groupSorting;
    }

    public void setGroupSorting(Integer groupSorting) {
        this.groupSorting = groupSorting;
    }

    @Basic
    @Column(name = "field_view_type", nullable = true, insertable = true, updatable  = true, length = 2147483647)
    public String getFieldViewType() {
        return fieldViewType;
    }

    public void setFieldViewType(String fieldViewType) {
        this.fieldViewType = fieldViewType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VContactsTechSpec that = (VContactsTechSpec) o;

        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (columnName != null ? !columnName.equals(that.columnName) : that.columnName != null) return false;
        if (idRole != null ? !idRole.equals(that.idRole) : that.idRole != null) return false;
        if (captionName != null ? !captionName.equals(that.captionName) : that.captionName != null) return false;
        if (localisation != null ? !localisation.equals(that.localisation) : that.localisation != null) return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (len != null ? !len.equals(that.len) : that.len != null) return false;
        if (numericScale != null ? !numericScale.equals(that.numericScale) : that.numericScale != null) return false;
        if (mandatory != null ? !mandatory.equals(that.mandatory) : that.mandatory != null) return false;
        if (dicNameR != null ? !dicNameR.equals(that.dicNameR) : that.dicNameR != null) return false;
        if (visible != null ? !visible.equals(that.visible) : that.visible != null) return false;
        if (readOnly != null ? !readOnly.equals(that.readOnly) : that.readOnly != null) return false;
        if (pageNumber != null ? !pageNumber.equals(that.pageNumber) : that.pageNumber != null) return false;
        if (sorting != null ? !sorting.equals(that.sorting) : that.sorting != null) return false;
        if (groupNumber != null ? !groupNumber.equals(that.groupNumber) : that.groupNumber != null) return false;
        if (groupSorting != null ? !groupSorting.equals(that.groupSorting) : that.groupSorting != null) return false;
        if (fieldViewType != null ? !fieldViewType.equals(that.fieldViewType) : that.fieldViewType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableSchema != null ? tableSchema.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (columnName != null ? columnName.hashCode() : 0);
        result = 31 * result + (idRole != null ? idRole.hashCode() : 0);
        result = 31 * result + (captionName != null ? captionName.hashCode() : 0);
        result = 31 * result + (localisation != null ? localisation.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (len != null ? len.hashCode() : 0);
        result = 31 * result + (numericScale != null ? numericScale.hashCode() : 0);
        result = 31 * result + (mandatory != null ? mandatory.hashCode() : 0);
        result = 31 * result + (dicNameR != null ? dicNameR.hashCode() : 0);
        result = 31 * result + (visible != null ? visible.hashCode() : 0);
        result = 31 * result + (readOnly != null ? readOnly.hashCode() : 0);
        result = 31 * result + (pageNumber != null ? pageNumber.hashCode() : 0);
        result = 31 * result + (sorting != null ? sorting.hashCode() : 0);
        result = 31 * result + (groupNumber != null ? groupNumber.hashCode() : 0);
        result = 31 * result + (groupSorting != null ? groupSorting.hashCode() : 0);
        result = 31 * result + (fieldViewType != null ? fieldViewType.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "repeated", nullable = true, insertable = true, updatable = true)
    public Boolean getRepeated() {
        return repeated;
    }

    public void setRepeated(Boolean repeated) {
        this.repeated = repeated;
    }

    @Basic
    @Column(name = "depends_type", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getDependsType() {
        return dependsType;
    }

    public void setDependsType(String dependsType) {
        this.dependsType = dependsType;
    }
}
