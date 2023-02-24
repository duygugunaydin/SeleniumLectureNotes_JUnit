package z_myPractice.actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Example_02 extends TestBase {
    @Test
    public void test01(){
        /*
        1- https://demoqa.com/droppable adresine gidelim
        2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
         */

        // 1 //
        driver.get("https://demoqa.com/droppable");

        // 2 //
        WebElement dragMeElementi=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereElementi=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElementi,dropHereElementi).perform();

        // 3 //
        String expectedText="Dropped!";
        String actualText= driver.findElement(By.xpath("(//p[text()='Dropped!'])[1]")).getText();
        Assert.assertEquals(expectedText,actualText);


    }
}
