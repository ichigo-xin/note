package com.xin;

import com.xin.config.SpringDataConfig;
import com.xin.repository.CustomerMethodNameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: ichigo-xin
 * @create: 2023-07-18 20:46
 * @description:
 **/
@ContextConfiguration(classes = SpringDataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MethodNameTest {

    @Autowired
    private CustomerMethodNameRepository repository;

    @Test
    public void test1(){
        repository.findByCustName("李四").forEach(System.out::println);
    }

    @Test
    public void test2(){
        repository.findByCustNameLike("李%").forEach(System.out::println);
    }
}
