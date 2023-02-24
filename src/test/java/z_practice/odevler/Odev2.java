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
                   // 1 // Navigate to  https://testpages.herokuapp.com/styled/index.html
                   // 2 // Click on  Calculater under Micro Apps
                   // 3 // Type any number in the first input
                   // 4 // Type any number in the second input
                   // 5 // Click on Calculate
                   // 6 // Get the result
                   // 7 // Print the result
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

        // 1 //
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // 2 //
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();

        // 3 //
        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("10");

        // 4 //
        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("10");

        // 5 //
        driver.findElement(By.xpath("//input[@id='calculate']")).click();

        // 6 //
        String result= driver.findElement(By.xpath("//span[@id='answer']")).getText();

        // 7 //
        System.out.println(result);

    }
}
