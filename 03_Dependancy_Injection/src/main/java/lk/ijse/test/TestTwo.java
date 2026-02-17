package lk.ijse.test;

import org.springframework.stereotype.Component;

@Component
public class TestTwo implements TestAgreement {
    @Override
    public void chat() {
        System.out.println("Chat-----");
    }

}
