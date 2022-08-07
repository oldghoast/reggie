package com.java.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName EmployeeMapper
 * @Description reggie
 * @Author oldghoast
 * @Date 2022/8/6 19:32
 * @Version 1.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
