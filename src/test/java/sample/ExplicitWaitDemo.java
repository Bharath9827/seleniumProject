package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        WebElement userName = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='username']")));
        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        userName.sendKeys("Admin");

        WebElement passWord = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='password']")));
        passWord.sendKeys("admin123");

        WebElement loginButton = myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();

        //driver.close();
    }
}
