package lk.ijse.config;

import lk.ijse.bean.MyConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "bean")
@ComponentScan(basePackages = "lk.ijse")
public class AppConfig {
    @Bean
//    @Scope("prototype")
    public MyConnection myConnection(){
        return new MyConnection();
    }
}
