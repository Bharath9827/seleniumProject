package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleCheckBoxes {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();


        //select multiple check boxes
        List<WebElement> dayCheckBoxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
//        for(WebElement element: dayCheckBoxes){
//            element.click();
//        }


        //to check if box is selected
        dayCheckBoxes.get(0).click();
        Thread.sleep(5000);
        //uncheck
        if(dayCheckBoxes.get(0).isSelected()){
            dayCheckBoxes.get(0).click();
        }
    }

}
