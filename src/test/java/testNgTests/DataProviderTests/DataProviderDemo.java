package testNgTests.DataProviderTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderDemo {

    WebDriver driver;


    @BeforeClass
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(dataProvider = "dp")
    void testLogin(String loginUserName, String loginPassword){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userName = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        userName.sendKeys(loginUserName);

        WebElement passWord = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        passWord.sendKeys(loginPassword);

        WebElement loginButton = myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();
        boolean loginStatus = driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
        if(loginStatus){
            Assert.assertTrue(true);
        }
        else{
            Assert.fail();
        }
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }

    @DataProvider(name = "dp")
    Object[][] loginData(){
        Object data[][] = {
                            {"Admin2","admin321"},
                {"Admin3","admin9090"},
                {"Admin","admin123"}
        };

        return data;
    }
}
