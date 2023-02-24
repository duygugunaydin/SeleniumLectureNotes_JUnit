package z_practice.AyseHocaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    public static void main(String[] args) throws InterruptedException {
/* ...Exercise3...
    go to url : https://www.techlistic.com/p/selenium-practice-form.html
    fill the firstname
    fill the lastname
    check the gender
    check the experience
    fill the date
    choose your profession -> Automation Tester
    choose your tool -> Selenium Webdriver
    choose your continent -> Antartica
    choose your command  -> Browser Commands
    click submit button

 */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        driver.manage().deleteAllCookies(); // kodun calismasini engellemeden calistirmaya devam eder

        driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click(); // Cikan pencereyi asmak icin

        driver.findElement(By.xpath("//a[text()='Tamam']")).click();

        driver.findElement(By.name("firstname")).sendKeys("cemile"+ Keys.ENTER);
        Thread.sleep(1000);

        WebElement lastName= driver.findElement(By.name("lastname"));
        lastName.sendKeys("amaaan");
        Thread.sleep(1000);
        lastName.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("sex-0")).click(); // Radio Button'lara click yapmak gerek.
        Thread.sleep(1000);
        driver.findElement(By.id("exp-1")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("datepicker")).sendKeys("12.10.2022");
        Thread.sleep(1000);

        WebElement profession = driver.findElement(By.xpath("//input[@id='profession-1']"));
        profession.click();
        profession.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//select[@id='continents']")).sendKeys("Africa");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option[normalize-space()='Browser Commands']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000);

        driver.quit();
    }
}