package com.java.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.java.reggie.common.R;
import com.java.reggie.entity.Employee;
import com.java.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName EmployeeController
 * @Description reggie
 * @Author oldghoast
 * @Date 2022/8/6 19:37
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<Employee>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp =  employeeService.getOne(queryWrapper);
        if(emp==null){
            return R.error("登录失败");
        }
        if(!password.equals(emp.getPassword())){
            return R.error("登录失败");
        }
        if(emp.getStatus()==0){
            return R.error("账号已禁用");
        }
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }
}
