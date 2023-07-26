package com.xin.my;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

/**
 * @author: ichigo-xin
 * @create: 2023-07-26 02:24
 * @description:
 **/
@Component
public class MyJpaBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        MyJpaClassPathBeanDefinitionScanner scanner = new MyJpaClassPathBeanDefinitionScanner(registry);
        scanner.addIncludeFilter(new AssignableTypeFilter(Repository.class));
        scanner.scan("com.xin.repository");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
