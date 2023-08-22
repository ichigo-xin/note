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
public class Trace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String traceName;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH/*CascadeType.ALL*/})
    @JoinColumn(name = "topic_id")
    private Topic topic;


}
