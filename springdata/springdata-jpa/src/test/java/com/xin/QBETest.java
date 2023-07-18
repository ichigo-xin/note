package com.xin;

import com.xin.config.SpringDataConfig;
import com.xin.pojo.Customer;
import com.xin.repository.CustomerMethodNameRepository;
import com.xin.repository.CustomerMethodQBERepository;
import com.xin.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

/**
 * @author: ichigo-xin
 * @create: 2023-07-18 00:48
 * @description:
 **/
@ContextConfiguration(classes = SpringDataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class QBETest {

    @Autowired
    private CustomerMethodQBERepository repository;

    @Test
    public void test1() {
        // 1.创建查询条件
        Customer customer = new Customer();
        customer.setCustAddress("beijing");
        // 2.创建匹配器
        Example<Customer> example = Example.of(customer);
        repository.findAll(example).forEach(System.out::println);
    }

    @Test
    public void test2() {
        // 1.创建查询条件
        Customer customer = new Customer();
        customer.setCustAddress("beijing");
        customer.setCustName("赵六");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("custAddress");
        // 2.创建匹配器
        Example<Customer> example = Example.of(customer, matcher);
        repository.findAll(example).forEach(System.out::println);
    }


}
