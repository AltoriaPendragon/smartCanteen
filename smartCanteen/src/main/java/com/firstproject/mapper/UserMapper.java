package com.firstproject.mapper;

import com.firstproject.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username, sex, age, nickname, password) " +
            "values(#{username}, #{sex}, #{age}, #{nickname}, #{password})")
    Integer insert(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteById(Integer id);

    Integer updateById(User user);
    @Update("update user set balance = balance + #{money} where id = #{id}")
    Integer addBalance(Integer id, Integer money);

    @Update("update user set balance = balance - #{money} where id = #{id}")
    Integer subBalance(Integer id, Integer money);

    @Select("select count(*) from user")
    Integer selectNum();

    @Select("select * from user where id = #{id}")
    User selectById(Integer id);
    @Select("select * from user where username = #{username}")
    Integer selectByUsername(String username);

    @Select("select * from user where username = #{username} and password = #{password}")
    User selectByUsernameAndPassword(String username, String password);

    List<User> selectByLimit(Map<String, Object> map);
}
