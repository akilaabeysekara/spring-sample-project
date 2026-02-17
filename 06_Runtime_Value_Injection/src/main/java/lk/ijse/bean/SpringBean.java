package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {

    @Value("Akila")
    private String name;

    public SpringBean() {
        System.out.println("SpringBean Object Created");
        System.out.println("Name before injection: " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Name after injection: " + name);
    }

}

//@Component
//public class SpringBean {
//
//    public SpringBean(@Value("Kamal") String name) {
//        @Autowired(required = true)
//                System.out.println("SpringBean Object Created with parameterized constructor");
//        System.out.println(name);
//    }
//
//    public SpringBean(@Value("Nimal") String name) {
//        @Autowired(required = false)
//                System.out.println("SpringBean Object Created with parameterized constructor");
//        System.out.println("name");
//    }
//}