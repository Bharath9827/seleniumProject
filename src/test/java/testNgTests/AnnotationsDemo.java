package testNgTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsDemo {

    @BeforeMethod
    void loginApp(){
        System.out.println("Logged in");
    }

    @Test
    void searchApp(){
        System.out.println("Search test case");
    }

    @Test
    void advSearch(){
        System.out.println("Advanced search");
    }

    @AfterMethod
    void logOut(){
        System.out.println("Logged out");
    }
}
