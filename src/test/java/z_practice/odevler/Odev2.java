package z_practice.odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev2 {

                /* ...Exercise4...
                   Navigate to  https://testpages.herokuapp.com/styled/index.html
                   Click on  Calculater under Micro Apps
                   Type any number in the first input
                   Type any number in the second input
                   Click on Calculate
                   Get the result
                   Print the result
                 */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void Test01(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@id='calculate']")).click();

        String result= driver.findElement(By.xpath("//span[@id='answer']")).getText();

        System.out.println(result);

    }
}
