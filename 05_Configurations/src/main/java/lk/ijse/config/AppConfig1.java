package lk.ijse.config;

import lk.ijse.bean.A;
import lk.ijse.bean.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {
    public AppConfig1() {
        System.out.println("AppConfig1 Created");
    }

    @Bean
    public A a(){
        return new A();
    }
    @Bean
    public B b(){
        return new B();
    }




}
