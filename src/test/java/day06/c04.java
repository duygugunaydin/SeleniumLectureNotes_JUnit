package day06;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class c04 extends TestBase {
    @Test
    public void test01(){
        /*
        ● https://the-internet.herokuapp.com/windows adresine gidin.
        ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        ● Click Here butonuna basın.
        ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        */

        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfa=driver.getWindowHandle();
        String expected="Opening a new window";
        String actual=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expected,actual);

        expected="The Internet";
        actual= driver.getTitle();
        Assert.assertEquals(expected,actual);

        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        String ikincisayfa="";
        Set<String> sayfaSeti=driver.getWindowHandles();
        for (String each:sayfaSeti
             ) {
            if (!each.equals(ilkSayfa))
                ikincisayfa=each;
        }
        driver.switchTo().window(ikincisayfa);
        expected="New Window";
        actual=driver.getTitle();
        Assert.assertEquals(expected,actual);

        driver.switchTo().window(ilkSayfa);
        expected="The Internet";
        actual=driver.getTitle();
        Assert.assertEquals(expected,actual);





    }
}
