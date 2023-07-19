package com.xin;

import com.xin.config.SpringDataConfig;
import com.xin.pojo.Department;
import com.xin.pojo.Employee;
import com.xin.pojo.TestEntity;
import com.xin.repository.CustomerRepository;
import com.xin.repository.TestEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ichigo-xin
 * @create: 2023-07-19 21:34
 * @description:
 **/
@ContextConfiguration(classes = SpringDataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class LombokTest {

    @Autowired
    private TestEntityRepository testEntityRepository;

    @Test
    public void test1() {
        TestEntity testEntity = new TestEntity();
        Set<TestEntity> set = new HashSet<>();
        set.add(testEntity);
        testEntityRepository.save(testEntity);
        Assert.isTrue(set.contains(testEntity), "Entity not found in the set");
    }

    @Test
    public void test2() {
        Department department = new Department();
        department.setId(1L);
        department.setName("Engineering");

        Employee employee = new Employee();
        employee.setId(100L);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setDepartment(department);

        System.out.println(employee); // 输出结果：Employee(id=100, firstName=John, lastName=Doe)

    }


}
