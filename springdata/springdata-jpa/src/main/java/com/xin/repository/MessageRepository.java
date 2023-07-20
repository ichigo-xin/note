package com.xin.repository;

import com.xin.pojo.Customer;
import com.xin.pojo.Message;
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
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {

    List<Message> findByCustomer(Customer customer);

}
