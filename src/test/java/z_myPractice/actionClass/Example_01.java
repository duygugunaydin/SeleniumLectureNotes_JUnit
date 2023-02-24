package z_myPractice.actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class Example_01 extends TestBase {
    @Test
    public void test01(){
        /*
        1- Yeni bir class olusturalim: MouseActions1
        2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        3- Cizili alan uzerinde sag click yapin
        4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        5- Tamam diyerek alert’i kapatalim
        6- Elemental Selenium linkine tiklayalim
        7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
         */


        // 2 //
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String firstPageHandleCode=driver.getWindowHandle();

        // 3 //
        WebElement cizgiliAlanElementi=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(cizgiliAlanElementi).contextClick().perform();

        // 4 //
        String expextedAlertText="You selected a context menu";
        String actualAlertText=driver.switchTo().alert().getText();
        Assert.assertEquals(expextedAlertText,actualAlertText);

        // 5 //
        driver.switchTo().alert().accept();

        // 6 //
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // 7 //
        Set<String> pageHandleCodes=driver.getWindowHandles();
        String secondPageHandleCode="?";
        for (String eachcode:pageHandleCodes
             ) {
            if (!eachcode.equals(firstPageHandleCode))
                secondPageHandleCode=eachcode;
        }
        driver.switchTo().window(secondPageHandleCode);
        String expectedTagText=driver.findElement(By.tagName("h1")).getText();
        String actualTagText="Elemental Selenium";
        Assert.assertEquals(expectedTagText,actualTagText);

    }
}
