package com.firstproject.service.impl;

import com.firstproject.mapper.StaffMapper;
import com.firstproject.pojo.Staff;
import com.firstproject.service.StaffService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffMapper staffMapper;

    @Override
    public boolean insert(Staff staff) {
        return staffMapper.insert(staff) > 0;
    }

    @Override
    public boolean updateById(Staff staff) {
        return staffMapper.updateById(staff) > 0;
    }

    public boolean plusSalary(String staffAccount){
        return staffMapper.updateByStaffAccount(staffAccount) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return staffMapper.deleteById(id) > 0;
    }

    @Override
    public Integer selectNum() {
        return staffMapper.selectNum();
    }

    @Override
    public Staff selectById(Integer id) {
        return staffMapper.selectById(id);
    }

    @Override
    public List<Staff> selectByLimit(Map<String, Object> map) {
        return staffMapper.selectByLimit(map);
    }
}
