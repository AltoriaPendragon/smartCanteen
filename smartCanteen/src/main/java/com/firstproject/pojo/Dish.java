package com.firstproject.pojo;

import lombok.Data;

@Data
public class Dish {
    private Integer id;
    private String dishName;
    private Integer price;
    private Integer typeId;
    private Integer sales;
    private String name; //菜品类型名
}
