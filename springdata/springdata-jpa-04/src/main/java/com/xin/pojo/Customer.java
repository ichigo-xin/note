package com.xin.pojo;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author: ichigo-xin
 * @create: 2023-07-17 20:22
 * @description:
 **/
@Entity
@Table(name = "tb_customer")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_address")
    private String custAddress;

    public Customer(String name, String address) {
        this.custName = name;
        this.custAddress = address;
    }
}
