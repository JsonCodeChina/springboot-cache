package com.shen.springboot_cache.service;

import com.shen.springboot_cache.bean.Employee;
import com.shen.springboot_cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {


    /**
     * cacheable 是在方法调用之前就运行 所以不要使用#result.id
     * 而cacheput 是在方法调用之后 所以可以使用result.id
     */


    @Autowired
    EmployeeMapper employeeMapper;

    //将方法的运行结果进行缓存 如果下次要获取数据 就不用去数据库获取数据了
    //使用cacheManager【concurrentHashMap】按照名字得到组件
    //,key = "#root.args[0]",condition = "#id>0",unless = "#result == null "
    //key = "#root.methodName+'['+#id+']'"
    @Cacheable(cacheNames = "emp",condition = "#id>0")
    public Employee getEmp(Integer id){
        System.out.println("查询员工："+id+ "号员工");
       return employeeMapper.getEepById(id);
    }

    /**
     * @CachePut 即调用方法 又更新缓存数据
     */
    @CachePut(cacheNames = "emp",key="#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("员工更新的方法调用");
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(cacheNames = "emp",key="#id")
    public void deleteEmp(Integer id){
        System.out.println("这里是删除一个员工");
        //employeeMapper.deleteEmpById(id);
    }

    @Caching(
         cacheable = {
                 @Cacheable(value = "emp",key = "#lastName")
         },
         put = {
                 @CachePut(value = "emp",key = "#result.id")
         }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEepByLastName(lastName);
    }
}
