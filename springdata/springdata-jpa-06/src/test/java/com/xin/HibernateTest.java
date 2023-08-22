package com.xin;

import com.xin.springdata.config.SpringDataConfig;
import com.xin.springdata.pojo.Topic;
import com.xin.springdata.pojo.Trace;
import com.xin.springdata.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : ichigo-xin
 * @date 2023/8/21
 */
@ContextConfiguration(classes = SpringDataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class HibernateTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private TraceRepository traceRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Test
    public void test1() {
        // 插入数据
        Topic topic = new Topic();
        topic.setTopicName("topic3");
        topicRepository.save(topic);
    }

    @Test
    public void test2() {
        // 插入数据
        Trace trace = new Trace();
        trace.setTraceName("trace3");
        Topic topic = topicRepository.findByTopicName("topic3");
        trace.setTopic(topic);
        traceRepository.save(trace);
    }

    @Test
    public void test3() {
        //测试删除
        Trace trace = traceRepository.findByTraceName("trace2");
        traceRepository.delete(trace);
    }

    @Test
    public void test4() {
        //测试删除Topic
        Topic topic = topicRepository.findByTopicName("topic3");
        topicRepository.delete(topic);
    }

}
