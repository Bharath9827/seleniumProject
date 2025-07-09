package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(5000);
        List<WebElement> searchResults = driver.findElements(By.xpath("//a[contains(text(),'Selenium')]"));
        System.out.println(searchResults.size());
        for(WebElement result: searchResults){
            result.click();
        }
        Set<String> windows = driver.getWindowHandles();

//        List<String> windowIds = new ArrayList<>(windows);
//
//        String parentId = windowIds.get(0);
//        String childId = windowIds.get(1);
        System.out.println(windows.size());
        for(String windowId : windows){
            String title = driver.switchTo().window(windowId).getTitle();
            System.out.println(title);
        }

    }
}
