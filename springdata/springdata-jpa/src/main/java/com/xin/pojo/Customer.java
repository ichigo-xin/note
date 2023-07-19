package com.xin.pojo;

import lombok.*;

import javax.persistence.*;

/**
 * @author: ichigo-xin
 * @create: 2023-07-17 20:22
 * @description:
 **/
@Entity
@Table(name = "t_customer")
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

    // 单向关联 一对一
    /**
     * cascade 设置级联操作
     * CascadeType.PERSIST 保存
     * CascadeType.REMOVE 删除
     * CascadeType.MERGE 更新
     * CascadeType.ALL 所有
     *
     * fetch 设置懒加载
     * FetchType.LAZY 懒加载（不是所有的关联对象都要用到）
     * FetchType.EAGER 立即加载
     *
     *orphanRemoval 设置是否删除孤儿数据
     * 如果把关联数据设置null，想删除关联数据就设置为true
     *
     * optional 设置关联对象是否可以为空
     *
     * mappedBy 将外键约束执行另一方维护，通常在双向关联关系中会放弃一方的关联约束
     * 值=另一方属性名
     */
    @ToString.Exclude
    @OneToOne(mappedBy ="customer", cascade = CascadeType.PERSIST, /*fetch = FetchType.LAZY,*/ orphanRemoval = true)
    // 设置外键的字段名
    @JoinColumn(name = "account_id")
    private Account account;

    public Customer(String name, String address) {
        this.custName = name;
        this.custAddress = address;
    }
}
