package com.xin.my;

import com.xin.repository.CustomerRepository;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * @author: ichigo-xin
 * @create: 2023-07-26 20:56
 * @description:
 **/

public class MyJpaFactoryBean implements FactoryBean {

    @Autowired
    LocalContainerEntityManagerFactoryBean entityManagerFactory;

    Class<?> repositoryInterface;

    public MyJpaFactoryBean(Class<?> repositoryInterface) {
        this.repositoryInterface = repositoryInterface;
    }

    @Override
    public Object getObject() throws Exception {
        EntityManager em = entityManagerFactory.createNativeEntityManager(null);

        //获取当前接口的pojo类
        ParameterizedType parameterizedType = (ParameterizedType) repositoryInterface.getGenericInterfaces()[0];
        Type type = parameterizedType.getActualTypeArguments()[0];
        Class clazz = Class.forName(type.getTypeName());

        return Proxy.newProxyInstance(
                CustomerRepository.class.getClassLoader(),
                new Class[]{repositoryInterface},
                new MyJpaInvocationHandler(em, clazz));
    }

    @Override
    public Class<?> getObjectType() {
        return repositoryInterface;
    }
}
