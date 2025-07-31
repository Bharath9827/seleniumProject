package testNgTests;

import org.testng.annotations.Test;

public class FirstTestCase {

    @Test(priority = 0)
    void openApp(){
        System.out.println("App opened");
    }

    @Test(priority = 1)
    void loginToApp(){
        System.out.println("Logged in");

    }

    @Test(priority = 2)
    void logOut(){
        System.out.println("Logged out");

    }
}
