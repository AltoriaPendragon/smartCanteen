package com.firstproject.service;

import com.firstproject.pojo.User;
import org.springframework.stereotype.Service;


public interface SignUpService {
    Integer signUp(User user);
}
