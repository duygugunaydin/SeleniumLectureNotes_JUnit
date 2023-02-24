package z_practice.odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Odev_AhmetHoca_x extends TestBase {
    @Test
    public void test01(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");


        //  2. Headers da bulunan basliklari yazdirin
        System.out.println("===================== 2 ============================");
        List<WebElement> headers= driver
                .findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        for (WebElement eachone:headers
        ) {
            System.out.println(eachone.getText());
        }


        //  3. 3.sutunun basligini yazdirin
        // div[@class='rt-thead -header']//div[1]/div[3]/div[1]
        System.out.println("===================== 3 ============================");
        int sutunSayisi=3;
        String headerTd= "//div[@class='rt-thead -header']//div[1]/div["+sutunSayisi+"]/div[1]";
        System.out.println(driver.findElement(By.xpath(headerTd)).getText());



        //  4. Tablodaki tum datalari yazdirin
        System.out.println("===================== 4 ============================");
        List<WebElement> allDatas=driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        for (WebElement eachData:allDatas
             ) {
            System.out.println(eachData.getText());
        }


        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        //div[@class='rt-tr -padRow -odd']  //div[@class='rt-tr -padRow -even']
        System.out.println("===================== 5 ============================");
        int sira=1;
        List<WebElement> allCells=driver.findElements(By.xpath("//div[@role='gridcell']"));
        for (WebElement each:allCells
             ) {
            System.out.println(sira+"-"+each.getText());
            sira++;
        }
        sira=0;
        for (WebElement each:allCells
        ) {
            if (!each.getText().isBlank())
                sira++;
        }
        System.out.println("Bos olmayan data sayisi = " + sira);


        //  6. Tablodaki satir sayisini yazdirin
        System.out.println("===================== 6 ============================");
        List<WebElement> numberOfRow=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki satir sayisi : "+numberOfRow.size());


        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("===================== 7 ============================");
        System.out.println("Tablodaki sutun sayisi : " + headers.size());


        //  8. Tablodaki 3.kolonu yazdirin
        System.out.println("===================== 8 ============================");
        //div[@class='rt-tbody']/div/div[1]/div[X]
        List<WebElement> colums=driver
                .findElements(By.xpath("//div[@class='rt-tbody']/div/div[1]/div[3]"));
        for (WebElement each:colums
             ) {
            System.out.println(each.getText());
        }


        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("===================== 9 ============================");
        // sutun bulma xpat i >> //div[@class='rt-tbody']/div/div[1]/div[xNUMBERx]
        // satir bulma xpat i (tumsatir)>> //div[@class='rt-tbody']/div[xNUMBERx]/div
        // satir bulma xpat i (hucresel)>> //div[@class='rt-tbody']/div[2]/div/div



        // 10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde
        System.out.println("===================== 10 ============================");
        findCellOfTable(3,5);
        //  //div[@class='rt-tbody']/div[3]/div[1]/div[5]

    }
    public void findCellOfTable(int satir,int sutun){
        //div[@class='rt-tbody']/div[3]/div[1]/div[5]
        System.out.println(driver
                .findElement(By.xpath(" //div[@class='rt-tbody']/div["+satir+"]/div[1]/div["+sutun+"]"))
                .getText());
    }
}
