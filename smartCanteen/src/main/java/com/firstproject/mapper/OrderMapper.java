package com.firstproject.mapper;

import com.firstproject.pojo.Order;
import com.firstproject.pojo.ShopCart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("insert into shop_cart(orderId, dishName, amount) " +
            "values(#{orderId}, #{dishName}, #{amount})")
    Integer insertShopCart(ShopCart shopCart);
    @Insert("insert into `order`(orderId, userId, username, total, createTime, seatNumber)" +
            "values(#{orderId}, #{userId}, #{username}, #{total}, #{createTime}, #{seatNumber})")
    Integer insertOrder(Order order);

    @Update("update `order` set finishTime = #{finishTime} where orderId = #{orderId} and finishTime is null")
    Integer updateFinishTime(String orderId, Timestamp finishTime);

    Integer selectPosition(String orderId);
    @Select("select * from `order`")
    List<Order> selectAll();

    @Select("select avg(TIMESTAMPDIFF(SECOND , createTime, finishTime)) from `order`")
    Double selectAvgOrderTime();

    @Select("select * from shop_cart where orderId = #{orderId}")
    List<ShopCart> selectByOrderId(String orderId);
}
