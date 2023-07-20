package com.xin.repository;

import com.xin.pojo.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: ichigo-xin
 * @create: 2023-07-18 00:47
 * @description:
 **/
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    //    @Query("from Customer where custName = ?1")
    @Query("from Customer where custName =:custname")
    List<Customer> findCustomerByCustname(@Param("custname") String custname);

    @Transactional
    @Modifying  // 通知springdatajpa是增删改的操作
    @Query("update Customer c set c.custName = :custname where c.custId = :custid")
    int updateCustomer(@Param("custname") String custname, @Param("custid") Long custid);


    @Transactional
    @Modifying  // 通知springdatajpa是增删改的操作
    @Query("delete from Customer c where c.custId = :custid")
    int deleteCustomer(@Param("custid") Long custid);

    @Query(value="select * from t_customer where cust_name =:custname",nativeQuery = true)
    List<Customer> findCustomerByCustnameBySql(@Param("custname") String custname);

    List<Customer> findByRolesId(Long roleId);

}
