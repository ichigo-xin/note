package com.xin;

import com.xin.config.SpringDataConfig;
import com.xin.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : ichigo-xin
 * @date 2023/7/18
 */
@ContextConfiguration(classes = SpringDataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JpqlTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void test1(){
        System.out.println(repository.findCustomerByCustname("王五"));
    }

    @Test
    public void test2(){
        System.out.println(repository.updateCustomer("李四", 1L));
    }

    @Test
    public void test3(){
        System.out.println(repository.deleteCustomer(10L));
    }

    @Test
    public void test4(){
        System.out.println(repository.findCustomerByCustnameBySql("王五"));
    }
}
