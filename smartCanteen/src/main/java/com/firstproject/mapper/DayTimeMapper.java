package com.firstproject.mapper;

import com.firstproject.pojo.DayTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DayTimeMapper {

    Integer update(DayTime dayTime);
    @Select("select * from daytime")
    DayTime selectAll();
}
