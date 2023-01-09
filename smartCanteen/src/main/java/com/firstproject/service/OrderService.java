package com.firstproject.service;


import com.firstproject.pojo.Order;
import com.firstproject.pojo.ShopCart;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface OrderService {

    String addOrder(Map<String, Object> dishes);

    Integer judgeBalance(Integer id, int money);

    boolean endOrder(String orderId);

    Integer getWaitPosition(String orderId);

    Double getAvgOrderTime();

    List<Order> selectAll();

    List<ShopCart> selectByOrderId(String orderId);

}
