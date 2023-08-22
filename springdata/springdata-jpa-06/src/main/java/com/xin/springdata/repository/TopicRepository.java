package com.xin.springdata.repository;

import com.xin.springdata.pojo.Topic;
import com.xin.springdata.pojo.Trace;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : ichigo-xin
 * @date 2023/8/22
 */
public interface TopicRepository extends PagingAndSortingRepository<Topic, Long> {

    Topic findByTopicName(String topicName);
}
