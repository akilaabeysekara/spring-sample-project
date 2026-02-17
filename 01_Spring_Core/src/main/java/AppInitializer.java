import bean.MyConnection;
import bean.SpringBean;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        SpringBean springBean = context.getBean(SpringBean.class);
        springBean.printMessage();
        System.out.println(springBean);

        SpringBean springBean1 = context.getBean(SpringBean.class);
        SpringBean springBean2 = context.getBean(SpringBean.class);
        System.out.println(springBean1);
        System.out.println(springBean2);
        System.out.println(springBean1 == springBean2);

     //   SpringTest springTest = context.getBean(SpringTest.class);

        MyConnection myConnection = context.getBean(MyConnection.class);



        context.registerShutdownHook();
    }
}
