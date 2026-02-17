package lk.ijse.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Spring_Bean {

    public Spring_Bean(@Value("Kamal") String name) {
        @Autowired(required = true)
                System.out.println("SpringBean Object Created with parameterized constructor");
                System.out.println(name);
    }

    public Spring_Bean(@Value("Nimal") String name) {
        @Autowired(required = false)
                System.out.println("SpringBean Object Created with parameterized constructor");
                System.out.println("name");
    }
}