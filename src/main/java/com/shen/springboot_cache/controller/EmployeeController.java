package com.shen.springboot_cache.controller;


import com.shen.springboot_cache.bean.Employee;
import com.shen.springboot_cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;


    @RequestMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){

        Employee emp = employeeService.getEmp(id);

        return emp;
    }


    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        return employeeService.updateEmp(employee);
    }

    @GetMapping("/delemp")
    public String deleteEmp(Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpByName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
