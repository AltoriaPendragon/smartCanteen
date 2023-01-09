package com.firstproject.mapper;

import com.firstproject.pojo.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StaffMapper {
    @Insert("insert into staff (staffName, age, sex, staffAccount, password) " +
            "values(#{staffName}, #{age}, #{sex}, #{staffAccount}, #{password})")
    Integer insert(Staff staff);

    @Delete("delete from staff where id = #{id}")
    Integer deleteById(Integer id);

    Integer updateById(Staff staff);

    @Update("update staff set workload = workload + 1, income = 10 * workload where staffAccount = #{staffAccount}")
    Integer updateByStaffAccount(String staffAccount);

    @Select("select count(*) from staff")
    Integer selectNum();

    @Select("select * from staff where id = #{id}")
    Staff selectById(Integer id);
    @Select("select * from staff where staffAccount = #{staffAccount} and password = #{password}")
    Staff selectByStaffAccountAndPassword(String staffAccount, String password);

    List<Staff> selectByLimit(Map<String, Object> map);
}
