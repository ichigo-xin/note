package com.xin.repository;


import com.xin.pojo.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * @author: ichigo-xin
 * @create: 2023-07-18 00:47
 * @description:
 **/
@Component
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {



}
