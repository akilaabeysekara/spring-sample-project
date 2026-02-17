package lk.ijse.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestOne implements Agreement {
    //property injection
//    @Autowired
//    TestAgreement testAgreement;
//
//    public void chat() {
//        testAgreement.chat();

    //constructor injection
//    TestAgreement testAgreement;
//    @Autowired
//    public TestOne(TestAgreement testAgreement) {
//        this.testAgreement = testAgreement;
//    }
//
//
//
//   TestAgreement testAgreement;
//    if without @Autowired annotation also work
//    public TestOne(TestAgreement testAgreement) {
//        this.testAgreement = testAgreement;
//    }
//

    //setter method injection
//    TestAgreement testAgreement;
//    @Autowired
//    public void setTestAgreement(TestAgreement testAgreement) {
//        this.testAgreement = testAgreement;
//    }
//
//    public void chat(){
//        testAgreement.chat();
//    }

//TestAgreement testAgreement;
//    @Autowired
//    @Override
//
//public void inject(TestAgreement agreement){
//    this.testAgreement = agreement;
//}
//public void chat(){


    //Interface Through Injection
    TestAgreement testAgreement;
    @Autowired
    @Override
    public void inject(TestAgreement agreement) {
        this.testAgreement = agreement;
    }
    public void chatWithTestTwo() {
        testAgreement.chat();
    }



}