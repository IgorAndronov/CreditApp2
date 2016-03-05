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
 * Extracts fields and its values from the corresponding techspec with depth of child pages limited to "recursionLimit var"
 */

@Component(value = "FieldsTechSpec")
public class FieldsTechSpec {
    final int  recursionLimit = 3;
    @Resource(name = "TechSpecServiceImpl")
    TechSpecService techSpecService;

    public List<Map<String, FieldAttribute>> getFieldsEditMode(Integer clientId, String locale, int tabsheetNumber, String techSpecName, int recursionStep){
        if(recursionStep > recursionLimit){
            return null;
        }else{
            recursionStep++;
        }
        //contains list of all elements with "page" view type
        List<Map<String, FieldAttribute>> resultingFieldsPage =new ArrayList<>();

        //get specification data
        List<TechSpecDictionary> TechSpecDictionaryList = techSpecService.getTechSpecFieldsList(locale, tabsheetNumber, techSpecName);

        //prepare result
        int currentGroup = -1;
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

            //Page view type:
            if(techSpecDictionary.getFieldViewType().equalsIgnoreCase("page")){
                List<Map<String, FieldAttribute>> embeddedTechSpec = getFieldsEditMode(clientId, locale, 1, techSpecDictionary.getTableSchema()+"."+techSpecDictionary.getDicNameR(), recursionStep);
                fieldAttribute.setEmbededPage(embeddedTechSpec);
            }else {
                //"Not page" view type: proceed for all "not page" types
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
            groupFields.put(techSpecDictionary.getId(), fieldAttribute);

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
