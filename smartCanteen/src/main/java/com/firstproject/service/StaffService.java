package com.firstproject.service;

import com.firstproject.pojo.Staff;

import java.util.List;
import java.util.Map;


public interface StaffService {
    boolean insert(Staff staff);

    boolean updateById(Staff staff);

    boolean plusSalary(String staffAccount);

    boolean deleteById(Integer id);

    Integer selectNum();

    Staff selectById(Integer id);

    List<Staff> selectByLimit(Map<String, Object> map);
}
