import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void Test() {

        driver.get("https://www.google.com/ncr");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.submit();
        List <WebElement> resultsList = driver.findElements(By.cssSelector("div.srg div.g h3.r a"));
        //Выводим заголовок и ссылку из поиска
        for(WebElement res : resultsList){
            System.out.println(res.getText());
            System.out.println(res.getAttribute("href") + "\n");
        }

        //переход по пятой ссылке
        driver.get(resultsList.get(4).getAttribute("href"));
        Assert.assertEquals(driver.getTitle(), "Selenium (software) - Wikipedia");
        System.out.println("Test passed");
    }
//    @AfterTest
//    public void tearDown(){
//        driver.quit();
//    }
}
