package z_myPractice.actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Example_03 extends TestBase {

    @Test
    public void test01(){

        /*
        1- https://www.amazon.com/ adresine gidin
        2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
           mouse’u bu menunun ustune getirin
        3- “Create a list” butonuna basin
        4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
         */

        // 1 //
        driver.get("https://www.amazon.com");

        // 2 //
        Actions actions = new Actions(driver);
        WebElement accountListsElementi= driver.findElement(By.xpath("//span[text()='Account & Lists']"));
        WebElement createAListElementi= driver.findElement(By.xpath("//span[text()='Create a List']"));
        actions.moveToElement(accountListsElementi).perform();

        // 3 //
        actions.moveToElement(createAListElementi).click().perform();

        // 4 //
        WebElement yourListElementi= driver.findElement(By.xpath("//div[@role='heading']"));
        Assert.assertTrue(yourListElementi.isDisplayed());







    }
}
