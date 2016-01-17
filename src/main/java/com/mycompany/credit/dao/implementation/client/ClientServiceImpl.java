package com.mycompany.credit.dao.implementation.client;

import com.mycompany.credit.dao.entity.client.ClientFieldSpecification;
import com.mycompany.credit.dao.entity.commons.KeyValueResult;
import com.mycompany.credit.dao.interfaces.client.ClientService;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static com.mycompany.credit.dao.entity.commons.ClientDictionaries.*;

/**
 * Created by igor on 17.08.15.
 */
@Repository(value = "ClientServiceImpl")
@Transactional
public class ClientServiceImpl implements ClientService {
    final static Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Resource(name = "mySessionFactory")
    private SessionFactory sessionFactory;



}
