package com.xin;

import com.xin.config.SpringDataConfig;
import com.xin.pojo.Customer;
import com.xin.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ichigo-xin
 * @date 2023/7/18
 */
@ContextConfiguration(classes = SpringDataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringDataJpaPagingAndSortTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void test1(){
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            customers.add(new Customer("张三"+i, "北京"+i));
        }
        repository.saveAll(customers);
    }

    @Test
    public void test2(){
        Page<Customer> all = repository.findAll(PageRequest.of(0, 5));
        System.out.println(all.getTotalElements());
        System.out.println(all.getTotalPages());
        System.out.println(all.getContent());
    }

    @Test
    public void test3(){
        Sort sort = Sort.by(Sort.Direction.DESC, "custId");
        repository.findAll(sort).forEach(System.out::println);
    }

    @Test
    public void test4(){
        Sort.TypedSort<Customer> typedSort = Sort.sort(Customer.class);
        Sort sort = typedSort.by(Customer::getCustId).descending();
        repository.findAll(sort).forEach(System.out::println);
    }

}
