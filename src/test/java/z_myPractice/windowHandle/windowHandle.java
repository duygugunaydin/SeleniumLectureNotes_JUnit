package z_myPractice.windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;

public class windowHandle {
    /*
         1."http://webdriveruniversity.com/" adresine gidin
         2."Login Portal" a kadar asagi inin
         3."Login Portal" a tiklayin
         4.Diger window'a gecin
         5."username" ve "password" kutularina deger yazdirin
         6."login" butonuna basin
         7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
         8.Ok diyerek Popup'i kapatin
         9.Ilk sayfaya geri donun
         10.Ilk sayfaya donuldugunu test edin
     */
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1 //
        driver.get("http://webdriveruniversity.com/");
        String firstWindow= driver.getWindowHandle();

        // 2 //
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // 3 //
        WebElement loginPortalElementi=driver.findElement(By.xpath("(//div[@class='section-title'])[2]"));
        loginPortalElementi.click();

        // 4 //
        Set<String> WindowHandleValues=driver.getWindowHandles();
        String secondWindow= "?";
        for (String each:WindowHandleValues
             ) {
            if (!each.equals(firstWindow))
                secondWindow=each;
        }
        driver.switchTo().window(secondWindow);

        // 5 //
        // 6 //
        driver.findElement(By.xpath("//input[@id='text']"))
                .sendKeys("John Doe"+Keys.TAB+"12345"+Keys.TAB+Keys.ENTER);


        // 7 //
        String expectedText="validation failed";
        String actualText=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText,actualText);

        // 8 //
        driver.switchTo().alert().accept();

        // 9 //
        driver.switchTo().window(firstWindow);

        // 10 //
        String expectedWindowHandleValue=firstWindow;
        String actualWindowHandleValue=driver.getWindowHandle();
        Assert.assertEquals(expectedWindowHandleValue,actualWindowHandleValue);
    }
}
