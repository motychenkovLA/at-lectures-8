import org.junit.Before;
import org.openqa.selenium.By;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class TestVisibleText {
    @Test
    public void testDoubleClick() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/buttons");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement webElement = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(webElement).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        String textDoubleClick = driver.findElement(By.id("doubleClickMessage")).getText();
        assertEquals("You have done a double click", textDoubleClick);
        WebElement webElement1 = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(webElement1).perform();
        String textRightClick = driver.findElement(By.id("rightClickMessage")).getText();
        assertEquals("You have done a right click", textRightClick);
        WebElement webElement2 = driver.findElement(By.xpath(".//button[(@class='btn btn-primary' and text()='Click Me')]"));
        webElement2.click();
        String textLeftClick = driver.findElement(By.id("dynamicClickMessage")).getText();
        assertEquals("You have done a dynamic click", textLeftClick);
        driver.quit();
    }
//    @Test
//    public void testRightClick() {
//        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        WebDriver driver = new ChromeDriver(options);
//        Actions actions = new Actions(driver);
//        driver.get("https://demoqa.com/buttons");
//        new WebDriverWait(driver, 3)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickBtn")));
//        WebElement webElement = driver.findElement(By.id("rightClickBtn"));
//        actions.contextClick(webElement).perform();
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage")));
//        String textDoubleClick = driver.findElement(By.id("rightClickMessage")).getText();
//        assertEquals("You have done a right click", textDoubleClick);
//        driver.quit();
//    }
//    @Test
//    public void testLeftClick() {
//        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        WebDriver driver = new ChromeDriver(options);
//        Actions actions = new Actions(driver);
//        driver.get("https://demoqa.com/buttons");
//        new WebDriverWait(driver, 3)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[(@class='btn btn-primary' and text()='Click Me')]")));
//        WebElement webElement = driver.findElement(By.xpath(".//button[(@class='btn btn-primary' and text()='Click Me')]"));
//        webElement.click();
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));
//        String textDoubleClick = driver.findElement(By.id("dynamicClickMessage")).getText();
//        assertEquals("You have done a dynamic click", textDoubleClick);
//        driver.quit();
//    }

}
