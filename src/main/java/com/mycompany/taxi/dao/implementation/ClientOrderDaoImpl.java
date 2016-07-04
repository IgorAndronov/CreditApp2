package com.mycompany.taxi.dao.implementation;

import com.mycompany.taxi.dao.entity.ClientOrdersEntity;
import com.mycompany.taxi.dao.entity.ClientOrdersExtraInfoEntity;
import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by iandronov on 13.06.2016.
 */


@Repository(value = "ClientOrderDaoImpl")
@Transactional
public class ClientOrderDaoImpl
{
    final String STATUS_INPROGRESS="inprogress";

    final static Logger logger = Logger.getLogger(ClientOrderDaoImpl.class);

    @Resource(name = "mySessionFactory")
    private  SessionFactory sessionFactory;

    public void saveOrder(Map<String,String> orderData){
        ClientOrdersEntity clientOrdersEntity = new ClientOrdersEntity();
        ClientOrdersExtraInfoEntity clientOrdersExtraInfoEntity= new ClientOrdersExtraInfoEntity();

        clientOrdersEntity.setRegion(orderData.get("city1")); //set region based on city from address

        clientOrdersEntity.setAddressCityFrom(orderData.get("city1"));
        clientOrdersEntity.setAddressCityTo1(orderData.get("city2"));
        clientOrdersEntity.setAddressCityTo2(orderData.get("city3"));
        clientOrdersEntity.setAddressCityTo3(orderData.get("city4"));

        clientOrdersEntity.setAddressDistrictFrom(orderData.get("district1"));
        clientOrdersEntity.setAddressDistrictTo1(orderData.get("district2"));
        clientOrdersEntity.setAddressDistrictTo2(orderData.get("district3"));
        clientOrdersEntity.setAddressDistrictTo3(orderData.get("district4"));

        clientOrdersEntity.setAddressStreetFrom(orderData.get("street1"));
        clientOrdersEntity.setAddressStreetTo1(orderData.get("street2"));
        clientOrdersEntity.setAddressStreetTo2(orderData.get("street3"));
        clientOrdersEntity.setAddressStreetTo3(orderData.get("street4"));

        clientOrdersEntity.setAddressHomeFrom(orderData.get("house1"));
        clientOrdersEntity.setAddressHomeTo1(orderData.get("house2"));
        clientOrdersEntity.setAddressHomeTo2(orderData.get("house3"));
        clientOrdersEntity.setAddressHomeTo3(orderData.get("house4"));

        clientOrdersEntity.setAddressNoteFrom(orderData.get("note1"));
        clientOrdersEntity.setAddressNoteTo1(orderData.get("note2"));
        clientOrdersEntity.setAddressNoteTo2(orderData.get("note3"));
        clientOrdersEntity.setAddressNoteTo3(orderData.get("note4"));

        clientOrdersEntity.setDistance(Double.parseDouble(orderData.get("distance")));
        clientOrdersEntity.setOrderInitialPrise(Double.parseDouble(orderData.get("prise")));
        clientOrdersEntity.setStatus(STATUS_INPROGRESS);


        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date arrivalTime = formatter.parse(orderData.get("arrivalDate")+" "+ orderData.get("arrivalTime").replaceAll("\\s+",""));
            System.out.println(arrivalTime);
            System.out.println(formatter.format(arrivalTime));

            clientOrdersEntity.setOrderTime(new java.sql.Timestamp(new Date().getTime()));  //current time of order
            clientOrdersEntity.setArrivalTime(new java.sql.Timestamp(arrivalTime.getTime())); //time when car should be delivered to client

        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
       // clientOrdersEntity.setId(2);
        sessionFactory.getCurrentSession().saveOrUpdate(clientOrdersEntity);


    }

    public  List<Object> getOrderDetailsFromHist(Integer userId){
        Statistics stats = sessionFactory.getStatistics();
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());
        stats.setStatisticsEnabled(true);
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());
        printStats(stats,0);

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClientOrdersEntity.class);
        criteria.setCacheable(true);
        criteria.setCacheMode(CacheMode.NORMAL);

        List<Object> orderDetails = criteria.list();

        printStats(stats,1);
        return orderDetails;
    }

    private static void printStats(Statistics stats, int i) {
        System.out.println("***** " + i + " *****");
        System.out.println("Fetch Count="
                + stats.getEntityFetchCount());
        System.out.println("Second Level Hit Count="
                + stats.getSecondLevelCacheHitCount());
        System.out
                .println("Second Level Miss Count="
                        + stats
                        .getSecondLevelCacheMissCount());
        System.out.println("Second Level Put Count="
                + stats.getSecondLevelCachePutCount());
    }



}
