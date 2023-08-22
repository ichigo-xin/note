package com.xin.springdata.pojo;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/**
 * @author : ichigo-xin
 * @date 2023/8/22
 */
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch=LAZY)
    Publisher publisher;

}