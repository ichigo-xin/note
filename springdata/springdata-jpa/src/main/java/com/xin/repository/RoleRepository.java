package com.xin.repository;

import com.xin.pojo.Customer;
import com.xin.pojo.Message;
import com.xin.pojo.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author: ichigo-xin
 * @create: 2023-07-18 00:47
 * @description:
 **/
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {



}
