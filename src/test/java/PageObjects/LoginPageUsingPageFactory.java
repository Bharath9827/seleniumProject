package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPageUsingPageFactory {

    WebDriver driver;

    //constructor
    LoginPageUsingPageFactory(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Locators

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userName_loc;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password_loc;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton_loc;

    @FindBy(tagName = "a")
    List<WebElement> links;


    //Actions
    public void setUserName(String user){
        userName_loc.sendKeys(user);
    }

    public void setPassword(String password){
        password_loc.sendKeys(password);
    }

    public void clickLogin(){
        submitButton_loc.click();
    }
}
