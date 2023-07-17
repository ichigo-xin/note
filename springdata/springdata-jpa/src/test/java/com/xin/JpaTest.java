package com.xin;

import com.xin.pojo.Customer;
import com.xin.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

/**
 * @author: ichigo-xin
 * @create: 2023-07-18 00:48
 * @description:
 **/
@ContextConfiguration(locations = {"classpath:spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void test1(){
        Optional<Customer> byId = repository.findById(1L);
        System.out.println(byId.get());
    }

    //插入
    @Test
    public void test2(){
        Customer customer = new Customer();
        customer.setCustName("赵六");
        customer.setCustAddress("shanghai");
        repository.save(customer);
    }


}
