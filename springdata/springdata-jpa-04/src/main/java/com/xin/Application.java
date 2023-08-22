package com.xin;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.xin.config.SpringDataConfig;
import com.xin.pojo.Customer;
import com.xin.repository.CustomerRepository;

/**
 * @author: ichigo-xin
 * @create: 2023-07-26 01:24
 * @description:
 **/
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfig.class);
        CustomerRepository repository = context.getBean(CustomerRepository.class);
        Customer customer = repository.findById(1L).get();
        System.out.println(customer);
    }
}
