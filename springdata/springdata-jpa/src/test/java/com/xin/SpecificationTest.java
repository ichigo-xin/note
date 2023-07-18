package com.xin;

import com.xin.config.SpringDataConfig;
import com.xin.pojo.Customer;
import com.xin.repository.CustomerMethodNameRepository;
import com.xin.repository.CustomerSpecificationsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author: ichigo-xin
 * @create: 2023-07-18 22:56
 * @description:
 **/
@ContextConfiguration(classes = SpringDataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpecificationTest {

    @Autowired
    private CustomerSpecificationsRepository repository;

    @PersistenceContext
    EntityManager em;

    @Test
    public void test1() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery(); // 使用TupleQuery
        Root<Customer> root = query.from(Customer.class);
        query.select(criteriaBuilder.tuple(root.get("custName"), root.get("custAddress"))) // 选择指定字段
                .orderBy(criteriaBuilder.asc(root.get("custAddress"))); // 按照custAddress升序排序

        List<Tuple> result = em.createQuery(query).getResultList();

        for (Tuple tuple : result) {
            String custName = (String) tuple.get(0);
            String custAddress = (String) tuple.get(1);
            System.out.println("custName: " + custName + ", custAddress: " + custAddress);
        }
    }

}
