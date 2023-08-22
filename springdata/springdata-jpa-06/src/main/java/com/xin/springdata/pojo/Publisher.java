package com.xin.springdata.pojo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(mappedBy="publisher")
    Set<Book> books;

}