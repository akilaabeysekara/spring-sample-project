package lk.ijse;

import lk.ijse.bean.MyConnection;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        //context.getBean(SpringBean.class);

        MyConnection myConnection = context.getBean(MyConnection.class);
        context.registerShutdownHook();


    }
}
