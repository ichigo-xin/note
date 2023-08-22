package com.xin.springdata.repository;

import com.xin.springdata.pojo.Author;
import com.xin.springdata.pojo.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : ichigo-xin
 * @date 2023/8/22
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
