package com.xin;

import com.xin.springdata.pojo.Customer;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author: ichigo-xin
 * @create: 2023-07-17 22:30
 * @description:
 **/
public class JpaTest {

    private EntityManager entityManager;

    @Before
    public void before() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate");
        entityManager = factory.createEntityManager();
    }

    @Test
    public void test1() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = new Customer();
        customer.setCustName("张三");
        entityManager.persist(customer);
        transaction.commit();
    }

    // 立即查询
    @Test
    public void test2() {
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println("--------------");
        System.out.println(customer);
    }

    //延迟查询
    @Test
    public void test3() {
        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println("--------------");
        System.out.println(customer);
    }

    @Test
    public void test4() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, 1L);
        customer.setCustName("李四");
        Customer customer2 = entityManager.find(Customer.class, 1L);
        System.out.println(customer2);
        transaction.commit();
    }
}
