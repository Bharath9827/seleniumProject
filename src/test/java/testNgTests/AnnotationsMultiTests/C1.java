package testNgTests.AnnotationsMultiTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {

    @Test
    void abc(){
        System.out.println("Test abc in c1");
    }

    @BeforeTest
    void bt(){
        System.out.println("Test bt in c1");
    }


}
