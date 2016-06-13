package com.mycompany.credit.dao.implementation.taxi;

import com.mycompany.credit.logic.taxi.Address;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by iandronov on 13.06.2016.
 */


@Repository(value = "ClientOrderDaoImpl")
@Transactional
public class ClientOrderDaoImpl
{
    public static List<Object> getOrderDetailsFromHist(Integer userId){
        List<Object> orderDetails = new ArrayList<>();

        return orderDetails;
    }

}
