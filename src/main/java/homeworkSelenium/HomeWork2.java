package homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeWork2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/homeworkSelenium/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        webDriver.get("https://demoqa.com/alerts");

        WebElement alertButton = webDriver.findElement(By.xpath("//*[@id=\"alertButton\"]"));
        WebElement timerAlertButton = webDriver.findElement(By.xpath("//*[@id=\"timerAlertButton\"]"));
        WebElement confirmButton = webDriver.findElement(By.xpath("//*[@id=\"confirmButton\"]"));

        Actions actions = new Actions(webDriver);
        actions.click(alertButton).build().perform();
        webDriver.switchTo().alert().accept();

        actions.click(timerAlertButton).build().perform();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

        actions.click(confirmButton).build().perform();
        webDriver.switchTo().alert().dismiss();

        boolean isHaveConfirmResult = !webDriver.findElements(By.xpath("//*[@id=\"confirmResult\"]")).isEmpty();

        if (isHaveConfirmResult) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
        webDriver.quit();
    }
}
