package day06;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class c05 extends TestBase {
    /*
    2- https://the-internet.herokuapp.com/context_menu sitesine gidin
    3- Cizili alan uzerinde sag click yapin
    4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
    5- Tamam diyerek alert’i kapatalim
    6- Elemental Selenium linkine tiklayalim
    7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions action= new Actions(driver);





    }
}
