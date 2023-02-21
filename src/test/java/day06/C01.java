package day06;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {
    /*
         1- Bir class olusturun : BasicAuthentication
         2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
         3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
         Html komutu : https://username:password@URL
         Username    : admin
         password     : admin
         4- Basarili sekilde sayfaya girildigini dogrulayin
     */
    @Test
    public void Test01(){

        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement frameElementi = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(frameElementi);

        WebElement yazi=driver.findElement(By.xpath("//body[@id='tinymce']"));
        Assert.assertTrue(yazi.isDisplayed());

    }
}
