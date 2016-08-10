package com.mycompany.taxi.logic;

import com.mycompany.taxi.dao.implementation.ClientOrderDaoImpl;
import com.mycompany.taxi.web.WebConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by iandronov on 13.06.2016.
 */
@Component
public class OrderDetails {
    Address addressFrom;
    Address addressTo1;
    Address addressTo2;
    Address addressTo3;

    @Autowired
    ClientOrderDaoImpl clientOrderDao;

    public  Long setOrderDetails(Map<String,String> order){

        clientOrderDao.saveOrder(order);

        for(String k:order.keySet()){
            System.out.println(k+":"+order.get(k));
        }
     Long orderId = 5L;
     return orderId;
    };

    public  Map<String,Address> getOrderDetails(Integer userId){

      List<Object> orderDetails = clientOrderDao.getOrderDetailsFromHist(userId);

      return convertAddress(orderDetails);

    };

    private  Map<String,Address> convertAddress(List<Object> orderDetails){
        Map<String,Address> address = new HashMap<>();

        addressFrom = new Address();
        addressFrom.setAddressFull("");
        address.put("addressFrom", addressFrom);

        return address;
    }

    public CarDetails getCar(Long orderId){
        CarDetails carDetails= new CarDetails();

        carDetails.setCarModel("Nissan X-Trail 2005");
        carDetails.setCarNumber("AA1234VB");
        carDetails.setDriverPhone("067 2637836");
        carDetails.setArrivalTime("19:15");
        carDetails.setCarQuality("3");
        carDetails.setDriverQuality("3");

        return carDetails;
    }

    public Map<String, List<String>> getDataForLov(Map<String, String> inputMap){
        Map<String,List<String>> resultData = new HashMap<>();

        for(String key:inputMap.keySet()){
            if(key.equals("city")){
                resultData.putAll(getAllOrdersFromDistrictsForCity(inputMap.get(key)));
            }

            if(key.startsWith("district")){
                String s=inputMap.get(key);
                int index = s.indexOf("//");
                String city = s.substring(0,index);
                String district = s.substring(index+2,s.length());
                resultData.putAll(getAllOrdersFromStreetsForDistrict(city,district,key.replaceAll("district","")));
            }
        }

        return resultData;
    }

    public Map<String, List<String>> getAllOrdersFromStreetsForDistrict(String city, String district, String sufix){
        Map<String, List<String>> result = new HashMap<>();
        if(district.equals(WebConstants.ALL_DISTRICTS_RU)
                          ||district.equals(WebConstants.ALL_DISTRICTS_EN)
                          ||district.equals(WebConstants.ALL_DISTRICTS_UA)){
          return result;
        }
        List<String> districtsFromList = clientOrderDao.getAllOrdersFromStreetsForDistrict(city, district);

        result.put("streetsFrom"+sufix, districtsFromList);

        return result;
    }

    public Map<String, List<String>> getAllOrdersFromDistrictsForCity(String city){
        Map<String, List<String>> result = new HashMap<>();
        List<String> districtsFromList = clientOrderDao.getAllOrdersFromDistrictsForCity(city);

        result.put("districtsFrom", districtsFromList);

        return result;
    }






}
