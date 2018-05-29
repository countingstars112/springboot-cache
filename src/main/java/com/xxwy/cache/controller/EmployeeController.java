package com.xxwy.cache.controller;

import com.xxwy.cache.bean.Employee;
import com.xxwy.cache.server.EmployeeServer;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * * From  xxwy
 *
 */
@RestController
public class EmployeeController {


    @Autowired
    EmployeeServer employeeServer;

    @GetMapping("getEmp/{id}")
    public Employee getEmpById(@PathVariable(value = "id") Integer id){
        Employee emp = employeeServer.getEmp(id);
        System.out.println(emp);
        return emp;
    }

    @PostMapping("updateEmp")
    public Employee update(Employee employee){
        Employee update = employeeServer.update(employee);
        return update;
    }

    @GetMapping("deleteEmp")
    public void deleteEmp(Integer id){
        employeeServer.deleteEmp(id);
    }
}
