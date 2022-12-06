package test.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoqaAlertsPageClass {

    private static final By alertButtonLocator = By.xpath("//button[@id=\"alertButton\"]");
    private static final By timerAlertButtonLocator = By.xpath("//button[@id=\"timerAlertButton\"]");
    private static final By confirmButtonLocator = By.xpath("//button[@id=\"confirmButton\"]");
    private static final By confirmResultLocator = By.xpath("//span[@id=\"confirmResult\"]");

    private final WebDriver webDriver;

    public DemoqaAlertsPageClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Принять алерт")
    public void alertAccept () {
        WebElement alertButton = webDriver.findElement(alertButtonLocator);
        alertButton.click();
        webDriver.switchTo().
                alert().
                accept();
    }

    @Step("Принять алерт после ожидания")
    public void timerAlertAccept () {
        WebElement timerAlertButton = webDriver.findElement(timerAlertButtonLocator);
        timerAlertButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo()
                .alert()
                .accept();
    }

    @Step("Отклонить алерт")
    public void alertDismiss () {
        WebElement confirmButton = webDriver.findElement(confirmButtonLocator);
        confirmButton.click();
        webDriver.switchTo()
                .alert()
                .dismiss();
    }

    @Step("Получить текст, который появляется после отмены алерта")
    public String getSelectedCancelText(WebDriver webDriver) {
        return webDriver.findElement(confirmResultLocator).getText();
    }
}
