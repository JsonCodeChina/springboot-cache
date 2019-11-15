package com.shen.springboot_cache;

import com.shen.springboot_cache.bean.Employee;
import com.shen.springboot_cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootCacheApplicationTests {


    @Autowired
    EmployeeMapper employeeMapper;


    @Test
    void contextLoads() {

        Employee emp = employeeMapper.getEepById(1);
        System.out.println(emp);

    }

}
