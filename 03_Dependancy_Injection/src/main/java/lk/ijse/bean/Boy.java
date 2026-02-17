package lk.ijse.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Boy{
    public Boy() {
        System.out.println("Boy object Created");
    }

    @Qualifier("girlOne")
    @Autowired //by this annotation spring will inject the girl object
    Agreement agreement;

    public void chatWithGirl(){
        //Girl girl = new Girl();
        agreement.chat();
    }

}
