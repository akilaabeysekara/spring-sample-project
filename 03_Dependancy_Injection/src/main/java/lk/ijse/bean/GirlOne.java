package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GirlOne implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean,Agreement {

    public GirlOne() {
        System.out.println("Girl object Created");
    }


    @Override
    public void setBeanName(String name) {
        System.out.println("Step 3: Bean Name Aware : " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Step 4: Bean Factory Aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Step 5: Application Context Aware");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Step 6: Initializing Bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Step 7: Disposable Bean");
    }
    @Override
    public void chat(){
        System.out.println("Chat with GirlOne");
    }
}