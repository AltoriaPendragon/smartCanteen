package com.firstproject.controller;

import com.firstproject.controller.utils.Result;
import com.firstproject.pojo.Staff;
import com.firstproject.pojo.User;
import com.firstproject.service.SignInService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import static com.firstproject.controller.utils.Code.POST_ERR;
import static com.firstproject.controller.utils.Code.POST_OK;

@RestController
@RequestMapping("/sign_in")
public class SignInController {

    @Resource
    private SignInService signInService;

    @PostMapping("/user")
    public Result userSignIn(@RequestBody User user) {
        User fullUser = signInService.userSignIn(user.getUsername(), user.getPassword());
        return new Result(fullUser != null ? POST_OK : POST_ERR, fullUser);
    }

    @PostMapping("/staff")
    public Result staffSignIn(@RequestBody Staff staff) {
        Staff fullStaff = signInService.staffSignIn(staff.getStaffAccount(), staff.getPassword());
        return new Result(fullStaff != null ? POST_OK : POST_ERR, fullStaff);
    }
}
