package com.xin.repository;

import com.xin.pojo.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * @author: ichigo-xin
 * @create: 2023-07-18 21:00
 * @description:
 **/
public interface CustomerMethodQBERepository extends PagingAndSortingRepository<Customer, Long>, QueryByExampleExecutor<Customer> {


}
