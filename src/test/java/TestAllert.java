import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class TestAllert {
    @Test
    public void testAllertButtonOne() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement webElement = driver.findElement(By.xpath(
                ".//button[(@class='btn btn-primary' and @id='alertButton')]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        webElement.click();
        driver.switchTo().alert().accept();

//        WebElement webElement1 = driver.findElement(By.xpath(
//                ".//button[(@class='btn btn-primary' and @id='timerAlertButton')]"));
//        webElement1.click();
//        driver.switchTo().alert().accept();
//
//        WebElement webElement2 = driver.findElement(By.xpath(
//                ".//button[(@class='btn btn-primary' and @id='confirmButton')]"));
//        webElement2.click();
//        //actions.moveToElement(webElement).click().perform();
//        driver.switchTo().alert().dismiss();
//        String textCancel = driver.findElement(By.id("confirmResult")).getText();
//        assertEquals("You selected Cancel", textCancel);

        driver.quit();
    }
    @Test
    public void testAllertButtonTwo() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement webElement = driver.findElement(By.xpath(
                ".//button[(@class='btn btn-primary' and @id='timerAlertButton')]"));
        webElement.click();
        new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.switchTo().alert().accept();
        driver.quit();
    }
    @Test
    public void testAllertButtonThree() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/alerts");
//        new WebDriverWait(driver, 4)
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//                        ".//button[(@class='btn btn-primary' and @id='confirmButton')]")));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement webElement = driver.findElement(By.xpath(
                ".//button[(@class='btn btn-primary' and @id='confirmButton')]"));
        webElement.click();
        //actions.moveToElement(webElement).click().perform();
        driver.switchTo().alert().dismiss();
        String textCancel = driver.findElement(By.id("confirmResult")).getText();
        assertEquals("You selected Cancel", textCancel);
        driver.quit();
    }
}
