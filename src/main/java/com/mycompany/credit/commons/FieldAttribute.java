package com.mycompany.credit.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by igor on 12.08.15.
 */
public class FieldAttribute {
    public static final String SIMPLE_INPUT = "simple";
    public static final String CALENDAR_INPUT = "calendar";
    public static final String RADIO_INPUT = "radio";
    public static final String LOV_INPUT = "lov";
    public static final String CHECKBOX_INPUT = "checkbox";
    public static final String PAGE_INPUT = "page";

    private String fieldType;
    private String fieldValue;
    private String fieldCaptionName;
    private List<String> fieldValueList = new ArrayList<>();
    private Boolean mandatory;
    private Boolean visibility;
    private int length;
    private String precision;
    private boolean startGroupFlag;
    private boolean endGroupFlag;
    private List<Map<String, FieldAttribute>> embededPage;



    public FieldAttribute(String fieldType,String fieldValue, List<String> fieldValueList, Boolean visibility, int length, String precision){
        this.fieldType= fieldType;
        this.fieldValue = fieldValue;
        this.fieldValueList=fieldValueList;
        this.visibility=visibility;
        this.length=length;
        this.precision=precision;

    }
    public FieldAttribute(){

    }

    public boolean isStartGroupFlag() {
        return startGroupFlag;
    }

    public void setStartGroupFlag(boolean startGroupFlag) {
        this.startGroupFlag = startGroupFlag;
    }

    public boolean isEndGroupFlag() {
        return endGroupFlag;
    }

    public void setEndGroupFlag(boolean endGroupFlag) {
        this.endGroupFlag = endGroupFlag;
    }

    public static String getSimpleInput() {
        return SIMPLE_INPUT;
    }

    public Boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public List<String> getFieldValueList() {
        return fieldValueList;
    }

    public void setFieldValueList(List<String> fieldValueList) {
        this.fieldValueList = fieldValueList;
    }

    public String getFieldCaptionName() {
        return fieldCaptionName;
    }

    public void setFieldCaptionName(String fieldCaptionName) {
        this.fieldCaptionName = fieldCaptionName;
    }

    public List<Map<String, FieldAttribute>> getEmbededPage() {
        return embededPage;
    }

    public void setEmbededPage(List<Map<String, FieldAttribute>> embededPage) {
        this.embededPage = embededPage;
    }
}
