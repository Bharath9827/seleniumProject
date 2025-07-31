package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/");
        driver.manage().window().maximize();

        WebElement tabButton = driver.findElement(By.xpath("//a[text()='Tabs']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",tabButton);

    }
}
