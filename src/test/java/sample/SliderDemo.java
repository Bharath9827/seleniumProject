package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SliderDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/sliders/");
        driver.manage().window().maximize();
        Actions act = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement slider = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]")));
        System.out.println(slider.getLocation().getX()+"  "+slider.getLocation().getY());
        act.dragAndDropBy(slider,2,slider.getLocation().getY()).perform();
        System.out.println(slider.getLocation().getX()+"  "+slider.getLocation().getY());

//        WebElement slider2 = wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]")));
//        System.out.println(slider2.getLocation().getX()+"  "+slider2.getLocation().getY());
//        act.dragAndDropBy(slider2,-slider2.getLocation().getX()+10,slider2.getLocation().getY()).perform();
//        System.out.println(slider2.getLocation().getX()+"  "+slider2.getLocation().getY());

        System.out.println("reached line 28");
    }
}
