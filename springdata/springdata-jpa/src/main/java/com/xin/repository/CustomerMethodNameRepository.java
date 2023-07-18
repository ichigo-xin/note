package com.xin.repository;

import com.xin.pojo.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author: ichigo-xin
 * @create: 2023-07-18 20:41
 * @description:
 **/
public interface CustomerMethodNameRepository extends PagingAndSortingRepository<Customer, Long> {

    List<Customer> findByCustName(String custName);

    List<Customer> findByCustNameLike(String custName);

}
