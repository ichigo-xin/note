package com.xin.repository;

import com.xin.pojo.Customer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author: ichigo-xin
 * @create: 2023-07-18 22:54
 * @description:
 **/
public interface CustomerSpecificationsRepository extends PagingAndSortingRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {


}
