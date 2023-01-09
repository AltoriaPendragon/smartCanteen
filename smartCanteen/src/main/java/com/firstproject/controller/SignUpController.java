package com.firstproject.controller;

import com.firstproject.controller.utils.Result;
import com.firstproject.pojo.User;
import com.firstproject.service.SignUpService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.firstproject.controller.utils.Code.POST_ERR;
import static com.firstproject.controller.utils.Code.POST_OK;

@RestController
@RequestMapping("/sign_up")
public class SignUpController {

    @Resource
    SignUpService signUpService;

    @PostMapping
    public Result signUp(@RequestBody User user) {
        boolean flag = signUpService.signUp(user) > 0;
        return new Result(flag ? POST_OK : POST_ERR, flag);
    }
}
