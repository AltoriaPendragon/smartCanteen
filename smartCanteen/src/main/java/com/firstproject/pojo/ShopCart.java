package com.firstproject.pojo;

import lombok.Data;

@Data
public class ShopCart {
    private Integer id;
    private String orderId;
    private String dishName;
    private Integer amount;
}
