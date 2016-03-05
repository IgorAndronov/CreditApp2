package com.mycompany.credit.dao.entity.commons;

import org.hibernate.annotations.Immutable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by igor on 20.10.15.
 */

@Entity
@Immutable
public class TechSpecDictionary {
    private String id;
    private String tableSchema;
    private String tableName;
    private String columnName;
    private Integer idRole;
    private String captionName;
    private String localisation;
    private String dataType;
    private Integer fieldLength;
    private Integer numericScale;
    private Boolean mandatory;
    // private String mandatory;
    private String dicNameR;
    private Boolean visible;
    // private String visible;
    private String readOnly;
    private Integer tabsheetNumber;
    private Integer sorting;
    private Integer groupNumber;
    private Integer groupSorting;
    private String fieldViewType;
    private Boolean repeatable;



    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "table_schema", nullable = true, insertable = false, updatable = false)
    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }


    @Column(name = "table_name", nullable = true, insertable = false, updatable = false)
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Column(name = "column_name", nullable = true, insertable = false, updatable = false)
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Basic
    @Column(name = "id_role", nullable = true, insertable = false, updatable = false)
    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "caption_name", nullable = true, insertable = false, updatable = false, length = 30)
    public String getCaptionName() {
        return captionName;
    }

    public void setCaptionName(String captionName) {
        this.captionName = captionName;
    }

    @Basic
    @Column(name = "localisation", nullable = true, insertable = false, updatable = false, length = 5)
    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Basic
    @Column(name = "data_type", nullable = true, insertable = false, updatable = false)
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Basic
    @Column(name = "len", nullable = true, insertable = false, updatable = false)
    public Integer getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    @Basic
    @Column(name = "numeric_scale", nullable = true, insertable = false, updatable = false)
    public Integer getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(Integer numericScale) {
        this.numericScale = numericScale;
    }

    @Basic
    @Column(name = "mandatory", nullable = true, insertable = false, updatable = false, length = 2147483647)
    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }



    @Basic
    @Column(name = "dic_name_r", nullable = true, insertable = false, updatable = false, length = 2147483647)
    public String getDicNameR() {
        return dicNameR;
    }

    public void setDicNameR(String dicNameR) {
        this.dicNameR = dicNameR;
    }

    @Basic
    @Column(name = "visible", nullable = true, insertable = false, updatable = false, length = 2147483647)
    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }


    @Basic
    @Column(name = "read_only", nullable = true, insertable = false, updatable = false, length = 2147483647)
    public String getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

    @Basic
    @Column(name = "tab_sheet_number", nullable = true, insertable = false, updatable = false)
    public Integer getTabsheetNumber() {
        return tabsheetNumber;
    }

    public void setTabsheetNumber(Integer tabsheetNumber) {
        this.tabsheetNumber = tabsheetNumber;
    }

    @Basic
    @Column(name = "sorting", nullable = true, insertable = false, updatable = false)
    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }

    @Basic
    @Column(name = "group_number", nullable = true, insertable = false, updatable = false)
    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Basic
    @Column(name = "group_sorting", nullable = true, insertable = false, updatable = false)
    public Integer getGroupSorting() {
        return groupSorting;
    }

    public void setGroupSorting(Integer groupSorting) {
        this.groupSorting = groupSorting;
    }

    @Basic
    @Column(name = "field_view_type", nullable = true, insertable = false, updatable = false, length = 2147483647)
    public String getFieldViewType() {
        return fieldViewType;
    }

    public void setFieldViewType(String fieldViewType) {
        this.fieldViewType = fieldViewType;
    }

    @Column(name = "repeated", nullable = true)
    public Boolean getRepeatable() {
        return repeatable;
    }

    public void setRepeatable(Boolean repeatable) {
        this.repeatable = repeatable;
    }
}
