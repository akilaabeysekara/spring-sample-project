package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyConnection implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {

    public MyConnection() {
        System.out.println("Step 1: (*) Prototype Bean instantiated");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Step 3: (*) BeanNameAware - Bean name = " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Step 4: (*) BeanFactoryAware - BeanFactory set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Step 5: (*) ApplicationContextAware - ApplicationContext set");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Step 6: (*) InitializingBean - afterPropertiesSet()");
    }

    // ❗ Prototype beans are NOT destroyed by Spring
    public void close() {
        System.out.println("Step 7: (*) Manual cleanup method called");
    }
}
