package com.firstproject.service.impl;

import com.firstproject.mapper.DayTimeMapper;
import com.firstproject.pojo.DayTime;
import com.firstproject.service.DayTimeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DayTimeServiceImpl implements DayTimeService {

    @Resource
    DayTimeMapper dayTimeMapper;

    public DayTime selectAll(){
        return dayTimeMapper.selectAll();
    }
}
