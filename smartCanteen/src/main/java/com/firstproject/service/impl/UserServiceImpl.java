package com.firstproject.service.impl;

import com.firstproject.mapper.UserMapper;
import com.firstproject.pojo.User;
import com.firstproject.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean insert(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean updateById(User user) {
        return userMapper.updateById(user) > 0;
    }

    @Override
    public boolean recharge(Integer id, Integer money) {
        return userMapper.addBalance(id, money) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public Integer selectNum() {
        return userMapper.selectNum();
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectByLimit(Map<String, Object> map) {
        return userMapper.selectByLimit(map);
    }
}
