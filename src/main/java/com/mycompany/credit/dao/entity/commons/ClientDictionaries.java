package com.mycompany.credit.dao.entity.commons;

import com.mycompany.credit.dao.entity.client.dictionary.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by igor on 31.08.15.
 */
public class ClientDictionaries {
    public static Map clientDictionaries = new HashMap();
    static{

        clientDictionaries.put("v_dic_address_type", VDicAddressType.class);
        clientDictionaries.put("v_dic_area_type", VDicAreaType.class);
      //  clientDictionaries.put("v_dic_citezenship", );
        clientDictionaries.put("v_dic_district_type", VDicDistrictType.class);
        clientDictionaries.put("v_dic_document_type", VDicDocumentType.class);
        clientDictionaries.put("v_dic_education_type", VDicEducationType.class);
        clientDictionaries.put("v_dic_employment_type", VDicEmploymentType.class);
        clientDictionaries.put("v_dic_married_type", VDicMarriedType.class);
        clientDictionaries.put("v_dic_phone_type",  VDicPhoneType.class);
        clientDictionaries.put("v_dic_residency_type", VDicResidency.class);
        clientDictionaries.put("v_dic_sex_type", VDicSexType.class);
        clientDictionaries.put("v_dic_street_type", VDicStreetType.class);
        clientDictionaries.put("v_dic_www_type",  VDicWwwType.class);

    }

}
