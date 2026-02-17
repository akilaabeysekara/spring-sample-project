package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class SpringBean implements InitializingBean {
    //-------------------- Environment Variables -------------
    //System Variables
//    Map<String, String> systemVariables = System.getenv();
//
//    public SpringBean() {
//        for (String key : systemVariables.keySet()) {
//            System.out.println(key);
//        }
//}

    //Java Properties
//    public SpringBean() {
//        java.util.Properties properties = System.getProperties();
//        for (String key : properties.stringPropertyNames()) {
//            System.out.println(key + " = " + properties.getProperty(key));
//        }
//    }

    //Resource Bundle
    @Value("${db.name}")
    private String name;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    @Value("${db.url}")
    private String url;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Name: " + name);
        System.out.println("User: " + user);
        System.out.println("Password: " + password);
        System.out.println("URL: " + url);
    }

}