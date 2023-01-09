package com.firstproject.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Order {
    private Integer id;
    private String orderId;
    private Integer userId;
    private String username;
    private Integer total;
    private Timestamp createTime;
    private Timestamp finishTime;
    private Integer seatNumber;
    private String staffAccount; //负责此订单的工作人员账号
}
