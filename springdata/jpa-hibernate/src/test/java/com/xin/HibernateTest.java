package com.xin;

import com.xin.springdata.pojo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author: ichigo-xin
 * @create: 2023-07-17 20:47
 * @description:
 **/
public class HibernateTest {

    //数据库会话
    private SessionFactory sf;

    @Before
    public void before() {
        //创建会话工厂
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void test1() {
        //创建会话
        try (Session session = sf.openSession()) {
            Transaction tx = session.getTransaction();
            tx.begin();
            Customer customer = new Customer();
            customer.setCustName("ichigo-xin");
            customer.setCustAddress("chengdu");
            session.save(customer);
            tx.commit();
        }
    }

    @Test
    public void test2() {
        //创建会话
        try (Session session = sf.openSession()) {
            String hql = "from Customer where custId = 1";
            List<Customer> resultList = session.createQuery(hql, Customer.class).getResultList();
            System.out.println(resultList);
        }
    }



}
