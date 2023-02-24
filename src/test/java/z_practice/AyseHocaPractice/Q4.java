package z_practice.AyseHocaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q4 {
    /* ...Exercise4...
Navigate to  https://testpages.herokuapp.com/styled/index.html
Click on  Calculater under Micro Apps
Type any number in the first input
Type any number in the second input
Click on Calculate
Get the result
Print the result

     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        driver.findElement(By.id("calculatetest")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("number1")).sendKeys("12"); // WebElement'e de atayabiliriz eger birden fazla kez kullanacaksak
        Thread.sleep(1000);
        driver.findElement(By.id("number2")).sendKeys("32");
        Thread.sleep(1000);
        driver.findElement(By.id("calculate")).click();
        Thread.sleep(1000);
        WebElement sonuc = driver.findElement(By.xpath("//span[@id='answer']"));
        String result = driver.findElement(By.xpath("//span[@id='answer']")).getText();
        Thread.sleep(1000);
        System.out.println("Sonuc : "+ sonuc.getText());

        driver.quit();
    }
}
