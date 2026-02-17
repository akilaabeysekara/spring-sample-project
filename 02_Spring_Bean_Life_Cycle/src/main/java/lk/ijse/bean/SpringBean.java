package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public SpringBean() {
        System.out.println("Step 1: SpringBean Created / instantiated");
    }

    // 1. Bean Name Aware
    @Override
    public void setBeanName(String name) {
        System.out.println("Step 3: BeanNameAware : Bean name is = " + name);
    }

    // 2. Bean Factory Aware
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Step 4:BeanFactoryAware : BeanFactory is set");
    }

    // 3. Application Context Aware
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Step 5: ApplicationContextAware : ApplicationContext is set");
    }

    // 4. Initializing Bean
    @Override
    public void afterPropertiesSet() {
        System.out.println("Step 6: InitializingBean : afterPropertiesSet() called");
    }

    // 5. Disposable Bean
    @Override
    public void destroy() {
        System.out.println("Step 7: DisposableBean : destroy() called");
    }
}

