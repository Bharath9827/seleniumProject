package testNgTests.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {

    @Test(priority = 1)
    void openApp(){
        System.out.println("Open App");
        Assert.assertTrue(true);
    }
    @Test(priority = 2, dependsOnMethods = {"openApp"})
    void loginApp(){
        System.out.println("Logged in");
        Assert.assertTrue(true);
    }

    @Test(priority = 3, dependsOnMethods = {"loginApp"})
    void searchApp(){
        System.out.println("Search test case");
        Assert.assertTrue(false);
    }

    @Test(priority = 4, dependsOnMethods = {"loginApp","searchApp"})
    void advSearch(){
        System.out.println("Advanced search");
    }

    @Test(priority = 5, dependsOnMethods = {"loginApp"})
    void logOut(){
        System.out.println("Logged out");
    }
}
