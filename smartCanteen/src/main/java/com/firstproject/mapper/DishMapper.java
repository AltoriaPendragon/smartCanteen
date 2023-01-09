package com.firstproject.mapper;

import com.firstproject.pojo.Dish;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DishMapper {

    @Insert("insert into dish (dishName, price, typeId) values(#{dishName}, #{price}, #{typeId})")
    Integer insert(Dish dish);

    @Delete("delete from dish where id = #{id}")
    Integer deleteById(Integer id);

    Integer updateById(Dish dish);

    Integer updateByDishName(Dish dish);


    @Select("select * from dish where id = #{id}")
    Dish selectById(Integer id);

    @Select("select count(*) from dish")
    Integer selectNum();

    List<Dish> selectByLimit(Map<String, Object> map);

    @Select("select * from dish")
    List<Dish> selectAll();
}
