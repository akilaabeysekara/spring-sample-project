package lk.ijse;

import lk.ijse.config.AppConfig;
import lk.ijse.config.AppConfig1;
import lk.ijse.config.AppConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        context.registerShutdownHook();
    }
}