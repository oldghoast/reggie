package com.java.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.reggie.entity.Employee;
import com.java.reggie.mapper.EmployeeMapper;
import com.java.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @ClassName EmployeeServiceImpl
 * @Description reggie
 * @Author oldghoast
 * @Date 2022/8/6 19:36
 * @Version 1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
