package com.xin.springdata.repository;

import com.xin.springdata.pojo.Author;
import com.xin.springdata.pojo.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : ichigo-xin
 * @date 2023/8/22
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
