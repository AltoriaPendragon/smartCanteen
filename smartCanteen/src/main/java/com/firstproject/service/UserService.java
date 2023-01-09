package com.firstproject.service;

import com.firstproject.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    boolean insert(User user);

    boolean updateById(User user);

    boolean recharge(Integer id, Integer money);

    boolean deleteById(Integer id);

    Integer selectNum();

    User selectById(Integer id);

    List<User> selectByLimit(Map<String, Object> map);
}
