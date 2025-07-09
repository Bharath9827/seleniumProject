package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FirstTestCase {
    public static void main(String[] args) {

        //Launch browser
        ChromeDriver driver = new ChromeDriver();

        //open URL
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();

        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        if(pageTitle.equals("Your Store")){
            System.out.println("Test passed");
        }
        else System.out.println("Test failed");


        //Finding elements
//        driver.findElement(By.name("search")).sendKeys("hello");
//        driver.findElement(By.id("12")).isDisplayed();
//        driver.findElement(By.linkText("display")).isEnabled();
    //    driver.findElement(By.partialLinkText("dis")).isEnabled();

        // By.linkText vs partialLinkText - LinkText looks for fulll text of element, partials looks for part of text

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //capture group of web elements
       List<WebElement> headerLinks = driver.findElements(By.className("hrefch"));
       System.out.println("Total number of header links: "+headerLinks.size());
       for(WebElement link: headerLinks){
           System.out.println(link.getAttribute("href"));
       }


        driver.navigate().refresh();
       //navigational commands
        //navigate().back()
        //navigate().forward()
        //navigate().refresh()

        //close browser
        driver.quit();
    }
}
