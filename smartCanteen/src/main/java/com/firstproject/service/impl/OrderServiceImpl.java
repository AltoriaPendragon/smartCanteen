package com.firstproject.service.impl;

import com.firstproject.controller.utils.OrderIdGenerator;
import com.firstproject.mapper.DayTimeMapper;
import com.firstproject.mapper.DishMapper;
import com.firstproject.mapper.OrderMapper;
import com.firstproject.mapper.UserMapper;
import com.firstproject.pojo.DayTime;
import com.firstproject.pojo.Dish;
import com.firstproject.pojo.Order;
import com.firstproject.pojo.ShopCart;
import com.firstproject.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    UserMapper userMapper;

    @Resource
    DishMapper dishMapper;

    @Resource
    OrderMapper orderMapper;

    @Resource
    DayTimeMapper dayTimeMapper;

    @Override
    public Integer judgeBalance(Integer id, int money) {
        if (userMapper.selectById(id).getBalance() > money) {
            return userMapper.subBalance(id, money);
        }
        return 0;
    }

    @Override
    public String addOrder(Map<String, Object> dishes) {
        Order order = new Order();
        String orderId = OrderIdGenerator.getOrderNumber();
        Timestamp createTime = new Timestamp(System.currentTimeMillis());


        order.setOrderId(orderId);
        order.setUserId(Integer.parseInt(dishes.get("userId").toString()));
        order.setUsername(String.valueOf(dishes.get("username")));
        order.setTotal(Integer.parseInt(dishes.get("total").toString()));
        order.setCreateTime(createTime);
        order.setSeatNumber(Integer.parseInt(dishes.get("seatNumber").toString()));


        boolean flag1 = orderMapper.insertOrder(order) > 0;
        boolean flag2 = false;
        boolean flag3 = false;

        for (Map.Entry<String, Object> entry : dishes.entrySet()) {
            if (!entry.getKey().equals("userId") && !entry.getKey().equals("username")
                    && !entry.getKey().equals("total") && !entry.getKey().equals("seatNumber")
                    && !entry.getValue().toString().equals("0")) {
                ShopCart shopCart = new ShopCart();
                Dish dish = new Dish();

                shopCart.setOrderId(orderId);
                shopCart.setDishName(entry.getKey());
                shopCart.setAmount(Integer.parseInt(entry.getValue().toString()));
                flag2 = orderMapper.insertShopCart(shopCart) > 0;

                dish.setDishName(entry.getKey());
                dish.setSales(Integer.parseInt(entry.getValue().toString()));
                flag3 = dishMapper.updateByDishName(dish) > 0;

            }
        }

        Integer hour = createTime.getHours();
        DayTime dayTime = new DayTime();
        switch (hour) {
            case 1:
                dayTime.setOne(1);
                dayTimeMapper.update(dayTime);
                break;
            case 2:
                dayTime.setTwo(1);
                dayTimeMapper.update(dayTime);
                break;
            case 3:
                dayTime.setThree(1);
                dayTimeMapper.update(dayTime);
                break;
            case 4:
                dayTime.setFour(1);
                dayTimeMapper.update(dayTime);
                break;
            case 5:
                dayTime.setFive(1);
                dayTimeMapper.update(dayTime);
                break;
            case 6:
                dayTime.setSix(1);
                dayTimeMapper.update(dayTime);
                break;
            case 7:
                dayTime.setSeven(1);
                dayTimeMapper.update(dayTime);
                break;
            case 8:
                dayTime.setEight(1);
                dayTimeMapper.update(dayTime);
                break;
            case 9:
                dayTime.setNine(1);
                dayTimeMapper.update(dayTime);
                break;
            case 10:
                dayTime.setTen(1);
                dayTimeMapper.update(dayTime);
                break;
            case 11:
                dayTime.setEleven(1);
                dayTimeMapper.update(dayTime);
                break;
            case 12:
                dayTime.setTwelve(1);
                dayTimeMapper.update(dayTime);
                break;
            case 13:
                dayTime.setThirteen(1);
                dayTimeMapper.update(dayTime);
                break;
            case 14:
                dayTime.setFourteen(1);
                dayTimeMapper.update(dayTime);
                break;
            case 15:
                dayTime.setFifteen(1);
                dayTimeMapper.update(dayTime);
                break;
            case 16:
                dayTime.setSixteen(1);
                dayTimeMapper.update(dayTime);
                break;
            case 17:
                dayTime.setSeventeen(1);
                dayTimeMapper.update(dayTime);
                break;
            case 18:
                dayTime.setEighteen(1);
                dayTimeMapper.update(dayTime);
                break;
            case 19:
                dayTime.setNineteen(1);
                dayTimeMapper.update(dayTime);
                break;
            case 20:
                dayTime.setTwenty(1);
                dayTimeMapper.update(dayTime);
                break;
            case 21:
                dayTime.setTwenty_one(1);
                dayTimeMapper.update(dayTime);
                break;
            case 22:
                dayTime.setTwenty_two(1);
                dayTimeMapper.update(dayTime);
                break;
            case 23:
                dayTime.setTwenty_three(1);
                dayTimeMapper.update(dayTime);
                break;
            case 0:
                dayTime.setZero(1);
                dayTimeMapper.update(dayTime);
                break;
        }

        if (flag1 && flag2 && flag3)
            return orderId;
        else return "false";
    }

    @Override
    public Integer getWaitPosition(String orderId) {
        return orderMapper.selectPosition(orderId);
    }

    @Override
    public Double getAvgOrderTime() {
        return orderMapper.selectAvgOrderTime();
    }

    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public List<ShopCart> selectByOrderId(String orderId) {
        return orderMapper.selectByOrderId(orderId);
    }

    @Override
    public boolean endOrder(String orderId) {
        return orderMapper.updateFinishTime(orderId, new Timestamp(System.currentTimeMillis())) > 0;
    }
}


