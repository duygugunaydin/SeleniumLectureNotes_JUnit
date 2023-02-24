package z_practice.odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev3 extends TestBase {
    // .......Exercise5........
    /*
    // 1  // Navigate to website https://testpages.herokuapp.com/styled/index.html
    // 2  // Under the ORIGINAL CONTENTS
             click on Alerts
    // 3  // print the URL
    // 4  // navigate back
    // 5  // print the URL
    // 6  // Click on Basic Ajax
    // 7  // print the URL
    // 8  // enter value 20 and ENTER
    // 9  // and then verify Submitted Values is displayed open page
    // 10 // close driver
     */

    @Test
    public void test01(){

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // 2 //
        driver.findElement(By.xpath("//a[@id='alerts']")).click();

        // 3 //
        System.out.println(driver.getCurrentUrl());

        // 4 //
        driver.navigate().back();

        // 5 //
        System.out.println(driver.getCurrentUrl());

        // 6 //
        driver.findElement(By.xpath("//a[@id='basicajax']")).click();

        // 7 //
        System.out.println(driver.getCurrentUrl());

        // 8 //
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("20"+ Keys.ENTER);

        // 9 //
        WebElement verifyElementi=driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        Assert.assertTrue(verifyElementi.isDisplayed());

    }
}
