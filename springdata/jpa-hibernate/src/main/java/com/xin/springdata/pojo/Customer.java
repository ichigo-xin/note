package com.xin.springdata.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: ichigo-xin
 * @create: 2023-07-17 20:22
 * @description:
 **/
@Entity
@Table(name = "t_customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_address")
    private String custAddress;
}
