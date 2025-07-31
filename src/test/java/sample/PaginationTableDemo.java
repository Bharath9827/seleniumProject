package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTableDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();


        int numOfPages = driver.findElements(By.xpath("//ul[@class='pagination']/li")).size();

        for(int i=1;i<=numOfPages;i++){
            if(i>1){
                driver.findElement(By.xpath("//ul[@class='pagination']/li["+i+"]")).click();
            }
            int numOfRowsInPage = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
            for(int j=1;j<=numOfRowsInPage;j++){
                driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[4]/input")).click();
            }
            Thread.sleep(2000);
        }


    }
}
