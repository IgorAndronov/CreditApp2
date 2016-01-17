package com.mycompany.credit.dao.interfaces.common;

import com.mycompany.credit.dao.entity.client.ClientFieldSpecification;
import com.mycompany.credit.dao.entity.commons.KeyValueResult;
import com.mycompany.credit.dao.entity.commons.TechSpecDictionary;

import java.util.List;

/**
 * Created by igor on 20.10.15.
 */
public interface TechSpecService  {

    public List<TechSpecDictionary> getTechSpecFieldsList(String Locale, int PageNumber, String techSpecName);
    public List<KeyValueResult<String,String>> getDictionaryData(String DicNameView,String locale);

}
