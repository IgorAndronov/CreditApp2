package com.mycompany.taxi.logic;

import com.mycompany.taxi.dao.implementation.ClientOrderDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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

}
