package z_myPractice.cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class Example_01 extends TestBase  {
    /*
         1- Amazon anasayfaya gidin
         2- tum cookie’leri listeleyin
         3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
         4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
         5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
         olusturun ve sayfaya ekleyin
         6- eklediginiz cookie’nin sayfaya eklendigini test edin
         7- ismi skin olan cookie’yi silin ve silindigini test edin
         8- tum cookie’leri silin ve silindigini test edin
     */
    @Test
    public void test01(){

        // 1 //
        driver.get("https://amazon.com");

        // 2 //
        Set<Cookie> allCookies=driver.manage().getCookies();
        for (Cookie each:allCookies) {
            System.out.println(each);
        }

        // 3 //
        Assert.assertTrue(allCookies.size()>5);

        // 4 //
        String expectedCookieValue="USD";
        String actualCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // 5 //
        Cookie newCookieAdd= new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(newCookieAdd);

        // 6 //
        allCookies=driver.manage().getCookies();
        Assert.assertTrue(allCookies.contains(newCookieAdd));

        // 7 //
        driver.manage().deleteCookieNamed("skin");
        allCookies=driver.manage().getCookies();
        Assert.assertFalse(allCookies.contains(driver.manage().getCookieNamed("skin")));

        // 8 //
        driver.manage().deleteAllCookies();
        allCookies=driver.manage().getCookies();
        Assert.assertTrue(allCookies.size()==0);




    }
}
