package com.xin;

import com.xin.config.SpringDataConfig;
import com.xin.pojo.Customer;
import com.xin.pojo.Role;
import com.xin.repository.CustomerRepository;
import com.xin.repository.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
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
public class ManyToManyTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoleRepository roleRepository;

    // 插入
    @Test
    public void test1() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("超级管理员"));
        roles.add(new Role("日志管理员"));
        Customer customer = new Customer();
        customer.setCustName("李四");
        customer.setRoles(roles);
        customerRepository.save(customer);
    }


    @Test
    @Transactional(readOnly = true)
    public void test2() {
        Optional<Customer> byId = customerRepository.findById(5L);
        System.out.println("=================");
        System.out.println(byId);
    }

    /**
     * 多对多不适合级联删除，因为会把其他的关联数据也删除掉
     */
    @Test
    public void test3() {
        Optional<Customer> byId = customerRepository.findById(2L);
        customerRepository.delete(byId.get());
    }

    @Test
    public void test4() {
        roleRepository.deleteById(3L);
    }

    // 多对多删除，先要删除中间表中的数据，再删除关联表中的数据
    @Test
    @Transactional
    @Commit
    public void test5() {
        Long roleId = 7L;
        // Step 1: 查询所有包含该角色的 Customer 实体
        List<Customer> customersWithRole = customerRepository.findByRolesId(roleId);

        // 遍历每个包含该角色的 Customer 实体，从它们的 roles 集合中删除该角色
        for (Customer customer : customersWithRole) {
            List<Role> roles = customer.getRoles();
            roles.removeIf(role -> role.getId().equals(roleId));
            customer.setRoles(roles);
            // 这里注意要调用 save 方法，将更新后的 Customer 实体持久化到数据库
            customerRepository.save(customer);
        }

        // Step 2: 删除 Role 实体
//        roleRepository.deleteById(roleId);
    }


    @Test
    @Transactional
    @Commit
    public void test6() {
        Customer customer = customerRepository.findById(1L).get();
        Role role = roleRepository.findById(3L).get();
        List<Role> roles = customer.getRoles();
        roles.add(role);
//        customerRepository.save(customer);

    }

    @Test
    public void test7() {
        Role role = new Role("用户管理员");
        roleRepository.save(role);
    }

}
