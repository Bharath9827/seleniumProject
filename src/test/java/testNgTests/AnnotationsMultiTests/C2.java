package testNgTests.AnnotationsMultiTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C2 {

    @Test
    void abc(){
        System.out.println("Test abc in c2");
    }

    @AfterTest
    void at(){
        System.out.println("Test at in c2");
    }
}
