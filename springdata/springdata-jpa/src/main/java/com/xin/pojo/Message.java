package com.xin.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author: ichigo-xin
 * @create: 2023-07-20 20:47
 * @description:
 **/
@Entity
@Table(name = "tb_message")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String info;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer customer;

    public Message(String info, Customer customer) {
        this.info = info;
        this.customer = customer;
    }

    public Message(String info) {
        this.info = info;
    }
}
