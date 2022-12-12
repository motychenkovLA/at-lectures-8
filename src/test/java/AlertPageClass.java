import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AlertPageClass {
    private static final By alertButton = By.xpath("//*[@id=\"alertButton\"]");
    private static final By timerAlertButton = By.xpath("//*[@id=\"timerAlertButton\"]");
    private static final By confirmButton = By.xpath("//*[@id=\"confirmButton\"]");

    private static final By confirmResult = By.xpath("//*[@id=\"confirmResult\"]");

    WebDriver webDriver;

    public AlertPageClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Вызвать алерт и принять")
    public void alertButtonClick (){
        WebElement alertClick = webDriver.findElement(alertButton);
        alertClick.click();
        webDriver.switchTo().alert().accept();
    }

    @Step("Вызвать алерт и принять после задержки по времени")
    public void timerAlertButtonClick (){
        WebElement timerAlertClick = webDriver.findElement(timerAlertButton);
        timerAlertClick.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    @Step("Вызвать алерт и отклонить")
    public void confirmButtonClick (){
        WebElement confirmClick = webDriver.findElement(confirmButton);
        confirmClick.click();
        webDriver.switchTo().alert().dismiss();
    }

    @Step("Получить сообщение после отклонения алерта")
    public String getConfirmResult (WebDriver webDriver) {
        return webDriver.findElement(confirmResult).getText();
    }

}
