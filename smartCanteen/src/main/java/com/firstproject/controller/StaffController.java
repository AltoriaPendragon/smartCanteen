package com.firstproject.controller;

import com.firstproject.controller.utils.Result;
import com.firstproject.pojo.Staff;
import com.firstproject.service.StaffService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.firstproject.controller.utils.Code.*;
import static com.firstproject.controller.utils.Code.GET_ERR;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Resource
    private StaffService staffService;

    @PostMapping
    public Result insert(@RequestBody Staff staff){
        boolean flag = staffService.insert(staff);
        return new Result(flag ? POST_OK:POST_ERR, flag);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = staffService.deleteById(id);
        return new Result(flag ? DELETE_OK:DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Staff staff){
        boolean flag = staffService.updateById(staff);
        return new Result(flag ? UPDATE_OK:UPDATE_ERR, flag);
    }

    @GetMapping("{id}")
    public Result selectById(@PathVariable Integer id){
        Staff staff = staffService.selectById(id);
        Integer code  = staff != null ? GET_OK:GET_ERR;
        return new Result(code, staff);
    }


    @GetMapping("{currentPage}/{pageSize}")
    public Result selectByLimit(@PathVariable int currentPage,@PathVariable int pageSize, Staff staff){
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", (currentPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("staffName", staff.getStaffName());
        map.put("staffAccount", staff.getStaffAccount());
        map.put("sex", staff.getSex());
        List<Staff> staffList = staffService.selectByLimit(map);
        Integer code = staffList != null ? GET_OK:GET_ERR;
        int total = staffService.selectNum();
        if (total <= (currentPage - 1) * pageSize){
            map.put("startIndex", (currentPage - 2) * pageSize);
            staffList = staffService.selectByLimit(map);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("staffList", staffList);
        data.put("total", total);
        System.out.println(data.get("staffList"));
        return new Result(code, data);
    }
}
