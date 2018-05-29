package com.xxwy.cache.server;

import com.xxwy.cache.bean.Employee;
import com.xxwy.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * * From  xxwy
 */
@Service
//抽取這個類里緩存配置的公共屬性
@CacheConfig(cacheNames = "emp")
public class EmployeeServer {

    @Autowired
    EmployeeMapper employeeMapper;
    /**
     * cacheManager : 管理多个Cache组件 ， 以后要保存玄相同的数据，不从数据库中获取，从缓存中获取
     * cacheManager: 类似管理HashMap
     * cacheable：--HashMap
     * 几个属性：
     *      cacheNames/value ； 名字 ="" / ={" ", ..}
     *      key ；缓存的key 默认参数的值 ，eg : #id / #root.args[0] / #a0 / #p0 / #root.MethodName+'['+#id+']'
     *      keyGeneration :key的生成器 于key二选一
     *      cacheManager : 从哪个缓存管理器中拿到数据
     *      cacheResolver :指定缓存解析器 ， 于CacheManager二选一
     *      condition: 条件为true:缓存  指定条件
     *      unless : 否定缓存，当unless条件为true不缓存
     *      sync ：是否使用异步
     *原理：
     *  1.自动配置类:cacheAutoconfigration
     * @param id
     * @return
     */
    @Cacheable( value = "emp",condition="#id>0", key = "#id")
    public Employee getEmp(Integer id){
        System.out.println("=============");
        Employee employeeId = employeeMapper.getEmployeeId(id);
        return employeeId;
    }


    /**
     * 方法结束之后保存
     * @param employee
     * @return
     */
    @CachePut(value = "emp" , key = "#result.id")
    public Employee update(Employee employee){
        System.out.println(employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * 方法执行完毕或者开始
     * @param id
     */
    @CacheEvict(value = "emp" ,key = "#id" ,beforeInvocation = true, allEntries = true)
    public void deleteEmp(Integer id){
        System.out.println("==========");
    }


}
