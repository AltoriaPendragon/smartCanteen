package com.firstproject.controller;

import com.firstproject.controller.utils.Result;
import com.firstproject.mapper.DayTimeMapper;
import com.firstproject.pojo.DayTime;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.firstproject.controller.utils.Code.GET_ERR;
import static com.firstproject.controller.utils.Code.GET_OK;

@RestController
@RequestMapping("/daytime")
public class DayTimeController {

    @Resource
    DayTimeMapper dayTimeMapper;

    @GetMapping
    public Result getAll() {
        DayTime dayTime = dayTimeMapper.selectAll();
        return new Result(dayTime == null ? GET_ERR : GET_OK, dayTime);
    }
}
