package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    WebDriver driver;
    //constructor
    LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    By userName_loc = By.xpath("//input[@placeholder='Username']");
    By password_loc = By.xpath("//input[@placeholder='Password']");
    By submitButton_loc = By.xpath("//button[@type='submit']");

    //Actions
    public void setUserName(String user){
        driver.findElement(userName_loc).sendKeys(user);
    }

    public void setPassword(String password){
        driver.findElement(password_loc).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(submitButton_loc).click();
    }
}
