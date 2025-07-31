package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;


public class MouseActions {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        Actions act = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));

        List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='gallery']/li"));
        WebElement dropElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='trash']")));
        //driver.findElement(By.xpath("//div[@id='trash']"));
        for(WebElement element: elements){
            act.dragAndDrop(element,dropElement).perform();
            System.out.println("element dropped");
            Thread.sleep(2000);
        }
    }
}
