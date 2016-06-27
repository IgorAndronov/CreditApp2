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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iandronov on 13.06.2016.
 */


@Repository(value = "ClientOrderDaoImpl")
@Transactional
public class ClientOrderDaoImpl
{
    final static Logger logger = Logger.getLogger(ClientOrderDaoImpl.class);

    @Resource(name = "mySessionFactory")
    private  SessionFactory sessionFactory;

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
