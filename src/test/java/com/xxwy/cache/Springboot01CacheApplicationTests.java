package com.xxwy.cache;

import com.xxwy.cache.bean.Employee;
import com.xxwy.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Test
	public void contextLoads() {
        Employee employeeId = employeeMapper.getEmployeeId(1);
        employeeMapper.insertEmployee(new Employee(null, "小啊","981852280@qq",1,1));
        employeeMapper.updateEmp(new Employee(1, "xxxx","popop",1,1));
        System.out.println(employeeId);
    }

}
