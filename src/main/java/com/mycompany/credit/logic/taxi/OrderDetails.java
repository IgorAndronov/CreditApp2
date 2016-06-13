package com.mycompany.credit.logic.taxi;

import com.mycompany.credit.dao.implementation.taxi.ClientOrderDaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by iandronov on 13.06.2016.
 */
public class OrderDetails {
    Address addressFrom;
    Address addressTo1;
    Address addressTo2;
    Address addressTo3;

    public  void setOrderDetails(Map<String,String> order){

        for(String k:order.keySet()){
            System.out.println(k+":"+order.get(k));
        }


    };

    public  Map<String,Address> getOrderDetails(Integer userId){
      List<Object> orderDetails = ClientOrderDaoImpl.getOrderDetailsFromHist(userId);

      return convertAddress(orderDetails);

    };

    private  Map<String,Address> convertAddress(List<Object> orderDetails){
        Map<String,Address> address = new HashMap<>();

        addressFrom = new Address();
        addressFrom.setAddressFull("sdfsfasf");
        address.put("addressFrom", addressFrom);

        return address;
    }
}
