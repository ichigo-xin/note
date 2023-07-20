package com.xin.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author: ichigo-xin
 * @create: 2023-07-20 22:05
 * @description:
 **/
@Entity
@Table(name = "tb_role")
@ToString
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

}
