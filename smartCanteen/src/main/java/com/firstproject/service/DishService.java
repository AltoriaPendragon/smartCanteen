package com.firstproject.service;

import com.firstproject.pojo.Dish;

import java.util.List;
import java.util.Map;

public interface DishService {
    Dish selectById(Integer id);

    boolean insert(Dish dish);

    boolean updateById(Dish dish);

    boolean deleteById(Integer id);

    Integer selectNum();

    List<Dish> selectByLimit(Map<String, Object> map);

    List<Dish> selectAll();
}
