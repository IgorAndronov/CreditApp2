package com.mycompany.credit.dao.implementation.common;

import com.mycompany.credit.dao.entity.client.ClientFieldSpecification;
import com.mycompany.credit.dao.entity.commons.KeyValueResult;
import com.mycompany.credit.dao.entity.commons.TechSpecDictionary;
import com.mycompany.credit.dao.interfaces.common.TechSpecService;
import com.mycompany.credit.logic.FieldsTechSpec;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.mycompany.credit.dao.entity.commons.ClientDictionaries.clientDictionaries;

/**
 * Created by igor on 20.10.15.
 */

@Repository(value = "TechSpecServiceImpl")
@Transactional
public class TechSpecServiceImpl implements TechSpecService{

    final static Logger logger = Logger.getLogger(TechSpecServiceImpl.class);

    @Resource(name = "mySessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationContext appContext;

    @Transactional
    @Override
    public List<TechSpecDictionary> getTechSpecFieldsList(String locale, int tabsheetNumber, String techSpecName ) {
        logger.debug("getting data ...");

        String q = "select random() Id, cf.* from " + techSpecName +" cf " +
                "where cf.localisation=:locale " +
                "and cf.tab_sheet_number=:tabsheetNumber " +
                "and cf.visible='true'"+
                "order by group_number, group_sorting";
        List<TechSpecDictionary> TechSpecDictionaryList = (List<TechSpecDictionary>) sessionFactory.getCurrentSession()
                .createSQLQuery(q)
                .addEntity(TechSpecDictionary.class)
                .setParameter("locale", locale)
                .setParameter("tabsheetNumber", tabsheetNumber)
                .list();

        for (TechSpecDictionary c: TechSpecDictionaryList) {
            logger.debug(c.getCaptionName());
        }

        return TechSpecDictionaryList;
    }


    public List<KeyValueResult<String,String>> getDictionaryData(String dicNameView,String locale){
        logger.debug("reading " + dicNameView + " locale is " + locale);

        Class dictionary =(Class) clientDictionaries.get(dicNameView);
        String q = "select value as key, name as value from "+"\"icredit\"."+dicNameView+
                " where localisation=:locale";

        List<KeyValueResult<String,String>> dicDataList = (List<KeyValueResult<String,String>>) sessionFactory.getCurrentSession()
                .createSQLQuery(q)
                .setParameter("locale", locale)
                .setResultTransformer(new AliasToBeanResultTransformer(KeyValueResult.class))
                .list();

        logger.debug("dicDataList ="+dicDataList);

        return dicDataList;

    }

}
