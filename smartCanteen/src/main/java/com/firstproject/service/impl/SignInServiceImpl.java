package com.firstproject.service.impl;

import com.firstproject.mapper.StaffMapper;
import com.firstproject.mapper.UserMapper;
import com.firstproject.pojo.Staff;
import com.firstproject.pojo.User;
import com.firstproject.service.SignInService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SignInServiceImpl implements SignInService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private StaffMapper staffMapper;

    @Override
    public User userSignIn(String username, String password) {
        return userMapper.selectByUsernameAndPassword(username, password);
    }

    @Override
    public Staff staffSignIn(String staffAccount, String password) {
        return staffMapper.selectByStaffAccountAndPassword(staffAccount, password);
    }


}
