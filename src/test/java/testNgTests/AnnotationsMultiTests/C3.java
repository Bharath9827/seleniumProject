package testNgTests.AnnotationsMultiTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {

    @Test
    void abc(){
        System.out.println("Test abc in c3");
    }

    @BeforeSuite
    void bs(){
        System.out.println("This is before suite");
    }

    @AfterSuite
    void at(){
        System.out.println("This is after suite");
    }
}
