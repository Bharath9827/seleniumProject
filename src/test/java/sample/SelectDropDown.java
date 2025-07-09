package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement selectElement = driver.findElement(By.xpath("//select[@id='country']"));
        Select drpCountry = new Select(selectElement);

        System.out.println(drpCountry.getOptions().size());
        drpCountry.selectByValue("canada");

    }
}
