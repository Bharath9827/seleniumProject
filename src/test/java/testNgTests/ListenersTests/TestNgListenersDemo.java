package testNgTests.ListenersTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNgListenersDemo {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void testLogo(){
        boolean status = driver.findElement(By.xpath("//div[@class='orangehrm-login-logo']")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Test(priority = 2)
    void testAppUrl(){
        Assert.assertEquals(driver.getCurrentUrl(),"incorrect url test");
    }

    @Test(priority = 3, dependsOnMethods = {"testAppUrl"})
    void testTitle(){
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
