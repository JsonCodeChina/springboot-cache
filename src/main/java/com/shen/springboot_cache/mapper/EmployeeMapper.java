package com.shen.springboot_cache.mapper;


import com.shen.springboot_cache.bean.Employee;
import org.apache.ibatis.annotations.*;


@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEepById(Integer id);

    @Update("update employee set lastName=#{lastName}," +
            "email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id =#{id}")
    public void deleteEmpById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) " +
            "values(#{lastName},#{email},#{gender},#{d_id})")
    public void insertUser(Employee employee);

    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEepByLastName(String lastName);
}
