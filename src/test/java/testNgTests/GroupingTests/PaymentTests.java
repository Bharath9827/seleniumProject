package testNgTests.GroupingTests;

import org.testng.annotations.Test;

public class PaymentTests {

    @Test(priority = 1, groups = {"regression"})
    void gpayPayment(){
        System.out.println("Payment with gpay");
    }

    @Test(priority = 2, groups = {"sanity"})
    void phonePePayment(){
        System.out.println("Payment using phonepe");
    }

}
