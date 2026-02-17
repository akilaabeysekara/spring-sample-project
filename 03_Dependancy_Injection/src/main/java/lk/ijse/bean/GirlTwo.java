package lk.ijse.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GirlTwo implements Agreement {
    @Override
    public void chat() {
        System.out.println("Chat with GirlTwo");
    }

}