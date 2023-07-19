package com.xin.repository;

import com.xin.pojo.TestEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: ichigo-xin
 * @create: 2023-07-19 21:36
 * @description:
 **/
public interface TestEntityRepository extends CrudRepository<TestEntity, Long> {
}
