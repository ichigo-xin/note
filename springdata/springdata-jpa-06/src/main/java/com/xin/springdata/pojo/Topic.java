package com.xin.springdata.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author : ichigo-xin
 * @date 2023/8/22
 */
@Entity
@Table
@Setter
@Getter
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topicName;

    @OneToOne(mappedBy = "topic", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Trace trace;

}
