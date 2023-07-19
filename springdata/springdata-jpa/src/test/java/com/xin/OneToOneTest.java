package com.xin;

import com.xin.config.SpringDataConfig;
import com.xin.pojo.Account;
import com.xin.pojo.Customer;
import com.xin.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author: ichigo-xin
 * @create: 2023-07-20 00:48
 * @description:
 **/
@ContextConfiguration(classes = SpringDataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OneToOneTest {

    @Autowired
    private CustomerRepository repository;

    // 插入
    @Test
    public void test1(){
        // 初始化数据
        Account account = new Account();
        account.setUsername("zhangsan");

        Customer customer = new Customer();
        customer.setCustName("张三");
        customer.setAccount(account);

        repository.save(customer);
    }

    // 查询
    @Test
    //懒加载为什么要配置事务
    //当repository执行完了之后，就会关闭session
    //加了事务之后，就可以让session在整个方法执行完之后才关闭
    @Transactional
    public void test2() {
        Optional<Customer> byId = repository.findById(14L);
        System.out.println("==============");
        System.out.println(byId.get());
        System.out.println(byId.get().getAccount());
    }

    // 删除
    @Test
    public void test3() {
        repository.deleteById(1L);
    }

    // 更新
    @Test
    public void test4() {
        Optional<Customer> byId = repository.findById(17L);
        Customer customer = byId.get();
        customer.setCustName("33");
        Account account = customer.getAccount();
        account.setUsername("222");
        repository.save(customer);
    }

    @Test
    public void test5(){
        // 初始化数据
        Account account = new Account();
        account.setUsername("zhangsan");

        Customer customer = new Customer();
        customer.setCustName("张三");
        customer.setAccount(account);
        account.setCustomer(customer);

        repository.save(customer);
    }

}
