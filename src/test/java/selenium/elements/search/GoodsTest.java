package selenium.elements.search;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GoodsTest extends BaseTest {

    @Test
    public void checkboxes() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // Launch the application
        openURL();

        //To maximize the window. This code may not work with Selenium 3 jars. If script fails you can remove the line below
        driver.manage().window().maximize();

        List<WebElement> foundGoods = new ArrayList<>();

        while (foundGoods.size() < 9) {
            // This  will scroll down the page by  200 pixel vertical
            jse.executeScript("window.scrollBy(0,200)");
            sleepALittleBit(1);

            foundGoods = driver.findElements(
                    By.xpath("//rz-goods-section[contains(@class, 'ng-star-inserted')]"));
        }

        // foundGoods.forEach(foundGood -> System.out.println(foundGood.getText()));
        System.out.println(
                // Найбільш обговорювані товари
                foundGoods.get(7).getText()
        );

    }
}

