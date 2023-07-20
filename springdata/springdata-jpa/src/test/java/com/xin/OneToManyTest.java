package com.xin;

import com.xin.config.SpringDataConfig;
import com.xin.pojo.Account;
import com.xin.pojo.Customer;
import com.xin.pojo.Message;
import com.xin.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: ichigo-xin
 * @create: 2023-07-20 00:48
 * @description:
 **/
@ContextConfiguration(classes = SpringDataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OneToManyTest {

    @Autowired
    private CustomerRepository repository;

    // 插入
    @Test
    public void test1(){

        Customer customer = new Customer();
        customer.setCustName("张三");

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message("你好"));
        messageList.add(new Message("java"));
        customer.setMessages(messageList);
        repository.save(customer);
    }

    // 查询
    @Test
    @Transactional(readOnly = true)
    public void test2(){
        Optional<Customer> byId = repository.findById(1L);
        System.out.println("=================");
        System.out.println(byId);
    }


}
