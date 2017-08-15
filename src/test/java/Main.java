import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.google.com/ncr");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Новости");
        searchField.submit();
        List <WebElement> resultsList = driver.findElements(By.cssSelector("div.srg div.g h3.r a"));
        //Выводим заголовок и ссылку из поиска
//        for(WebElement res : resultsList){
//            System.out.println(res.getText());
//            System.out.println(res.getAttribute("href") + "\n");
//        }

        //переход по четвертой ссылке
        driver.get(resultsList.get(3).getAttribute("href"));
        Assert.assertEquals("Лента новостей. Новости от 15.08.2017 - РИА Новости", driver.getTitle());
        System.out.println("Test passed");

    }
}
