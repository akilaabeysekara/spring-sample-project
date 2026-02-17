package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class SpringBeanTwo implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public  SpringBeanTwo() {
        System.out.println("SpringBeanTwo : Constructor");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBeanTwo : setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBeanTwo : setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBeanTwo : destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBeanTwo : bean initialization");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringBeanTwo : setApplicationContext");
    }
}