package day06;


import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.RemoteWebElement;
import utilities.TestBaseClass;

public class c03 extends TestBaseClass {
    @Test
    public void test01(){

        driver.get("https://www.amazon.com");
        WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchbox.isEnabled());
        String amazonSekmesi=driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://wisequarter.com");
        String expected="wisequarter";
        String actual=driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
        String wiseQuarterSekmesi=driver.getWindowHandle();

        driver.switchTo().window(amazonSekmesi);
        searchbox.sendKeys("Nutella"+ Keys.ENTER);
        expected="Nutella";
        actual=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        Assert.assertTrue(actual.contains(expected));

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://youtube.com");
        expected="youtube";
        actual=driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));

        driver.switchTo().window(wiseQuarterSekmesi);
        expected="Wise Quarter";
        actual=driver.getTitle();
        Assert.assertTrue(actual.contains(expected));




    }
}
