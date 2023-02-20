package z_practice.odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Odev1_ {


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

    static WebDriver driver ;

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
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
        driver.findElement(By.xpath("//span[text()='Close']"));
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Duygu");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Gunaydin");
        driver.findElement(By.xpath("//input[@id='sex-1']")).click();
        driver.findElement(By.xpath("//input[@id='exp-0']")).click();
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("20-02-23");
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();

        WebElement ddmContinent=driver.findElement(By.xpath("//select[@id='continents']"));
        Select select1=new Select(ddmContinent);
        select1.selectByVisibleText("Antartica");

        WebElement ddmCommand =driver.findElement(By.xpath("//select[@id='selenium_commands']"));
        Select select2= new Select(ddmCommand);
        select2.selectByVisibleText("Browser Commands");

        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }



}
