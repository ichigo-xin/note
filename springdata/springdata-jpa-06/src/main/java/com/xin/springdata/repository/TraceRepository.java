package com.xin.springdata.repository;

import com.xin.springdata.pojo.Author;
import com.xin.springdata.pojo.Trace;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : ichigo-xin
 * @date 2023/8/22
 */
public interface TraceRepository extends PagingAndSortingRepository<Trace, Long> {

    Trace findByTraceName(String traceName);
}
