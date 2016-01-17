package com.mycompany.credit.logic;

import com.mycompany.credit.commons.FieldAttribute;
import com.mycompany.credit.dao.entity.commons.KeyValueResult;
import com.mycompany.credit.dao.entity.commons.TechSpecDictionary;
import com.mycompany.credit.dao.interfaces.common.TechSpecService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mycompany.credit.commons.Constants.LOCALE_VAL_EN;

/**
 * Created by igor on 20.10.15.
 */

@Component(value = "FieldsTechSpec")
public class FieldsTechSpec {
    final int  recursionLimit = 3;
    @Resource(name = "TechSpecServiceImpl")
    TechSpecService techSpecService;

    public List<Map<String, FieldAttribute>> getFieldsEditMode(Integer clientId, String locale, int pageNumber, String techSpecName, int recursionStep){
        if(recursionStep > recursionLimit){
            return null;
        }else{
            recursionStep++;
        }
        //contains list of all elemnts with "table" view type
        List<Map<String, FieldAttribute>> resultingFieldsPage =new ArrayList<>();

        //get specification data
        List<TechSpecDictionary> TechSpecDictionaryList = techSpecService.getTechSpecFieldsList(locale, pageNumber, techSpecName);

        //prepare result
        int currentGroup =0;
        Map<String,FieldAttribute> groupFields=null;

        for(TechSpecDictionary techSpecDictionary: TechSpecDictionaryList){

            FieldAttribute fieldAttribute = new FieldAttribute();

            if (currentGroup != techSpecDictionary.getGroupNumber()) {
                //start new group
                groupFields = new LinkedHashMap<>();
                resultingFieldsPage.add(groupFields);
                currentGroup = techSpecDictionary.getGroupNumber();
            }

            fieldAttribute.setFieldType(techSpecDictionary.getFieldViewType());
            fieldAttribute.setFieldCaptionName(techSpecDictionary.getCaptionName());
            fieldAttribute.setMandatory(techSpecDictionary.getMandatory());
            fieldAttribute.setVisibility(techSpecDictionary.getVisible());

            //Table view type:
            if(techSpecDictionary.getFieldViewType().equalsIgnoreCase("table")){
                List<Map<String, FieldAttribute>> embededTechSpec = getFieldsEditMode(clientId, locale, 1, techSpecDictionary.getTableSchema()+"."+techSpecDictionary.getDicNameR(), recursionStep);
                fieldAttribute.setEmbededTable(embededTechSpec);
            }else {
                //Non table view type: proceed for all non table types
                if (techSpecDictionary.getFieldLength() != null) {
                    fieldAttribute.setLength(techSpecDictionary.getFieldLength());
                }

                //add client data if present
                if (clientId != null) {

                    // getClientData(clientId, locale);

                }
                //fill LOV
                if (techSpecDictionary.getFieldViewType().equalsIgnoreCase(FieldAttribute.LOV_INPUT)) {
                    List<KeyValueResult<String, String>> dictionaryData = techSpecService.getDictionaryData(techSpecDictionary.getDicNameR(), locale);
                    List<String> lov = retriveValuesList(dictionaryData);
                    fieldAttribute.setFieldValueList(lov);
                }
            }
            groupFields.put(techSpecDictionary.getColumnName(), fieldAttribute);

        }


        return resultingFieldsPage;

    }

    public Map<String,FieldAttribute> getFieldsViewMode(){
        return null;
    }


    List<String> retriveValuesList(List<KeyValueResult<String,String>> dictionaryData){
        List<String> result = new ArrayList<>();

        for(KeyValueResult<String,String> item:dictionaryData){
            result.add(item.getValue());
        }

        return result;

    }



}
