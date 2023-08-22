package com.xin.springdata.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ichigo-xin
 * @date 2023/7/25
 */
@Entity
@Table
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    private Author author;

}
