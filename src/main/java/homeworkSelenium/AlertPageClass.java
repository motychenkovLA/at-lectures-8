package homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class AlertPageClass {
    private static final By alertButton = By.xpath("//*[@id=\"alertButton\"]");
    private static final By timerAlertButton = By.xpath("//*[@id=\"timerAlertButton\"]");
    private static final By confirmButton = By.xpath("//*[@id=\"confirmButton\"]");

    private static final By confirmResult = By.xpath("//*[@id=\"confirmResult\"]");
    WebDriver webDriver;

    public AlertPageClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void alertButtonClick (){
        //Actions actions = new Actions(webDriver);
        WebElement alertClick = webDriver.findElement(alertButton);
        alertClick.click();
        webDriver.switchTo().alert().accept();
    }

    public void timerAlertButtonClick (){
        WebElement timerAlertClick = webDriver.findElement(timerAlertButton);
        timerAlertClick.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void confirmButtonClick (){
        WebElement confirmClick = webDriver.findElement(confirmButton);
        confirmClick.click();
        webDriver.switchTo().alert().dismiss();
    }
    public void checkConfirmResult (){
        if (!webDriver.findElements(confirmResult).isEmpty()){
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
    }
}
