package com.xin.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: ichigo-xin
 * @create: 2023-07-19 20:23
 * @description:
 **/

@Table
@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
