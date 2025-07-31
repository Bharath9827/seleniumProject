package sample.DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import sample.utils.ExcelUtils;

import java.io.IOException;
import java.time.Duration;

public class FDCalculator {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
        driver.manage().window().maximize();

        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\resources\\calData.xlsx";

        int rows = ExcelUtils.getROwCount(filePath,"Sheet1");

        for(int i=1;i<=rows;i++){
            //read data from excel
            String principlePrice = ExcelUtils.getCellData(filePath,"Sheet1",i,0);
            String rateOfInterest = ExcelUtils.getCellData(filePath,"Sheet1",i,1);
            String period1 = ExcelUtils.getCellData(filePath,"Sheet1",i,2);
            String period2 = ExcelUtils.getCellData(filePath,"Sheet1",i,3);
            String freq = ExcelUtils.getCellData(filePath,"Sheet1",i,4);
            String expectedValue = ExcelUtils.getCellData(filePath,"Sheet1",i,5);

            //pass data to application
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principlePrice);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);

            WebElement selectElement = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
            Select tenureDropDown = new Select(selectElement);
            tenureDropDown.selectByVisibleText(period2);

            WebElement freqSelectElement = driver.findElement(By.xpath("//select[@name='frequency']"));
            Select freqDropDown = new Select(freqSelectElement);
            freqDropDown.selectByVisibleText(freq);

            driver.findElement(By.xpath("//a[@onclick='return getfdMatVal(this);']")).click();

            String maturityAmount = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
            //do validations
            if(Double.parseDouble(maturityAmount) == Double.parseDouble(expectedValue)){
                System.out.println("Test case passed");
            }
            Thread.sleep(2000);
            driver.findElement(By.xpath("//img[@class='PL5']")).click();
        }


        driver.quit();
    }
}
