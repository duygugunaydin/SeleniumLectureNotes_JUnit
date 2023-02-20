package practice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Q2 {
    /* ...Exercise2...
 1 - Java class'imiza chromedriver.exe'yi tanitalim
 2 - Driver olusturalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklemesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.otto.de");
        String ottoTitle = driver.getTitle();
        System.out.println("ottoTitle = " + ottoTitle);

        String ottoUrl= driver.getCurrentUrl();
        System.out.println("ottoUrl = " + ottoUrl);
        if (ottoTitle.contains("OTTO") && ottoUrl.contains("OTTO")){
            System.out.println("OTTO yazisi vardir");
        }else System.out.println("OTTO yazisi icermiyor");
        driver.navigate().to("https://wisequarter.com/");
        String wqTitle = driver.getTitle();
        System.out.println("wqTitle = " + wqTitle);
        boolean isTrue = wqTitle.contains("Quarter");
        if (isTrue)
            System.out.println("TEST PASSED");
        else System.out.println("TEST FAILED");
    }
}
