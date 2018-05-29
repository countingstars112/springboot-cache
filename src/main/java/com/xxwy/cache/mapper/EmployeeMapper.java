package com.xxwy.cache.mapper;

import com.xxwy.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * * From  xxwy
 */
@Mapper
public interface EmployeeMapper {

    @Select("SELECT * from Employee WHERE id = #{id}")
    public Employee getEmployeeId(Integer id);

    @Update("update Employee set lastName=#{lastName}, email=#{email} ,gender=#{gender},did=#{did} where id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("delete from Employee where id=#{id}")
    public void deleteEmpByid(Integer id);

    @Insert("insert into Employee (lastName,email,gender,did) values (#{lastName},#{email} ,#{gender},#{did})")
    public void insertEmployee(Employee employee);
}
