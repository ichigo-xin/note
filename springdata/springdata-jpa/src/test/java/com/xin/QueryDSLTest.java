package com.xin;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.xin.config.SpringDataConfig;
import com.xin.pojo.Customer;
import com.xin.pojo.QCustomer;
import com.xin.repository.CustomerQueryDSLRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author: ichigo-xin
 * @create: 2023-07-18 00:48
 * @description:
 **/
@ContextConfiguration(classes = SpringDataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryDSLTest {

    @Autowired
    private CustomerQueryDSLRepository repository;

    @Test
    public void test1() {
        QCustomer customer = QCustomer.customer;
        BooleanExpression eq = customer.custName.eq("张三");
        repository.findAll(eq).forEach(System.out::println);
    }

    @Test
    public void test2() {
        Customer customerParams = new Customer();
        customerParams.setCustName("张三");
        customerParams.setCustAddress("beijing");

        QCustomer customer = QCustomer.customer;
        // 构造1=1
        BooleanExpression expression = customer.isNull().or(customer.isNotNull());
        expression = customerParams.getCustName() != null ?
                expression.and(customer.custName.eq(customerParams.getCustName())) : expression;
        expression = customerParams.getCustAddress() != null ?
                expression.and(customer.custAddress.eq(customerParams.getCustAddress())) : expression;
        repository.findAll(expression).forEach(System.out::println);

    }

    // 线程安全问题，使用这个注解解决
    @PersistenceContext
    EntityManager em;

    @Test
    public void test3() {
        int pageNo = 1; // 当前页数
        int pageSize = 5; // 每页显示的记录数

        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        QCustomer customer = QCustomer.customer;

        // 查询总数
        long totalCount = jpaQueryFactory.from(customer)
                .select(customer.custName.count())
                .fetchCount();

        // 计算总页数
        long totalPages = (totalCount + pageSize - 1) / pageSize;

        // 执行带分页限制的查询
        List<Tuple> result = jpaQueryFactory.from(customer)
                .select(customer.custName, customer.custAddress)
                .orderBy(customer.custAddress.desc())
                .offset((pageNo - 1) * pageSize)
                .limit(pageSize)
                .fetch();

        for (Tuple tuple : result) {
            System.out.println(tuple.get(customer.custName));
        }

        System.out.println("Total Pages: " + totalPages);
        System.out.println("Total Count: " + totalCount);
    }
}
