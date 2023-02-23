package day08_ecplicitlyWait_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class C01 {
    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        WebElement tumbody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumbody.getText());

        List<WebElement> satirsayisi = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10,satirsayisi.size());

        for (WebElement each:satirsayisi
             ) {
            System.out.println(each.getText());
        }



    }
}























