package com.firstproject.service.impl;

import com.firstproject.mapper.DishMapper;
import com.firstproject.pojo.Dish;
import com.firstproject.service.DishService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DishServiceImpl implements DishService {

    @Resource
    private DishMapper dishMapper;

    @Override
    public Dish selectById(Integer id) {
        return dishMapper.selectById(id);
    }

    @Override
    public boolean insert(Dish dish) {
        return dishMapper.insert(dish) > 0;
    }

    @Override
    public boolean updateById(Dish dish) {
        return dishMapper.updateById(dish) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return dishMapper.deleteById(id) > 0;
    }

    @Override
    public Integer selectNum() {
        return dishMapper.selectNum();
    }

    @Override
    public List<Dish> selectByLimit(Map<String, Object> map) {
        return dishMapper.selectByLimit(map);
    }

    @Override
    public List<Dish> selectAll() {
        return dishMapper.selectAll();
    }
}
