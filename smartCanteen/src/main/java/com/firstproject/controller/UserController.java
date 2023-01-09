package com.firstproject.controller;

import com.firstproject.controller.utils.Result;
import com.firstproject.pojo.User;
import com.firstproject.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.firstproject.controller.utils.Code.*;
import static com.firstproject.controller.utils.Code.GET_ERR;

@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping
    public Result insert(@RequestBody User user){
        boolean flag = userService.insert(user);
        System.out.println(user);
        return new Result(flag ? POST_OK:POST_ERR, flag);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = userService.deleteById(id);
        return new Result(flag ? DELETE_OK:DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody User user){
        boolean flag = userService.updateById(user);
        return new Result(flag ? UPDATE_OK:UPDATE_ERR, flag);
    }
    @PutMapping("/recharge")
    public Result recharge(@RequestBody User user){
        boolean flag = userService.recharge(user.getId(), user.getMoney());
        return new Result(flag ? UPDATE_OK:UPDATE_ERR, flag);
    }

    @GetMapping("{id}")
    public Result selectById(@PathVariable Integer id){
        User user = userService.selectById(id);
        Integer code  = user != null ? GET_OK:GET_ERR;
        return new Result(code, user);
    }


    @GetMapping("{currentPage}/{pageSize}")
    public Result selectByLimit(@PathVariable int currentPage,@PathVariable int pageSize, User user){
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", (currentPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("username", user.getUsername());
        map.put("sex", user.getSex());
        map.put("nickname", user.getNickname());
        List<User> userList = userService.selectByLimit(map);
        Integer code = userList != null ? GET_OK:GET_ERR;
        int total = userService.selectNum();
        if (total <= (currentPage - 1) * pageSize){
            map.put("startIndex", (currentPage - 2) * pageSize);
            userList = userService.selectByLimit(map);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("userList", userList);
        data.put("total", total);
        return new Result(code, data);
    }
}
