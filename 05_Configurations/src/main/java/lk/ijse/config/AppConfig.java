package lk.ijse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig Created");
    }

}