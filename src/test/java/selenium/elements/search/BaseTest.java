package selenium.elements.search;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected String URL = "https://rozetka.com.ua/";
    @BeforeClass
    public void initBrowser() {
        WebDriverManager.chromedriver().arch64().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeBrowser() {
        sleepALittleBit(2);
        driver.quit();
    }

    public void openURL() {
        driver.get(String.format("%s", URL));
    }

    public void sleepALittleBit(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
