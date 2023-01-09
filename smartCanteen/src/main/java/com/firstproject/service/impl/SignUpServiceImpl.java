package com.firstproject.service.impl;

import com.firstproject.mapper.UserMapper;
import com.firstproject.pojo.User;
import com.firstproject.service.SignUpService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class SignUpServiceImpl implements SignUpService {

    @Resource
    UserMapper userMapper;

    @Override
    public Integer signUp(User user) {
        if (userMapper.selectByUsername(user.getUsername()) == null){
            return userMapper.insert(user);
        }
        return 0;
    }
}
