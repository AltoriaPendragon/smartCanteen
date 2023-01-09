package com.firstproject.service;


import com.firstproject.pojo.Staff;
import com.firstproject.pojo.User;

public interface SignInService {

    User userSignIn(String username, String password);

    Staff staffSignIn(String staffAccount, String password);
}
