package testNgTests.GroupingTests;

import org.testng.annotations.Test;

public class LogInTests {

    @Test(priority = 1, groups = {"sanity","regression"})
    void logInFaceBook(){
        System.out.println("Login to facebook");
    }

    @Test(priority = 2, groups = {"regression"})
    void logInTwitter(){
        System.out.println("Login to twitter");
    }
}
