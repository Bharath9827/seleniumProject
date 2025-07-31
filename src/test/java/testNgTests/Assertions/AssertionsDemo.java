package testNgTests.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsDemo {

    //Hard assertion
    @Test
    void validateValues(){
        String myTitle = "Open Cart";
        String actualTitle = "Open Shop";

        Assert.assertEquals(myTitle,actualTitle);
    }

    @Test
    void softAssertionTest(){
        System.out.println("Before soft assert");
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(10,20);
        System.out.println("After soft assert");

        softAssert.assertAll();
    }
}
