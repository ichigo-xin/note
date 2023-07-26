package com.xin.my;

import com.xin.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: ichigo-xin
 * @create: 2023-07-26 21:01
 * @description:
 **/
public class MyJpaInvocationHandler implements InvocationHandler {

    EntityManager em;

    Class pojoClass;

    public MyJpaInvocationHandler(EntityManager em, Class pojoClass) {
        this.em = em;
        this.pojoClass = pojoClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyJpaProxy myJpaProxy = new MyJpaProxy(em, pojoClass);
        Method jpaMethod = myJpaProxy.getClass().getMethod(method.getName(), method.getParameterTypes());
        return jpaMethod.invoke(myJpaProxy, args);
    }
}
