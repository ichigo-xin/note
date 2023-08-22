package com.xin.springdata.repository;

import com.xin.springdata.pojo.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : ichigo-xin
 * @date 2023/8/22
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
