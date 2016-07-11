package com.mycompany.taxi.dao.implementation;

import com.mycompany.taxi.dao.entity.ClientOrdersEntity;
import com.mycompany.taxi.dao.entity.ClientOrdersExtraInfoEntity;
import com.mycompany.taxi.dao.entity.ClientsEntity;
import org.apache.log4j.Logger;
import org.apache.maven.artifact.versioning.Restriction;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

        //client order info
        ClientOrdersEntity clientOrdersEntity = new ClientOrdersEntity();

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

            Date arrivalTime;
            if(orderData.get("arrivalDate")!=null && !orderData.get("arrivalDate").equals("")
                                && orderData.get("arrivalTime")!=null && !orderData.get("arrivalTime").equals("")){
                arrivalTime = formatter.parse(orderData.get("arrivalDate")+" "+ orderData.get("arrivalTime").replaceAll("\\s+",""));
            }else{
                arrivalTime=new java.sql.Timestamp(new Date().getTime());
            }

            System.out.println(arrivalTime);
            System.out.println(formatter.format(arrivalTime));

            clientOrdersEntity.setOrderTime(new java.sql.Timestamp(new Date().getTime()));  //current time of order
            clientOrdersEntity.setArrivalTime(new java.sql.Timestamp(arrivalTime.getTime())); //time when car should be delivered to client



            //Client info
            String originPhone = orderData.get("phoneNo"); //used for sending to driver
            String purePhone = originPhone.replaceAll("[ )(]","").replaceFirst("\\+38",""); //used for comparision
            originPhone=convertToPkey(originPhone);
            purePhone=convertToPkey(purePhone);

            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClientsEntity.class);
            criteria.add(Restrictions.eq("pkey",purePhone));

            List<ClientsEntity> clientsEntityList =criteria.list();
            if(clientsEntityList!=null && !clientsEntityList.isEmpty()){
                clientOrdersEntity.setClient(clientsEntityList.get(0));
            }else{
                ClientsEntity client = new ClientsEntity();
                client.setName(orderData.get("name"));
                client.setPkey(purePhone);
                client.setPkey2(originPhone);
                sessionFactory.getCurrentSession().save(client);
                clientOrdersEntity.setClient(client);
            }

            //order extra info
            ClientOrdersExtraInfoEntity clientOrdersExtraInfoEntity= new ClientOrdersExtraInfoEntity();
            clientOrdersExtraInfoEntity.setAnimal(Boolean.parseBoolean(orderData.get("animals")));
            clientOrdersExtraInfoEntity.setBaggage(Boolean.parseBoolean(orderData.get("baggage")));
            clientOrdersExtraInfoEntity.setNoSmoking(Boolean.parseBoolean(orderData.get("nosmoking")));
            clientOrdersExtraInfoEntity.setNote(orderData.get("note_extra"));
            clientOrdersExtraInfoEntity.setClientOrder(clientOrdersEntity);

            sessionFactory.getCurrentSession().save(clientOrdersEntity);
            sessionFactory.getCurrentSession().save(clientOrdersExtraInfoEntity);

        } catch (Exception e) {
            logger.error(e.getMessage());
        }



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

    public String convertToPkey(String data ){
        Map<Character,String> converter = new HashMap<Character, String>(){{
            put('0',"qw");
            put('1',"asd");
            put('2',"zxc");
            put('3',"er");
            put('4',"dfg");
            put('5',"cvb");
            put('6',"ty");
            put('7',"ghj");
            put('8',"bnm");
            put('9',"ui");
            put(' ',"jkl");
            put('+',"mq");
            put('(',"sk");
            put(')',"wo");


        }};
        Map<Character,Character> symbol = new HashMap<Character, Character>(){{
            put('0','$');
            put('1','%');
            put('2','&');
            put('3','@');
            put('4','$');
            put('5','%');
            put('6','&');
            put('7','@');
            put('8','$');
            put('9','%');
            put(' ','@');
            put('+','%');
            put('(','&');
            put(')','%');
        }};


        StringBuilder pkey= new StringBuilder();
        for(Character character:data.toCharArray()){
            pkey.append(symbol.get(character));
            pkey.append(converter.get(character));
        }
        return pkey.toString();
    }

    public String backconvert(String pkey){

        String data = pkey.replaceAll("[$%&@]","");
        data=data.replace("qw","0")
                 .replace("asd","1")
                 .replace("zxc","2")
                 .replace("er","3")
                 .replace("dfg","4")
                 .replace("cvb","5")
                 .replace("ty","6")
                 .replace("ghj","7")
                 .replace("bnm","8")
                 .replace("ui","9")
                 .replace("jkl"," ")
                 .replace("mq","+")
                 .replace("sk","(")
                 .replace("wo",")");

        return data;
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
