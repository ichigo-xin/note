package com.xin.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "employees")
//@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ToString.Include
    private Long id;

//    @ToString.Include
    private String firstName;

//    @ToString.Include
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Department department;

    // Constructors, getters, setters, and other methods as needed
}
