package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TablesDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();
        WebElement selectElement = driver.findElement(By.xpath("//input[@value='Find Flights']"));
        selectElement.click();
        Thread.sleep(2000);

        //get number of rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']//tr[*]//td[1]"));

        List<Float> flightPrices = new ArrayList<>();
        Float minValue = Float.parseFloat(driver.findElement(By.xpath("//table[@class='table']//tr[1]//td[6]")).getText().substring(1));
        int minIndex =0;
        for(int i=1;i<=rows.size();i++){
            String price = driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText();
            flightPrices.add(Float.parseFloat(price.substring(1)));
            if(Float.parseFloat(price.substring(1))< minValue){
                minValue=Float.parseFloat(price.substring(1));
                minIndex = i-1;
            }
        }

        for(Float price: flightPrices){
            System.out.println(price);
        }

        //click on min priced flight
        WebElement minPricedFlight = driver.findElement(By.xpath("(//input[@value='Choose This Flight'])["+minIndex+"]"));
        minPricedFlight.click();
    }
}
